package soapMapper;

import entity.resources.Resource;
import soapModel.GetResourceSoap;
import soapModel.PostResourceSoap;
import soapModel.PutResourceSoap;

import java.util.UUID;

public class ResourceSoapMapper {

    public static GetResourceSoap resourceSOAPMapper(Resource res){
        return new GetResourceSoap(res);
    }

    public static Resource getPutResource(PutResourceSoap resourceSoap){
        return new Resource(UUID.fromString(resourceSoap.getId()), resourceSoap.getValueOfResource());
    }

    public static Resource getPostResource(PostResourceSoap resourceSoap){
        return new Resource(resourceSoap.getValueOfResource());
    }
}
