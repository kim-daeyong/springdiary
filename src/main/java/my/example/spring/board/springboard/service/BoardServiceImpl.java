package my.example.spring.board.springboard.service;


import my.example.spring.board.springboard.dao.BoardDao;
import my.example.spring.board.springboard.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;

    @Override
    @Transactional(readOnly = true)
    public List<Board> selectAllBoards(int page) {
        int start = page * 10 - 10;
        return boardDao.selectAllBoards(start,10);
    }

    @Override
    @Transactional(readOnly = true)
    public Board selectBoard(Long id) {
        return boardDao.selectBoard(id);
    }


    @Override
    @Transactional
    public long addBoard(Board board) {
        return boardDao.addBoard(board);
    }

    @Override
    @Transactional
    public long updateBoard(Long id, String title, String content) {
        return boardDao.updateBoard(id,title,content);
    }

    @Override
    @Transactional
    public long deleteBoard(Long id) {
        return boardDao.deleteBoard(id);
    }

    @Override
    @Transactional
    public long updateReadCount(long id) {
        return boardDao.updateReadCount(id);
    }

}