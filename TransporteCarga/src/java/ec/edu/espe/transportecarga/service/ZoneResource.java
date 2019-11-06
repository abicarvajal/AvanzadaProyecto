/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.zonaVO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Melissa
 */
@Path("Zone")
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ZoneResource
     */
    public ZoneResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ZoneResource
     * @return an instance of ec.edu.espe.transportecarga.model.zonaVO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public zonaVO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ZoneResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(zonaVO content) {
    }
}
