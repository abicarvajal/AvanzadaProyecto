/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.*;
import ec.edu.espe.transportecarga.model.clienteVO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Melissa
 */
@Path("Clients")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
        
        
        
    }
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonZones() {
        //TODO return proper representation object
        clienteDAO zona = new clienteDAO();
        ArrayList<clienteVO> guiaVO = new ArrayList<clienteVO>();
        guiaVO = zona.mostrarCliente();
        return guiaVO;
    }
    
    @GET
    @Path("client/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonGuide(@PathParam("number") String number) {
        //TODO return proper representation object
        clienteDAO clienteDAO = new clienteDAO();
        ArrayList<clienteVO> clienteVO = new ArrayList<clienteVO>();
        clienteVO = clienteDAO.mostrarClienteId(number);
        return clienteVO;
    }

    @POST
    @Path("/createClient")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(clienteVO data) {
        clienteDAO response = new clienteDAO();
        response.adicionarCliente(data);
        System.out.println(data.getIdentificacion());
        System.out.println(data.getNombre());
        System.out.println(data.getTelefono());
        System.out.println(data.getCorreo());
        System.out.println(data.getCiudad());
        System.out.println(data.getZona());
        System.out.println(data.getCalleP());
        System.out.println(data.getCalleS());
        System.out.println(data.getLote());
    }
    @PUT
    @Path("updateClient")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(clienteVO data) {
        clienteDAO response = new clienteDAO();        
        response.modificarClienteIdentificacion(data);
        //System.out.println(data.getNumero());
    }
    
    @DELETE
    @Path("deleteClient/{byNumber}")
    public void remove(@PathParam("number") String number) {
        clienteDAO response = new clienteDAO();
        response.eliminarClienteIdentificacion(number);
        System.out.println(number);
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ClientResource
     * @return an instance of ec.edu.espe.transportecarga.model.clienteVO
     */
   
    
    /**
     * PUT method for updating or creating an instance of ClientResource
     * @param content representation for the resource
     */
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(clienteVO content) {
    }
}
