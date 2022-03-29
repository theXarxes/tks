package DTO.resourceDTO;

import entity.resources.Resource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class PutResourceDTO {

    @NotNull
    UUID id;
    @NotNull
    int valueOfResource;

    public PutResourceDTO(Resource res) {
        this.id = res.getId();
        this.valueOfResource = res.getValueOfResource();
    }
}
