package my.example.spring.diary.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardImg {

    private Long id;
    private String name; // 오리지널 파일 명. toto.png
    private long length;
    private String saveFileName; //   /tmp/2019/02/01/1234-12342134-1234
    private String mimeType;
}
