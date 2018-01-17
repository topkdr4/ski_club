<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col s10">

    <div class="row card" id="specification-form">

        <div class="row">

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

            <div class="input-field col s12">
                <input placeholder="Название норматива" id="specification-name" type="text" class="validate">
            </div>

            <div class="input-field col s12">
                <textarea id="specification-description" placeholder="Описание неорматива" class="materialize-textarea"></textarea>
            </div>

            <div class="input-field col s6">
                <select id="specification-type">
                    <option value="Время" selected>Время</option>
                    <option value="Количество">Количество</option>
                </select>
                <label>Тип измерения</label>
            </div>

            <div class="input-field col s6">
                <input placeholder="Для выполнения норматива, необходимо:" id="specification-require" type="text" class="validate">
            </div>

            <div class="col s12">
                <p>
                    <a id="save-standard" class="waves-effect waves-light btn-large teal darken-2">Сохранить</a>
                </p>
            </div>

        </div>

    </div>

</div>

<script type="text/javascript" src="../static/js/standard-add.js"></script>
