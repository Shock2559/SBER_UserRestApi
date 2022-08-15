package com.inside.controller;

import com.inside.dao.UserRepository;
import com.inside.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api")
public class UserController {

    private UserRepository userRepository;

    public UserController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.userRepository = context.getBean("userRepository", UserRepository.class);
    }

    @GET
    @Path("all-users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GET
    @Path("user-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@QueryParam("id") int id) {
        return userRepository.getUserById(id);
    }

    @POST
    @Path("save-user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean saveUser(User newUser) {
        return userRepository.saveUser(newUser);
    }

    @POST
    @Path("update-user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @DELETE
    @Path("delete-user")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean deleteUser(@QueryParam("id") int id) {
        return userRepository.deleteUser(id);
    }


}
