<form  action="controller" method="post">
    <div class="form-group">
        <input name="operacao" value="LocalController" type="hidden">
        <label for="recipient-name" class="font-weight-bold">Nome?:*</label>
        <input name="locais" value="save" type="hidden"> <input
            name="chaveidLocal" id="component-idlocal" type="hidden">
        <input  type="text" name="descricao" class="form-control form-control-lg"
                id="component-descricao" aria-describedby="emailHelp" required=""
                placeholder="Descrição">
    </div>
    <div class="form-group">
        <label for="recipient-name" class="font-weight-bold">Cidade?:*</label>
        <input type="text" name="cidade" required=""
               class="form-control form-control-lg" id="component-cidade"
               placeholder="Cidade">
    </div>
    <div class="form-group">
        <label for="message-text" class="font-weight-bold">Qual rota pertence?:*</label> 
        <select name="rota" required class="text-uppercase custom-select form-control font-weight-bold" id="component-rota">
            <option class="font-weight-bold" value="1"/>
            <c:out value="Rota: 1" />
            </option>
            <option class="font-weight-bold" value="2"/>
            <c:out value="Rota: 2" />
            </option>
            <option class="font-weight-bold" value="3"/>
            <c:out value="Rota: 3" />
            </option>
            <option class="font-weight-bold" value="4"/>
            <c:out value="Rota: 4" />
            </option>
            <option class="font-weight-bold" value="5"/>
            <c:out value="Rota: 5" />
            </option>
            <option class="font-weight-bold" value="6"/>
            <c:out value="Rota: 6" />
            </option>
            <option class="font-weight-bold" value="7"/>
            <c:out value="Rota: 7" />
            </option>
        </select>
    </div>

    <div class="btn-group" role="group" aria-label="Basic example">
        <button type="submit" id="save-pessoa" class="btn border  bg-gradient-light font-weight-bold text-success"><i class="fa fa-check"> </i> Cadastrar Endereço</button>
        <button type="reset" class="btn bg-gradient-light border text-danger font-weight-bold"> <i class="fa fa-bug"> Limpar campos</i>
        </button>
    </div>

</form>