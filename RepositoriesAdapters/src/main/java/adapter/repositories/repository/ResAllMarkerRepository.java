package adapter.repositories.repository;

import adapter.repositories.data.resources.ResourceAllocationMarkerEnt;
import exception.ResourceAllocationException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ResAllMarkerRepository {

    @Inject
    ResourceRepository repository;

    List<ResourceAllocationMarkerEnt> markers = Collections.synchronizedList(new ArrayList<>());

    public void addMarker(ResourceAllocationMarkerEnt r){
        markers.add(r);
    }

    public List<ResourceAllocationMarkerEnt> getMarkers(){
        return markers;
    }

    public ResourceAllocationMarkerEnt findById(UUID id){
        for(ResourceAllocationMarkerEnt x: markers){
            if(x.getId().equals(id)){
                return x;
            }
        }
        return null;
    }

    public List<ResourceAllocationMarkerEnt> findAllByUser(String login){
        List<ResourceAllocationMarkerEnt> list = new ArrayList<>();
        for(ResourceAllocationMarkerEnt x: markers){
            if(x.getUser().equals(login)){
                list.add(x);
            }
        }
        return list;
    }

    public List<ResourceAllocationMarkerEnt> findAllByResource(UUID id){
        List<ResourceAllocationMarkerEnt> list = new ArrayList<>();
        for(ResourceAllocationMarkerEnt x: markers){
            if(x.getResource().equals(id)){
                list.add(x);
            }
        }
        return list;
    }

    public boolean delete(UUID id) throws ResourceAllocationException {
        for(ResourceAllocationMarkerEnt x: markers){
            if(x.getId().equals(id)){
                if(!x.isEnded()){
                    repository.changeAllocation(x.getResource());
                    markers.remove(x);
                    return true;
                }
                throw new ResourceAllocationException("Finished allocations cannot be deleted...");
            }
        }
        return false;
    }
}
