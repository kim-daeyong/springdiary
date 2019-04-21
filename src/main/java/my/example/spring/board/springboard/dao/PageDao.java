package my.example.spring.board.springboard.dao;

import my.example.spring.board.springboard.dto.Board;

import java.util.List;

public interface PageDao {
    public int getCount();
    public List<Board> search(String sort, String value);
}
