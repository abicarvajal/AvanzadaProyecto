/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

import java.sql.CallableStatement;
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
public class clienteDAO {
    Conexion con;

    public clienteDAO() {
        con=new Conexion();
    }
    public void adicionarCliente(clienteVO cliente){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO cliente (identificacion,nombre,telefono,correo,ciudad,zona,calleP,calleS,lote) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, cliente.getIdentificacion());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getCiudad());
            ps.setString(6, cliente.getZona());
            ps.setString(7, cliente.getCalleP());
            ps.setString(8, cliente.getCalleS());
            ps.setString(9, cliente.getLote());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

        public void mostrarClienteComno(JComboBox combo){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        combo.removeAllItems();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select nombre from cliente");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                combo.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public boolean buscarClienteIdentificacion(clienteVO cliente){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM cliente WHERE identificacion =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, cliente.getIdentificacion());
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

    public boolean buscarClienteNombre(clienteVO cliente){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM cliente WHERE nombre =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
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
    
    public ArrayList<clienteVO> mostrarClienteQuito(String city){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM cliente WHERE ciudad='"+city+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<clienteVO> mostrarClienteProductoFragil(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT c.*, COUNT(g.codigoProducto) AS TOTAL FROM producto as p, guia as g, cliente as c WHERE g.codigoProducto=p.codigo AND p.claseProducto=\"Frágil\" AND g.cedulaCliente=c.identificacion GROUP BY g.cedulaCliente ORDER BY TOTAL DESC");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<clienteVO> mostrarClienteValle(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT c.*, COUNT(c.ciudad) AS TOTAL FROM cliente as c WHERE c.ciudad=\"Quito\" AND c.zona=\"valle\"");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
        public ArrayList<clienteVO> mostrarClienteFueraQuito(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT * FROM cliente WHERE ciudad!='Quito';");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<clienteVO> mostrarClienteCarrier(String carrier){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT *, COUNT(cedulaCliente) as TOTAL from guia WHERE cedulaTransportista='"+carrier+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
   
    public ArrayList<clienteVO> mostrarClienteMayorValorComprado(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            String aux="TOTAL";
            PreparedStatement ps= acceso.prepareStatement("SELECT c.*, SUM(valorEnvio) AS TOTAL from guia as g, cliente as c WHERE g.codigoProducto='"+aux+"' AND g.cedulaCliente=c.identificacion GROUP BY g.cedulaCliente ORDER BY TOTAL DESC LIMIT 1");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
   
    public ArrayList<clienteVO> mostrarCliente(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from cliente");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }


    public ArrayList<clienteVO> mostrarClienteId(String dni){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from cliente where identificacion='" +dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<clienteVO> mostrarClienteNombre(String dni){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from cliente where nombre='" +dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    
    public void eliminarClienteIdentificacion(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from cliente where identificacion='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }

    public void eliminarClienteNombre(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from cliente where nombre='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }   
    }
    
    public void modificarClienteIdentificacion(clienteVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE cliente SET nombre='" +cli.getNombre()+"', telefono='"+cli.getTelefono()
                    +"', correo='"+cli.getCorreo()+"', ciudad='"+cli.getCiudad()+"', zona='"+cli.getZona()
                    +"', calleP='"+cli.getCalleP()+"', calleS='"+cli.getCalleS()+"', lote='"+cli.getLote()+"'WHERE identificacion='"+cli.getIdentificacion()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void modificarNombbre(clienteVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE cliente SET identificacion='" +cli.getIdentificacion()+"', telefono='"+cli.getTelefono()
                    +"', correo='"+cli.getCorreo()+"', ciudad='"+cli.getCiudad()+"', zona='"+cli.getZona()
                    +"', calleP='"+cli.getCalleP()+"', calleS='"+cli.getCalleS()+"', lote='"+cli.getLote()+"'WHERE nombre='"+cli.getNombre()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }    
    public ArrayList<clienteVO> mostrarClienteMayorGastoEnCompras(){
        ArrayList <clienteVO> listaB=new ArrayList <clienteVO>();
        clienteVO cliente;
        try{
            Connection acceso = con.obtenerConexion();
            String aux="TOTAL";
            PreparedStatement ps= acceso.prepareStatement("SELECT cedulaCliente , SUM(valorEnvio) AS TOTAL\n" +
"from guia\n" +
"GROUP BY cedulaCliente\n" +
"ORDER BY TOTAL DESC\n" +
"limit 1");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                cliente=new clienteVO();
                cliente.setIdentificacion(rs.getString(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCorreo(rs.getString(4));
                cliente.setCiudad(rs.getString(5));
                cliente.setZona(rs.getString(6));
                cliente.setCalleP(rs.getString(7));
                cliente.setCalleS(rs.getString(8));
                cliente.setLote(rs.getString(9));
                listaB.add(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    
    
}
