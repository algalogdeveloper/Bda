

<div class="row">
    <!-- Area Chart -->
    <div class="col-xl-8 col-lg-7">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div
                class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Grafico de vendas</h6>
                <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button"
                       id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i
                            class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div
                        class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                        aria-labelledby="dropdownMenuLink">
                        <div class="dropdown-header">Informa��es:</div>
                        <a class="dropdown-item" href="#">Action</a> <a
                            class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </div>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                </div>
            </div>
        </div>
    </div>

    <!-- Pie Chart -->
    <div class="col-xl-4 col-lg-5">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div
                class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Login</h6>
                <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button"
                       id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"> <i
                            class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div
                        class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                        aria-labelledby="dropdownMenuLink">
                        <div class="dropdown-header">Dropdown Header:</div>
                        <a class="dropdown-item" href="#">Action</a> <a
                            class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </div>
            </div>
            <!-- Card Body -->
            <div class="card-body">

                <div class="mt-4 small">
                    <form class="user" action="LoginUser" method="get">

                        <div class="form-group">
                            <input name="restricao" value="permission" type="hidden">
                            <input type="text" name="login"
                                   class="form-control form-control-user" id="exampleInputEmail"
                                   aria-describedby="emailHelp" placeholder="Login...">
                        </div>
                        <div class="form-group">
                            <input type="password" name="senha"
                                   class="form-control form-control-user" id="exampleInputPassword"
                                   placeholder="Senha...">
                        </div>

                        <button type="submit" class="btn btn-primary btn-user btn-block">Login</button>
                        <hr>
                        <button type="reset" class="btn btn-google btn-user btn-block">Limpar</button>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>