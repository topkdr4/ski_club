(function() {
    "use strict";

    var itemsPerPage = 9;

    function Trainer () {}


    Trainer.getTrainers = function(page, callback) {
        var range = getRange(page);
        Application.get("/trainer/list/" + range.from + '/' + range.to, {}, callback);
    };


    Trainer.setContent = function(data) {
        var array = data.result;
        var temp = [];
        array.forEach(function(item) {
            var tmpDate = new Date(item.dayOfBirth);
            temp.push({
                id: item.id,
                family: item.family,
                name: item.name,
                qualification: item.qualification,
                dayOfBirth: tmpDate.toLocaleDateString()
            });
        });

        Trainer.trainersList.trainers = temp;
    };


    Trainer.home = function(page) {
        var pagination = new Pagination($('.trainer_pagination'), {
            count:   '/trainer/list/count',
            content: '/trainer/list/'
        }, 'trainer');

        pagination.initialize();
        Trainer.getTrainers(page, Trainer.setContent);
        return pagination;
    };


    Trainer.getTrainerInfo = function(trainerId, callback) {
        Application.get("/trainer/get/" + trainerId, {id: trainerId}, function(data) {
            Trainer.trainersList.trainer = data;
            callback();
        });
    };


    Trainer.removeTrainer = function(trainerId) {
        Application.remove("/trainer/remove/" + trainerId, {}, function(data) {
            window.location.hash = '#trainer-page-' + Trainer.page;
        });
    };


    Trainer.saveTrainer = function(trainer, callback) {
        Application.put("/trainer/save", trainer, function(data) {
            if (callback) {
                callback()
            } else {
                $('#saveTrainer').modal('open');
            }
        });
    };


    Trainer.initialization = function() {
        Trainer.trainersList = new Vue({
            el: '#trainer-list',
            data: {
                trainers: [],
                showed: true,
                showInfo: false,
                trainer: null,
                root: '?action=trainer-list',
                hash: '#trainer-page-'
            }
        });

        $('.modal').modal();
        var pagination = Trainer.home(1);
        Trainer.page = 1;
        Router.watch(/^trainer-page/, function(arg) {
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
                    class: 'col s12 trainer_pagination'
                }));

                $('#app-content').append(rowContent).append(rowPaggin);
                pagination = Trainer.home(page);
            }

            Trainer.getTrainers(page, Trainer.setContent);
            pagination.setPage(page);
            Trainer.page = page;
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


    Trainer.basicInit = function () {
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


    $('.trainer-confirm-remove').on('click', function() {
       var id = $(this).attr('data-trainer-id');
       Trainer.removeTrainer(id);
    });

    $('.trainer-save-confirm').on('click', function() {
        Trainer.saveTrainer(Trainer.trainersList.trainer);
    });

    window.Trainer = Trainer;

})();
