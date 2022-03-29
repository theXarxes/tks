package adapter.repositories.data.resources;

import adapter.repositories.data.users.UserEnt;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class ResourceAllocationMarkerEnt {
    final UUID id;
    final LocalDate start;
    final UUID resource;
    boolean isEnded = false;
    String user;

    public ResourceAllocationMarkerEnt(UUID resource, int delay, String user) {
        this.id = UUID.randomUUID();
        this.resource = resource;
        this.start = LocalDate.now().plusDays(delay);
        this.user = user;
    }

    public ResourceAllocationMarkerEnt(UUID id, LocalDate start, UUID resource, boolean isEnded, String user) {
        this.id = id;
        this.start = start;
        this.resource = resource;
        this.isEnded = isEnded;
        this.user = user;
    }
}
