package entity.users;

import java.util.UUID;

public class DataAdminUser extends User{


    public DataAdminUser(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    public DataAdminUser(String login, String name) {
        super(login, name);
    }

    @Override
    public String getAccessLevel() {
        return "DATA_ADMIN";
    }
}
