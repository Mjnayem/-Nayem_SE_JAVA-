package com.nayem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDatabase {
    private Connection connection;
    public static final String JDBC_CONNECTION="JDBC_CONNECTION";

    private JdbcDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/sejava","default","default");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcDatabase getInstance() {
        return new JdbcDatabase();
    }

    public Connection getConnection() {
        return connection;
    }
}
