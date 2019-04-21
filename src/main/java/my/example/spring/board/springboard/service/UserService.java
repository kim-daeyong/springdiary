package my.example.spring.board.springboard.service;

import my.example.spring.board.springboard.dto.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getUserByEmail(String email);
    List<User> getUsers();
}
