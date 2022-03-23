package adapter.adapters;

import adapter.domainMappers.DomainUserMapper;
import adapter.repositories.data.users.UserEnt;
import adapter.repositories.repository.UserRepository;
import entity.users.User;
import infrastructure.userPorts.ReadUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserRepositoryAdapter implements ReadUsersPort {

    @Inject
    UserRepository repository;

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        for (UserEnt u: repository.getUsers()){
            list.add(DomainUserMapper.getDomainUser(u));
        }
        return list;
    }

    @Override
    public User getUser(String login) {
        return DomainUserMapper
                .getDomainUser(repository.getUser(login));
    }

    @Override
    public List<User> getByPartLogin(String login) {
        List<User> list = new ArrayList<>();
        for (UserEnt u: repository.getByPartLogin(login)){
            list.add(DomainUserMapper.getDomainUser(u));
        }
        return list;
    }

    @Override
    public boolean changeActivity(String login) {
        return repository.changeActivity(login);
    }


}
