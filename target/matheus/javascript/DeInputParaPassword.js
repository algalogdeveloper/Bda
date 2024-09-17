var evento = document.getElementById("button-addon2");
var ti = document.getElementById("tranformando-input");
var message = document.getElementById("message");
if (ti.value.length > 0) {
    var qtd = 1;
    evento.addEventListener('click', function (e) {
        if (qtd === 1)
        {
            ti.removeAttribute('type');
            message.removeAttribute("hidden");
            message.setAttribute("class", "font-weight-bold text-danger");
            evento.setAttribute("class", "btn bg-light border");
            evento.innerHTML = '<i class="fa fa-eye"></i>';
            qtd = 2;
        } else
        {
            ti.setAttribute("type", "password");
            message.setAttribute("hidden", "hidden");
            evento.setAttribute("class", "btn bg-light border");
            evento.innerHTML = '<i class="fa fa-eye-slash"></i>';
            qtd = 1;
        }
        ti.focus();
    });
}