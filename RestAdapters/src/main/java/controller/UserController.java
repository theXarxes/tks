package controller;

import DTO.userDTO.GetUserDTO;
import DTO.userDTO.PUserDTO;
import application.userPorts.EditUserAppPort;
import application.userPorts.ReadUserAppPort;
import entity.users.User;
import exception.UserException;
import mapper.UserMapper;

import javax.inject.Inject;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Path("/user")
public class UserController {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Inject
    ReadUserAppPort readUserPort;

    @Inject
    EditUserAppPort editUserPort;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<GetUserDTO> list = new ArrayList<>();
        for(User u: readUserPort.getUsers()){
            list.add(UserMapper.userMapper(u));
        }
        return Response.ok().entity(list).build();
    }

    @GET
    @Path("{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByLogin(@PathParam("login") String login) {
        try {
            GetUserDTO u = UserMapper.userMapper(readUserPort.getUser(login));
            return Response.ok().entity(u).build();
        } catch (UserException e){
            return Response.status(404).build();
        }
    }

    @GET
    @Path("/part/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPartialLogin(@PathParam("login") String login) {
        List<GetUserDTO> list = new ArrayList<>();
        for(User u: readUserPort.getByPartLogin(login)){
            list.add(UserMapper.userMapper(u));
        }
        return Response.ok().entity(list).build();
    }

    @GET
    @Path("/changeActivity/{login}")
    public Response changeActivity(@PathParam("login") String login){
        try {
            readUserPort.changeActivity(login);
            return Response.ok().build();
        } catch (UserException e){
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/addAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdminUser(PUserDTO userDTO){
        Set<ConstraintViolation<PUserDTO>> cos = validator.validate(userDTO);
        if(cos.isEmpty()){
            try {
                editUserPort.addAdminUser(UserMapper.getPAdminUserDomain(userDTO));
                return Response.status(201).build();
            } catch (UserException | NullPointerException e){
                return Response.status(409).build();
            }
        }
        return Response.status(400).build();
    }

    @POST
    @Path("/addData")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDataUser(PUserDTO userDTO){
        Set<ConstraintViolation<PUserDTO>> cos = validator.validate(userDTO);
        if(cos.isEmpty()){
            try {
                editUserPort.addDataUser(UserMapper.getPDataAdminUserDomain(userDTO));
                return Response.status(201).build();
            } catch (UserException | NullPointerException e){
                return Response.status(409).build();
            }
        }
        return Response.status(400).build();
    }

    @POST
    @Path("/addClient")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClientUser(PUserDTO userDTO){
        Set<ConstraintViolation<PUserDTO>> cos = validator.validate(userDTO);
        if(cos.isEmpty()){
            try {
                editUserPort.addClientUser(UserMapper.getPClientUserDomain(userDTO));
                return Response.status(201).build();
            } catch (UserException | NullPointerException e){
                return Response.status(409).build();
            }
        }
        return Response.status(400).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PUserDTO userDTO){
        Set<ConstraintViolation<PUserDTO>> cos = validator.validate(userDTO);
        if(cos.isEmpty()){
            try {
                editUserPort.updateUser(UserMapper.getPClientUserDomain(userDTO));
                return Response.status(201).build();
            } catch (UserException e){
                return Response.status(409).build();
            }
        }
        return Response.status(400).build();
    }
}