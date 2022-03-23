package service;

import application.userPorts.ReadAllUserAppPort;
import entity.users.User;
import infrastructure.userPorts.ReadAllUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService implements ReadAllUserAppPort {

    @Inject
    ReadAllUsersPort getUserPort;

    public List<User> getUsers(){
        return getUserPort.getUsers();
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
//    public GetUserDTO getUser(String login) throws UserException {
//            User u = getUserPort.getUser(login);
//            if (u == null){
//                throw new UserException("Invalid user login...");
//            }
//            return UserMapper.userMapper(u);
//    }
//
//    public void updateUser(PutUserDTO userDTO) throws UserException {
//        if(userDTO.getName() == null) throw new UserException("Incomplite user data...");
//        if (!getUserPort.updateUser(userDTO)){
//            throw new UserException("Invalid user id...");
//        }
//    }
//
//    public void changeActivity(String login) throws UserException {
//        if(!getUserPort.changeActivity(login)){
//            throw new UserException("Invalid user login");
//        }
//
//    }
//
//    public ArrayList<GetUserDTO> getByPartLogin(String login){
//        ArrayList<GetUserDTO> u = new ArrayList<>();
//        for (User x: getUserPort.getByPartLogin(login)){
//            u.add(UserMapper.userMapper(x));
//        }
//        return u;
//    }

}
