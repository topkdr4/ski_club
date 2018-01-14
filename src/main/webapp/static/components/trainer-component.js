Vue.component('trainer-cards', {
    props: [ 'trainer' ],
    template: '<div class="col s4" @click="getTrainerInfo">' +
    '                <div class="card hoverable">\n' +
    '                    <div class="trainer">\n' +
    '                        <div class="trainer-info">\n' +
    '                            <div class="trainer-info-item">\n' +
    '                                <span>{{trainer.family}}</span>\n' +
    '                            </div>\n' +
    '                            <div class="trainer-info-item">\n' +
    '                                <span>{{trainer.name}}</span>\n' +
    '                            </div>\n' +
    '                            <div class="trainer-info-item">\n' +
    '                                <span>{{trainer.dayOfBirth}}</span>\n' +
    '                            </div>\n' +
    '                            <div class="trainer-info-item">\n' +
    '                                <span>{{trainer.qualification}}</span>\n' +
    '                            </div>\n' +
    '                        </div>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>',
    methods: {
        getTrainerInfo: function() {
            window.location.hash = '#trainer-info-'+this.trainer.id;
        }
    }
});


Vue.component('trainer-info', {
    props: [ 'trainer' ],
    template: '<div class="row" id="trainer-form">\n' +
    '            <div class="row">\n' +
    '                <div class="col s12 card">\n' +
    '                    <div class="row">\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input id="family" placeholder="Фамилия" type="text" class="validate" v-model="trainer.family">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input id="name" placeholder="Имя" type="text" class="validate" v-model="trainer.name">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input id="dayOfBirth" placeholder="Дата рождения" type="text" class="datepicker">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s12">\n' +
    '                            <select v-model="trainer.qualification">\n' +
    '                                <option value="1" data-icon="/static/icons/awards/award_star_gold_1.png"  class="left circle">Тренер-преподаватель высшего уровня квалификации высшей категории</option>\n' +
    '                                <option value="2" data-icon="/static/icons/awards/medal_gold_1.png"       class="left circle">Тренер-преподаватель высшего уровня квалификации первой категории</option>\n' +
    '                                <option value="3" data-icon="/static/icons/awards/medal_silver_1.png"     class="left circle">Тренер-преподаватель высшего уровня квалификации второй категории</option>\n' +
    '                                <option value="4" data-icon="/static/icons/awards/medal_bronze_1.png"     class="left circle">Тренер-преподаватель высшего уровня квалификации без категории</option>\n' +
    '                                <option value="5" data-icon="/static/icons/awards/award_star_gold_2.png"  class="left circle">Тренер-преподаватель среднего уровня квалификации высшей категории</option>\n' +
    '                                <option value="6" data-icon="/static/icons/awards/medal_gold_2.png"       class="left circle">Тренер-преподаватель среднего уровня квалификации первой категории</option>\n' +
    '                                <option value="7" data-icon="/static/icons/awards/medal_silver_2.png"     class="left circle">Тренер-преподаватель среднего уровня квалификации второй категории</option>\n' +
    '                                <option value="8" data-icon="/static/icons/awards/medal_bronze_2.png"     class="left circle">Тренер-преподаватель среднего уровня квалификации без категории</option>\n' +
    '                                <option value="9" data-icon="/static/icons/awards/award_star_gold_3.png"  class="left circle">Инструктор, инструктор-методист высшего уровня квалификации высшей категории</option>\n' +
    '                                <option value="10" data-icon="/static/icons/awards/medal_gold_3.png"      class="left circle">Инструктор, инструктор-методист высшего уровня квалификации первой категории</option>\n' +
    '                                <option value="11" data-icon="/static/icons/awards/medal_silver_3.png"    class="left circle">Инструктор, инструктор-методист высшего уровня квалификации второй категории</option>\n' +
    '                                <option value="12" data-icon="/static/icons/awards/medal_bronze_3.png"    class="left circle">Инструктор, инструктор-методист высшего уровня квалификации без категории</option>\n' +
    '                                <option value="13" data-icon="/static/icons/awards/award.png"             class="left circle">Инструктор, инструктор-методист среднего уровня квалификации высшей категории</option>\n' +
    '                                <option value="14" data-icon="/static/icons/awards/award.png"             class="left circle">Инструктор, инструктор-методист среднего уровня квалификации первой категории</option>\n' +
    '                                <option value="15" data-icon="/static/icons/awards/award.png"             class="left circle">Инструктор, инструктор-методист среднего уровня квалификации второй категории</option>\n' +
    '                                <option value="16" data-icon="/static/icons/awards/award.png"             class="left circle">Инструктор, инструктор-методист среднего уровня квалификации без категории</option>\n' +
    '                            </select>\n' +
    '                        </div>\n' +
    '                        <div class="col s3">\n' +
    '                            <p>\n' +
    '                                <a class="waves-effect waves-light btn-large teal darken-2" @click="save">Сохранить</a>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                        <div v-show="trainer.id != null" class="col s3">\n' +
    '                            <p>\n' +
    '                                <a class="waves-effect waves-light btn-large red darken-2" @click="remove">Удалить</a>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                        <div class="col s12" v-if="trainer.id">\n' +
    '                            <p>\n' +
    '                                <a :href="href">К списку тренеров</a>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>',

    methods: {
        save: function() {
            this.trainer.qualification = $('.select-dropdown').val();
            this.trainer.dayOfBirth = $('.datepicker').pickadate('picker').get('select').pick;
            if (Trainer.trainersList) {
                Trainer.saveTrainer(Trainer.trainersList.trainer);
            } else {
                this.trainer.id = null;
                Trainer.saveTrainer(this.trainer, function () {
                    window.location = '?action=trainer-list'
                });
            }
        },
        remove: function() {
            $('.trainer-confirm-name').html('Тренер «' + (this.trainer.family) + '» будет <b>удален</b>. Продолжить?');
            $('.trainer-confirm-remove').attr(
                'data-trainer-id', this.trainer.id
            );
            $('#removeTrainer').modal('open');
        }
    },
    computed: {
        href: function() {
            return '#trainer-page-' + Trainer.page;
        }
    }
});
