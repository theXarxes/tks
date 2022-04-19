package adapter.domainMappers;

import adapter.repositories.data.resources.ResourceAllocationMarkerEnt;
import entity.resources.ResourceAllocationMarker;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DomainAllocationMapper {

    public static ResourceAllocationMarker getDomainAllocation(ResourceAllocationMarkerEnt markerEnt){
        return new ResourceAllocationMarker(
                markerEnt.getId(),
                markerEnt.getStart(),
                markerEnt.getResource(),
                markerEnt.isEnded(),
                markerEnt.getUser());
    }

    public static ResourceAllocationMarkerEnt getAllocation(ResourceAllocationMarker marker){
        return new ResourceAllocationMarkerEnt(
                marker.getId(),
                marker.getStart(),
                marker.getResource(),
                marker.isEnded(),
                marker.getUser());
    }

}
