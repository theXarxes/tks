//package controller;
//
//import model.DTO.resourceDTO.GetResourceDTO;
//import model.DTO.resourceDTO.PostResourceDTO;
//import model.DTO.resourceDTO.PutResourceDTO;
//import model.exception.ResourceException;
//import service.ResourceService;
//
//import javax.inject.Inject;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.Set;
//import java.util.UUID;
//
//@Path("/resource")
//public class ResourceController {
//
//    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    Validator validator = factory.getValidator();
//
//    @Inject
//    ResourceService resourceService;
//
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getById(@PathParam("id") String id) {
//        try {
//            return Response.ok().entity(resourceService.findById(UUID.fromString(id))).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public ArrayList<GetResourceDTO> findAll() {
//        return resourceService.findAll();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addUResource(PostResourceDTO resourceDTO){
//        Set<ConstraintViolation<PostResourceDTO>> cos = validator.validate(resourceDTO);
//        if(cos.isEmpty()){
//            resourceService.addResource(resourceDTO);
//            return Response.status(201).build();
//        }
//        return Response.status(400).build();
//
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(PutResourceDTO resourceDTO){
//        try {
//            resourceService.update(resourceDTO);
//            return Response.ok().build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") UUID id){
//        try {
//            resourceService.delete(id);
//            return Response.ok().build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//}
