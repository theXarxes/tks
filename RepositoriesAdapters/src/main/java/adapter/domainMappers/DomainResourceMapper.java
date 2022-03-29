package adapter.domainMappers;

import adapter.repositories.data.resources.ResourceEnt;
import entity.resources.Resource;

public class DomainResourceMapper {

    public static ResourceEnt getResourceEntMapper(Resource resource){
        return new ResourceEnt(resource.getId(), resource.getValueOfResource());
    }

    public static Resource getDomainResource(ResourceEnt r){
        return new Resource(r.getId(), r.getValueOfResource());
    }

}
