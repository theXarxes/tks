package application.resourcePorts;

import entity.resources.Resource;
import exception.ResourceAllocationException;
import exception.ResourceException;

import java.util.UUID;

public interface EditResourceAppPort {

    void addResource(Resource resource);

    void update(Resource resource) throws ResourceAllocationException;

    void delete(UUID id) throws ResourceException;
}
