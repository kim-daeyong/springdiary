package my.example.spring.diary.service;


import my.example.spring.diary.dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectAllBoards(Long userid, int page);
    Board selectBoard(Long id);
    long addBoard(Board board);
    void modifyBoard(Board board);
    long deleteBoard(Long id, Long userid);
}
