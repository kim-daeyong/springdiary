package my.example.spring.board.springboard.dao;

import my.example.spring.board.springboard.dto.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static my.example.spring.board.springboard.dao.UserDaoSql.SELECT_USER_BY_EMAIL;


@Repository
public class UserDaoImpl implements UserDao {


    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public Long addUser(User user) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", user.getName());
        paramMap.put("nickname", user.getNickname());
        paramMap.put("email", user.getEmail());
        paramMap.put("passwd", user.getPasswd());
        paramMap.put("regdate", user.getRegdate());
        Number number = simpleJdbcInsert.executeAndReturnKey(paramMap);
        return number.longValue();
    }

    @Override
    public User getUser(String email) {

        User user = null;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        try {
            user = jdbc.queryForObject(SELECT_USER_BY_EMAIL, paramMap, rowMapper);
        }catch(EmptyResultDataAccessException da){
            return null;
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
