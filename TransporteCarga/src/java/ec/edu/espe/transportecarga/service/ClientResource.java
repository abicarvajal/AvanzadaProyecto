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
 * @author Melissa
 */
@Path("Client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.transportecarga.service.ClientResource
     * @return an instance of ec.edu.espe.transportecarga.model.clienteVO
     */
    //CLIENTES QUE SEAN DE QUITO
    @GET
    @Path("{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientCity(@PathParam("city") String city) {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteQuito(city);
        return clientVO;
    }
        //CLIENTES QUE SEAN FUERA DE QUITO
    @GET
    @Path("/city/fuera")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonOutQuitoClientCity() {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteFueraQuito();
        return clientVO;
    }
    //Clientes que corresponden a un transportista X
    @GET
    @Path("/carriers/{carrier}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientCarrier(@PathParam("carrier")String carrier) {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteCarrier(carrier);
        return clientVO;
    }

    //clientes que han comprado mas en cantidad
    @GET
    @Path("/cliente/CompraMas/Cantidad")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientMasCompra() {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteMayorValorComprado();
        return clientVO;
    }
        //Clientes que corresponden a un transportista X
    @GET
    @Path("/cliente/gasto/mayorGasto")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientMayorGasto() {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteMayorGastoEnCompras();
        return clientVO;
    }
    //clientes que han comprado productos fragiles
    @GET
    @Path("/cliente/CompraProdFragil")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientCompraProdFragil() {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteProductoFragil();
        return clientVO;
    }

    //clientes que sean del valle
    @GET
    @Path("/clienteValle")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<clienteVO> getJsonClientValle() {
        //TODO return proper representation object
        clienteDAO client=new clienteDAO();
        ArrayList<clienteVO> clientVO=new ArrayList<clienteVO>();
        clientVO=client.mostrarClienteValle();
        return clientVO;
    }


    /*
    
     @GET
    @Path("{id}/{name}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Student getJsonStudentById(@PathParam("id") int id, @PathParam("name") String name) {
        //TODO return proper representation object
        Student student=new Student(id,name,"Apellido",8.0f,22);
        return student;
    }
    */
    /**
     * PUT method for updating or creating an instance of ClientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(clienteVO content) {
    }
}
