package application.userPorts;

import entity.users.User;
import exception.UserException;

import java.util.List;

public interface ReadUserAppPort {

    List<User> getUsers();

    User getUser(String login) throws UserException;

    List<User> getByPartLogin(String login);

    void changeActivity(String login) throws UserException;
}
