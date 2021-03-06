<%@ page import="ru.vetoshkin.service.SportsmanService" %>
<%@ page import="ru.vetoshkin.util.Jackson" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="../500.jsp" %>
<div class="col s10">
    <div class="row card">
        <table class="striped centered" id="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Спортсмен</th>
                    <th class="tooltipped" data-tooltip="Баллы">Дальность прыжка</th>
                    <th class="tooltipped" data-tooltip="Оценка судьи A">A</th>
                    <th class="tooltipped" data-tooltip="Оценка судьи B">B</th>
                    <th class="tooltipped" data-tooltip="Оценка судьи C">C</th>
                    <th class="tooltipped" data-tooltip="Оценка судьи D">D</th>
                    <th class="tooltipped" data-tooltip="Оценка судьи E">E</th>
                    <th class="tooltipped" data-tooltip="Фактор стартовых ворот">Компенсация</th>
                    <th class="tooltipped" data-tooltip="Фактор поправки на ветер">Поправка на ветер</th>
                    <th class="tooltipped" data-tooltip="Сумма баллов">Сумма</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Аноним</td>
                    <td>113</td>
                    <td>11</td>
                    <td>13</td>
                    <td>15</td>
                    <td>17</td>
                    <td>20</td>
                    <td>3.5</td>
                    <td>3</td>
                    <td>3</td>
                    <td>
                        <a class='dropdown-button btn-flat' href='#' data-activates='row-action'>Действие</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="fixed-action-btn">
        <a class="btn-floating btn-small teal darken-2 waves-effect waves-light">
            <i class="large material-icons" id="newResult">add</i>
        </a>
    </div>

    <div id="game-result" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="input-field col s6">
                    <select id="sportsman">
                        <option value="10" selected>8-14</option>
                    </select>
                    <label>Спортсмен</label>
                </div>

                <div class="input-field col s6">
                    <input id="range" type="text" placeholder="Дальность прыжка">
                    <label for="range">Дальность прыжка</label>
                </div>

                <div class="input-field col s6">
                    <input id="compensation" type="text" placeholder="Компенсация">
                    <label for="compensation">Компенсация</label>
                </div>

                <div class="input-field col s6">
                    <input id="wind" type="text" placeholder="Поправка на ветер">
                    <label for="wind">Поправка на ветер</label>
                </div>

                <div class="input-field col s4">
                    <input id="judgeA" type="text" placeholder="Судья А">
                    <label for="judgeA">Судья A</label>
                </div>

                <div class="input-field col s4">
                    <input id="judgeB" type="text" placeholder="Судья B">
                    <label for="judgeB">Судья B</label>
                </div>

                <div class="input-field col s4">
                    <input id="judgeC" type="text" placeholder="Судья C">
                    <label for="judgeC">Судья C</label>
                </div>

                <div class="input-field col s4">
                    <input id="judgeD" type="text" placeholder="Судья D">
                    <label for="judgeD">Судья D</label>
                </div>

                <div class="input-field col s4">
                    <input id="judgeE" type="text" placeholder="Судья E">
                    <label for="judgeE">Судья E</label>
                </div>

            </div>
        </div>
        <div class="modal-footer">
            <a href="javascript:;" id="removeResult" class="modal-action modal-close waves-effect waves-red btn-flat">Удалить</a>
            <a href="javascript:;" id="saveResult" class="modal-action modal-close waves-effect waves-teal btn-flat">Сохранить</a>
        </div>
    </div>
</div>


<script type="text/javascript">
    var sportsmans = <%=Jackson.toJson(SportsmanService.getSportsmansCategory(
            Boolean.parseBoolean(request.getParameter("sex")),
            Integer.parseInt(request.getParameter("ages"))
    ))%>;
    var id = <%=Integer.parseInt(request.getParameter("id"))%>;
</script>
<script type="text/javascript" src="../static/js/game-info.js"></script>

