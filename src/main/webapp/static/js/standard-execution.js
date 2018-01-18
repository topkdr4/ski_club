"use strict";

var trainers  = {};
var standards = {};
var sportsmans = {};
var result = {};

var selected = {
    sex: false,
    age: 11,
    finded: false
};

function init() {
    $('select').material_select();
    $('.modal').modal();
    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 30,
        today: 'Сегодня',
        clear: 'Отчистить',
        close: 'Ok',
        closeOnSelect: false
    });

    Application.get("/trainer/list", {}, function(data) {
        var trainerList = $('#trainer');
        trainerList.empty();
        trainerList.append($('<option></option>', {
            value: 'null',
            text: 'Нет'
        }));

        data.result.forEach(function(trainer) {
            trainers[trainer.id] = trainer;
            trainerList.append($('<option></option>', {
                value: trainer.id,
                text: trainer.family
            }));
        });

        $("select").material_select();
        fillData();
    });
}


function fillData() {
    standards = {};
    sportsmans = {};

    var sex = $('#sex').val();
    var ages = $('#ages').val();

    selected = {
        sex: sex,
        age: ages
    };

    var list = $('#standards-list');

    Application.get('/standard/list/' + sex + '/' + ages, {}, function(data) {
        list.empty();

        list.append($('<option></option>', {
            value: 'null',
            text: 'Норматив'
        }));

        data.result.forEach(function(std) {
            standards[std.id] = std;
            list.append($('<option></option>', {
                value: std.id,
                text: std.name
            }));
        });

        $("select").material_select();

        Application.get('/standard/sportsmans/' + sex + '/' + ages, {}, function(data) {
            var sportsmansList = $('#sportsman');
            sportsmansList.empty();

            data.result.forEach(function(sport) {
                sportsmans[sport.id] = sport;
                sportsmansList.append($('<option></option>', {
                    value: sport.id,
                    text: sport.family
                }));
            });

            $("select").material_select();
            console.log('standards', standards);
            console.log('sportsmans', sportsmans);
        });
    })
}


function find() {
    var list = $('#standards-list');
    if (list.val() == 'null') {
        Materialize.toast('Не выбран норматив!', 1500);
        return;
    }

    var picker = $('.datepicker').pickadate('picker');
    if (!picker.get('select')) {
        Materialize.toast('Не выбрана дата!', 1500);
        return;
    }

    Application.get('/standard/liststd/' + list.val() + '/' + picker.get('select').pick, {}, function(data) {
        selected.finded = true;
        result = {};
        var table = $('#table > tbody');
        table.empty();

        var num = 1;
        data.result.forEach(function(res) {
            result[res.id] = res;

            var tr = $('<tr/>');

            var numLine = $('<td/>').text(num);
            var fam     = $('<td/>').text(res.sportsman.family);
            var resu    = $('<td/>').text(res.result);
            var suc     = $('<td/>').text(res.success ? 'Сдано' : 'Не сдано');
            var dat     = $('<td/>').text(new Date(res.date).toLocaleDateString());
            var more    = $('<td/>').append($('<a/>', {
                class: 'std-modal'
            }).attr({
                'data-result-id': res.id,
                'href': '#!'
            }).text('Подробнее'));

            tr.append(numLine)
                .append(fam)
                .append(resu)
                .append(suc)
                .append(dat)
                .append(more);

            table.append(tr);
            num++;
        });

        console.log('result', result);
    });
}


function showModal() {
    var list = $('#standards-list');
    if (list.val() == 'null') {
        Materialize.toast('Не выбран норматив!', 1500);
        return;
    }

    var picker = $('.datepicker').pickadate('picker');
    if (!picker.get('select')) {
        Materialize.toast('Не выбрана дата!', 1500);
        return;
    }

    if (!selected.finded) {
        Materialize.toast('Поиск не выполнен!', 1500);
        return;
    }

    var id = $(this).attr('data-result-id');
    if (id) {
        $('#removeResult').show();
        $('#removeResult').attr({
            'data-result-id': id
        });
        $('#saveResult').attr({
            'data-result-id': id
        });

        fillForm(id);
    } else {
        $('#removeResult').hide();
        clearForm();
    }

    var modal = $('#std-result');
    modal.modal('open');
}


function fillForm(id) {
    var resultValue = result[id];

    if (resultValue.trainerId) {
        $('#trainer').val(resultValue.trainerId);
    } else {
        $('#trainer').val('null');
    }

    $('#sportsman').val(resultValue.sportsman.id);

    var radio = resultValue.success ? $('#succsess') : $('#no-succsess');
    radio.attr('checked', 'checked');

    $('#sportsman-result').val(resultValue.result);
    var $input = $('#deadLine').pickadate({
        selectMonths: true,
        selectYears: 30,
        today: 'Сегодня',
        clear: 'Отчистить',
        close: 'Ok',
        closeOnSelect: false
    });

    var picker = $input.pickadate('picker');
    picker.set('select', resultValue.date);
    $("select").material_select();
}


function clearForm() {
    $("#trainer").val($("#trainer option:first").val());
    $("#sportsman").val($("#sportsman option:first").val());
    $('#succsess').attr('checked', 'checked');
    $('#sportsman-result').val('');
    $("select").material_select();
}


function removeResult() {
    Application.remove("/standard/sportsmans/result/" + $(this).attr('data-result-id'), {}, find);
}


function saveResult() {
    var id = $(this).attr('data-result-id');
    Application.put("/standard/sportsmans/save/result", {
        id: id,
        sportsman: {
            id: $('#sportsman').val()
        },
        trainerId: $('#trainer').val(),
        result: $('#sportsman-result').val(),
        success: $('#succsess').attr('checked') == 'checked',
        date: $('#deadLine').pickadate('picker').get('select').pick,
        stdId: $('#standards-list').val()
    }, find);
}


init();


$('#sex').on('change', fillData);
$('#ages').on('change', fillData);
$('#table').on('click', '.std-modal', showModal);
$('.add-result').on('click', showModal);
$('.find-result').on('click', find);
$('#removeResult').on('click', removeResult);
$('#saveResult').on('click', saveResult);
