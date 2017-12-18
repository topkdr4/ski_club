(function () {
    "use strict";


    function Application() {

    }


    function showLoader() {

    }


    function hideLoader() {

    }


    Application.send = function(url, data, callback) {
        $.ajax({
            url: url,
            method: 'POST',
            dataType: 'json',
            data: data,
            success: function (data) {
                callback(data);
            },
            error: function (data) {

            }
        });
    }

    window.Application = Application;
})();