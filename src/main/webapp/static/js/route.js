(function() {
    "use strict";

    var Router = window.Router = {
        watch:  watch,
        route:  routePath,
        update: routeHash,
        onNotFound: function(path) {}
    };

    var routes = [];


    function watch(regexp, handler) {
        routes.push({
            regexp:  regexp,
            handler: handler
        });
    }


    function route(path) {
        for (var i = 0; i < routes.length; i++) {
            var route = routes[i];
            var match = route.regexp.exec(path);
            if (match != null) {
                match[0] = path;
                route.handler.apply(null, match);
                return;
            }
        }

        if (Router.onNotFound)
            Router.onNotFound(path);
    }


    function routePath(sourcePath, replace) {
        var path = sourcePath.replace(/^#+/, '');

        if (replace) {
            history.replaceState(null, null, '#' + path);
        } else {
            history.pushState(null, null, '#' + path);
        }

        route(path);
    }


    function routeHash(e) {
        var path = location.hash.replace(/^#+/, '');
        route(path);
    }


    Router.triggered = function() {
        routeHash();
    }


    $(window).on('hashchange', routeHash);
})();
