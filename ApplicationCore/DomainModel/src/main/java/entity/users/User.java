package entity.users;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    final UUID id;
    String login;
    boolean isActive;
    String name;

    public User(UUID uuid, String login, boolean isActive, String name) {
        this.id = uuid;
        this.login = login;
        this.isActive = isActive;
        this.name = name;
    }

    public String getAccessLevel(){
        return "User";
    };
}
