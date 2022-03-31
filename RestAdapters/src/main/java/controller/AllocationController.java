package controller;

import DTO.markerDTO.GetMarkerDTO;
import DTO.markerDTO.PostMarkerDTO;
import application.allocationPorts.EditAllocationAppPort;
import application.allocationPorts.ReadAllocationAppPort;
import entity.resources.ResourceAllocationMarker;
import exception.ResourceAllocationException;
import exception.ResourceException;
import exception.UserException;
import mapper.ResAllMarkerMapper;

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

@Path("/allocate")
public class AllocationController {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Inject
    ReadAllocationAppPort readAllocationAppPort;

    @Inject
    EditAllocationAppPort editAllocationAppPort;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<GetMarkerDTO> l = new ArrayList<>();
        for(ResourceAllocationMarker r: readAllocationAppPort.getMarkers()){
            l.add(ResAllMarkerMapper.resAllMarkerMapper(r));
        }
        return Response.ok().entity(l).build();
    }

    @GET
    @Path("/resource/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllByResource(@PathParam("id") UUID id) {
        try {
            List<GetMarkerDTO> l = new ArrayList<>();
            for(ResourceAllocationMarker r: readAllocationAppPort.findAllByResource(id)){
                l.add(ResAllMarkerMapper.resAllMarkerMapper(r));
            }
            return Response.ok().entity(l).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/user/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllByUser(@PathParam("login") String login) {
        try {
            List<GetMarkerDTO> l = new ArrayList<>();
            for(ResourceAllocationMarker r: readAllocationAppPort.findAllByUser(login)){
                l.add(ResAllMarkerMapper.resAllMarkerMapper(r));
            }
            return Response.ok().entity(l).build();
        } catch (ResourceException e){
            return Response.status(404).build();

        }
    }

    @GET
    @Path("/user/{login}/current")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllCurrentByUser(@PathParam("login") String login) {
        try {
            List<GetMarkerDTO> l = new ArrayList<>();
            for(ResourceAllocationMarker r: readAllocationAppPort.findAllCurrentByUser(login)){
                l.add(ResAllMarkerMapper.resAllMarkerMapper(r));
            }
            return Response.ok().entity(l).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/user/{login}/ended")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllEndedByUser(@PathParam("login") String login) {
        try {
            List<GetMarkerDTO> l = new ArrayList<>();
            for(ResourceAllocationMarker r: readAllocationAppPort.findAllEndedByUser(login)){
                l.add(ResAllMarkerMapper.resAllMarkerMapper(r));
            }
            return Response.ok().entity(l).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") UUID id) {
        try {
            GetMarkerDTO g = ResAllMarkerMapper.resAllMarkerMapper(readAllocationAppPort.findById(id));
            return Response.ok().entity(g).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) {
        try {
            editAllocationAppPort.delete(id);
            return Response.ok().build();
        } catch (ResourceAllocationException e){
            return Response.status(400).build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response allocateResource(PostMarkerDTO dto){
        Set<ConstraintViolation<PostMarkerDTO>> cos = validator.validate(dto);
        if(cos.isEmpty()){
            try {
                editAllocationAppPort.allocateResource(ResAllMarkerMapper.getAllocationDomain(dto));
                return Response.ok().build();
            } catch (ResourceException | UserException e){
                return Response.status(400).build();
            }
        }
        return Response.status(401).build();

    }

    @POST
    @Path("/end/{id}")
    public Response endAllocation(@PathParam("id") UUID id){
        try {
            editAllocationAppPort.endAllocation(id);
            return Response.ok().build();
        } catch (ResourceException e){
            return Response.status(404).build();
        }
    }

}
