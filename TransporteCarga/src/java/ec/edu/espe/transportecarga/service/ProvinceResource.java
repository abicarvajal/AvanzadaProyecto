/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.ProvinciaVO;
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
@Path("Province")
public class ProvinceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProvinceResource
     */
    public ProvinceResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ProvinceResource
     * @return an instance of ec.edu.espe.transportecarga.model.ProvinciaVO
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProvinciaVO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ProvinceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(ProvinciaVO content) {
    }
}
