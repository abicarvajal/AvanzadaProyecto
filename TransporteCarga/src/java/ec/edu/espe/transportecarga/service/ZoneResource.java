/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.zonaDAO;
import ec.edu.espe.transportecarga.model.zonaVO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("Zone")
public class ZoneResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ZoneResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public zonaVO getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("zones")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<zonaVO> getJsonZones() {
        //TODO return proper representation object
        zonaDAO zona = new zonaDAO();
        ArrayList<zonaVO> zonaVO = new ArrayList<zonaVO>();
        zonaVO = zona.mostrarZonas();
        return zonaVO;
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(zonaVO data) {
        zonaDAO response = new zonaDAO();
        response.adicionarZona(data);
        System.out.println(data.getCodigo());
        System.out.println(data.getNombre());
        System.out.println(data.getCiudad());
    }

    @DELETE
    @Path("deleteBy/{code}")
    public void remove(@PathParam("code") String code) {
        zonaDAO response = new zonaDAO();
        response.eliminarZonaCodigo(code);
        System.out.println(code);
    }

    @DELETE
    @Path("/delete/{byName}")
    public void deleteJsonZoneByName(@PathParam("byName") String byName) {
        zonaDAO response = new zonaDAO();
        response.eliminarZonaNombre(byName);
        System.out.println(byName);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(zonaVO content) {
    }
}
