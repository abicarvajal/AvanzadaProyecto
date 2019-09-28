/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Franciscos
 */
public class guiaDAONGTest {

    @org.junit.Test
    public void testDAOUsuario() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        guiaDAO gDAO = new guiaDAO();
        guiaVO gVO = new guiaVO();
        guiaVO gVO1 = new guiaVO();
        //seteo datos 
        gVO.setCedulaCliente("1718911488");
        gVO.setCedulaTransportista("0650026230");
        gVO.setCodigoProducto("PR761");
        gVO.setDestino("Guayaquil");
        gVO.setDireccion("Quito");
        gVO.setEstadoReserva("PENDIENTE");
        gVO.setFecha("12/7/2019");
        gVO.setNumero(20);
        gVO.setValorEnvio("15");
         //seteo datos a Modificar
        gVO1.setCedulaCliente("1718911488");
        gVO1.setCedulaTransportista("1714786629");
        gVO1.setCodigoProducto("PR761");
        gVO1.setDestino("Guayaquil");
        gVO1.setDireccion("Quito");
        gVO1.setEstadoReserva("ANULADO");
        gVO1.setFecha("12/7/2019");
        gVO1.setNumero(20);
        gVO1.setValorEnvio("15");
        
        try{
            //prueba agregar dato
            gDAO.adicionarGuia(gVO);
            //prueba modificacion guia 
            gDAO.modificarGuia(String.valueOf(gVO1.getNumero()));
            //prueba de listar guias
            indice = gDAO.mostrarGuiaUno().size()-1;
            assertEquals(gVO1.getEstadoReserva(),gDAO.mostrarGuiaUno().get(indice).getEstadoReserva());
            ///prueba  de eliminacion 
            gDAO.eliminarGuia(gVO.getCodigoProducto(), gVO.getNumero());
            
        }finally{
            conexion.objConex.rollback();
            conexion.objConex.close();
        }
        
        
        

    }

}
