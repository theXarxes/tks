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
    final ResourceEnt resource;
    boolean isEnded = false;
    UserEnt user;

    public ResourceAllocationMarkerEnt(ResourceEnt resource, int delay, UserEnt user) {
        this.id = UUID.randomUUID();
        this.resource = resource;
        this.start = LocalDate.now().plusDays(delay);
        this.user = user;
    }
}
