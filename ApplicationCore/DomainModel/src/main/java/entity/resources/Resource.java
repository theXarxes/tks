package entity.resources;

import lombok.Data;

import java.util.UUID;

@Data
public class Resource {

    final UUID id;
    boolean isAllocated = false;
    int valueOfResource;

    public Resource(int valueOfResource) {
        this.id = UUID.randomUUID();
        this.valueOfResource = valueOfResource;
    }

    public Resource(UUID id, int valueOfResource) {
        this.id = id;
        this.valueOfResource = valueOfResource;
    }
}
