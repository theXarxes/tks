package adapter.adapters;

import adapter.domainMappers.DomainUserMapper;
import adapter.repositories.data.users.DataAdminUserEnt;
import adapter.repositories.data.users.UserEnt;
import adapter.repositories.repository.UserRepository;
import entity.users.DataAdminUser;
import entity.users.User;
import infrastructure.userPorts.EditUserPort;
import infrastructure.userPorts.ReadUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserRepositoryAdapter implements ReadUsersPort, EditUserPort {

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


    @Override
    public boolean isLoginNotUnique(String login) {
        return repository.isLoginNotUnique(login);
    }

    @Override
    public void addAdminUser(User user) {
        repository.addAdminUser(DomainUserMapper.getAdminUserEnt(user));
    }

    @Override
    public void addDataUser(User user) {
        repository.addDataUser(DomainUserMapper.getDataAdminUserEnt(user));
    }

    @Override
    public void addClientUser(User user) {
        repository.addClientUser(DomainUserMapper.getClientUserEnt(user));
    }

    @Override
    public boolean updateUser(User user) {
        return repository.updateUser(DomainUserMapper.getClientUserEnt(user));
    }

}