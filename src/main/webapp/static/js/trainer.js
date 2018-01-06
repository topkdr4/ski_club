(function() {
    "use strict";

    var itemsPerPage = 9;

    function Trainer () {}


    Trainer.getTrainers = function(page, callback) {
        var range = getRange(page);
        Application.get("/trainer/list/" + range.from + '/' + range.to, {}, callback);
    };


    Trainer.trainersList = new Vue({
        el: '#trainer-list',
        data: {
            trainers: []
        }
    });


    Trainer.setContent = function(data) {
        var array = data.result;
        var temp = [];
        array.forEach(function(item) {
            var tmpDate = new Date(item.dayOfBirth);
            temp.push({
                family: item.family,
                name: item.name,
                qualification: item.qualification,
                dayOfBirth: tmpDate.toLocaleDateString()
            });
        });

        Trainer.trainersList.trainers = temp;
    };


    Trainer.home = function() {
        var pagination = new Pagination($('.trainer_pagination'), {
            count:   '/trainer/list/count',
            content: '/trainer/list/'
        }, 'trainer');

        pagination.initialize();
        Trainer.getTrainers(1, Trainer.setContent);
    };


    Trainer.getTrainerInfo = function(trainerId) {
        Application.get("/trainer/get/" + trainerId, {id: trainerId}, function(data) {
            console.log(data);
        });
    };


    Trainer.removeTrainer = function(trainerId) {
        Application.remove("/trainer/remove/" + trainerId, {id: trainerId}, function(data) {
            console.log(data);
        });
    };


    Trainer.saveTrainer = function(trainer) {
        Application.put("/trainer/save", trainer, function(data) {
            console.log(data);
        });
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
