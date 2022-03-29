package infrastructure.resourcePorts;

import entity.resources.Resource;
import exception.ResourceAllocationException;

import java.util.UUID;

public interface EditResourcePort {

    void addResource(Resource r);

    boolean update(Resource resource) throws ResourceAllocationException;

    boolean delete(UUID id) throws ResourceAllocationException;

    void changeAllocation(UUID id);
}
