<div class="col s10">
    <div class="row" id="sportsman-list">

        <sportsman-cards
                v-for="(item, index) in sportsmans"
                v-bind:sportsman="item"
        ></sportsman-cards>


        <div class="col s12 sportsman_pagination">
            <ul class="pagination">
                <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                <li class="active teal"><a href="#!">1</a></li>
                <li class="waves-effect waves-teal"><a href="#!">2</a></li>
                <li class="waves-effect waves-teal"><a href="#!">3</a></li>
                <li class="waves-effect waves-teal"><a href="#!">4</a></li>
                <li class="waves-effect waves-teal"><a href="#!">5</a></li>
                <li class="waves-effect waves-teal"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
            </ul>
        </div>

    </div>
</div>

<script type="text/javascript" src="../static/js/sportsman.js"></script>
<script type="text/javascript" src="../static/components/sportsman-component.js"></script>


<script type="text/javascript">
    Sportsman.initialization();
</script>
