"use strict";

var values = {};
$('select').material_select();
$('.modal').modal();


function setContent() {
    var sex = $('#sex').val();
    var ages = $('#ages').val();
    var url = '/standard/list/' + sex + '/' + ages;
    Application.get(url, {}, function(data) {
        setTable(data.result);
    })
}


function setTable(array) {
    var table = $('#table > tbody');
    table.empty();

    array.forEach(function(item) {

        var tr = $('<tr/>');

        values[item.id] = {
            desc: item.desc,
            name: item.name
        };

        var name = $('<td/>').text(item.name);
        var type = $('<td/>').text(item.type);
        var requier = $('<td/>').text(item.requier);
        var desc = $('<a/>', {
            class: 'show_info'
        }).text('Подробнее').attr({
            "data-standard-id": item.id,
            "href": '#!'
        });

        tr.append(name)
            .append(type)
            .append(requier)
            .append($('<td/>').append(desc));

        table.append(tr);
    });
}


function setModelContent() {
    var modal = $('#specification-extra-description');
    var id = $(this).attr('data-standard-id');
    $('.standard-title').text(values[id].name);
    $('.standard-desc').html(values[id].desc);
    $('#removeStd').attr({
        'data-standard-id': id
    });
    modal.modal('open');
}


$('#sex').on('change', setContent);
$('#ages').on('change', setContent);
$('#table').on('click', '.show_info', setModelContent);
setContent();
