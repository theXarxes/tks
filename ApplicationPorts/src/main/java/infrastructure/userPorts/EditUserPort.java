package infrastructure.userPorts;

import entity.users.User;

public interface EditUserPort {

    boolean isLoginNotUnique(String login);

    void addAdminUser(User user);

    void addDataUser(User user);

    void addClientUser(User user);

    boolean updateUser(User user);
}
