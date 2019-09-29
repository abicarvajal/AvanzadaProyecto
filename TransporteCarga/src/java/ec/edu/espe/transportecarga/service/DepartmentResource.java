/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.DepartamentoVO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Melissa
 */
@Path("Department")
public class DepartmentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DepartmentResource
     */
    public DepartmentResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.DepartmentResource
     * @return an instance of ec.edu.espe.transportecarga.model.DepartamentoVO
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public DepartamentoVO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DepartmentResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(DepartamentoVO content) {
    }
}
