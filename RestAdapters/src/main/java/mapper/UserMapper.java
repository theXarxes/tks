package mapper;

import DTO.userDTO.GetUserDTO;
import DTO.userDTO.PUserDTO;
import entity.users.AdminUser;
import entity.users.ClientUser;
import entity.users.DataAdminUser;
import entity.users.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {

    public static GetUserDTO userMapper(User user){
        return new GetUserDTO(user);
    }

    public static AdminUser getPAdminUserDomain(PUserDTO dto){
        return new AdminUser(dto.getLogin(), dto.getName());
    }

    public static DataAdminUser getPDataAdminUserDomain(PUserDTO dto){
        return new DataAdminUser(dto.getLogin(), dto.getName());
    }

    public static ClientUser getPClientUserDomain(PUserDTO dto){
        return new ClientUser(dto.getLogin(), dto.getName());
    }


}