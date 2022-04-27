package service;

import application.userPorts.EditUserAppPort;
import application.userPorts.ReadUserAppPort;
import entity.users.AdminUser;
import entity.users.ClientUser;
import entity.users.DataAdminUser;
import entity.users.User;
import exception.AccessLevelException;
import exception.UserException;
import infrastructure.userPorts.EditUserPort;
import infrastructure.userPorts.ReadUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class UserService implements ReadUserAppPort, EditUserAppPort {

    @Inject
    ReadUsersPort getUserPort;

    @Inject
    EditUserPort editUserPort;

    @Override
    public List<User> getUsers(){
        return getUserPort.getUsers();
    }

    @Override
    public User getUser(String login) throws UserException {
        User u = getUserPort.getUser(login);
        if (u == null){
            throw new UserException("Invalid user login...");
        }
        return u;
    }

    @Override
    public List<User> getByPartLogin(String login){
        return getUserPort.getByPartLogin(login);
    }

    @Override
    public void changeActivity(String login) throws UserException {
        if(!getUserPort.changeActivity(login)){
            throw new UserException("Invalid user login");
        }
    }

//    public void addUser(UserDTO userDTO) throws AccessLevelException, UserException {
//            String login = userDTO.getLogin();
//            int accessLevel = userDTO.getAccessLevel();
//            String name = userDTO.getName();
//            if(login == null || name == null || accessLevel == 0){
//                throw new UserException("Incomplite user data...");
//            }
//            if (userRepository.isLoginNotUnique(login)){
//                throw new UserException("This login is occupied...");
//            }
//            userRepository.addUser(userDTO);
//    }
//

    @Override
    public void addAdminUser(AdminUser user) throws UserException {
        if (editUserPort.isLoginNotUnique(user.getLogin())){
            throw new UserException("This login is occupied...");
        }
        editUserPort.addAdminUser(user);
    }

    @Override
    public void addDataUser(DataAdminUser user) throws UserException {
        if (editUserPort.isLoginNotUnique(user.getLogin())){
            throw new UserException("This login is occupied...");
        }
        editUserPort.addDataUser(user);
    }

    @Override
    public void addClientUser(ClientUser user) throws UserException {
        if (editUserPort.isLoginNotUnique(user.getLogin())){
            throw new UserException("This login is occupied...");
        }
        editUserPort.addClientUser(user);
    }

    public void updateUser(ClientUser user) throws UserException {
        if(user.getName() == null) throw new UserException("Incomplite user data...");
        if (!editUserPort.updateUser(user)){
            throw new UserException("Invalid user id...");
        }
    }
}
