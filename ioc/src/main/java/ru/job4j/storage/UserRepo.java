package ru.job4j.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    private final JdbcTemplate template;

    @Autowired
    public UserRepo(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public User add(User item) {
        String insert = "insert into users (name) values (?)";
        //MapSqlParameterSource params = new MapSqlParameterSource();
        //params.addValue("n", item.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //template.update(INSERT_SQL, new String[]{item.getName()}, keyHolder);
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(insert, new String[]{"id"});
                ps.setString(1, item.getName());
                return ps;
            }
        }, keyHolder);
        item.setId(keyHolder.getKey().intValue());
        return item;
    }

    @Override
    public User get(User item) {
        String select = "select * from users u where u.id = ?";
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", item.getId());
        return template.queryForObject(select, new Object[]{item.getId()}, new UserRowMapper());
    }

    @Override
    public List<User> getAll() {
        String selectAll = "select * from users";
        return template.query(selectAll, new BeanPropertyRowMapper(User.class));
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
