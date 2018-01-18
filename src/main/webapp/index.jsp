<%@ page import="ru.vetoshkin.util.PageService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/pages/500.jsp" pageEncoding="UTF-8"%>
<html lang="ru">
<head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

    <title>Летающий лыжник</title>

    <link rel="icon" type="image/png" href="favicon.png">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="../static/css/others.css">
    <link type="text/css" rel="stylesheet" href="../static/css/style.css">
    <link type="text/css" rel="stylesheet" href="../static/lib/materialize/css/materialize.min.css" media="screen,projection"/>

</head>
<body>

<nav class="teal darken-2">
    <div class="nav-wrapper">
        <div class="trampliner-logo">Клуб «Летающий лыжник»</div>
    </div>
</nav>

<div class="row" id="#rootElement">

    <div class="col s2">

        <ul class="collapsible" data-collapsible="accordion" style="user-select: none">
            <li>
                <div class="collapsible-header">
                    <i class="material-icons">timeline</i>Рекорды
                </div>

                <ul class="collection collapsible-body">
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle deep-orange darken-2">grid_on</i><a href="?action=record">Таблица</a>
                    </li>
                </ul>

            </li>
            <li>
                <div class="collapsible-header">
                    <i class="material-icons">casino</i>Соревнования
                </div>
                <ul class="collection collapsible-body">
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle light-green accent-4">format_list_bulleted</i><a href="?action=game-list">Список</a>
                    </li>
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle light-green accent-4">ac_unit</i>Новое соревнование
                    </li>
                </ul>
            </li>
            <li>
                <div class="collapsible-header">
                    <i class="material-icons">view_list</i>Нормативы
                </div>
                <ul class="collection collapsible-body">
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle cyan darken-2">format_list_bulleted</i><a href="?action=standard-list">Список</a>
                    </li>
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle cyan darken-2">add</i><a href="?action=standard-add">Новый норматив</a>
                    </li>
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle cyan darken-2">web_asset</i><a href="?action=standard-execution">Сдача норматива</a>
                    </li>
                </ul>
            </li>
            <li>
                <div class="collapsible-header">
                    <i class="material-icons">person</i>Тренерский состав
                </div>
                <ul class="collection collapsible-body">
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle pink darken-2">format_list_bulleted</i><a href="?action=trainer-list">Список</a>
                    </li>
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle pink darken-2">person_add</i><a href="?action=trainer-add">Новый тренер</a>
                    </li>
                </ul>
            </li>
            <li>
                <div class="collapsible-header">
                    <i class="material-icons">people</i>Члены клуба
                </div>
                <ul class="collection collapsible-body">
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle orange darken-2">format_list_bulleted</i><a href="?action=sportsman-list">Список</a>
                    </li>
                    <li class="collection-item avatar valign-wrapper">
                        <i class="material-icons circle orange darken-2">group_add</i><a href="?action=sportsman-add">Новый участник</a>
                    </li>
                </ul>
            </li>
        </ul>

    </div>



<script type="text/javascript" src="../static/js/jquery.js"></script>
<script type="text/javascript" src="../static/lib/materialize/js/materialize.min.js"></script>
<script type="text/javascript" src="../static/js/vue.js"></script>
<script type="text/javascript" src="../static/js/route.js"></script>
<script type="text/javascript" src="../static/js/pagniation.js"></script>
<script type="text/javascript" src="../static/js/app.js"></script>

    <%
        String action = request.getParameter("action");
        if (action != null) {
            String path = PageService.getPage(action);
            pageContext.include(path, false);
        }

    %>

</div>

</body>
</html>
