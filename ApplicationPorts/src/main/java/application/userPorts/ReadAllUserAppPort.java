package application.userPorts;

import entity.users.User;

import java.util.List;

public interface ReadAllUserAppPort {
    public List<User> getUsers();
}
