package my.example.spring.board.springboard.dao;

public class BoardDaoSQL {

    public static final String SELECT_BOARDS =
            "SELECT id,title, nickname,content,regdate,read_count FROM board limit :start,:limit";
    public static final String SELECT_BOARD_BY_ID =
            "SELECT id,title,nickname,content,regdate FROM board where id=:id";
    public static final String UPDATE_BOARD =
            "UPDATE board SET title=:title,content=:content WHERE id=:id";
    public static final String DELETE_BOARD =
            "DELETE FROM board WHERE id=:id";
    public static final String UPDATE_BOARD_READCOUNT =
            "UPDATE board SET read_count=read_count+1 WHERE id=:id";

    public static final String INSERT =
           "INSERT INTO board(nickname, content, title) VALUES(?, ?, ?)";

}