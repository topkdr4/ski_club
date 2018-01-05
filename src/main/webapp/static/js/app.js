(function () {
    "use strict";


    function Application() {

    }


    function showLoader() {

    }


    function hideLoader() {

    }


    Application.put = function(url, data, callback) {
        $.ajax({
            url: '/rest' + url,
            method: 'PUT',
            dataType: 'json',
            data: data,
            success: callback,
            error: function (data) {

            }
        });
    };


    Application.get = function(url, data, callback) {
        $.ajax({
            url: '/rest' + url,
            method: 'GET',
            dataType: 'json',
            data: data,
            success: callback,
            error: function (data) {

            }
        });
    };


    Application.delete = function(url, data, callback) {
        $.ajax({
            url: '/rest' + url,
            method: 'DELETE',
            dataType: 'json',
            data: data,
            success: callback,
            error: function (data) {

            }
        });
    };

    window.Application = Application;
})();
