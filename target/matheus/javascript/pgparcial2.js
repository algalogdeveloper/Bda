$('#pgParcial2').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var idcompra = evento.data('whatevereidcompra');
    var idpessoa = evento.data('whatevereidpessoa');
    var pessoa = evento.data('whateverepessoa');
    var screen = $(this);
    screen.find('#component-idcompra2').val(idcompra);
    screen.find('#component-idpessoa').val(idpessoa);
    screen.find('#component-pessoa').val(pessoa);
});
