<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10" id="app-content">
    <div class="row" id="standard-execution">
        <div class="row card">
            <div class="input-field col s3">
                <select id="sex">
                    <option value="true" selected>Мужчины</option>
                    <option value="false">Женщины</option>
                </select>
                <label>Пол</label>
            </div>
            <div class="input-field col s3">
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
            <div class="input-field col s2">
                <button class="btn-large waves-effect waves-light teal darken-2" style="width: 100%">Поиск
                    <i class="material-icons right">find_replace</i>
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
                    <tr>
                        <td>1</td>
                        <td>[]</td>
                        <td>[]</td>
                        <td>114</td>
                        <td>18.01.2018</td>
                        <td><a class="dropdown-button btn-flat" data-activates='row-action'>Подробнее</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="fixed-action-btn">
            <a class="btn-floating btn-small teal darken-2 waves-effect waves-light modal-trigger" href="#competitor">
                <i class="large material-icons">add</i>
            </a>
        </div>
    </div>
</div>

<ul id='row-action' class='dropdown-content'>
    <li><a href="javascript:;" class="modal-trigger"><i class="material-icons">edit</i>Редактировать</a></li>
    <li><a href="javascript:;"><i class="material-icons">delete</i>Удалить</a></li>
</ul>

<script type="text/javascript" src="../static/js/standard-execution.js"></script>
