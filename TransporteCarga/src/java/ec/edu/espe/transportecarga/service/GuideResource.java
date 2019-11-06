/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.Conexion;
import ec.edu.espe.transportecarga.model.guiaDAO;
import ec.edu.espe.transportecarga.model.guiaVO;
import ec.edu.espe.transportecarga.model.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("Guide")
public class GuideResource {

    @Context
    private UriInfo context;
    Conexion con;

    /**
     * Creates a new instance of GuideResource
     */
    public GuideResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.transportecarga.service.GuideResource
     *
     * @return an instance of ec.edu.espe.transportecarga.model.guiaVO
     */
    @GET
    @Path("guides")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<guiaVO> getJsonZones() {
        //TODO return proper representation object
        guiaDAO zona = new guiaDAO();
        ArrayList<guiaVO> guiaVO = new ArrayList<guiaVO>();
        guiaVO = zona.mostrarGuias();
        return guiaVO;
    }

    @GET
    @Path("guide/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<guiaVO> getJsonGuide(@PathParam("number") String number) {
        //TODO return proper representation object
        guiaDAO guiaDAO = new guiaDAO();
        ArrayList<guiaVO> guiaVO = new ArrayList<guiaVO>();
        guiaVO = guiaDAO.mostrarGuia(number);
        return guiaVO;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(guiaVO data) {
        guiaDAO response = new guiaDAO();
        response.adicionarGuia(data);
        System.out.println(data.getNumero());
        System.out.println(data.getFecha());
        System.out.println(data.getCedulaCliente());
        System.out.println(data.getCedulaTransportista());
        System.out.println(data.getCodigoProducto());
        System.out.println(data.getValorEnvio());
        System.out.println(data.getDestino());
        System.out.println(data.getDireccion());
        System.out.println(data.getEstadoReserva());
    }
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(guiaVO data) {
        guiaDAO response = new guiaDAO();        
        response.modificarGuiaPorNumero(data.getNumero());
        //System.out.println(data.getNumero());
    }
    
    @DELETE
    @Path("deleteBy/{number}")
    public void remove(@PathParam("number") String number) {
        guiaDAO response = new guiaDAO();
        response.eliminarGuiaCodigo(number);
        System.out.println(number);
    }

    /**
     * PUT method for updating or creating an instance of GuideResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(guiaVO content) {
    }
}
