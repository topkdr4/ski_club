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
                <select id="ages">
                    <option value="10" selected>8-14</option>
                    <option value="17">15-18</option>
                    <option value="23">19-29</option>
                    <option value="34">30-39</option>
                    <option value="45">40-49</option>
                </select>
                <label>Возраст</label>
            </div>

        </div>

        <div class="row card">
            <table id="table" class="bordered">

                <thead>
                <tr>
                    <th>Название</th>
                    <th>Тип измерения</th>
                    <th>Требования</th>
                    <th>Описание</th>
                </tr>
                </thead>

                <tbody>

                <tr>
                    <td>Отжимание</td>
                    <td>Количество</td>
                    <td>30</td>
                    <td><a class="modal-trigger">Подробнее</a></td>
                </tr>

                </tbody>

            </table>

        </div>

    </div>

</div>


<div id="specification-extra-description" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4 class="standard-title"></h4>
        <p class="standard-desc">
        </p>
    </div>
    <div class="modal-footer">
        <a id="removeStd" href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Удалить</a>
    </div>
</div>

<script type="text/javascript" src="../static/js/standard.js"></script>
