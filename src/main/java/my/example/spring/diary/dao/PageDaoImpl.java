package my.example.spring.diary.dao;

import my.example.spring.diary.dto.Board;
import my.example.spring.diary.dto.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

@Repository
public class PageDaoImpl implements PageDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Page> rowMapper = BeanPropertyRowMapper.newInstance(Page.class);

    public PageDaoImpl(DataSource dataSource){
        jdbc = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id");
    }
    @Override
    public int getCount() {
        int result = 0;
        result = jdbc.queryForObject(PageDaoSql.ALLCOUNT, (HashMap) null, Integer.class);
        return result;
    }

    @Override
    public List<Board> search(String sort, String value) {
        return null;
    }
}
