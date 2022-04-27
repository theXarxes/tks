package soapApi;

import exception.ResourceAllocationException;
import exception.ResourceException;
import soapModel.GetResourceSoap;
import soapModel.PostResourceSoap;
import soapModel.PutResourceSoap;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ResourceSoapApiItf {

    GetResourceSoap getById(String id) throws ResourceException;

    List<GetResourceSoap> findAll();

    void addUResource(PostResourceSoap resourceDTO);

    void update(PutResourceSoap resourceDTO) throws ResourceAllocationException;

    void delete(String id) throws ResourceException;
}
