package DTO.markerDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class PostMarkerDTO {

    @NotNull
    String user;
    @NotNull
    UUID resourceId;
    @NotNull
    int delay;

    public PostMarkerDTO(String user, UUID resourceId, int delay) {
        this.user = user;
        this.resourceId = resourceId;
        this.delay = delay;
    }
}
