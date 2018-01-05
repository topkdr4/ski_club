(function() {
    "use strict";


    /**
     * args = {
     *     source: {Array},
     *     count:  {Integer}, elements on page
     * }
     * */
    function Pagination(args) {
        this.__source = args.source;
        this.__count  = args.count;
        this.__pages  = Pagination.getPagesCount(args.source, args.count);
    }


    /**
     * Получить кол-во страниц
     * */
    Pagination.getPagesCount = function(src, elementOnPage) {
        if (!src)
            return 0;

        return Math.floor(src.length / elementOnPage) + 1;
    };


    Pagination.prototype.getElements = function(page) {
        if (page == 0 || page > this.__pages)
            throw new Error("ArrayIndexOFBoundException");

        var result = [];

        var start = (page - 1) * this.__count;
        var end   = (page * this.__count) - 1;

        if (start > end) {
            console.error("WHAT THE FUCK");
            return [];
        }

        if (start == end) {
            var temp = this.__source[start];
            return temp ? [ temp ] : [];
        }

        while (start != end) {
            var obj = this.__source[start];
            if (obj)
                result.push(obj);

            start++;
        }

        return result;
    };


    window.Pagination = Pagination;
})();
