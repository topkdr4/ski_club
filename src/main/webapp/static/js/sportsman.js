(function(){
    "use strict";

    var itemsPerPage = 9;

    function Sportsman() {}


    Sportsman.getSportsmans = function(page, callback) {
        var range = getRange(page);
        Application.get("/sportsman/list/" + range.from + '/' + range.to, {}, callback);
    };


    Sportsman.getSportsman = function(sportsmanId) {

    };


    Sportsman.saveSportsman = function(sportsman, callback) {
        Application.put("/sportsman/save", sportsman, function(data) {
            console.log(data);
            if (callback) {
                callback()
            } else {
                $('#saveTrainer').modal('open');
            }
        });
    };


    Sportsman.setContent = function(data) {
        var array = data.result;
        var temp = [];
        var now = new Date().getFullYear();
        array.forEach(function(item) {
            item.title = item.family + ' '  + (item.name ? item.name.substr(0, 1) : '');
            var tempDate = new Date(item.birthDay).getFullYear();
            item.ages = (now - tempDate) + ' лет';
            temp.push(item);
        });

        Sportsman.sportsmanList.sportsmans = temp;
    };


    Sportsman.home = function(page) {
        var pagination = new Pagination($('.sportsman_pagination'), {
            count:   '/sportsman/list/count',
            content: '/sportsman/list/'
        }, 'sportsman');

        pagination.initialize();
        Sportsman.getSportsmans(page, Sportsman.setContent);
        return pagination;
    };


    Sportsman.initialization = function() {
        Sportsman.sportsmanList = new Vue({
            el: '#sportsman-list',
            data: {
                sportsmans: [],
                showed: true,
                showInfo: false,
                trainer: null,
                root: '?action=sportsman-list',
                hash: '#sportsman-page-'
            }
        });

        $('.modal').modal();
        var pagination = Sportsman.home(1);
        Sportsman.page = 1;
        Router.watch(/^sportsman-page/, function(arg) {
            $('.pagination').show();
            Trainer.trainersList.showed = true;
            Trainer.trainersList.showInfo = false;

            var page = +arg.split('-')[2];
            if (!$("div").is("#trainer-list")) {
                var rowContent = $('<div/>', {
                    class: 'row',
                    id: 'trainer-list'
                });

                var rowPaggin = $('<div/>', {
                    class: 'row'
                }).append($('<div/>', {
                    class: 'col s12 sportsman_pagination'
                }));

                $('#app-content').append(rowContent).append(rowPaggin);
                pagination = Trainer.home(page);
            }

            Sportsman.getSportsmans(page, Sportsman.setContent);
            pagination.setPage(page);
            Sportsman.page = page;
        });


        Router.watch(/^trainer-info/, function(arg) {
            var id = arg.split('-')[2];
            Trainer.getTrainerInfo(id, function () {
                $('.pagination').hide();
                Trainer.trainersList.showed = false;
                Trainer.trainersList.showInfo = true;

                $(document).ready(function() {
                    var $input = $('.datepicker').pickadate({
                        selectMonths: true,
                        selectYears: 30,
                        today: 'Сегодня',
                        clear: 'Отчистить',
                        close: 'Ok',
                        closeOnSelect: false
                    });

                    var picker = $input.pickadate('picker');
                    picker.set('select', Trainer.trainersList.trainer.dayOfBirth);

                    $('select').material_select();
                    $('.select-dropdown').val(Trainer.trainersList.trainer.qualification);
                });

            });
        });
    };



    Sportsman.basicInit = function () {
        $(document).ready(function() {
            $('.modal').modal();
            var $input = $('.datepicker').pickadate({
                selectMonths: true,
                selectYears: 30,
                today: 'Сегодня',
                clear: 'Отчистить',
                close: 'Ok',
                closeOnSelect: false
            });
            $('select').material_select();
        });
    };


    function getRange(page) {
        var max = page * itemsPerPage;

        var result = {};
        result.to = max + 1;
        result.from = max - itemsPerPage;
        return result
    }


    window.Sportsman = Sportsman;
})();
