
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<nav
    class="navbar navbar-expand-lg navbar-light bg-gradient-light font-weight-bold my-1">
    <a class="navbar-brand" href="controller?operacao=IndexController"><img
            alt="" src="img/lrt-logo.jpeg" width="30"
            class="img-fluid rounded-circle"> L.R.T Serviços</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse text-uppercase"
         id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> CADASTROS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=PessoaController&pessoa=listar"> <i class="fa fa-arrow-right"> Pessoas</i>  
                    </a> <a class="dropdown-item  font-weight-bold"
                            href="controller?operacao=CatalogoFuncionario"><i class="fa fa-arrow-right"> Funcionário</i></a> <a
                            class="dropdown-item  font-weight-bold"
                            href="controller?operacao=LocalController&locais=listar"><i class="fa fa-arrow-right">
                            Endereços</i></a>
                    <!--                    <a class="dropdown-item  font-weight-bold"
                                           href="controller?operacao=CarrinhoController&carrinho=loja"><i class="fa fa-arrow-right"> Inserir Talão </i></a>-->

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=UISacola"><i class="fa fa-arrow-right"> Cadastrar Novos Canhatos </i></a>



                </div></li>
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> CONSULTAS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultaRapidaComprasCliente"><i class="fa fa-arrow-right"> Filtrar apostas por nome e milhar</i> </a>
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultasController&consulta=compras"><i class="fa fa-arrow-right"> Filtrar apostas por endereço</i> </a>
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=FiltrarComprasPorFuncionario"><i class="fa fa-arrow-right"> Filtar apostas por
                            Funcionário</i> </a> <a class="dropdown-item  font-weight-bold"
                                            href="controller?operacao=SelecionarComprasPeloSeuMilhar&acao=Clear"><i class="fa fa-arrow-right"> Filtrar apostas por milhar </i></a> <a
                                            class="dropdown-item  font-weight-bold"
                                            href="controller?operacao=DirecionarPaginaExibirComprasRealizadas"><i class="fa fa-arrow-right"> Todas Apostas realizadas dos
                            clientes</i> </a> 
                    <a href="controller?operacao=CarregarPaginaReizinho"
                       title="Consultar Compras realizadas Cobradores"
                       class="dropdown-item  font-weight-bold"> <i class="fa fa-arrow-right"> Filtrar apostas realizadas Cobradores</i>
                    </a> 
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultasController&consulta=ativa">
                        <i class="fa fa-arrow-right"> Aqui voce ativa um milhar </i>
                    </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ViewListaAgrupada">
                        <i class="fa fa-arrow-right"> Buscar milhar em todas as apostas </i>
                    </a>
                </div></li>
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> PAGAMENTOS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=PagamentoController"><i class="fa fa-arrow-right"> Realizar cobrança</i> </a> <a
                       class="dropdown-item  font-weight-bold"
                       href="controller?operacao=ConsultarPagamentosDoDia"><i class="fa fa-arrow-right"> Vizualizar pagamentos do dia</i></a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=Faturamento"><i class="fa fa-arrow-right">
                            Relatorio de Faturamento</i> </a>
                </div></li>

            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> RELATÓRIOS </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <div class="dropdown-divider"></div>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=UIRotas"><i class="fa fa-arrow-right"> Gerar PDF por rotas de cobrança </i> </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=UIRotasPorPagina"><i class="fa fa-arrow-right"> Gerar Rotas de cobrança por paginas de cada endereço </i> </a>

                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=FormFiltroEnderecoParaGerarPdfCompraSemMilhar"><i class="fa fa-arrow-right"> Gerar Pdf de apostas sem milhar </i> </a> 
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=DirecionarPaginaPDFPorEndereco"><i class="fa fa-arrow-right"> Gerar Pdf todos clientes por endereço </i> </a> 
                    <a  class="dropdown-item  font-weight-bold"
                        href="controller?operacao=FormFiltroEnderecoParaGerarPdfCompra"><i class="fa fa-arrow-right"> Gerar Pdf de apostas com milhar </i> </a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=ConsultarCompraQtdValor"><i class="fa fa-arrow-right"> Consultar apostas por
                            qtd e valor </i> </a> <a class="dropdown-item  font-weight-bold"
                                             href="controller?operacao=VerificarGanhador"><i class="fa fa-arrow-right">
                            Buscar cliente com talão prêmiado </i> </a> <!-- <a
            class="dropdown-item  font-weight-bold"
            href="controller?operacao=ObterMilharPremiado"><img
            alt="Verificar ganhador" width="20" src="img/ganhador.png">
            Verificar Prêmio</a> -->
                </div></li>
            <li class="nav-item dropdown active"><a
                    class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                    role="button" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false"> Usuário: <c:out value="${usuario}" />
                </a>
                <div class="dropdown-menu font-weight-bold"
                     aria-labelledby="navbarDropdown">
                    <a class="dropdown-item  font-weight-bold"
                       href="controller?operacao=IndexController"> <i
                            class="fas fa-calendar-day"> </i> Data acesso: <fmt:formatDate
                            value="${dataAcesso}" pattern="dd/MM/yyyy" /></a> <a
                        class="dropdown-item  font-weight-bold"
                        href="controller?operacao=IndexController"> <i
                            class="fas fa-sign"></i> Sair
                    </a>
                </div></li>
            <li class="nav-item active"><a class="nav-link" href="#">AJUDA
                </a></li>
        </ul>

    </div>
</nav>