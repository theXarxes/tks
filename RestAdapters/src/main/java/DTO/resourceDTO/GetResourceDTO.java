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
public class GetResourceDTO {

    @NotNull
    UUID id;
    @NotNull
    boolean isAllocated;
    @NotNull
    int valueOfResource;

    public GetResourceDTO(Resource res) {
        this.id = res.getId();
        this.isAllocated = res.isAllocated();
        this.valueOfResource = res.getValueOfResource();
    }
}
