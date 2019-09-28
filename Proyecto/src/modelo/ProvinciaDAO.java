/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ProvinciaDAO {
     Conexion1 con;

    public ProvinciaDAO() {
        con=new Conexion1();
    }
    public void adicionarProducto(ProvinciaVO provincia){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO provincia (idprovincia,provincia,idDepartamento) VALUES(?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setInt(1, provincia.getIdProvincia());
            ps.setString(2, provincia.getProvincia());
            ps.setInt(3, provincia.getIdDepartamento());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
        public void eliminarZonaNombre(int dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from provincia where idprovincia=" +dni);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }   
    }
    
    public void modificarTransportistaIdentificacion(ProvinciaVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE provincia SET provincia='" +cli.getProvincia()+"', idDepartamento='"+cli.getIdDepartamento()
                    +"'WHERE idprovincia='"+cli.getIdProvincia()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public void modificarNombre(ProvinciaVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE provincia SET idprovincia='" +cli.getIdProvincia()+"', idDepartamento='"+cli.getIdDepartamento()
                    +"'WHERE provincia='"+cli.getProvincia()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
        
    
    public void listar_provincia(JComboBox box, int id){
        
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            ps = con.prepareStatement("SELECT * FROM provincia where idDepartamento = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(new ProvinciaVO(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                con.close();
            }catch(Exception ex){
            }
        }
        
    }


    
    public int contar_provincia(){
        int cont=0;
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            ps = con.prepareStatement("SELECT * FROM provincia");
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            while(rs.next()){
                cont++;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                con.close();
            }catch(Exception ex){
            }
        }
        return cont;
        
    }
    
            public void adicionarProvicnia(ProvinciaVO provincia){
                    Conectar conec = new Conectar();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            ps = con.prepareStatement("INSERT INTO provincia (idprovincia,provincia,idDepartamento) VALUES(?,?,?)");
            ps.setInt(1, provincia.getIdProvincia());
            ps.setString(2, provincia.getProvincia());
            ps.setInt(3, provincia.getIdDepartamento());
            ps.executeQuery();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        
        }
            }
}
