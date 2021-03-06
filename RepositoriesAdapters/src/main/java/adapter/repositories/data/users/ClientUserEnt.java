package adapter.repositories.data.users;

import java.util.UUID;

public class ClientUserEnt extends UserEnt {

    public ClientUserEnt(UUID uuid, String login, boolean isActive, String name) {
        super(uuid, login, isActive, name);
    }

    public ClientUserEnt(String login, String name) {
        super(login, name);
    }

    @Override
    public String getAccessLevel() {
        return "CLIENT";
    }

}
