"use strict";

var $input = $('#gameDate').pickadate({
    selectMonths: true,
    selectYears: 30,
    today: 'Сегодня',
    clear: 'Отчистить',
    close: 'Ok',
    closeOnSelect: false
});
$("select").material_select();
$('.modal').modal();

var picker = $input.pickadate('picker');
picker.set('select', new Date().getTime());


function setContent() {
    var table = $('#table > tbody');
    table.empty();

    Application.get("/games/list/" +
        picker.get('select').pick + '/'
        + $('#sex').val() + '/'
        + $('#ages').val(), {}, function(data) {
        var num = 1;
        data.result.forEach(function(game) {
            var tr = $('<tr/>');

            var numLine = $('<td/>').text(num++);
            var name = $('<td/>').text(game.name);
            var info = $('<td/>').append(
                $('<a/>', {
                    href: '?action=game-info&sex=' + $('#sex').val() + '&ages=' + $('#ages').val() + '&id=' + game.id
                }).text('Подробнее')
            );

            var remove = $('<td/>').append($('<a/>',{
                class: 'red-text removeGame',
                href: 'javascript:;',
                'game-id': game.id
            }).text('Удалить'));

            tr.append(numLine)
                .append(name)
                .append(info)
                .append(remove);

            table.append(tr);
        });
    });
}


function addNewGame() {
    $('#gameName').val('');
    var modal = $('#new-game-modal');
    modal.modal('open');
}


function saveGame() {
    Application.put('/games/add/' +
        $('#gameName').val() + '/' +
        picker.get('select').pick + '/' +
        $('#sex').val() + '/' +
        $('#ages').val(), {}, setContent);
}


function removeGame() {
    Application.remove("/games/game/remove/" + $(this).attr('game-id'), {}, setContent);
}


$('#gameDate').on('change', setContent);
$('#sex').on('change', setContent);
$('#ages').on('change', setContent);
$('#newGame').on('click', addNewGame);
$('#saveGame').on('click', saveGame);
$('#table').on('click', '.removeGame', removeGame);

setContent();
