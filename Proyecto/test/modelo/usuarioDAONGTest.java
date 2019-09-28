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
public class usuarioDAONGTest {

    @org.junit.Test
    public void testDAOUsuario() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        usuarioDAO usudao = new usuarioDAO();
        usuarioVO usuvo = new usuarioVO();
        usuarioVO usuvo1 = new usuarioVO();
        /////datos de ingreso 
        usuvo.setPassword("12345");
        usuvo.setTipo(1);
        usuvo.setUsuario("Francisco");
        /////cambio datos 
        usuvo1.setPassword("fgsgsd");
        usuvo1.setTipo(2);
        usuvo1.setUsuario("Francisco");
        try {
            //prueba de  registro usuario a la base de datos
            usudao.adicionarUsuario(usuvo);
            //prueba de  busqueda usuario del tipo 1//Administrador ->desde  base de datos
            assertEquals(true, usudao.buscarUsuarioAdmin(usuvo));
            //prueba de  modificacion usuario a la base de datos
            usudao.modificarUsuario(usuvo1);
            //prueba de  busqueda usuario del tipo 2//Administrador ->desde  base de datos
            assertEquals(true, usudao.buscarUsuarioLoguistica(usuvo1));
            //pruba de listado desde la base de datos
            indice = usudao.mostrarUsuario().size() - 1;
            assertEquals(usuvo.getUsuario(), usudao.mostrarUsuario().get(indice).getUsuario());
            //prueba de eliminacion
            usudao.eliminarUsuario(usuvo.getUsuario());
        } finally {
            conexion.objConex.rollback();
            conexion.objConex.close();
        }
    }

}
