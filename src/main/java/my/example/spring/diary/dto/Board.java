package my.example.spring.diary.dto;

// VO or DTO - 하나의 값을 가지는 객체

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@Getter
@Setter
public class Board{
    private long id;
    private String nickname;
    private String content;
    private Date regdate;

    public Board() {
        regdate = new Date();
    }

    public Board(String content) {
        this();
        this.content = content;
    }

    public Board(String nickname,String content) {
        this();
        this.nickname = nickname;
        this.content = content;
    }

    public Board(String nickname,String content,Long id) {
        this(nickname,content);
        this.id = id;
    }

    public Board(Long id ,String nickname,String content,Date regdate) {
        this(nickname, content, id);
        this.regdate = regdate;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}