package entity.users;

import java.util.UUID;

public class ClientUser extends User{

    public ClientUser(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    public ClientUser(String login, String name) {
        super(login, name);
    }

    @Override
    public String getAccessLevel() {
        return "CLIENT";
    }

}
