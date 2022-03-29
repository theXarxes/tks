package controller;

import DTO.resourceDTO.GetResourceDTO;
import DTO.resourceDTO.PostResourceDTO;
import DTO.resourceDTO.PutResourceDTO;
import application.resourcePorts.EditResourceAppPort;
import application.resourcePorts.ReadResourceAppPort;
import entity.resources.Resource;
import exception.ResourceException;
import mapper.ResourceMapper;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Path("/resource")
public class ResourceController {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Inject
    ReadResourceAppPort readResourcePort;

    @Inject
    EditResourceAppPort editResourcePort;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") String id) {
        try {
            return Response.ok().entity(readResourcePort.findById(UUID.fromString(id))).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GetResourceDTO> findAll() {
        List<GetResourceDTO> u = new ArrayList<>();
        for(Resource r: readResourcePort.findAll()){
            u.add(ResourceMapper.resourceMapper(r));
        }
        return u;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUResource(PostResourceDTO resourceDTO){
        Set<ConstraintViolation<PostResourceDTO>> cos = validator.validate(resourceDTO);
        if(cos.isEmpty()){
            editResourcePort.addResource(ResourceMapper.getResource(resourceDTO));
            return Response.status(201).build();
        }
        return Response.status(400).build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PutResourceDTO resourceDTO){
        try {
            editResourcePort.update(ResourceMapper.getPutResource(resourceDTO));
            return Response.ok().build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id){
        try {
            editResourcePort.delete(id);
            return Response.ok().build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }
}
