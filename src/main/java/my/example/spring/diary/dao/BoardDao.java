package my.example.spring.diary.dao;


import my.example.spring.diary.dto.Board;

import java.util.List;

public interface BoardDao {
    List<Board> selectAllBoards(int start, int limit);
    Board selectBoard(Long id);
    long addBoard(Board board);
    long updateBoard(Long id,String content);
    long deleteBoard(Long id);
}
