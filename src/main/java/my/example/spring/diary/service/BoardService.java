package my.example.spring.diary.service;


import my.example.spring.diary.dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectAllBoards(int page);
    Board selectBoard(Long id);
    long addBoard(Board board);
    long updateBoard(Long id,String content);
    long deleteBoard(Long id);
}
