<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10">

    <div class="row" id="specification-list-filter">

        <div class="row card">

            <div class="input-field col s6">
                <select id="sex">
                    <option value="true" selected>Мужчины</option>
                    <option value="false">Женщины</option>
                </select>
                <label>Пол</label>
            </div>

            <div class="input-field col s6">
                <select id="type">
                    <option value="jump" selected>Дальность прыжка</option>
                    <option value="judge">Оценка судей</option>
                    <option value="wind">Компенсацию разгона</option>
                    <option value="compensation">Поправка на ветер</option>
                    <option value="sum">Сумма баллов</option>
                </select>
                <label>Категории</label>
            </div>

        </div>

        <div class="row card">
            <div class="col s12">
                <ul class="tabs tabs-fixed-width tabes">
                    <li class="tab col s6"><a href="#table" class="active teal-text text-darken-2">Таблица</a></li>
                    <li class="tab col s6"><a href="#graph" class="teal-text text-darken-2">График</a></li>
                </ul>
            </div>
        </div>

        <div class="row card">
            <table id="table" class="striped centered">

                <thead>
                <tr>
                    <th>#</th>
                    <th>Спортсмен</th>
                    <th>Баллы</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>1</td>
                    <td>[]</td>
                    <td>114</td>
                </tr>
                </tbody>

            </table>
        </div>

        <div class="row card" id="graph">

        </div>

    </div>

</div>

<script type="text/javascript" src="../static/js/highcharts.js"></script>
<script type="text/javascript" src="../static/js/record.js"></script>
