package DTO.userDTO;

import entity.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class GetUserDTO {

    @NotBlank
    String login;
    @NotBlank
    boolean isActive;
    @NotBlank
    String accessLevel;
    @NotBlank
    String name;

    public GetUserDTO(User user) {
        this.login = user.getLogin();
        this.isActive = user.isActive();
        this.accessLevel = user.getAccessLevel();
        this.name = user.getName();
    }
}
