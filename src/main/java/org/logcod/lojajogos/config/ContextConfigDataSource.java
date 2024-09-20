package org.logcod.lojajogos.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class ContextConfigDataSource {

    private static Connection connection;
    protected JdbcConect conexao = JdbcConect.POSTGRESQL;
    private static ContextConfigDataSource configDataSource;

    private ContextConfigDataSource() {
        DataSourceConnection conn = conexao.ConectDataSource();
        connection = conn.obterConectionServer();        
    }

    public static synchronized ContextConfigDataSource singletonConexao() {
        if (configDataSource == null) {
            configDataSource = new ContextConfigDataSource();
        }
        return configDataSource;
    }

    public Connection conect() {
        return connection;
    }
    
    public void closeConect() throws SQLException{
        if(Objects.isNull(connection)) connection.close();       
    }

}
