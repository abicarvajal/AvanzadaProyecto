/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
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
public class ProvinciaDAONGTest {

    @org.junit.Test
    public void testDAOUsuario() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        ProvinciaDAO pdao = new ProvinciaDAO();
        ProvinciaVO pvo = new ProvinciaVO();
        ProvinciaVO pvo1 = new ProvinciaVO();
        //seteo datos
        pvo.setIdDepartamento(2);
        pvo.setIdProvincia(1);
        pvo.setProvincia("Manabi");
        //prueba de modificacion de datos
        pvo1.setIdDepartamento(2);
        pvo1.setIdProvincia(1);
        pvo1.setProvincia("Manabi");

        try {
            //prueba de registro
            pdao.adicionarProvicnia(pvo);
            //prueba de registro
            pdao.modificarNombre(pvo1);
            //prueba de elimnacion 
            pdao.eliminarZonaNombre(pvo1.getIdProvincia());
        } finally {
            conexion.objConex.rollback();
            conexion.objConex.close();
        }

    }

}
