
var enviar = document.getElementById("enviar");
var limpar = document.getElementById("limpar");
enviar.addEventListener('click', function () {
    var url = "controller?operacao=UISacolaEnviar";
    $.ajax({
        type: 'POST',
        url,
        data: {
            nome: $("#nome").val(),
            endereco: $("#endereco").val(),
            descricao: $("#descricao").val(),
            valor: $("#valor").val(),
            qtd: $("#qtd").val(),
            desconto: $("#desconto").val(),
            situacao: $("#situacao").val()
        },
        success: function (data, textStatus, jqXHR) {
            if (textStatus) {
                alert("Enviando com sucesso");
            }
        }

    });
});
limpar.addEventListener('click', function () {
    $("#nome").val("");
    alert("Limpar");
});

