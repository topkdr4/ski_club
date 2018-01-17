"use strict";

function init() {
    $('select').material_select();
    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 30,
        today: 'Сегодня',
        clear: 'Отчистить',
        close: 'Ok',
        closeOnSelect: false
    });

    $('.dropdown-button').dropdown({
            inDuration: 300,
            outDuration: 225,
            constrainWidth: false,
            hover: false,
            gutter: 0,
            belowOrigin: false,
            alignment: 'left',
            stopPropagation: false
        }
    );
}

init();
