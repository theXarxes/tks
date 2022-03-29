package DTO.resourceDTO;

import entity.resources.Resource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class PostResourceDTO {

    @NotNull
    int valueOfResource;

    public PostResourceDTO(Resource res) {
        this.valueOfResource = res.getValueOfResource();
    }
}
