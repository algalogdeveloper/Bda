package org.logcod.lojajogos.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.logcod.lojajogos.config.util.Informacoes;

public class ConnectionIntegrator implements DataSourceConnection {

    @Override
    public java.sql.Connection obterConectionServer() {  	
        try { 	
            Class.forName("org.postgresql.Driver").newInstance();
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bolaodeacupe_fully_rifas_bd", "bolaodeacupe_fully_user", "1@cuca82");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            Informacoes.SOP(e.getMessage());
        }
        return null;

    }

}
