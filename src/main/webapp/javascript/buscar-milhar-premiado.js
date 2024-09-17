function add() {
    var milhar = document.getElementById("milhar");
    if (milhar.length == 4) {
        carregar(milhar)
    }
}
function carregar(milhar) {
    var url = "controller?operacao=controller?operacao=ObterMilharPremiado";
    $.ajax({
        type: 'POST',
        url: url,
        data: "milhar=" + milhar,
        success: function (data, textStatus, jqXHR) {
            parent.location.href = "controller?operacao=controller?operacao=ObterMilharPremiado"
        }
    });
}



