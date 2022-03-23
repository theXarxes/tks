package service;

import application.userPorts.ReadUserAppPort;
import entity.users.User;
import exception.UserException;
import infrastructure.userPorts.ReadUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService implements ReadUserAppPort {

    @Inject
    ReadUsersPort getUserPort;

    public List<User> getUsers(){
        return getUserPort.getUsers();
    }

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

//    public void addAdminUser(PostUserDTO userDTO) throws AccessLevelException, UserException {
//        if (getUserPort.isLoginNotUnique(userDTO.getLogin())){
//            throw new UserException("This login is occupied...");
//        }
//        getUserPort.addAdminUser(userDTO);
//    }
//
//    public void addDataUser(PostUserDTO userDTO) throws AccessLevelException, UserException {
//        if (getUserPort.isLoginNotUnique(userDTO.getLogin())){
//            throw new UserException("This login is occupied...");
//        }
//        getUserPort.addDataUser(userDTO);
//    }
//
//    public void addClientUser(PostUserDTO userDTO) throws AccessLevelException, UserException {
//        if (getUserPort.isLoginNotUnique(userDTO.getLogin())){
//            throw new UserException("This login is occupied...");
//        }
//        getUserPort.addClientUser(userDTO);
//    }
//
//
//    public void updateUser(PutUserDTO userDTO) throws UserException {
//        if(userDTO.getName() == null) throw new UserException("Incomplite user data...");
//        if (!getUserPort.updateUser(userDTO)){
//            throw new UserException("Invalid user id...");
//        }
//    }
//

}
