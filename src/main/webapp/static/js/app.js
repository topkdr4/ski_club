(function () {
    "use strict";

    var preloader = $('<div/>', {
        class: 'follow'
    }).append($('<div/>').append($('<div/>')));

    var hover = $('<div/>', {
        class: 'hover'
    }).append(preloader);

    function Application() {

    }


    function showLoader() {
        $('body').append(hover);
    }


    function hideLoader() {
        $('.hover').remove();
    }


    Application.put = function(url, data, callback) {
        showLoader();
        $.ajax({
            url: '/rest' + url,
            method: 'PUT',
            dataType: 'json',
            contentType : "application/json",
            data: JSON.stringify(data),
            success: function(data) {
                hideLoader();
                callback(data);
            },
            error: function (data) {
                hideLoader();
            }
        });
    };


    Application.get = function(url, data, callback) {
        showLoader();
        $.ajax({
            url: '/rest' + url,
            method: 'GET',
            dataType: 'json',
            data: data,
            success: function(data) {
                hideLoader();
                callback(data);
            },
            error: function (data) {
                hideLoader();
            }
        });
    };


    Application.remove = function(url, data, callback) {
        showLoader();
        $.ajax({
            url: '/rest' + url,
            method: 'DELETE',
            dataType: 'json',
            data: data,
            success: function(data) {
                hideLoader();
                callback(data);
            },
            error: function (data) {
                hideLoader();
            }
        });
    };

    window.Application = Application;
})();
