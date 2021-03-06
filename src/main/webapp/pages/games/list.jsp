<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10" id="app-content">
    <div class="row card">
        <div class="input-field col s4">
            <select id="sex">
                <option value="true" selected>Мужчины</option>
                <option value="false">Женщины</option>
            </select>
            <label>Пол</label>
        </div>
        <div class="input-field col s4">
            <select id="ages">
                <option value="10" selected>8-14</option>
                <option value="17">15-18</option>
                <option value="23">19-29</option>
                <option value="34">30-39</option>
                <option value="45">40-49</option>
            </select>
            <label>Возраст</label>
        </div>
        <div class="input-field col s4">
            <input id="gameDate" type="text" class="datepicker">
            <label for="gameDate">Дата Соревнования</label>
        </div>
    </div>
    <div class="row card">
        <table id="table" class="striped centered">
            <thead>
            <tr>
                <th>#</th>
                <th>Название</th>
                <th>Результаты</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Чемпионат клуба</td>
                <td><a href="#game-description">Подробнее</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="fixed-action-btn">
        <a class="btn-floating btn-small teal darken-2 waves-effect waves-light">
            <i class="large material-icons" id="newGame">add</i>
        </a>
    </div>

    <div id="new-game-modal" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="input-field col s12">
                    <input id="gameName" type="text" placeholder="Наименование соревнования">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <a href="javascript:;" id="saveGame" class="modal-action modal-close waves-effect waves-teal btn-flat">Добавить</a>
        </div>
    </div>
</div>

<script type="text/javascript" src="../static/js/game-list.js"></script>
