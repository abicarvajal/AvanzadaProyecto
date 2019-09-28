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
public class transportistaDAONGTest {

    @org.junit.Test
    public void testDAOTransportista() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        transportistaDAO trDAO = new transportistaDAO();
        transportistaVO trVO = new transportistaVO();
        transportistaVO trVO1 = new transportistaVO();
        /////seteo datos
        trVO.setCorreo("f@gmail.com");
        trVO.setDireccion("Altamares");
        trVO.setIdentificacion("2300504947");
        trVO.setNombre("Francisco");
        trVO.setPlaca("LTAD-258");
        trVO.setTelefono("052662413");
        trVO.setZona("norte");
        /////seteo datos MOdificar
        trVO1.setCorreo("f@hotmail.com");
        trVO1.setDireccion("colina ");
        trVO1.setIdentificacion("2300504947");
        trVO1.setNombre("Francisco");
        trVO1.setPlaca("LTAD-258");
        trVO1.setTelefono("05266252");
        trVO.setZona("centro");

        try {
            ////pruebas de ingreso de datos transportista
            trDAO.adicionarCliente(trVO);
            ///prueba de busqueda de transportisa por identificacion
            trDAO.buscarClienteIdentificacion(trVO);
            assertEquals(true, trDAO.buscarClienteIdentificacion(trVO));
            ////prueba de transportista por Nombre  
            assertEquals(true, trDAO.buscarClienteNombre(trVO));
            //prueba de modificacion
            trDAO.modificarNombbre(trVO);
            ///////prueba de transportista por placa
            assertEquals(true, trDAO.buscarTransportistaPlaca(trVO1));
            //prueba de obtencion datos desde base datos
            indice = trDAO.mostrarTransportista().size() - 1;
            assertEquals(trVO.getNombre(), trDAO.mostrarTransportista().get(indice).getNombre());
            //prueba de eliminacion 
            trDAO.eliminarTranportistaIdentificacion(trVO1.getIdentificacion());
        } finally {
            conexion.objConex.rollback();
            conexion.objConex.close();
        }

    }

}
