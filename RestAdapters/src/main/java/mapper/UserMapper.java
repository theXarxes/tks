package mapper;

import DTO.userDTO.GetUserDTO;
import entity.users.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {
    public static GetUserDTO userMapper(User user){
        return new GetUserDTO(user);
    }
}