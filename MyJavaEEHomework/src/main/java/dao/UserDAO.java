package dao;

import model.User;

public interface UserDAO {

    void createUser(User user);

    User getUserById(int id);

    User getUserByUsernameAndPwd(String userName, String pwd);

    User getUserByMail(String email);

    void updateUser(User user);

    void deleteUser(int id);

}
