package my.example.spring.board.springboard.dao;

import my.example.spring.board.springboard.dto.User;

import java.util.List;

public interface UserDao {

    Long addUser(User user);
    User getUser(String email);

    List<User> getUsers();
}
