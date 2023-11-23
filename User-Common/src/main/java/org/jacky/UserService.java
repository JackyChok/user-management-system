package org.jacky;

public interface UserService {
    User register(User user);
    User login(String username, String password);
    User getUserInfo(String username);
    User getUserById(int id);
    User updateUserInfo(User user);
    String sayHello(String name);
}
