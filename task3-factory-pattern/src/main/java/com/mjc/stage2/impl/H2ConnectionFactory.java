package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class H2ConnectionFactory implements ConnectionFactory {
    private static H2ConnectionFactory instance;
    private String jdbcDriver;
    private String dbUrl;
    private String user;
    private String password;

    private H2ConnectionFactory() {
        ResourceBundle rb = ResourceBundle.getBundle("database");
        jdbcDriver = rb.getString("jdbc_driver");
        dbUrl = rb.getString("db_url");
        user = rb.getString("user");
        password = rb.getString("password");

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver");
        }
    }

    @Override
    public Connection createConnection() {
        try {
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
