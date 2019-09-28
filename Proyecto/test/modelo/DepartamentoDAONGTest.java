/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
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
public class DepartamentoDAONGTest {

    @Test
    public void testDAODepartamento() throws SQLException {
        int indice = 0;
        Conexion conexion = new Conexion();
        conexion.objConex.setAutoCommit(false);
        DepartamentoDAO dptDao = new DepartamentoDAO();
        DepartamentoVO  dptvo = new DepartamentoVO();
        JComboBox jbox = new JComboBox();
        
        ///seteo datos ingreso
        dptvo.setDepartamento("morador");
        dptvo.setIdDepartamento(1);
            
        try{
            //prueba de registro departamento 
            dptDao.adicionarDep(dptvo);
            //prueba listado desde base
        
            
        }finally{
            conexion.objConex.rollback();
            conexion.objConex.close();
        }
                

    }

}
