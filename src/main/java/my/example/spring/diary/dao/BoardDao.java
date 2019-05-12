package my.example.spring.diary.dao;


import my.example.spring.diary.dto.Board;

import java.util.List;

public interface BoardDao {
    List<Board> selectAllBoards(long userid,int start, int limit);
    Board selectBoard(Long id);
    long addBoard(Board board);
    void modifyBoard(String content, Long id);
    long deleteBoard(Long id, Long userid);
}
