package practiceapp.practiceapp.service;

import practiceapp.practiceapp.model.User;

import java.util.List;


public interface UserService {
    User addNewUser(User user);

    List<User> getUserList();

    User getUser(Long userId);


    String deleteUser(Long userId);

    User updateUser(User user);

    List<User> searchUserByUsername(String username);
}
