package application.allocationPorts;

import entity.resources.ResourceAllocationMarker;
import exception.ResourceException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ReadAllocationAppPort {

    ResourceAllocationMarker findById(UUID id) throws ResourceException;

    List<ResourceAllocationMarker> findAllByUser(String login) throws ResourceException;

    ArrayList<ResourceAllocationMarker> findAllCurrentByUser(String login) throws ResourceException;

    ArrayList<ResourceAllocationMarker> findAllEndedByUser(String login) throws ResourceException;

    List<ResourceAllocationMarker> findAllByResource(UUID id) throws ResourceException;

    List<ResourceAllocationMarker> getMarkers();

}
