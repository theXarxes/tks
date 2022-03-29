package DTO.markerDTO;

import entity.resources.ResourceAllocationMarker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class GetMarkerDTO {

    @NotNull
    UUID id;
    @NotNull
    LocalDate start;
    @NotNull
    UUID resourceId;
    @NotNull
    boolean isEnded;
    @NotNull
    String user;

    public GetMarkerDTO(ResourceAllocationMarker res) {
        this.id = res.getId();
        this.start = res.getStart();
        this.resourceId = res.getResource();
        this.isEnded = res.isEnded();
        this.user = res.getUser();
    }
}
