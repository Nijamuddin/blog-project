package com.cisco.cmad.blogs.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cisco.cmad.blogs.api.User;
import com.cisco.cmad.blogs.api.Users;
import com.cisco.cmad.blogs.service.UsersService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {

	private static Users users = UsersService.getInstance();
    private Logger logger = Logger.getLogger(getClass().getName());
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        users.create(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("/{userId}")
    public Response read(@PathParam("userId") String userId) {
        User user = users.read(userId);
        return Response.ok().entity(user).build();
    }
}
