package adapter.repositories.repository;

import adapter.repositories.data.users.AdminUserEnt;
import adapter.repositories.data.users.ClientUserEnt;
import adapter.repositories.data.users.DataAdminUserEnt;
import adapter.repositories.data.users.UserEnt;
import entity.users.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class UserRepository {

    List<UserEnt> users = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
            new AdminUserEnt(UUID.randomUUID(), "user1", true, "Bolek"),
            new DataAdminUserEnt(UUID.randomUUID(), "user2", true, "Lolek"),
            new ClientUserEnt(UUID.randomUUID(), "user3", true, "Tola")
    )));

    public List<UserEnt> getUsers(){
        return users;
    }

    public UserEnt getUser(String login){
        for(UserEnt x: users){
            if(x.getLogin().equals(login)){
                return x;
            }
        }
        return null;
    }

    public ArrayList<UserEnt> getByPartLogin(String login){
        ArrayList<UserEnt> u = new ArrayList<>();
        for(UserEnt x: users){
            if (x.getLogin().contains(login)){
                u.add(x);
            }
        }
        return u;
    }

    public boolean changeActivity(String login){
        UserEnt u = getUser(login);
        if (u != null){
            u.setActive(!u.isActive());
            return true;
        }
        return false;
    }

    public void addAdminUser(AdminUserEnt user){
        users.add(new AdminUserEnt(UUID.randomUUID(), user.getLogin(),true, user.getName()));
    }

    public void addDataUser(DataAdminUserEnt user){
        users.add(new DataAdminUserEnt(UUID.randomUUID(), user.getLogin(),true, user.getName()));
    }

    public void addClientUser(ClientUserEnt user){
        users.add(new ClientUserEnt(UUID.randomUUID(), user.getLogin(),true, user.getName()));
    }

    public boolean updateUser(ClientUserEnt user){
        UserEnt userEnt = getUser(user.getLogin());
        if (userEnt != null){
            userEnt.setName(user.getName());
            return true;
        }
        return false;
    }

    public boolean isLoginNotUnique(String login){
        for (UserEnt u : users){
            if (u.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }
}
