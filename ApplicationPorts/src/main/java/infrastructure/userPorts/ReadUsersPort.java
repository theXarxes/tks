package infrastructure.userPorts;


import entity.users.User;

import java.util.ArrayList;
import java.util.List;

public interface ReadUsersPort {

    List<User> getUsers();

    User getUser(String login);

    List<User> getByPartLogin(String login);

    boolean changeActivity(String login);
}
