package application.allocationPorts;

import entity.resources.ResourceAllocationMarker;
import exception.ResourceException;
import exception.UserException;

import java.util.UUID;

public interface EditAllocationAppPort {

    void delete(UUID id) throws ResourceException;

    void allocateResource(ResourceAllocationMarker dto) throws ResourceException, UserException;

    void endAllocation(UUID id) throws ResourceException;
}
