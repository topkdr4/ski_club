Vue.component('sportsman-cards', {
    props: [ 'sportsman' ],
    template: '<div class="col s4" @click="getSportsmanInfo">\n' +
    '        <div class="card hoverable">\n' +
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
    '    </div>',
    methods: {
        getSportsmanInfo: function () {
            window.location.hash = '#sportsman-info-'+this.sportsman.id;
        }
    }
});


Vue.component('sportsman-info', {
    props: [ 'sportsman' ],
    template: '<div class="row" id="sportsman-form">\n' +
    '        <div class="row" v-if="sportsman.id">\n' +
    '            <div class="col s12 card">\n' +
    '                <ul class="tabs tabs-fixed-width tabes">' +
    '                    <li class="tab col s3"><a href="#info" class="active teal-text text-darken-2">Информация</a></li>\n' +
    '                    <li class="tab col s3"><a href="#standards" class="teal-text text-darken-2">Нормативы</a></li>\n' +
    '                    <li class="tab col s3"><a href="#games" class="teal-text text-darken-2">Соревнования</a></li>\n' +
    '                    <li class="tab col s3"><a href="#prognoz" class="teal-text text-darken-2">Прогноз</a></li>' +
    '                </ul>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="row" id="info">\n' +
    '            <div class="col s3 card" v-bind:class="[{fullMan : sportsman.sex}, {fullWom : !sportsman.sex}]">\n' +
    '                 </div>\n' +
    '            <div class="col s9">\n' +
    '                <div class="row" v-if="sportsman.id">\n' +
    '                   <div class="col s4 card">\n' +
    '                      <div class="collapsible-header valign-wrapper flow-text" style="justify-content: space-evenly;">\n' +
    '                         <img src="static/icons/awards/award-1.png" alt="" class="circle">{{sportsman.places.first}}\n' +
    '                      </div>\n' +
    '                   </div>\n' +
    '                   <div class="col s4 card">\n' +
    '                      <div class="collapsible-header valign-wrapper flow-text" style="justify-content: space-evenly;">\n' +
    '                         <img src="static/icons/awards/award-2.png" alt="" class="circle">{{sportsman.places.second}}\n' +
    '                      </div>\n' +
    '                    </div>\n' +
    '                    <div class="col s4 card">\n' +
    '                       <div class="collapsible-header valign-wrapper flow-text" style="justify-content: space-evenly;">\n' +
    '                          <img src="static/icons/awards/award-3.png" alt="" class="circle">{{sportsman.places.third}}\n' +
    '                       </div>\n' +
    '                    </div>\n' +
    '                </div>' +
    '                <div class="row card">\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <input v-model="sportsman.family" placeholder="Фамилия" id="family" type="text" class="validate">\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <input v-model="sportsman.name" placeholder="Имя" id="name" type="text" class="validate">\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <select>\n' +
    '                            <option value="1">Мастер спорта международного класса</option>\n' +
    '                            <option value="2">Мастер спорта</option>\n' +
    '                            <option value="3">Кандидат в мастера спорта</option>\n' +
    '                            <option value="4">I разряд</option>\n' +
    '                            <option value="5">II разряд</option>\n' +
    '                            <option value="6">III разряд</option>\n' +
    '                            <option value="7">Нет</option>\n' +
    '                        </select>\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <input v-model="sportsman.weight" placeholder="Вес" id="weight" type="text" class="validate">\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <input v-model="sportsman.height" placeholder="Рост" id="height" type="number" class="validate">\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s4">\n' +
    '                        <input placeholder="Дата рождения" id="dayOfBirth" type="text" class="datepicker">\n' +
    '                    </div>\n' +
    '                    <div class="input-field col s3">\n' +
    '                        <input v-model="sportsman.yearOfStart" placeholder="Начало занятий" id="sportStart" type="number">\n' +
    '                    </div>\n' +
    '                    <div class="col s3">\n' +
    '                        <p>\n' +
    '                            <input name="sex" type="radio" id="man-sex" checked @click="change_sex"/>\n' +
    '                            <label for="man-sex">Мужской</label>\n' +
    '                        </p>\n' +
    '                        <p>\n' +
    '                            <input name="sex" type="radio" id="wom-sex" @click="change_sex"/>\n' +
    '                            <label for="wom-sex">Женский</label>\n' +
    '                        </p>\n' +
    '                    </div>\n' +
    '                    <div class="col s3">\n' +
    '                        <p>\n' +
    '                            <a class="waves-effect waves-light btn-large teal darken-2" @click="save">Сохранить</a>\n' +
    '                        </p>\n' +
    '                    </div>\n' +
    '                    <div class="col s3" v-if="sportsman.id">\n' +
    '                        <p>\n' +
    '                            <a class="waves-effect waves-light btn-large red darken-2" @click="remove">Удалить</a>\n' +
    '                        </p>\n' +
    '                    </div>\n' +
    '                    <div class="col s12" v-if="sportsman.id">\n' +
    '                        <p>\n' +
    '                            <a :href="href">К списку спортсменов</a>\n' +
    '                        </p>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>' +
    '        <div class="row" id="standards" v-if="sportsman.id">\n' +
    '           <table id="std_table" class="striped centered card">\n' +
    '              <thead>\n' +
    '                 <tr>\n' +
    '                    <th>#</th>\n' +
    '                    <th>Норматив</th>\n' +
    '                    <th>Дата</th>\n' +
    '                    <th>Результат</th>\n' +
    '                 </tr>\n' +
    '              </thead>\n' +
    '              <tbody>\n' +
    '                 <tr>\n' +
    '                    <td>1</td>\n' +
    '                    <td>Отжимание</td>\n' +
    '                    <td>30.01.2018</td>\n' +
    '                    <td>Сдано</td>\n' +
    '                 </tr>\n' +
    '              </tbody>\n' +
    '           </table>\n' +
    '        </div>' +
    '        <div class="row" id="games" v-if="sportsman.id">\n' +
    '           <table id="game_table" class="striped centered card">\n' +
    '              <thead>\n' +
    '                 <tr>\n' +
    '                    <th>#</th>\n' +
    '                    <th>Название</th>\n' +
    '                    <th>Дата</th>\n' +
    '                    <th>Результат</th>\n' +
    '                 </tr>\n' +
    '              </thead>\n' +
    '              <tbody>\n' +
    '                 <tr>\n' +
    '                    <td>1</td>\n' +
    '                    <td>Первый этап</td>\n' +
    '                    <td>30.01.2018</td>\n' +
    '                    <td>1-ое место</td>\n' +
    '                 </tr>\n' +
    '              </tbody>\n' +
    '           </table>\n' +
    '        </div>\n' +
    '        <div class="row" id="prognoz" v-if="sportsman.id">\n' +
    '           <div class="row" id="graph"></div>\n' +
    '        </div>' +
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
            $('.sportsman-confirm-name').html('Спортсмен «' + (this.sportsman.family) + '» будет <b>удален</b>. Продолжить?');
            $('.sportsman-confirm-remove').attr(
                'data-sportsman-id', this.sportsman.id
            );
            $('#removeSportsman').modal('open');
        }
    },
    computed: {
        href: function() {
            return '#sportsman-page-' + Sportsman.page;
        }
    }
});
