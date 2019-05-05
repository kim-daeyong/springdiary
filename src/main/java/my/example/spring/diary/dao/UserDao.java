package my.example.spring.diary.dao;

import my.example.spring.diary.dto.User;

import java.util.List;

public interface UserDao {

    Long addUser(User user);
    User getUser(String email);

    List<User> getUsers();
}
