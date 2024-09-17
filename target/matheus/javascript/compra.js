$('#comprasModal').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var idpessoa = evento.data('whateveridpessoa');
    var idcompra = evento.data('whateveridcompra');
    var screen = $(this);
    screen.find('#component-idpessoa').val(idpessoa);
    screen.find('#component-idcompra').val(idcompra);

});
