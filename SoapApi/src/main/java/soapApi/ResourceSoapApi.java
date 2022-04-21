package soapApi;

import application.resourcePorts.EditResourceAppPort;
import application.resourcePorts.ReadResourceAppPort;
import entity.resources.Resource;
import exception.ResourceAllocationException;
import exception.ResourceException;
import soapMapper.ResourceSoapMapper;
import soapModel.GetResourceSoap;
import soapModel.PostResourceSoap;
import soapModel.PutResourceSoap;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.*;

@WebService(serviceName = "ResourceApi")
public class ResourceSoapApi {

    @Inject
    private ReadResourceAppPort readResourcePort;

    @Inject
    private EditResourceAppPort editResourcePort;

    public GetResourceSoap getById(String id) throws ResourceException {
        return ResourceSoapMapper.resourceSOAPMapper(readResourcePort.findById(UUID.fromString(id)));
    }

    public List<GetResourceSoap> findAll() {
        List<GetResourceSoap> u = new ArrayList<>();
        for(Resource r: readResourcePort.findAll()){
            u.add(ResourceSoapMapper.resourceSOAPMapper(r));
        }
        return u;
    }

    public void addUResource(PostResourceSoap resourceDTO){
        editResourcePort.addResource(ResourceSoapMapper.getPostResource(resourceDTO));
    }

    public void update(PutResourceSoap resourceDTO) throws ResourceAllocationException {
            editResourcePort.update(ResourceSoapMapper.getPutResource(resourceDTO));
    }

    public void delete(String id) throws ResourceException {
        editResourcePort.delete(UUID.fromString(id));
    }
}
