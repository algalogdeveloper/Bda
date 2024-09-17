
<div class="modal fade" id="modalFuncionario" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-gradient-light text-dark font-weight-bold">
                <h5 class="modal-title font-weight-bold" id="exampleModalLabel">FORMULÁRIO DE
                    CADASTRO</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true"><i class="fa fa-window-close"></i></span>
                </button>
            </div>
            <div class="modal-body">
                <form action="controller?operacao=EnviaFuncionario" method="post">
                    <input name="idf" id="idf" type="hidden">
                    <div class="form-group">
                        <label for="exampleFormControlInput1" class="font-weight-bold">Nome:</label> <input
                            name="nome" type="text" class="form-control" id="component-name"
                            placeholder="Nome do funcionário?">
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Email:</label> <input
                                    type="email" class="form-control" name="email"
                                    id="component-email"
                                    placeholder="Qual seu e-mail recuperar senha?">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Contato(zap):</label> <input
                                    type="tel" class="form-control" name="contato"
                                    id="component-contato"
                                    placeholder="De preferência contato que seja zap?">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleFormControlSelect1" class="font-weight-bold">Permissão</label> <select 
                            class="custom-select form-control font-weight-bold" name="permissao"
                            id="component-permissao">
                            <option value="1" class="font-weight-bold">Ações de Baixa</option>
                            <option value="2" class="font-weight-bold">Ações de consultas</option>
                            <option value="3" class="font-weight-bold">Ações de Vizualições</option>
                        </select>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Login:</label> <input
                                    type="text" class="form-control" name="login"
                                    id="component-login" placeholder="Dados restritos">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Senha:</label> <input
                                    type="password" class="form-control" name="senha"
                                    id="component-senha" placeholder="***************">
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="exampleFormControlInput1" class="font-weight-bold">Confirmar Senha:</label> <input
                                    type="password" class="form-control" name="senha2"
                                    id="component-senha" placeholder="*************">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <button type="submit" class="btn bg-gradient-primary text-white">
                                <i class="fas fa-save"> Enviar Dados</i>
                            </button>
                            <button type="reset" class="btn bg-gradient-light text-danger font-weight-bold">
                                <i class="fa fa-flag"> </i> Limpar
                            </button>

                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>




