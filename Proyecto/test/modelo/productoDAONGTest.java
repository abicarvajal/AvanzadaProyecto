/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
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
public class productoDAONGTest {

    @org.junit.Test
    public void testDAOUsuario() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        productoDAO proDAO = new productoDAO();
        productoVO proVO = new productoVO();
        productoVO proVO1 = new productoVO();

        //seteo datos 
        proVO.setClaseProducto("Fragil");
        proVO.setCodigo("PR095");
        proVO.setDescrpcion("Laptop");
        proVO.setValorEnvio(10);
        //seteo datos a modificar 
        proVO1.setClaseProducto("Fragil");
        proVO1.setCodigo("PR095");
        proVO1.setDescrpcion("Laptop");
        proVO1.setValorEnvio(20);
        try {
            //prueba de registro producto 
            proDAO.adicionarProducto(proVO);
            //prueba de busqueda de producto por codigo
            assertEquals(true, proDAO.buscarProductoIdentificacion(proVO));
            //prueba de modificacion
            proDAO.modificarProductoIdentificacion(proVO1);
            //prueba de busqueda de prodcuto por nombre
            assertEquals(true, proDAO.buscarProductoNombre(proVO1));
            //prueba de listado desde la base de datos
            indice = proDAO.mostrarProducto().size() - 1;
            assertEquals(proVO.getCodigo(), proDAO.mostrarProducto().get(indice).getCodigo());
            //prueba de eliminacion 
            proDAO.eliminarProductoIdentificacion(proVO1.getCodigo());
        } finally {
            conexion.objConex.rollback();
            conexion.objConex.close();

        }

    }

}
