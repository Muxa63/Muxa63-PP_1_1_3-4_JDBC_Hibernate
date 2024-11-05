package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.name";
    private static final String PASSWORD_LEY = "db.password";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),PropertiesUtil.get(USER_KEY),PropertiesUtil.get(PASSWORD_LEY));
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
        return null;
    }
}

