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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author nycha
 */
public class productoDAO {
    Conexion con;

    public productoDAO() {
        con=new Conexion();
    }
    public void adicionarProducto(productoVO producto){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO producto (codigo,descripcion,valorEnvio,claseProducto) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescrpcion());
            ps.setFloat(3, producto.getValorEnvio());
            ps.setString(4, producto.getClaseProducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public boolean buscarProductoIdentificacion(productoVO producto){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM producto WHERE codigo =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
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


    public boolean buscarProductoNombre(productoVO producto){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM producto WHERE descripcion =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, producto.getDescrpcion());
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
    
    
    public ArrayList<productoVO> mostrarProducto(){
        ArrayList <productoVO> listaB=new ArrayList <productoVO>();
        productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from producto");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<productoVO> mostrarProductoCodgio(String dni){
        ArrayList <productoVO> listaB=new ArrayList <productoVO>();
        productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from producto where codigo='"+dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    
    
    public productoVO mostrarProductoNombre(String dni){
        productoVO producto = null;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from producto where descripcion='"+dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
//                producto
               // listaB.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return producto;
    }
    
    
        public ArrayList<productoVO> mostrarProductosVendido(){
       ArrayList<productoVO> product=new ArrayList<productoVO>();
       productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT p.*, COUNT(g.codigoProducto) FROM guia as g, producto as p WHERE g.codigoProducto=p.codigo GROUP BY g.codigoProducto");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                product.add(producto);
                System.out.println(producto.toString());
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return product;
    }
        
    public ArrayList<productoVO> mostrarProductoMayorCompra(){
       ArrayList<productoVO> product=new ArrayList<productoVO>();
       productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT *, codigoProducto , SUM(valorEnvio) as MasVendido\n" +
"FROM guia\n" +
"WHERE codigoProducto != 'TOTAL'\n" +
"GROUP BY codigoProducto\n" +
"ORDER BY MasVendido DESC\n" +
"limit 1");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                product.add(producto);
                System.out.println(producto.toString());
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return product;
    }
    public ArrayList<productoVO> mostrarProductoMasCaro(){
       ArrayList<productoVO> product=new ArrayList<productoVO>();
       productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT *, descripcion, MAX(valorEnvio)\n" +
"FROM producto;");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                product.add(producto);
                System.out.println(producto.toString());
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return product;
    }
    public void mostrarProductoComno(JComboBox combo){
        ArrayList <productoVO> listaB=new ArrayList <productoVO>();
        productoVO producto;
        combo.removeAllItems();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select descripcion from producto");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                combo.addItem(rs.getString("descripcion"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    

    
    public void eliminarProductoIdentificacion(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from producto where codigo='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public void modificarProductoIdentificacion(productoVO pro){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE producto SET descripcion='" +pro.getDescrpcion()+"', valorEnvio='"+pro.getValorEnvio()
                    +"', claseProducto='"+pro.getClaseProducto()+"'WHERE codigo='"+pro.getCodigo()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<productoVO> mostrarProductosMenoresA1(int cod){
       ArrayList<productoVO> product=new ArrayList<productoVO>();
       productoVO producto;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM producto WHERE producto.valorEnvio<'"+cod+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                producto=new productoVO();
                producto.setCodigo(rs.getString(1));
                producto.setDescrpcion(rs.getString(2));
                producto.setValorEnvio(rs.getFloat(3));
                producto.setClaseProducto(rs.getString(4));
                product.add(producto);
                System.out.println(producto.toString());
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return product;
    }
}
