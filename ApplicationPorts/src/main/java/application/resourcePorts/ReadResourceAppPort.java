package application.resourcePorts;

import entity.resources.Resource;
import exception.ResourceException;

import java.util.List;
import java.util.UUID;

public interface ReadResourceAppPort {

    Resource findById(UUID id) throws ResourceException;

    List<Resource> findAll();
}
