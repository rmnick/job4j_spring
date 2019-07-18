package ru.job4j.storage;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.job4j.item.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Properties;

@Component
public class JdbcStorage implements IStorage<User> {
    private final static BasicDataSource SOURCE = new BasicDataSource();
    private final static Logger LOG = Logger.getLogger(JdbcStorage.class.getName());

    public JdbcStorage() {
        try (InputStream in = JdbcStorage.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties config = new Properties();
            config.load(in);
            SOURCE.setDriverClassName(config.getProperty("driver-class-name"));
            SOURCE.setUrl(config.getProperty("url"));
            SOURCE.setUsername(config.getProperty("username"));
            SOURCE.setPassword(config.getProperty("password"));
            SOURCE.setMinIdle(5);
            SOURCE.setMaxIdle(10);
            SOURCE.setMaxOpenPreparedStatements(100);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * add user to DB
     * @param user User
     * @return result User
     */
    @Override
    public User add(User user) {
        User result = null;
        String insert = "insert into users (name) values (?);";
        try (Connection con = SOURCE.getConnection(); PreparedStatement ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (!rs.next()) {
                throw new NoSuchElementException();
            }
            int id = rs.getInt(1);
            user.setId(id);
            result = user;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public User get(User user) {
        User result = null;
        String select = String.format("select u.name from users as u where u.id = %d;", user.getId());
        try (Connection con = SOURCE.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(select)) {
            while (rs.next()) {
                user.setName(rs.getString(1));
            }
            result = user;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() {
        try {
            if (SOURCE != null) {
                SOURCE.close();
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
