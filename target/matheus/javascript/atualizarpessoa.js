
$('#modalDiscount').on('show.bs.modal',
        function (event) {
            var button = $(event.relatedTarget);
            var chave = button.data('whateverid');
            var nome = button.data('whatevernome');
            var email = button.data('whateveremail');
            var contato = button.data('whateverecontato');
            var referencia = button.data('whateverreferencia');
            var idLocal = button.data('whateverlocal');

            var modal = $(this);

            modal.find('#component-idPessoa').val(chave);

            modal.find('#component-name').val(nome);

            modal.find('#component-email').val(email);

            modal.find('#component-contato').val(contato);

            modal.find('#component-referencia').val(referencia);
            if (idLocal !== null)
                modal.find('#component-endereco').val(idLocal);



        });
