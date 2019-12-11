/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;
//carrier es transportista en el vo

import ec.edu.espe.transportecarga.model.*;
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
@Path("Carriers")
public class CarrierResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarrierResource
     */
    public CarrierResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.CarrierResource
     * @return an instance of ec.edu.espe.transportecarga.model.transportistaVO
     */
    //CONSULTA TODOS LOS TRANSPORTISTAS
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<transportistaVO> getJsonAnyCarrier() {
       transportistaDAO guia=new transportistaDAO();
       ArrayList<transportistaVO> guiaVO=new ArrayList<transportistaVO>();
        guiaVO=guia.mostrarTransportista();
        return guiaVO;
    }

    
    @GET
    @Path("carrier/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<transportistaVO> getJsonGuide(@PathParam("number") String number) {
        //TODO return proper representation object
        transportistaDAO transportistaDAO = new transportistaDAO();
        ArrayList<transportistaVO> transportistaVO = new ArrayList<transportistaVO>();
        transportistaVO = transportistaDAO.mostrarTransportistaCd(number);
        return transportistaVO;
    }

    
    //identificacion,nombre,direccion,telefono,correo,placa,zona
    @POST
    @Path("/createCarrier")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(transportistaVO data) {
        transportistaDAO response = new transportistaDAO();
        response.adicionarCliente(data);
        System.out.println(data.getIdentificacion());
        System.out.println(data.getNombre());
        System.out.println(data.getDireccion());
        System.out.println(data.getTelefono());
        System.out.println(data.getCorreo());
        System.out.println(data.getPlaca());
        System.out.println(data.getZona());
    }

    @PUT
    @Path("updateCarrier")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(transportistaVO data) {
        transportistaDAO response = new transportistaDAO();
        response.modificarTransportistaIdentificacion(data);
        //System.out.println(data.getIdentificacion());
    }

        
    @DELETE
    @Path("deleteCarrier/{byID}")
    public void remove(@PathParam("id") String id) {
        transportistaDAO response = new transportistaDAO();
        response.eliminarTranportistaIdentificacion(id);
        //System.out.println(id);
    }

    
    
}
