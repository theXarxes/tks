package infrastructure.userPorts;


import entity.users.User;
import java.util.List;

public interface ReadAllUsersPort {

    public List<User> getUsers();
}
