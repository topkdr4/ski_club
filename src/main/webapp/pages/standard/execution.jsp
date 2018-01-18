<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10" id="app-content">
    <div class="row" id="standard-execution">
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
                <input placeholder="Дата сдачи" id="day" type="text" class="datepicker">
            </div>
            <div class="input-field col s4">
                <select id="standards-list">
                    <option value="null" selected>Норматив</option>
                </select>
                <label>Нормативы</label>
            </div>
            <div class="input-field col s2">
                <button class="btn-large waves-effect waves-light teal darken-2 find-result" style="width: 100%">Поиск
                    <i class="material-icons right">search</i>
                </button>
            </div>
        </div>
        <div class="row card">
            <table id="table" class="striped centered">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Спортсмен</th>
                        <th>Результат</th>
                        <th>Сдано</th>
                        <th>Дата</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <div class="fixed-action-btn add-result">
            <a class="btn-floating btn-small teal darken-2 waves-effect waves-light">
                <i class="large material-icons">add</i>
            </a>
        </div>
    </div>
</div>

<div id="std-result" class="modal modal-fixed-footer" style="height: 600px;">
    <div class="modal-content">
        <div class="col s12">
            <div class="row">
                <div class="input-field col s4">
                    <select id="sportsman">
                        <option value="10" selected>8-14</option>
                    </select>
                    <label>Спортсмен</label>
                </div>
                <div class="input-field col s4">
                    <select id="trainer">
                        <option value="null" selected>Нет</option>
                    </select>
                    <label>Тренер</label>
                </div>
                <div class="input-field col s4">
                    <input placeholder="Результат:" id="sportsman-result" type="text" class="validate">
                </div>
                <div class="col s4">
                    <p>
                        <input name="suc" type="radio" id="succsess" checked="checked"/>
                        <label for="succsess">Сдано</label>
                    </p>
                    <p>
                        <input name="suc" type="radio" id="no-succsess"/>
                        <label for="no-succsess">Не сдано</label>
                    </p>
                </div>
                <div class="input-field col s4">
                    <input placeholder="Дата сдачи" id="deadLine" type="text" class="datepicker">
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a id="removeResult" href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Удалить</a>
        <a id="saveResult" href="#!" class="modal-action modal-close waves-effect waves-teal btn-flat">Сохранить</a>
    </div>
</div>

<script type="text/javascript" src="../static/js/standard-execution.js"></script>
