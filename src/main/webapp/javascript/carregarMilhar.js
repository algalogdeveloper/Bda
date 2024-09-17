$('#checkModal').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var idpessoa = evento.data('whateveridpessoa');
    var idcompra = evento.data('whateveridcompra');
    var numero = evento.data('whatevernumero');
    var idposta = evento.data('whateveridaposta');
    var milhar_old = evento.data('whatevermilharold');

    var screen = $(this);
    screen.find('#component-idpessoa').val(idpessoa);
    screen.find('#component-idcompra').val(idcompra);
    screen.find('#component-milhar').val(numero);
    screen.find('#component-idaposta').val(idposta);
    screen.find('#component-idcompra-old').val(milhar_old);


});
