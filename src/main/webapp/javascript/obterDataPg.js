var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
    var button = event.relatedTarget
    var recipient = button.getAttribute('data-bs-whatever')
    var chave = button.getAttribute('data-bs-whateverchave')
    var modalTitle = exampleModal.querySelector('.modal-title')
    var modalBodyInput = exampleModal.querySelector('.modal-body input')
    var modalBodyText = exampleModal.querySelector('.modal-body textarea')
    modalTitle.textContent = 'Wello Word: ' + recipient
    modalBodyInput.value = recipient
    modalBodyText.value = chave;
})