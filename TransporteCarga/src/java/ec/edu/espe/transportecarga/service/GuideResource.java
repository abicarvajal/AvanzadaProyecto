/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.Conexion;
import ec.edu.espe.transportecarga.model.guiaDAO;
import ec.edu.espe.transportecarga.model.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
 * @author Melissa
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
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.GuideResource
     * @return an instance of ec.edu.espe.transportecarga.model.guiaVO
     */
    //CLIENTE QUE MAS HA HECHO PEDIDOS 
    @GET
    @Path("/orders/max")
    @Produces(MediaType.APPLICATION_JSON)
    public guiaVO getJsonMaxOrders() {
       //TODO return proper representation object
        guiaDAO guia=new guiaDAO();
        ArrayList<guiaVO> guiaVO=new ArrayList<guiaVO>();
        guiaVO=guia.mostrarClientePedidos();
        return guiaVO.get(0);
    }
    
    //Clientes que corresponden a un transportista X
    @GET
    @Path("/order/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<guiaVO> getJsonGuideMonth(@PathParam("month")int month) {
        guiaDAO guia=new guiaDAO();
        ArrayList<guiaVO> guiaVO=new ArrayList<guiaVO>();
        guiaVO=guia.mostrarClientePedidoMes(month);
        return guiaVO;
    }
    /**
     * PUT method for updating or creating an instance of GuideResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(guiaVO content) {
    }
}
