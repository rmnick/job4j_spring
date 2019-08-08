package ru.job4j.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.job4j.item.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserRepo implements IStorage<User> {

    private final NamedParameterJdbcTemplate template;
//    private final JdbcTemplate template;


    @Autowired
    public UserRepo(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
//        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public User add(User item) {
        final String INSERT_SQL = "insert into users (name) values (:name)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", item.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(INSERT_SQL, params, keyHolder);
//        template.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement ps = connection.prepareStatement(insert, new String[]{"id"});
//                ps.setString(1, item.getName());
//                return ps;
//            }
//        }, keyHolder);
        item.setId((int) keyHolder.getKeys().get("id"));
        return item;
    }

    @Override
    public User get(User item) {
        final String SELECT = "select * from users u where u.id = :id";
        SqlParameterSource params = new MapSqlParameterSource().addValue("id", item.getId());
        return template.queryForObject(SELECT, params, new UserRowMapper());
    }

    @Override
    public List<User> getAll() {
        final String SELECT_ALL = "select * from users";
        return template.query(SELECT_ALL, new BeanPropertyRowMapper(User.class));
    }

    @Override
    public void close() {
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        }
    }
}
