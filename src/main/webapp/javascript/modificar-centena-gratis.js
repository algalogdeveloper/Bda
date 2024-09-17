$('#edit_form_centena').on('show.bs.modal', function (event) {
    var evento = $(event.relatedTarget);
    var id = evento.data('whatevereid');
    var centena = evento.data('whatevercentena');
    var screen = $(this);
    screen.find('#component-idcentena-gratis').val(id);
    screen.find('#component-centena').val(centena);

});
