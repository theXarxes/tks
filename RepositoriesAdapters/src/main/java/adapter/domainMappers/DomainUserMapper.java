package adapter.domainMappers;

import adapter.repositories.data.users.AdminUserEnt;
import adapter.repositories.data.users.ClientUserEnt;
import adapter.repositories.data.users.DataAdminUserEnt;
import adapter.repositories.data.users.UserEnt;
import entity.users.AdminUser;
import entity.users.ClientUser;
import entity.users.DataAdminUser;
import entity.users.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DomainUserMapper {

    public static User getDomainUser(UserEnt userEnt){
        if(userEnt instanceof AdminUserEnt){
            return new AdminUser(userEnt.getId(), userEnt.getLogin(), userEnt.isActive(), userEnt.getName());
        }else if(userEnt instanceof DataAdminUserEnt){
            return new DataAdminUser(userEnt.getId(), userEnt.getLogin(), userEnt.isActive(), userEnt.getName());
        }else if(userEnt instanceof ClientUserEnt){
            return new ClientUser(userEnt.getId(), userEnt.getLogin(), userEnt.isActive(), userEnt.getName());
        }
        return null;
    }

    public static AdminUserEnt getAdminUserEnt(User user){
        return new AdminUserEnt(user.getLogin(), user.getName());
    }

    public static DataAdminUserEnt getDataAdminUserEnt(User user){
        return new DataAdminUserEnt(user.getLogin(), user.getName());
    }

    public static ClientUserEnt getClientUserEnt(User user){
        return new ClientUserEnt(user.getLogin(), user.getName());
    }

}
