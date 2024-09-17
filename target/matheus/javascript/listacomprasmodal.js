$('#listacomprasmodal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var compras = button.data('compras');
    //  console.log(compras.toString().split(","));
    var cliente = button.data('cliente');
    var lista = compras.toString().split(",");
    var view = document.getElementById("item");
    var coluna = document.getElementById("coluna");
    var modal = $(this);
    modal.find(".modal-title").text("cliente: " + cliente);
    var count = 0;
    console.log(lista);
    var contador = 50;
    var tr = document.createElement("tr");
    var qtd_talao = lista[parseInt(45)].replace("qtd_cartela=", "");
    for (var item = 1; item <= qtd_talao; item++) {
        createTableColumn(coluna, lista, qtd_talao);
    }

    /*  for (var item in lista) {
     if (parseInt(item) >= '50' && parseInt(item) < (lista.length - 1)) {
     var elem = lista[parseInt(item)].toString().replace("apostas=[", "").replace("]", "");
     if (!isNaN(elem)) {
     var td = document.createElement("td");
     var texto = document.createTextNode(elem);
     td.appendChild(texto);
     view.appendChild(td);
     count++;
     }
     }
     if ((count + 1) <= view.childElementCount) {
     remover(view);
     count = 0;
     }
     
     }
     modal.find("#qtdmilhar").text("Quantidade de milhar: " + view.childElementCount);
     
     if (view.childElementCount > 16) {
     modal.find("#qtdmilhar").text("Acima de 16 milhar nao mostra todos os " + view.childElementCount + " milhar: ");
     
     }*/
});
function remover(child) {
    child.removeChild(child.firstElementChild);
}

function createTableColumn(tbody, lista, qtd_talao) {
    var tr = document.createElement("tr");
    var contador = 49;
    var contador2 = 4;
    for (var x = 1; x <= (contador2 * qtd_talao); x++) {
        var item =
                lista[parseInt((contador + x))]
                .toString()
                .replace("apostas=[", "")
                .replace("]", "");
        var td = document.createElement("td");
        if (!isNaN(item))
            var data = document.createTextNode(item);
        td.appendChild(data);
        tr.appendChild(td);
    }
    tbody.appendChild(tr);
    remover(tbody);
}