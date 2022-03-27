package application.userPorts;

import entity.users.AdminUser;
import entity.users.ClientUser;
import entity.users.DataAdminUser;
import exception.AccessLevelException;
import exception.UserException;

public interface EditUserAppPort {

    void addAdminUser(AdminUser user) throws UserException;

    void addDataUser(DataAdminUser user) throws UserException;

    void addClientUser(ClientUser user) throws UserException;

    void updateUser(ClientUser user) throws UserException;
}
