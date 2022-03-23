//package controller;
//
//import model.DTO.markerDTO.PostMarkerDTO;
//import model.exception.ResourceAllocationException;
//import model.exception.ResourceException;
//import model.exception.UserException;
//import service.ResAllMarkerService;
//
//import javax.inject.Inject;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.Set;
//import java.util.UUID;
//
//@Path("/allocate")
//public class AllocationController {
//
//    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    Validator validator = factory.getValidator();
//
//    @Inject
//    ResAllMarkerService markerService;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAll() {
//        return Response.ok().entity(markerService.getMarkers()).build();
//    }
//
//    @GET
//    @Path("/resource/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAllByResource(@PathParam("id") UUID id) {
//        try {
//            return Response.ok().entity(markerService.findAllByResource(id)).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @GET
//    @Path("/user/{login}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAllByUser(@PathParam("login") String login) {
//        try {
//            return Response.ok().entity(markerService.findAllByUser(login)).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//
//        }
//    }
//
//    @GET
//    @Path("/user/{login}/current")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAllCurrentByUser(@PathParam("login") String login) {
//        try {
//            return Response.ok().entity(markerService.findAllCurrentByUser(login)).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @GET
//    @Path("/user/{login}/ended")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAllEndedByUser(@PathParam("login") String login) {
//        try {
//            return Response.ok().entity(markerService.findAllEndedByUser(login)).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findById(@PathParam("id") UUID id) {
//        try {
//            return Response.ok().entity(markerService.findById(id)).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @DELETE
//    @Path("{id}")
//    public Response delete(@PathParam("id") UUID id) {
//        try {
//            markerService.delete(id);
//            return Response.ok().build();
//        } catch (ResourceAllocationException e){
//            return Response.status(400).build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response allocateResource(PostMarkerDTO dto){
//        Set<ConstraintViolation<PostMarkerDTO>> cos = validator.validate(dto);
//        if(cos.isEmpty()){
//            try {
//                markerService.allocateResource(dto);
//                return Response.ok().build();
//            } catch (ResourceException | UserException e){
//                return Response.status(400).build();
//            }
//        }
//        return Response.status(401).build();
//
//    }
//
//    @POST
//    @Path("/end/{id}")
//    public Response endAllocation(@PathParam("id") UUID id){
//        try {
//            markerService.endAllocation(id);
//            return Response.ok().build();
//        } catch (ResourceException e){
//            return Response.status(404).build();
//        }
//    }
//
//}
