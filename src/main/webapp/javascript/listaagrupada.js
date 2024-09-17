$('#cartagrupado').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var recipient = button.data('lista');
    var cliente = button.data('cliente');
    var modal = $(this);
    modal.find('.modal-title').text('Modificar o milhar do(a): ' + cliente);
    var lista = recipient.toString().replace("[", "").replace("]", "").split(",");
    console.log(lista);
    var td = document.getElementById("row_id1");
    var td2 = document.getElementById("row_id2");
    var td3 = document.getElementById("row_id3");
    var td4 = document.getElementById("row_id4");
    var td5 = document.getElementById("row_id5");
    var td6 = document.getElementById("row_id6");
    var td7 = document.getElementById("row_id7");
    var td8 = document.getElementById("row_id8");

    td.value = lista[0];
    td2.value = lista[1].substring(0);
    td3.value = lista[2].substring(0);
    td4.value = lista[3].substring(0);
    console.log('Numero: ' + lista[4]);
    if (lista[4] === undefined)
    {
        td5.setAttribute("hidden", "hidden");
        td6.setAttribute("hidden", "hidden");
        td7.setAttribute("hidden", "hidden");
        td8.setAttribute("hidden", "hidden");
    } else
    {
        td5.value = lista[4].substring(0);
        td6.value = lista[5].substring(0);
        td7.value = lista[6].substring(0);
        td8.value = lista[7].substring(0);
        td5.removeAttribute("hidden");
        td6.removeAttribute("hidden");
        td7.removeAttribute("hidden");
        td8.removeAttribute("hidden");
    }
});