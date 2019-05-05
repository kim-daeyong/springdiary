package my.example.spring.diary.dao;

import my.example.spring.diary.dto.Board;

import java.util.List;

public interface PageDao {
    public int getCount();
    public List<Board> search(String sort, String value);
}
