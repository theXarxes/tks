package entity.resources;

import lombok.Data;
import entity.users.User;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ResourceAllocationMarker {
    final UUID id;
    final LocalDate start;
    final Resource resource;
    boolean isEnded = false;
    User user;

    public ResourceAllocationMarker(Resource resource, int delay, User user) {
        this.id = UUID.randomUUID();
        this.resource = resource;
        this.start = LocalDate.now().plusDays(delay);
        this.user = user;
    }
}
