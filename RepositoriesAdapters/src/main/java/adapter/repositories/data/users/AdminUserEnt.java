package adapter.repositories.data.users;

import java.util.UUID;

public class AdminUserEnt extends UserEnt {

    public AdminUserEnt(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    @Override
    public String getAccessLevel() {
        return "ADMIN";
    }
}
