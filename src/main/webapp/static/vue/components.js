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
    '                        <span>Состоит в клубе с: {{sportsman.startedFrom}}</span>\n' +
    '                    </div>\n' +
    '                    <div class="person-info-item">\n' +
    '                        <span>Квалификация: {{sportsman.qualification}}</span>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </div>'
});

Vue.component('trainer-cards', {
    props: [ 'trainer' ],
    template: '<div class="col s4">\n' +
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
    '            </div>'
});
