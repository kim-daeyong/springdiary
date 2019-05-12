package my.example.spring.diary.service;


import my.example.spring.diary.dao.BoardDao;
import my.example.spring.diary.dto.Board;
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
    public List<Board> selectAllBoards(Long userid, int page) {
        int start = page * 10 - 10;
        return boardDao.selectAllBoards(userid, start,10);
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
    public void modifyBoard(Board board) {
        boardDao.modifyBoard(board.getContent(), board.getId());
    }

    @Override
    @Transactional
    public long deleteBoard(Long id, Long userid) {
        return boardDao.deleteBoard(id, userid);
    }


}