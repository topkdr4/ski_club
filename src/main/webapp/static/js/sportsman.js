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
            window.location.hash = '#sportsman-page-' + Sportsman.page;
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
                    $('ul.tabs').tabs();
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


    $('body').on('click', 'li > a[href="#standards"]', function() {
        var id = Sportsman.sportsmanList.sportsman.id;
        Application.get('/sportsman/result/get/' + id, {}, function(data) {
            var table = $('#std_table > tbody');
            table.empty();

            var num = 1;
            data.result.forEach(function(item) {
                var tr = $('<tr/>');

                var numLine = $('<td/>').text(num++);
                var name  = $('<td/>').text(item.name);
                var date  = $('<td/>').text(new Date(item.date).toLocaleDateString());
                var success = $('<td/>').text(item.success ? 'Сдано' : 'Не сдано');

                tr.append(numLine)
                    .append(name)
                    .append(date)
                    .append(success);

                table.append(tr);
            });
        });
    });


    $('body').on('click', 'li > a[href="#games"]', function() {
        var id = Sportsman.sportsmanList.sportsman.id;
        Application.get('/sportsman/places/get/' + id, {}, function(data) {
            var table = $('#game_table > tbody');
            table.empty();

            var num = 1;
            data.result.forEach(function(item) {
                var tr = $('<tr/>');

                var numLine = $('<td/>').text(num++);
                var name  = $('<td/>').text(item.name);
                var date  = $('<td/>').text(new Date(item.date).toLocaleDateString());
                var res = $('<td/>').text(item.place + ' место');

                tr.append(numLine)
                    .append(name)
                    .append(date)
                    .append(res);

                table.append(tr);
            });
        });
    });


    $('body').on('click', 'li > a[href="#prognoz"]', function() {
        var id = Sportsman.sportsmanList.sportsman.id;
        Application.get('/sportsman/places/get/' + id, {}, function(data) {
           var list = [];
           var num = 1;
           var def = [];

           data.result.forEach(function(item) {
               list.push({
                   x: num,
                   y: item.place
               });

               var _tempArray = [];
               _tempArray.push(num);
               _tempArray.push(item.place);
               def.push(_tempArray);
               num++;
           });

            var lll = minSquare(list);
            var regress = [];
            lll.forEach(function(item) {
                var __temp = [];
                __temp.push(item.x);
                __temp.push(item.y);
                regress.push(__temp);
            });

            Highcharts.chart('graph', {
                credits: {
                    enabled: false
                },
                xAxis: {
                    min: 0,
                    title: {
                        text: 'Игра'
                    }
                },
                yAxis: {
                    title: {
                        text: 'Занятое место'
                    },
                    min: 0
                },
                title: {
                    text: 'Модель линейной регрессии'
                },
                series: [{
                    type: 'line',
                    name: 'Линейная регрессия',
                    data: regress,
                    marker: {
                        enabled: true
                    },
                    states: {
                        hover: {
                            lineWidth: 0
                        }
                    },
                    enableMouseTracking: false
                }, {
                    type: 'scatter',
                    name: 'Исходные данные',
                    data: def,
                    marker: {
                        radius: 4
                    }
                }]
            });
        });
    });

    window.Sportsman = Sportsman;

    //*************************************

    // Метод наименьших квадратов
    function minSquare(list) {
        var midX = getSumX(list) / list.length;
        var midY = getSumY(list) / list.length;
        var b = (list.length * getCompXY(list) - getSumX(list) * getSumY(list)) / (list.length * getSumCompX(list) - Math.pow(getSumX(list), 2));
        var a = midY - b * midX;

        var result = [];
        list.forEach(function(item) {
            result.push({
                x: item.x,
                y: a + b * item.x
            });
        });

        return result;
    }


    function getSumX(list) {
        var result = 0;
        list.forEach(function(item) {
            result += item.x;
        });
        return result;
    }


    function getSumY(list) {
        var result = 0;
        list.forEach(function(item) {
            result += item.y;
        });
        return result;
    }


    function getCompXY(list) {
        var result = 0;
        list.forEach(function(item) {
            result += (item.x * item.y);
        });
        return result;
    }


    function getSumCompX(list) {
        var result = 0;
        list.forEach(function(item) {
            result += (Math.pow(item.x, 2));
        });
        return result;
    }

})();
