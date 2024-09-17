package org.logcod.lojajogos.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.logcod.lojajogos.config.util.Informacoes;

public class ConnectionHeroku implements DataSourceConnection {

    protected String HOST = "localhost";
    protected String USER = "";
    protected String PASSWD = "";
    protected String BD = "d4guqohis59qqt";

    @Override
    public java.sql.Connection obterConectionServer() {
        try {
            Properties ps = new Properties();
            ps.setProperty("user", USER);
            ps.setProperty("password", PASSWD);
            Class.forName("org.postgresql.Driver").newInstance();
            return DriverManager.getConnection("jdbc:postgresql://" + HOST + ":5432/" + BD + "?sslmode = require", ps);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            Informacoes.SOP(e.getCause());
            return null;
        }

    }

}
