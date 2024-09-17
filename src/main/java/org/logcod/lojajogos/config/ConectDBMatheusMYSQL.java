
package org.logcod.lojajogos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDBMatheusMYSQL implements DataSourceConnection{

    @Override
    public Connection obterConectionServer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bolaodeacupe_matheusdb", "bolaodeacupe_matheus_rifas", "1@cuca82");
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
}
