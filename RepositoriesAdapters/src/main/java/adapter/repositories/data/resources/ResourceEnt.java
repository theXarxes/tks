package adapter.repositories.data.resources;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResourceEnt {

    final UUID id;
    boolean isAllocated = false;
    int valueOfResource;

    public ResourceEnt(int valueOfResource) {
        this.id = UUID.randomUUID();
        this.valueOfResource = valueOfResource;
    }

    public ResourceEnt(UUID id, int valueOfResource) {
        this.id = id;
        this.valueOfResource = valueOfResource;
    }
}
