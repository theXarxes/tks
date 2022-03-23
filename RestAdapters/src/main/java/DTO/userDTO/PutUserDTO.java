package DTO.userDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class PutUserDTO {

    @NotBlank
    private String login;
    @NotBlank
    private String name;
}
