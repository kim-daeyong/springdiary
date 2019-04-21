package my.example.spring.board.springboard.dao;


import my.example.spring.board.springboard.dto.Board;

import java.util.List;

public interface BoardDao {
    List<Board> selectAllBoards(int start,int limit);
    Board selectBoard(Long id);
    long addBoard(Board board);
    long updateBoard(Long id,String title,String content);
    long deleteBoard(Long id);
    long updateReadCount(long id);
}
