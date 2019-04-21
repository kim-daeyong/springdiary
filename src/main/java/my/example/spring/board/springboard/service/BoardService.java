package my.example.spring.board.springboard.service;


import my.example.spring.board.springboard.dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectAllBoards(int page);
    Board selectBoard(Long id);
    long addBoard(Board board);
    long updateBoard(Long id,String title,String content);
    long deleteBoard(Long id);
    long updateReadCount(long id);
}
