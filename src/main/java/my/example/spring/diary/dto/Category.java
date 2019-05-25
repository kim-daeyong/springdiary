package my.example.spring.diary.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Category {
    private long id;
    private String categoryName;

}
