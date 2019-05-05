package my.example.spring.diary.service;

import my.example.spring.diary.dto.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getUserByEmail(String email);
    List<User> getUsers();
}
