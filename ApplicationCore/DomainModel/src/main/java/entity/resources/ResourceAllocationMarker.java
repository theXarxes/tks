package entity.resources;

import lombok.Data;
import entity.users.User;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ResourceAllocationMarker {
    final UUID id;
    final LocalDate start;
    final UUID resource;
    boolean isEnded = false;
    String user;

    public ResourceAllocationMarker(UUID resource, int delay, String user) {
        this.id = UUID.randomUUID();
        this.resource = resource;
        this.start = LocalDate.now().plusDays(delay);
        this.user = user;
    }

    public ResourceAllocationMarker(UUID id, LocalDate start, UUID resource, String user) {
        this.id = id;
        this.start = start;
        this.resource = resource;
        this.user = user;
    }

    public ResourceAllocationMarker(UUID id, LocalDate start, UUID resource, boolean isEnded, String user) {
        this.id = id;
        this.start = start;
        this.resource = resource;
        this.isEnded = isEnded;
        this.user = user;
    }
}
