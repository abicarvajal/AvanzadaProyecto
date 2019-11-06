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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author nycha
 */
public class zonaDAO {
    Conexion con;

    public zonaDAO() {
        con=new Conexion();
    }
    
    public void adicionarZona(zonaVO zona){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO zona (codigo,nombre,ciudad) VALUES(?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, zona.getCodigo());
            ps.setString(2, zona.getNombre());
            ps.setString(3, zona.getCiudad());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    
    

    public boolean buscarZonaCodigo(zonaVO zona){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM zona WHERE codigo =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, zona.getCodigo());
            ps.executeQuery();

            if(ps.executeQuery().next()){
                band=true;
            }else{
                band=false;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return band;
    }

    
        public void mostrarZinaComnoNombre(JComboBox combo){
        ArrayList <zonaVO> listaB=new ArrayList <zonaVO>();
        zonaVO zona;
        combo.removeAllItems();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select nombre from zona");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                combo.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }


        
            
        public void mostrarZinaComnoCiudad(JComboBox combo){
        ArrayList <zonaVO> listaB=new ArrayList <zonaVO>();
        zonaVO zona;
        combo.removeAllItems();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select ciudad from zona");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                combo.addItem(rs.getString("ciudad"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

        
    public boolean buscarZonaNombre(zonaVO zona){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM zona WHERE nombre =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, zona.getNombre());
            ps.executeQuery();

            if(ps.executeQuery().next()){
                band=true;
            }else{
                band=false;
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return band;
    }
    
    public ArrayList<zonaVO> mostrarZona(){
        ArrayList <zonaVO> listaB=new ArrayList <zonaVO>();
        zonaVO zona;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from zona");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                zona=new zonaVO();
                zona.setCodigo(rs.getString(1));
                zona.setNombre(rs.getString(2));
                zona.setCiudad(rs.getString(3));
                listaB.add(zona);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<zonaVO> mostrarZonas() {
        ArrayList<zonaVO> listaB = new ArrayList<zonaVO>();
        zonaVO zona;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from zona");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                zona = new zonaVO();
                zona.setCodigo(rs.getString(1));
                zona.setNombre(rs.getString(2));
                zona.setCiudad(rs.getString(3));
                listaB.add(zona);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }
    
    public void eliminarZonaCodigo(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from zona where codigo='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public void eliminarZonaNombre(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from zona where nombre='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }   
    }
    
    public void modificarZonaIdentificacion(zonaVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE zona SET nombre='" +cli.getNombre()+"', ciudad='"+cli.getCiudad()+"' WHERE codigo='"+cli.getCodigo()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
}
