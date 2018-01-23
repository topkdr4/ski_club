<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10">
    <div class="row" id="sportsman-list">

        <sportsman-cards
                v-for="(item, index) in sportsmans"
                v-bind:sportsman="item"
                v-bind:key="item.id"
                v-if="showed"
        ></sportsman-cards>

        <sportsman-info
                v-if="showInfo"
                v-bind:sportsman="sportsman"
        ></sportsman-info>


        <div class="col s12 sportsman_pagination">
            <ul class="pagination">
                <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                <li class="active teal"><a href="#!">1</a></li>
                <li class="waves-effect waves-teal"><a href="#!">2</a></li>
                <li class="waves-effect waves-teal"><a href="#!">3</a></li>
                <li class="waves-effect waves-teal"><a href="#!">4</a></li>
                <li class="waves-effect waves-teal"><a href="#!">5</a></li>
                <li class="waves-effect waves-teal"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
            </ul>
        </div>

    </div>
</div>

<!-- Удаление спортсмена -->
<div id="removeSportsman" class="modal">
    <div class="modal-content">
        <h4>Внимание!</h4>
        <p class="sportsman-confirm-name">Вы действительно желаете <b>удалить</b> спортсмена</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-red btn-flat sportsman-confirm-remove" data-trainer-id="0">Удалить</a>
    </div>
</div>

<!-- Сохранение спортсмена -->
<div id="saveSportsman" class="modal">
    <div class="modal-content">
        <h4>Сохранено</h4>
    </div>
</div>

<script type="text/javascript" src="../static/js/sportsman.js"></script>
<script type="text/javascript" src="../static/js/highcharts.js"></script>
<script type="text/javascript" src="../static/components/sportsman-component.js"></script>


<script type="text/javascript">
    Sportsman.initialization();
</script>
