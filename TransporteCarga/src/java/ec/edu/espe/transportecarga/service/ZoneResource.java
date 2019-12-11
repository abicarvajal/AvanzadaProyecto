/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import ec.edu.espe.transportecarga.model.*;
import ec.edu.espe.transportecarga.model.zonaVO;
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
     * Retrieves representation of an instance of
     * ec.edu.espe.transportecarga.service.ZoneResource
     *
     * @return an instance of ec.edu.espe.transportecarga.model.zonaVO
     */
    //CONSULTA TODAS LAS ZONAS 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<zonaVO> getJsonAnyZone() {
        zonaDAO guia = new zonaDAO();
        ArrayList<zonaVO> guiaVO = new ArrayList<zonaVO>();
        guiaVO = guia.mostrarZona();
        return guiaVO;
    }

    @PUT
    @Path("updateZone")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(zonaVO data) {
        zonaDAO response = new zonaDAO();        
        response.modificarZonaIdentificacion(data);
    }

    @POST
    @Path("/createZone")
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(zonaVO data) {
        zonaDAO response = new zonaDAO();
        response.adicionarZona(data);
        System.out.println(data.getCodigo());
        System.out.println(data.getNombre());
        System.out.println(data.getCiudad());
    }

    @DELETE
    @Path("deleteZone/{byCode}")
    public void remove(@PathParam("code") String code) {
        zonaDAO response = new zonaDAO();
        response.eliminarZonaCodigo(code);
        System.out.println(code);
    }

    @DELETE
    @Path("/deleteZOne/{byName}")
    public void deleteJsonZoneByName(@PathParam("byName") String byName) {
        zonaDAO response = new zonaDAO();
        response.eliminarZonaNombre(byName);
        System.out.println(byName);
    }

}
