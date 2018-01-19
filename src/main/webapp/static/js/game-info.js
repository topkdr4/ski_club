"use strict";

var games = {};

function getFameInfo() {
    var table = $('#table > tbody');
    table.empty();

    var num = 1;
    Application.get('/games/sportsmans/list/' + id, {}, function(data) {
        games = {};
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
            var more = $('<a/>').text('Подробнее').attr({
                'data-gameResult-id': gameInfo.gameId,
                'href': 'javascript:;'
            });

            tr.append(compensation)
                .append(wind)
                .append($('<td/>').append(more));

            table.append(tr);
        });
    });
}


getFameInfo();
