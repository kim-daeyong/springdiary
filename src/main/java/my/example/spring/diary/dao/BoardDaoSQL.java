package my.example.spring.diary.dao;

public class BoardDaoSQL {

    public static final String SELECT_BOARDS =
            "SELECT id, nickname,content,regdate FROM board limit :start,:limit";

    public static final String SELECTBOARDS =
            "SELECT id, nickname,content,regdate FROM board ";

    public static final String SELECT_BOARD_BY_ID =
            "SELECT id,nickname,content,regdate FROM board where id=:id";

    public static final String UPDATE_BOARD =
            "UPDATE board SET title=:title,content=:content WHERE id=:id";

    public static final String DELETE_BOARD =
            "DELETE FROM board WHERE id=:id";

    public static final String INSERT =
           "INSERT INTO board(nickname, content) VALUES(?, ?)";

}