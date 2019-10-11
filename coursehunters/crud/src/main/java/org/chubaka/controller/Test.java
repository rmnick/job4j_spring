package org.chubaka.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//only just for testing connection
public class Test extends HttpServlet {
    public final static Logger LOG = Logger.getLogger(Test.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try (PrintWriter pw = resp.getWriter();
             InputStream in = Test.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            pw.println("Hello");
            pw.flush();
            pw.println("start connection");
            pw.flush();
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
            pw.println("connection's complete");
            pw.flush();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } catch (ClassNotFoundException  e) {
            LOG.error(e.getMessage(), e);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                if (connection != null) {
                connection.close();
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
