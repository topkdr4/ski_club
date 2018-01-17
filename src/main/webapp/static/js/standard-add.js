"use strict";

$('select').material_select();


function save() {
    var ages = $('#ages').val();
    var sex  = $('#sex').val();
    var reqt = {
        id: null,
        name: $('#specification-name').val(),
        requier: $('#specification-require').val(),
        type: $('#specification-type').val(),
        desc: $('#specification-description').val()
    };

    Application.put("/standard/save/" + sex + '/' + ages, reqt, function (data) {
        $('#specification-name').val('');
        $('#specification-description').val('');
        $('#specification-require').val('');
    });
}


$('#save-standard').on('click', save);
