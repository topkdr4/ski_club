Vue.component('sportsman-cards', {
    props: [ 'sportsman' ],
    template: '<div class="col s4">\n' +
    '        <div id="app1" class="card hoverable">\n' +
    '            <div class="person card-content">\n' +
    '                <div class="person-image"' +
    '                   v-bind:class="[{man : sportsman.sex}, {wom : !sportsman.sex}]"' +
    '                   ></div>\n' +
    '                <div class="person-info">\n' +
    '                    <div class="person-info-item">\n' +
    '                        <span>{{sportsman.title}}</span>\n' +
    '                    </div>\n' +
    '                    <div class="person-info-item">\n' +
    '                        <span>{{sportsman.ages}}</span>\n' +
    '                    </div>\n' +
    '                    <div class="person-info-item">\n' +
    '                        <span>Состоит в клубе с: {{sportsman.yearOfStart}}г.</span>\n' +
    '                    </div>\n' +
    '                    <div class="person-info-item">\n' +
    '                        <span>Квалификация: {{sportsman.qualification}}</span>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </div>'
});


Vue.component('sportsman-info', {
    props: [ 'sportsman' ],
    template: '<div class="col s12">\n' +
    '        <div class="row" id="sportsman-form">\n' +
    '            <div class="row">\n' +
    '                <div class="col s3 card">\n' +
    '                    <div class="col s12">\n' +
    '                        <div  v-bind:class="[{fullMan : sportsman.sex}, {fullWom : !sportsman.sex}]"></div>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '                <div class="col s9 card">\n' +
    '                    <div class="row">\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input v-model="sportsman.family" placeholder="Фамилия" id="family" type="text" class="validate">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input v-model="sportsman.name" placeholder="Имя" id="name" type="text" class="validate">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <select>\n' +
    '                                <option value="1">Мастер спорта международного класса</option>\n' +
    '                                <option value="2">Мастер спорта</option>\n' +
    '                                <option value="3">Кандидат в мастера спорта</option>\n' +
    '                                <option value="4">I разряд</option>\n' +
    '                                <option value="5">II разряд</option>\n' +
    '                                <option value="6">III разряд</option>\n' +
    '                                <option value="7">Нет</option>\n' +
    '                            </select>\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input v-model="sportsman.weight" placeholder="Вес" id="weight" type="text" class="validate">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input v-model="sportsman.height" placeholder="Рост" id="height" type="number" class="validate">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s4">\n' +
    '                            <input placeholder="Дата рождения" id="dayOfBirth" type="text" class="datepicker">\n' +
    '                        </div>\n' +
    '                        <div class="input-field col s3">\n' +
    '                            <input v-model="sportsman.yearOfStart" placeholder="Начало занятий" id="sportStart" type="number">\n' +
    '                        </div>\n' +
    '                        <div class="col s3">\n' +
    '                            <p>\n' +
    '                                <input name="sex" type="radio" id="man-sex" checked @click="change_sex"/>\n' +
    '                                <label for="man-sex">Мужской</label>\n' +
    '                            </p>\n' +
    '                            <p>\n' +
    '                                <input name="sex" type="radio" id="wom-sex" @click="change_sex"/>\n' +
    '                                <label for="wom-sex">Женский</label>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                        <div class="col s3">\n' +
    '                            <p>\n' +
    '                                <a class="waves-effect waves-light btn-large teal darken-2" @click="save">Сохранить</a>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                        <div class="col s3" v-if="sportsman.id">\n' +
    '                            <p>\n' +
    '                                <a class="waves-effect waves-light btn-large red darken-2" @click="remove">Удалить</a>\n' +
    '                            </p>\n' +
    '                        </div>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </div>',
    methods: {
        change_sex: function () {
            this.sportsman.sex = !this.sportsman.sex;
        },
        save: function() {
            this.sportsman.qualification = $('.select-dropdown').val();
            this.sportsman.birthDay = $('.datepicker').pickadate('picker').get('select').pick;
            if (Sportsman.sportsmanList) {
                Sportsman.saveSportsman(this.sportsman);
            } else {
                this.sportsman.id = null;
                Sportsman.saveSportsman(this.sportsman, function () {
                    window.location = '?action=sportsman-list'
                });
            }
        },
        remove: function() {
            $('.trainer-confirm-name').html('Тренер «' + (this.trainer.family) + '» <b>удален</b>. Продолжить?');
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
