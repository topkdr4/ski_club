"use strict";

$('ul.tabs').tabs();
$('select').material_select();


function setContent() {
    var sex = $('#sex').val();
    var type = $('#type').val();
    var url = '/record/' + type + '/' + sex;
    Application.get(url, {}, function(data) {
        setTable(data.result);
        setGraph(data.result, $('#type option:selected').text());
    })
}


function setGraph(array, title) {
    var data = [];
    array.forEach(function (item) {
        data.push(item.result);
    });

    data.sort(function(first, second) {
        return first - second;
    });

    var place = [];

    for (var i = 0; i < data.length; i++) {
        place.push(data.length - i);
    }

    Highcharts.chart('graph', {
        chart: {
            type: 'spline'
        },
        title: {
            text: ''
        },
        xAxis: {
            categories: place
        },
        yAxis: {
            title: {
                text: 'Баллы'
            }
        },
        tooltip: {
            formatter: function() {
                var s = [];
                $.each(this.points, function(i, point) {
                    var currentValue = array[point.key - 1];
                    var date = new Date(currentValue.game).toLocaleDateString();
                    s.push('<a href="?action=sportsman-list#sportsman-info-' + currentValue.id + '">' + currentValue.family + '</a><br><span>' + date + '</span>');
                });

                return s.join(" ");
            },
            useHTML: true,
            shared: true,
            style: {
                pointerEvents: 'auto'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: title,
            data: data
        }]
    });
}


function setTable(array) {
    var table = $('#table > tbody');
    table.empty();

    var numRow = 1;
    array.forEach(function(item) {
        var tmpDate = new Date(item.game);

        var tr = $('<tr/>');
        var num = $('<td/>').text(numRow);
        var fam = $('<td/>').text(item.family);
        var date = $('<td/>').text(tmpDate.toLocaleDateString());
        var result = $('<td/>').text(item.result);

        tr.append(num)
            .append(fam)
            .append(date)
            .append(result);

        table.append(tr);
        numRow++;
    });
}


setContent();
$('#sex').on('change', setContent);
$('#type').on('change', setContent);
