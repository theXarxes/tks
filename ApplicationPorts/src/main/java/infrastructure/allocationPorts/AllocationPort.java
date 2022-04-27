package infrastructure.allocationPorts;

import entity.resources.ResourceAllocationMarker;
import exception.ResourceAllocationException;

import java.util.List;
import java.util.UUID;

public interface AllocationPort {

    List<ResourceAllocationMarker> getMarkers();

    ResourceAllocationMarker findById(UUID id);

    List<ResourceAllocationMarker> findAllByUser(String login);

    List<ResourceAllocationMarker> findAllByResource(UUID id);

    boolean delete(UUID id) throws ResourceAllocationException;

    void addMarker(ResourceAllocationMarker r);

    void changeAllocation(UUID id);
}
