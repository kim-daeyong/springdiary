package my.example.spring.board.springboard.dto;

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
    private String title;
    private String nickname;
    private String content;
    private Date regdate;
    private int read_count;

    public Board() {
        regdate = new Date();
        read_count = 0;
    }

    public Board(String title,String nickname,String content) {
        this();
        this.title = title;
        this.nickname = nickname;
        this.content = content;
    }

    public Board(String title,String nickname,String content,Long id) {
        this(title,nickname,content);
        this.id = id;
    }

    public Board(Long id,String title,String nickname,String content,Date regdate) {
        this(title, nickname, content, id);
        this.read_count = read_count;
        this.regdate = regdate;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                ", read_count=" + read_count +
                '}';
    }
}