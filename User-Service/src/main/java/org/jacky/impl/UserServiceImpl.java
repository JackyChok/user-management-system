package org.jacky.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.jacky.User;
import org.jacky.UserService;
import org.jacky.dao.UserDao;
import org.jacky.dao.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DubboService
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        UserModel userModel = userDao.getUserById(id);
        User user = new User();
        user.setId(userModel.getId());
        user.setUsername(userModel.getUsername());
        return user;
    }

    @Override
    public User updateUserInfo(User user) {
        return null;
    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
