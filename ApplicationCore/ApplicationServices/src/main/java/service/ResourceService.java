package service;


import application.resourcePorts.EditResourceAppPort;
import application.resourcePorts.ReadResourceAppPort;
import entity.resources.Resource;
import exception.ResourceAllocationException;
import exception.ResourceException;
import infrastructure.resourcePorts.EditResourcePort;
import infrastructure.resourcePorts.ReadResourcePort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ResourceService implements ReadResourceAppPort, EditResourceAppPort {

    @Inject
    ReadResourcePort readResourcePort;

    @Inject
    EditResourcePort editResourcePort;

    @Override
    public Resource findById(UUID id) throws ResourceException {
        Resource r = readResourcePort.findById(id);
        if (r == null){
            throw new ResourceException("Invalid resource id...");
        }
        return r;
    }

    @Override
    public List<Resource> findAll(){
        return readResourcePort.findAll();
    }

    @Override
    public void addResource(Resource resource){
        editResourcePort.addResource(resource);
    }

    @Override
    public void update(Resource resource) throws ResourceAllocationException {
            if (!editResourcePort.update(resource)){
                throw new ResourceAllocationException("Invalid resource id...");
            }
    }

    @Override
    public void delete(UUID id) throws ResourceException {
            if (!editResourcePort.delete(id)){
                throw new ResourceException("Invalid resource id...");
            }
    }
}
