package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> listUsers();
    User getUserByModel(String model, int series);
    void cleanDb();
    void removeUserById(long id);
}
