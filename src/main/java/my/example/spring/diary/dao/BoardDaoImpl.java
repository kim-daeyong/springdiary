package my.example.spring.diary.dao;


import my.example.spring.diary.dto.Board;
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

import static my.example.spring.diary.dao.BoardDaoSQL.*;

@Repository
public class BoardDaoImpl implements BoardDao{

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    public BoardDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("Board")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Board> selectAllBoards(int start, int limit) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("start", start);
        paramMap.put("limit", limit);
        return jdbc.query(SELECT_BOARDS, paramMap,rowMapper);
    }

    @Override
    public Board selectBoard(Long id) {
        Board board = null;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        try {
            board = jdbc.queryForObject(SELECT_BOARD_BY_ID, paramMap, rowMapper);
        }catch(EmptyResultDataAccessException da){
            return null;
        }
        return board;
    }


    @Override
    public long  addBoard(Board board) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("nickname", board.getNickname());
        paramMap.put("content", board.getContent());
        paramMap.put("regdate", board.getRegdate());

        Number number = simpleJdbcInsert.executeAndReturnKey(paramMap);
        return number.longValue();
    }

    @Override
    public long updateBoard(Long id, String content) {
        long count = 0;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("content", content);
        count = jdbc.update(UPDATE_BOARD, paramMap);
        return count;
    }

    @Override
    public long deleteBoard(Long id) {
        long result = 0;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        return jdbc.update(DELETE_BOARD, paramMap);
    }

}