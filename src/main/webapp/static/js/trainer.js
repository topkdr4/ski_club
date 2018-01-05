(function() {
    "use strict";

    var itemsPerPage = 9;

    function Trainer () {}


    Trainer.getTrainers = function(page) {
        var range = getRange(page);
        Application.get("/trainer/list/" + range.from + '/' + range.to, {}, function(data) {
            console.log(data);
        });
    };


    Trainer.home = function() {
        Application.get("/trainer/list/count", {}, function(data) {
            var allItems = data.result;
            var allPages = Math.floor(allItems / itemsPerPage) + 1;
            //TODO: Пагинация
            console.log('all items: ' + allItems);
            console.log('all pages: ' + allPages);
            Trainer.getTrainers(1);
        });
    };


    Trainer.getTrainerInfo = function(trainerId) {
        Application.get("/trainer/get", {id: trainerId}, function(data) {
            console.log(data);
        });
    };


    Trainer.saveTrainer = function(trainer) {

    };


    function getRange(page) {
        var max = page * itemsPerPage;

        var result = {};
        result.to = max + 1;
        result.from = max - itemsPerPage;

        return result
    }


    window.Trainer = Trainer;

})();
