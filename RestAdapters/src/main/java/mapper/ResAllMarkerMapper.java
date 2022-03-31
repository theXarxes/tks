package mapper;

import DTO.markerDTO.GetMarkerDTO;
import DTO.markerDTO.PostMarkerDTO;
import DTO.resourceDTO.PostResourceDTO;
import entity.resources.ResourceAllocationMarker;

public class ResAllMarkerMapper {

    public static GetMarkerDTO resAllMarkerMapper(ResourceAllocationMarker res){
        return new GetMarkerDTO(res);
    }

    public static ResourceAllocationMarker getAllocationDomain(PostMarkerDTO dto){
        return new ResourceAllocationMarker(dto.getResourceId(), dto.getDelay(), dto.getUser());
    }


}
