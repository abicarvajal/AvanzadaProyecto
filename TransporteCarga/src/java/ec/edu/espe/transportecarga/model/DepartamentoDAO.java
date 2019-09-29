/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class DepartamentoDAO {
    Conexion1 con;

    public DepartamentoDAO() {
        con=new Conexion1();
    }
    public void adicionarProducto(DepartamentoVO departamento){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO departamento (iddepartamento,departamento) VALUES(?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setInt(1, departamento.getIdDepartamento());
            ps.setString(2, departamento.getDepartamento());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void listar_departamento(JComboBox box){
        
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM departamento");
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(new DepartamentoVO(rs.getInt(1),rs.getString(2)));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                st.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){
            }
        }
        
    }
    
    
            public void adicionarDep(DepartamentoVO departamento){
                    Conectar conec = new Conectar();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            ps = con.prepareStatement("INSERT INTO departamento (iddepartamento,departamento) VALUES(?,?)");
            ps.setInt(1, departamento.getIdDepartamento());
            ps.setString(2, departamento.getDepartamento());
            ps.executeQuery();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        }
    
}
