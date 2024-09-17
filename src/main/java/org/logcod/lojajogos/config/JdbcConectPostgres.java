package org.logcod.lojajogos.config;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;
import org.logcod.lojajogos.config.util.Informacoes;

public class JdbcConectPostgres implements DataSourceConnection {

    @Override
    public Connection obterConectionServer() {
        try {
            Properties properties = jdbcConectDataSourceProperties();
            Class.forName(properties.getProperty("driver"));
            return DriverManager.getConnection(properties.getProperty("url"), properties);
        } catch (ClassNotFoundException | SQLException e) {
            Informacoes.SOP(e.getMessage());
            return null;
        }

    }

    private Properties jdbcConectDataSourceProperties() {
        try {
            Properties properties = new Properties();
            properties.setProperty("url", "jdbc:postgresql://127.0.0.1:5432/bolaodeacupedb");
            properties.setProperty("driver", "org.postgresql.Driver");
            properties.setProperty("user", "postgres");
            properties.setProperty("password", "root");
            return properties;
        } catch (Exception e) {
            return null;
        }

    }

    public static String extractInterfaceIP() throws IOException {

        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        String[] hosts = new String[5];
        try {
            int count = 1;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) ias.nextElement();
                    System.out.println("Host: = " + count + " " + ia.getHostAddress());
                    hosts[count++] = ia.getHostAddress();
                }
            }
            String ip = Objects.equals(hosts[3], "127.0.0.1") ? "127.0.0.1" : hosts[3];
            System.out.println("Ip: " + ip);
            return ip;
        } catch (Exception e) {
            System.out.println("host:" + e);
            return "127.0.0.1";
        }

    }
}
