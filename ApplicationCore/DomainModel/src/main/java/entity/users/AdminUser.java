package entity.users;

import java.util.UUID;

public class AdminUser extends User{

    public AdminUser(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    public AdminUser(String login, String name) {
        super(login, name);
    }

    @Override
    public String getAccessLevel() {
        return "ADMIN";
    }
}
