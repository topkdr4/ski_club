<meta charset="UTF-8">

<div id="newTrainer" class="col s10">
    <trainer-info
            v-bind:trainer="trainer"
    ></trainer-info>
</div>

<script type="text/javascript" src="../static/js/trainer.js"></script>
<script type="text/javascript" src="../static/vue/components.js"></script>

<script type="text/javascript">
    Trainer.page = 1;
    var trainer = new Vue({
        el: '#newTrainer',
        data: {
            showed: false,
            trainer: {}
        }
    });

    Trainer.basicInit();
</script>
