<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10" id="app-content">
    <div class="row card">
        <div class="input-field col s6">
            <select id="sex">
                <option value="true" selected>Мужчины</option>
                <option value="false">Женщины</option>
            </select>
            <label>Пол</label>
        </div>

        <div class="input-field col s6">
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
</div>

<script type="text/javascript" src="../static/js/game-list.js"></script>
