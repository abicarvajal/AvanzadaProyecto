/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import static org.junit.Assert.assertEquals;
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
public class clienteDAONGTest {
    
    @org.junit.Test
    public void testDAOCliente() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        clienteDAO clientedao = new clienteDAO();
        clienteVO clientevo = new clienteVO();
        clienteVO clientevo1 = new clienteVO();
        clientevo.setNombre("Maria");
        clientevo.setTelefono("0982524744");
        clientevo.setCalleP("maldonado e35");
        clientevo.setCalleS("salustio 15");
        clientevo.setCiudad("Quito");
        clientevo.setCorreo("fg@hotmail.com");
        clientevo.setIdentificacion("2300504947");
        clientevo.setLote("e6");
        clientevo.setZona("norte");
        
        ///
        
         clientevo1.setNombre("Maria");
        clientevo1.setTelefono("0982524744");
        clientevo1.setCalleP("maldonado e35");
        clientevo1.setCalleS("salustio 15");
        clientevo1.setCiudad("Quito");
        clientevo1.setCorreo("fg@hotmail.com");
        clientevo1.setIdentificacion("2300504947");
        clientevo1.setLote("e78");
        clientevo1.setZona("sur");
        try {
            clientedao.adicionarCliente(clientevo);
            clientedao.modificarClienteIdentificacion(clientevo1);
            indice = clientedao.mostrarCliente().size()-1;
            assertEquals(clientevo.getNombre(), clientedao.mostrarCliente().get(indice).getNombre());
            clientedao.eliminarClienteIdentificacion(clientevo.getIdentificacion());
            
        } finally  {
            conexion.objConex.rollback();
            conexion.objConex.close();
                    
        }
    }

}
