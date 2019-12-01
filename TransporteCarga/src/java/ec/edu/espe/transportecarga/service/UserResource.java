/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.guiaDAO;
import ec.edu.espe.transportecarga.model.guiaVO;
import ec.edu.espe.transportecarga.model.usuarioDAO;
import ec.edu.espe.transportecarga.model.usuarioVO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Melissa
 */
@Path("Users")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.UserResource
     * @return an instance of ec.edu.espe.transportecarga.model.usuarioVO
     */
    @GET
    @Path("/users/data/{login}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<usuarioVO> getJsonUser(@PathParam("login") String login, @PathParam("login") String passw) {
       usuarioDAO guia=new usuarioDAO();
       ArrayList<usuarioVO> usuarioVO=new ArrayList<usuarioVO>();
        usuarioVO=guia.mostrarTipoUsuario(login,passw);
        return usuarioVO;
    }
    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(usuarioVO content) {
    }
}
