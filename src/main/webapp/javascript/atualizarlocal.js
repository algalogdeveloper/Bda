$('#localModal').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var codlocal = evento.data('whateverid');
    var descricao = evento.data('whateveredescricao');
    var cidade = evento.data('whateverecidade');
    var rota = evento.data('whatevererota');
    var screen = $(this);
    screen.find('#component-idlocal').val(codlocal);
    screen.find('#component-descricao').val(descricao);
    screen.find('#component-cidade').val(cidade);
    if (rota !== null) {
        screen.find('#component-rota').val(rota);
    } else {
        screen.find('#component-rota').val("Select");
    }

});
