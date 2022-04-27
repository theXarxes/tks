package service;



import application.allocationPorts.EditAllocationAppPort;
import application.allocationPorts.ReadAllocationAppPort;
import entity.resources.Resource;
import entity.resources.ResourceAllocationMarker;
import entity.users.User;
import exception.ResourceAllocationException;
import exception.ResourceException;
import exception.UserException;
import infrastructure.allocationPorts.AllocationPort;
import infrastructure.resourcePorts.EditResourcePort;
import infrastructure.resourcePorts.ReadResourcePort;
import infrastructure.userPorts.ReadUsersPort;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class ResAllMarkerService implements ReadAllocationAppPort, EditAllocationAppPort {

    @Inject
    AllocationPort allocationPort;

    @Inject
    ReadResourcePort readResourcePort;

    @Inject
    EditResourcePort editResourcePort;

    @Inject
    ReadUsersPort usersPort;

    @Override
    public ResourceAllocationMarker findById(UUID id) throws ResourceException {
        ResourceAllocationMarker r = allocationPort.findById(id);
        if (r == null) {
            throw new ResourceException("Invalid marker id...");
        }
        return r;
    }

    @Override
    public List<ResourceAllocationMarker> findAllByUser(String login) throws ResourceException {
        List<ResourceAllocationMarker> list = allocationPort.findAllByUser(login);
        if (list.isEmpty()) {
            throw new ResourceException("Invalid marker id...");
        }
        return list;
    }

    @Override
    public ArrayList<ResourceAllocationMarker> findAllCurrentByUser(String login) throws ResourceException {
        ArrayList<ResourceAllocationMarker> list = new ArrayList<>();
        for (ResourceAllocationMarker r : allocationPort.findAllByUser(login)) {
            if (!r.isEnded()) list.add(r);
        }
        if (list.isEmpty()) {
            throw new ResourceException("Invalid marker id...");
        }
        return list;
    }

    @Override
    public ArrayList<ResourceAllocationMarker> findAllEndedByUser(String login) throws ResourceException {
        ArrayList<ResourceAllocationMarker> list = new ArrayList<>();
        for (ResourceAllocationMarker r : allocationPort.findAllByUser(login)) {
            if (r.isEnded()) list.add(r);
        }
        if (list.isEmpty()) {
            throw new ResourceException("Invalid marker id...");
        }
        return list;
    }

    @Override
    public List<ResourceAllocationMarker> findAllByResource(UUID id) throws ResourceException {
        List<ResourceAllocationMarker> list = allocationPort.findAllByResource(id);
        if (list.isEmpty()) {
            throw new ResourceException("Invalid marker id...");
        }
        return list;
    }

    @Override
    public List<ResourceAllocationMarker> getMarkers() {
        return allocationPort.getMarkers();
    }

    @Override
    public void delete(UUID id) throws ResourceException {
        if (!allocationPort.delete(id)) {
            throw new ResourceException("Invalid marker id...");
        }
    }

    @Override
    public void allocateResource(ResourceAllocationMarker dto) throws ResourceException, UserException {
        User u = usersPort.getUser(dto.getUser());
        if (u != null) {
            if (u.isActive()) {
                Resource r = readResourcePort.findById(dto.getResource());
                if (r != null) {
                    if (!r.isAllocated()) {
                        ResourceAllocationMarker marker = new ResourceAllocationMarker(
                                dto.getId(),
                                dto.getStart(),
                                dto.getResource(),
                                dto.getUser());
                        editResourcePort.changeAllocation(r.getId());
                        allocationPort.addMarker(marker);
                        return;
                    }
                    throw new ResourceAllocationException("Resource already allocated...");
                }
                throw new ResourceAllocationException("Invalid resource id...");
            }
            throw new UserException("User is inactive...");
        }
        throw new UserException("Invalid user login...");
    }

    @Override
    public void endAllocation(UUID id) throws ResourceException {
        ResourceAllocationMarker r = allocationPort.findById(id);
        if (r == null) throw new ResourceException("Invalid marker id...");
        editResourcePort.changeAllocation(r.getResource());
        allocationPort.changeAllocation(id);
    }

}
