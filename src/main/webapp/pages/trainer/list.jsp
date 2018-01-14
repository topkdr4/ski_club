<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10" id="app-content">
    <div class="row" id="trainer-list">

        <trainer-cards
                v-for="(item, index) in trainers"
                v-bind:trainer="item"
                v-bind:key="item.id"
                v-if="showed"
        ></trainer-cards>

        <trainer-info
                v-if="showInfo"
                v-bind:trainer="trainer"
        ></trainer-info>

    </div>

    <div class="row">
        <div class="col s12 trainer_pagination">
            <ul class="pagination">
                <li class="disabled"><a href="#trainer-page-back"><i class="material-icons">chevron_left</i></a></li>
                <li class="active teal"><a href="#trainer-page-1">1</a></li>
                <li class="waves-effect waves-teal"><a href="#trainer-page-2">2</a></li>
                <li class="waves-effect waves-teal"><a href="#trainer-page-3">3</a></li>
                <li class="waves-effect waves-teal"><a href="#trainer-page-4">4</a></li>
                <li class="waves-effect waves-teal"><a href="#trainer-page-5">5</a></li>
                <li class="waves-effect waves-teal"><a href="#trainer-page-next"><i class="material-icons">chevron_right</i></a></li>
            </ul>
        </div>
    </div>
</div>

<!-- Удаление тренера -->
<div id="removeTrainer" class="modal">
    <div class="modal-content">
        <h4>Внимание!</h4>
        <p class="trainer-confirm-name">Вы действительно желаете <b>удалить</b> тренера</p>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-red btn-flat trainer-confirm-remove" data-trainer-id="0">Удалить</a>
    </div>
</div>

<!-- Сохранение тренера -->
<div id="saveTrainer" class="modal">
    <div class="modal-content">
        <h4>Сохранено</h4>
    </div>
</div>

<script type="text/javascript" src="../static/js/trainer.js"></script>
<script type="text/javascript" src="../static/components/trainer-component.js"></script>


<script type="text/javascript">
    Trainer.initialization();
</script>
