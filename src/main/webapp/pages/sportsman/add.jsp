<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="newSportsman" class="col s10">
    <sportsman-info
            v-bind:sportsman="sportsman"
    ></sportsman-info>
</div>

<script type="text/javascript" src="../static/js/sportsman.js"></script>
<script type="text/javascript" src="../static/components/sportsman-component.js"></script>

<script type="text/javascript">
    Sportsman.page = 1;
    var newSportsman = new Vue({
        el: '#newSportsman',
        data: {
            showed: false,
            sportsman: {
                sex: true
            }
        }
    });

    Sportsman.basicInit();
</script>
