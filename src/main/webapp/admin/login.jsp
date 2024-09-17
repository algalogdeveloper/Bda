<div class="container">
    <section
        class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
            <div class="row justify-content-center">         
                <div class="col-lg-6 col-md-6 d-flex flex-column align-items-center justify-content-center">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="pt-2">
                                <div class="d-flex justify-content-center py-4">
                                    <a href="#"
                                       class="logo d-flex align-items-center w-auto"> <img
                                            src="img/lrt-logo.jpeg" class="img-fluid rounded-circle"
                                            width="120" alt="">
                                    </a>
                                </div>
                                <h3 class="text-center font-weight-bold mb-3 text-success text-uppercase">Conectar Usuário</h3>

                                <c:choose>
                                    <c:when test="${not empty msg }">
                                        <p class="alert alert-danger font-weight-bold text-center small" role="alert">
                                            <c:out value="${msg}" />
                                        </p>
                                    </c:when>
                                </c:choose>
                            </div>
                            <form action="LoginUser?restricao=permission" method="post">

                                <div class="form-group">
                                    <label for="exampleInputEmail1" class="font-weight-bold">Usuário:</label>
                                    <input name="login" type="text" class="form-control form-control-lg"
                                           required="required" id="exampleInputEmail1"
                                           aria-describedby="emailHelp"> <small id="emailHelp"
                                           class="form-text text-muted">Nós nunca
                                        compartilharemos seus dados com outra pessoa.</small>
                                </div>
                                <label for="exampleInputEmail1" class="font-weight-bold">Senha:</label>
                                <div class="input-group mb-3">
                                    <input type="password" name="senha" id="tranformando-input" class="form-control form-control-lg" placeholder="Informe a senha" aria-label="Recipient's username" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button class="btn bg-gradient-none border" type="button" id="button-addon2"><i class="fa fa-eye-slash"></i></button>
                                    </div>

                                </div>
                                <small id="message" hidden="" class="form-text text-muted">Sua senha está visível.</small>
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input"
                                           checked="checked" id="exampleCheck1"> <label
                                           class="form-check-label font-weight-bold" for="exampleCheck1">Permanecer
                                        conectado</label>
                                </div>
                                <button type="submit" class="btn bg-light mb-3 text-uppercase btn-lg border-bottom-success btn-block">
                                    <i class="fas fa-user-lock text-success  font-weight-bold"> Logar Cliente</i> 
                                </button>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</div>