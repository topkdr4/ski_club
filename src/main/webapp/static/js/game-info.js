"use strict";

$('.modal').modal();
var sportsmansList = $('#sportsman');
sportsmansList.empty();
sportsmans.forEach(function(item) {
    sportsmansList.append($('<option></option>', {
        value: item.id,
        text: item.family
    }));
});
$("select").material_select();



var games = {};

function getGameInfo() {
    var table = $('#table > tbody');
    table.empty();

    var num = 1;
    Application.get('/games/sportsmans/list/' + id, {}, function(data) {
        games = {};


        function getMax(array) {
            var max = array[0];
            array.forEach(function (item) {
                if (max < item)
                    max = item;
            });

            return max;
        }


        function getMin(array) {
            var min = array[0];
            array.forEach(function(item) {
                if (item < min)
                    min = item;
            });
            return min;
        }


        function sum(array) {
            var result = 0;

            array.forEach(function(item) {
                result += item;
            });

            return result;
        }


        function getScore(game) {
            return game.compensation + game.wind + game.jump + sum(game.judge) - getMax(game.judge) - getMin(game.judge);
        }

        data.result.sort(function(a, b) {
            return getScore(b) - getScore(a);
        });


        data.result.forEach(function(gameInfo) {
            games[gameInfo.gameId] = gameInfo;

            var tr = $('<tr/>');

            var numLine = $('<td/>').text(num++);
            var family  = $('<td/>').text(gameInfo.family);
            var range   = $('<td/>').text(gameInfo.jump);
            tr.append(numLine)
                .append(family)
                .append(range);

            gameInfo.judge.forEach(function(judge) {
                tr.append($('<td/>').text(judge));
            });

            var compensation = $('<td/>').text(gameInfo.compensation);
            var wind = $('<td/>').text(gameInfo.wind);
            var more = $('<a/>', {
                class: 'get-more-info'
            }).text('Подробнее').attr({
                'data-gameResult-id': gameInfo.resultGameId,
                'href': 'javascript:;'
            });

            tr.append(compensation)
                .append(wind)
                .append($('<td/>').text(getScore(gameInfo)))
                .append($('<td/>').append(more));

            table.append(tr);
        });
    });
}


function clear() {

}


function getResultInfo() {
    clear();

    var current = $(this);
    if (current.attr('data-gameResult-id')) {
        $('#removeResult').attr({
            'data-gameResult-id': current.attr('data-gameResult-id')
        }).show();
        $('#saveResult').attr({
            'data-gameResult-id': current.attr('data-gameResult-id')
        }).show();
    } else {
        $('#removeResult').hide();
        $('#saveResult').attr({
            'data-gameResult-id': null
        }).show();
    }

    var modal = $('#game-result');
    modal.modal('open');
}


function removeResult() {
    Application.remove("/games/remove/" + $(this).attr('data-gameResult-id'), {}, function() {
        clear();
        getGameInfo();
    });
}


getGameInfo();
$('#table').on('click', '.get-more-info', getResultInfo);
$('#newResult').on('click', getResultInfo);
$('#removeResult').on('click', removeResult);
