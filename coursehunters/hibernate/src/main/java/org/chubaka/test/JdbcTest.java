package org.chubaka.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTest {
    public static void main(String[] args) {
        try (InputStream in = JdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties config = new Properties();
            config.load(in);
            Connection connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
            //Class.forName(config.getProperty("driver-class-name"));
            System.out.println("successful connection");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
