package adapter.repositories.data.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class UserEnt {
    UUID id;
    String login;
    boolean isActive;
    String name;

    public UserEnt(UUID uuid, String login, boolean isActive, String name) {
        this.id = uuid;
        this.login = login;
        this.isActive = isActive;
        this.name = name;
    }

    public UserEnt(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public abstract String getAccessLevel();
}
