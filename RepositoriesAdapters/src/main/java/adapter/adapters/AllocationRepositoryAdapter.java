package adapter.adapters;

import adapter.domainMappers.DomainAllocationMapper;
import adapter.repositories.data.resources.ResourceAllocationMarkerEnt;
import adapter.repositories.repository.ResAllMarkerRepository;
import entity.resources.ResourceAllocationMarker;
import exception.ResourceAllocationException;
import infrastructure.allocationPorts.AllocationPort;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestScoped
public class AllocationRepositoryAdapter implements AllocationPort {

    @Inject
    ResAllMarkerRepository repository;

    @Override
    public void addMarker(ResourceAllocationMarker r){
        repository.addMarker(DomainAllocationMapper.getAllocation(r));
    }

    @Override
    public void changeAllocation(UUID id) {
        repository.changeAllocation(id);
    }

    @Override
    public List<ResourceAllocationMarker> getMarkers(){
        List<ResourceAllocationMarker> u = new ArrayList<>();
        for(ResourceAllocationMarkerEnt r: repository.getMarkers()){
            u.add(DomainAllocationMapper.getDomainAllocation(r));
        }
        return u;
    }

    @Override
    public ResourceAllocationMarker findById(UUID id){
        return DomainAllocationMapper.getDomainAllocation(repository.findById(id));
    }

    @Override
    public List<ResourceAllocationMarker> findAllByUser(String login){
        List<ResourceAllocationMarker> u = new ArrayList<>();
        for(ResourceAllocationMarkerEnt r: repository.findAllByUser(login)){
            u.add(DomainAllocationMapper.getDomainAllocation(r));
        }
        return u;
    }

    @Override
    public List<ResourceAllocationMarker> findAllByResource(UUID id){
        List<ResourceAllocationMarker> u = new ArrayList<>();
        for(ResourceAllocationMarkerEnt r: repository.findAllByResource(id)){
            u.add(DomainAllocationMapper.getDomainAllocation(r));
        }
        return u;
    }

    @Override
    public boolean delete(UUID id) throws ResourceAllocationException{
        return repository.delete(id);
    }
}
