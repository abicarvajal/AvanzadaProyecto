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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("Transportist")
public class TransportistResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public TransportistResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ClientResource
     * @return an instance of ec.edu.espe.transportecarga.model.clienteVO
     */

    //transportistas que corresponden a un cliente X
        @GET
    @Path("/carriers/{carrier}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<transportistaVO> getJsonClientCarrier(@PathParam("carrier")String carrier) {
        //TODO return proper representation object
        transportistaDAO client=new transportistaDAO();
        ArrayList<transportistaVO> transportistaVO=new ArrayList<transportistaVO>();
        transportistaVO=client.mostrarTransportistaCarrier(carrier);
        return transportistaVO;
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(transportistaVO content) {
    }
}
