/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.productoDAO;
import ec.edu.espe.transportecarga.model.productoVO;
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
@Path("Products")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ProductResource
     * @return an instance of ec.edu.espe.transportecarga.model.productoVO
     */
   
    /*
    public clienteVO getJsonClientCity(@PathParam("city") String city) {
        //TODO return proper representation object
       
    }
    */
    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(productoVO content) {
    }
}
