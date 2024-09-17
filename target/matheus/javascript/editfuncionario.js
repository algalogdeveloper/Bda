$('#modalFuncionario').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var chave = button.data('whateverid');
    var nome = button.data('whatevernome');
    var email = button.data('whateveremail');
    var contato = button.data('whatevercontato');
    var login = button.data('whateverlogin');
    var permissao = button.data('whateverpermissao');

    var modal = $(this);

    modal.find('#idf').val(chave);

    modal.find('#component-name').val(nome);

    modal.find('#component-email').val(email);

    modal.find('#component-contato').val(contato);

    modal.find('#component-login').val(login);
    if (permissao > 0)
        modal.find('#component-permissao').val(permissao);

});