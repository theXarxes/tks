package adapter.repositories.data.users;

import java.util.UUID;

public class DataAdminUserEnt extends UserEnt {


    public DataAdminUserEnt(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    public DataAdminUserEnt(String login, String name) {
        super(login, name);
    }

    @Override
    public String getAccessLevel() {
        return "DATA_ADMIN";
    }
}
