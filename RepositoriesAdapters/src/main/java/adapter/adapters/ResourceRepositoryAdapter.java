package adapter.adapters;

import adapter.domainMappers.DomainResourceMapper;
import adapter.repositories.data.resources.ResourceEnt;
import adapter.repositories.repository.ResourceRepository;
import entity.resources.Resource;
import exception.ResourceAllocationException;
import infrastructure.resourcePorts.EditResourcePort;
import infrastructure.resourcePorts.ReadResourcePort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ResourceRepositoryAdapter implements ReadResourcePort, EditResourcePort {

    @Inject
    ResourceRepository repository;

    @Override
    public void addResource(Resource r){
        repository
                .addResource(DomainResourceMapper.getResourceEntMapper(r));
    }

    @Override
    public Resource findById(UUID id){
        return DomainResourceMapper
                .getDomainResource(repository.findById(id));
    }

    @Override
    public List<Resource> findAll(){
        List<Resource> u = new ArrayList<>();
        for(ResourceEnt r: repository.findAll()){
            u.add(DomainResourceMapper.getDomainResource(r));
        }
        return u;
    }

    @Override
    public boolean update(Resource resource) throws ResourceAllocationException{
        return repository.update(DomainResourceMapper.getResourceEntMapper(resource));
    }

    @Override
    public boolean delete(UUID id) throws ResourceAllocationException{
        return repository.delete(id);
    }

    @Override
    public void changeAllocation(UUID id){
        repository.changeAllocation(id);
    }
}
