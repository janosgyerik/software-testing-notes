package testing.db;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final JdbcOperations jdbcOperations;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcOperations = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, name FROM User";
        return jdbcOperations.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return new User(rs.getInt("id"), rs.getString("name"));
            }
        });
    }

    @Override
    public void create(int id, String name) {
        String sql = "INSERT INTO User (id, name) VALUES (?, ?)";
        jdbcOperations.update(sql, id, name);
    }
}
