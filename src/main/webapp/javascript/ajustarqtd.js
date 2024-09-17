$('#modalqtd').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var id = button.data('whateverqtd')
    var modal = $(this);
    modal.find('#idcompra').val(id);
})