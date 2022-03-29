package infrastructure.resourcePorts;

import entity.resources.Resource;
import exception.ResourceAllocationException;

import java.util.List;
import java.util.UUID;

public interface ReadResourcePort {

    Resource findById(UUID id);

    List<Resource> findAll();

}
