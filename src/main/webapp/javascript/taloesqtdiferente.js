$('#dialogqtddiferente').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var idcompra = evento.data('whateveridcompra');
    var screen = $(this);
    screen.find('#component-idcompra-qtd').val(idcompra);

});
