package adapter.domainMappers;

import adapter.repositories.data.users.UserEnt;
import entity.users.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DomainUserMapper {

    public static User getDomainUser(UserEnt userEnt){
        return new User(userEnt.getId(), userEnt.getLogin(), userEnt.isActive(), userEnt.getName());
    }

}
