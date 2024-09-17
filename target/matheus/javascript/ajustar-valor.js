$('#addajustevalor').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var keypessoa = evento.data('whateverkeypessoa');
    var keycompra = evento.data('whateverkeycompra');
    var screen = $(this);
    screen.find('#pessoa-idpessoa').val(keypessoa);
    screen.find('#compra-idcompra').val(keycompra);


});
