(function(){
    "use strict";

    var itemsPerPage = 9;

    function Sportsman() {}


    Sportsman.getSportsmans = function(page, callback) {
        var range = getRange(page);
        Application.get("/sportsman/list/" + range.from + '/' + range.to, {}, callback);
    };


    Sportsman.getSportsmanInfo = function(sportsmanId, callback) {
        Application.get("/sportsman/get/" + sportsmanId, {}, function(data) {
            Sportsman.sportsmanList.sportsman = data;
            callback();
        });
    };


    Sportsman.saveSportsman = function(sportsman, callback) {
        Application.put("/sportsman/save", sportsman, function(data) {
            if (callback) {
                callback()
            } else {
                $('#saveSportsman').modal('open');
            }
        });
    };


    Sportsman.removeSportsman = function(sportsmanId, callback) {
        Application.remove("/sportsman/remove/" + sportsmanId, {id: sportsmanId}, function(data) {
            window.location.hash = '#sportsmanId-page-' + Sportsman.page;
        });
    };


    Sportsman.setContent = function(data) {
        var array = data.result;
        var temp = [];
        var now = new Date().getFullYear();
        array.forEach(function(item) {
            var tempDate = new Date(item.birthDay).getFullYear();
            item.ages = (now - tempDate) + ' лет';
            item.title = item.family + ' '  + (item.name ? item.name.substr(0, 1) : '');

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
                sportsman: null,
                root: '?action=sportsman-list',
                hash: '#sportsman-page-'
            }
        });

        $('.modal').modal();
        var pagination = Sportsman.home(1);
        Sportsman.page = 1;
        Router.watch(/^sportsman-page/, function(arg) {
            $('.pagination').show();
            Sportsman.sportsmanList.showed = true;
            Sportsman.sportsmanList.showInfo = false;

            var page = +arg.split('-')[2];
            if (!$("div").is("#sportsman-list")) {
                var rowContent = $('<div/>', {
                    class: 'row',
                    id: 'sportsman-list'
                });

                var rowPaggin = $('<div/>', {
                    class: 'row'
                }).append($('<div/>', {
                    class: 'col s12 sportsman_pagination'
                }));

                $('#app-content').append(rowContent).append(rowPaggin);
                pagination = Sportsman.home(page);
            }

            Sportsman.getSportsmans(page, Sportsman.setContent);
            pagination.setPage(page);
            Sportsman.page = page;
        });


        Router.watch(/^sportsman-info/, function(arg) {
            var id = arg.split('-')[2];
            Sportsman.getSportsmanInfo(id, function () {
                $('.pagination').hide();
                Sportsman.sportsmanList.showed = false;
                Sportsman.sportsmanList.showInfo = true;

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
                    picker.set('select', Sportsman.sportsmanList.sportsman.birthDay);

                    $('select').material_select();
                    $('.select-dropdown').val(Sportsman.sportsmanList.sportsman.qualification);
                });

            });
        });

        if (location.hash != '')
            Router.triggered();
    };


    Sportsman.basicInit = function () {
        $(document).ready(function() {
            $('ul.tabs').tabs();
            $('.modal').modal();
            $('.datepicker').pickadate({
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


    $('.sportsman-confirm-remove').on('click', function() {
        var id = $(this).attr('data-sportsman-id');
        Sportsman.removeSportsman(id);
    });

    window.Sportsman = Sportsman;
})();
