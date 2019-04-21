package my.example.spring.board.springboard.service;


import my.example.spring.board.springboard.dao.UserDao;
import my.example.spring.board.springboard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User addUser(User user) {
        Long id = userDao.addUser(user);
        user.setId(id);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        User user = userDao.getUser(email);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        List<User> users = userDao.getUsers();
        return users;
    }
}
