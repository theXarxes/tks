package DTO.markerDTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import entity.resources.ResourceAllocationMarker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter

public class GetMarkerDTO implements Serializable {

    @NotNull
    UUID id;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
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
