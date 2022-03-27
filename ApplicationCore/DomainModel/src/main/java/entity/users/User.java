package entity.users;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class User {
    UUID id;
    String login;
    boolean isActive;
    String name;

    public User(UUID uuid, String login, boolean isActive, String name) {
        this.id = uuid;
        this.login = login;
        this.isActive = isActive;
        this.name = name;
    }

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public abstract String getAccessLevel();
}
