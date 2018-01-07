(function() {
    "use strict";

    var ITEMS_PER_PAGE = 9;

    /**
     * toObject - в какой элемент html вставлять пагинацию
     * urls     - {
     *              count:   'урл для получения кол-во элементов',
     *              content: 'урл для получения контента'
     *            }
     * */
    function Pagination(toObject, urls, prefix) {
        this.toObject = toObject;
        this.urls     = urls;
        this.elements = {};
        this.prefix   = prefix;
    }


    Pagination.prototype.initialize = function() {
        this.toObject.empty();
        var that = this;
        Application.get(this.urls.count, {}, function(data) {
            that.elements.all   = data.result;
            that.elements.pages = Math.floor(that.elements.all / ITEMS_PER_PAGE) + 1;
            that.setPage(1);
        });
    };


    function initControllers(instance) {
        instance.controllers = {
            back: backButton(),
            next: nextButton()
        };

        initBack(instance);
        initNext(instance);
    }


    function initBack(instance) {
        instance.controllers.back.on('click', function(e) {
            if ($(this).hasClass('disabled'))
                return;

            if (instance.currentPage - 1 == 1)
                $(this).addClass('disabled');

            instance.controllers.next.removeClass('disabled');
            instance.setPage(instance.currentPage - 1);
            window.location.hash = '#' + instance.prefix + '-page-' + (instance.currentPage - 1)
        });
    }


    function initNext(instance) {
        instance.controllers.next.on('click', function(e) {
            if ($(this).hasClass('disabled'))
                return;

            if (instance.currentPage + 1 == instance.elements.pages)
                $(this).addClass('disabled');

            instance.controllers.back.removeClass('disabled');
            instance.setPage(instance.currentPage + 1);
        });
    }


    Pagination.prototype.setPage = function(pageNumber) {
        var that = this;
        var __pages = [];

        that.currentPage = pageNumber;
        that.toObject.empty();
        that.rootElement = $('<ul/>', { class: 'pagination' });
        initControllers(that);

        var back = that.controllers.back;

        if (pageNumber == 1) {
            back.addClass('disabled');
            back.removeClass('waves-effect waves-teal');
        } else {
            back.removeClass('disabled');
            back.addClass('waves-effect waves-teal');
        }

        __pages.push(back);

        var range = {
            from: 0,
            to: 0
        };

        if (pageNumber > 5) {
            range.from = (pageNumber - 2) > 0 ? pageNumber - 2 : 0;
            range.to = (pageNumber + 2) > that.elements.pages ? that.elements.pages : pageNumber + 2;
        } else {
            range.from = 0;
            range.to = (5 > that.elements.pages) ? that.elements.pages : 5;
        }

        for (var i = range.from; i < range.to; i++) {
            var button = createPageButton(that.prefix, i + 1);
            if (i + 1 == pageNumber)
                button.addClass('active teal');

            __pages.push(button);
        }

        var next = that.controllers.next;
        if (pageNumber == that.elements.pages) {
            next.addClass('disabled');
            next.removeClass('waves-effect waves-teal');
        } else {
            next.removeClass('disabled');
            next.addClass('waves-effect waves-teal');
        }
        __pages.push(next);

        __pages.forEach(function(item) {
            item.appendTo(that.rootElement);
        });

        that.toObject.append(that.rootElement);
    };


    function createPageButton(prefix, number) {
        var result = $('<li/>', {
            class: 'waves-effect waves-teal'
        });
        var link = $('<a/>', {
            href: '#' + prefix + '-page-' + number
        }).text(number);

        link.appendTo(result);
        return result;
    }


    function backButton() {
        var result = $('<li/>', {
            class: 'back-page'
        });
        var link   = $('<a/>');
        var i = $('<i/>', {
            class: 'material-icons'
        }).text('chevron_left');

        i.appendTo(link);
        link.appendTo(result);

        return result;
    }


    function nextButton() {
        var result = $('<li/>', {
            class: 'next-page'
        });
        var link   = $('<a/>');
        var i = $('<i/>', {
            class: 'material-icons'
        }).text('chevron_right');

        i.appendTo(link);
        link.appendTo(result);

        return result;
    }


    window.Pagination = Pagination;
})();
