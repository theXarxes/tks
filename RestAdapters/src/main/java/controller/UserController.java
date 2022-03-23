package controller;

import DTO.userDTO.GetUserDTO;
import application.userPorts.ReadAllUserAppPort;
import entity.users.User;
import mapper.UserMapper;

import javax.inject.Inject;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/user")
public class UserController {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Inject
    ReadAllUserAppPort userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<GetUserDTO> list = new ArrayList<>();
        for(User u: userService.getUsers()){
            list.add(UserMapper.userMapper(u));
        }
        return Response.ok().entity(list).build();
    }

//    @GET
//    @Path("{login}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findByLogin(@PathParam("login") String login) {
//        try {
//            return Response.ok().entity(userService.getUser(login)).build();
//        } catch (UserException e){
//            return Response.status(404).build();
//        }
//    }
//
//    @GET
//    @Path("/part/{login}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findByPartialLogin(@PathParam("login") String login) {
//        return Response.ok().entity(userService.getByPartLogin(login)).build();
//    }
//
//    @POST
//    @Path("/addAdmin")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addAdminUser(PostUserDTO userDTO){
//        Set<ConstraintViolation<PostUserDTO>> cos = validator.validate(userDTO);
//        if(cos.isEmpty()){
//            try {
//                userService.addAdminUser(userDTO);
//                return Response.status(201).build();
//            } catch (AccessLevelException | UserException | NullPointerException e){
//                return Response.status(409).build();
//            }
//        }
//        return Response.status(400).build();
//    }
//
//    @POST
//    @Path("/addData")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addDataUser(PostUserDTO userDTO){
//        Set<ConstraintViolation<PostUserDTO>> cos = validator.validate(userDTO);
//        if(cos.isEmpty()){
//            try {
//                userService.addDataUser(userDTO);
//                return Response.status(201).build();
//            } catch (AccessLevelException | UserException | NullPointerException e){
//                return Response.status(409).build();
//            }
//        }
//        return Response.status(400).build();
//    }
//
//    @POST
//    @Path("/addClient")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addClientUser(PostUserDTO userDTO){
//        Set<ConstraintViolation<PostUserDTO>> cos = validator.validate(userDTO);
//        if(cos.isEmpty()){
//            try {
//                userService.addClientUser(userDTO);
//                return Response.status(201).build();
//            } catch (AccessLevelException | UserException | NullPointerException e){
//                return Response.status(409).build();
//            }
//        }
//        return Response.status(400).build();
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response update(PutUserDTO userDTO){
//        Set<ConstraintViolation<PutUserDTO>> cos = validator.validate(userDTO);
//        if(cos.isEmpty()){
//            try {
//                userService.updateUser(userDTO);
//                return Response.status(201).build();
//            } catch (UserException e){
//                return Response.status(409).build();
//            }
//        }
//        return Response.status(400).build();
//    }
//
//    @GET
//    @Path("/changeActivity/{login}")
//    public Response changeActivity(@PathParam("login") String login){
//        try {
//            userService.changeActivity(login);
//            Response.ok().build();
//        } catch (UserException e){
//            return Response.status(404).build();
//        }
//
//        return Response.status(400).build();
//    }

}