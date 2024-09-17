package org.logcod.lojajogos.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConectMysqlDB implements DataSourceConnection {

    @Override
    public Connection obterConectionServer() {
        try {
            Properties p = jdbcConectPropertiesResource();
            Class.forName(p.getProperty("driver")).newInstance();
            return DriverManager.getConnection(p.getProperty("url"), p);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Properties jdbcConectPropertiesResource() {
        try {
            Properties p = new Properties();
            p.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            return p;
        } catch (IOException e) {
            throw new IllegalArgumentException("Nao foi possivel realizar a conexao: " + e);
        }

    }

}
