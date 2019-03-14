package io.orten.nano.business;

import io.orten.nano.impl.UserService;
import io.orten.nano.model.User;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserAPI {

    public static List<User> userList = new ArrayList<User>();

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") long userId) {
        try {
            User user = UserService.getUserById(userId);
            return Response.status(HttpServletResponse.SC_OK).entity(user).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<User> users = UserService.getUsers();
            return Response.status(HttpServletResponse.SC_OK).entity(users).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/userName/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByUserName(@PathParam("userName") String userName) {
        try {
            List<User> users = UserService.getUsersByUserName(userName);
            return Response.status(HttpServletResponse.SC_OK).entity(users).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
        public Response saveUser(User user) {
        try {
            UserService.saveUser(user);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEvent(User user, @PathParam("userid") Long userId) {
        try {
            if(user.getUserId() == userId) {
                UserService.updateUser(user);
                return Response.status(HttpServletResponse.SC_OK).build();
            }
            else {
                return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
            }

        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{userid}")
    public Response deleteUser(@PathParam("userid") Long  userId) {
        try {
            UserService.deleteUser(userId);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
}