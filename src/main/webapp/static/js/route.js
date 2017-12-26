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
            console.log(match)
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
        console.log('path:', path);
        route(path);
    }


    $(window).on('hashchange', routeHash);
})();