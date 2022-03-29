package mapper;


import DTO.resourceDTO.GetResourceDTO;
import DTO.resourceDTO.PostResourceDTO;
import DTO.resourceDTO.PutResourceDTO;
import entity.resources.Resource;

public class ResourceMapper {

    public static GetResourceDTO resourceMapper(Resource res){
        return new GetResourceDTO(res);
    }

    public static Resource getPutResource(PutResourceDTO resourceDTO){
        return new Resource(resourceDTO.getId(), resourceDTO.getValueOfResource());
    }

    public static Resource getResource(PostResourceDTO resourceDTO){
        return new Resource(resourceDTO.getValueOfResource());
    }
}
