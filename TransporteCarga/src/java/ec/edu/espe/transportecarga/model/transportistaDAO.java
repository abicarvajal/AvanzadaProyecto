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
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.util.List;
import java.lang.reflect.Type ;


/**
 *
 * @author nycha
 */
public class transportistaDAO {
    Conexion con;

    public transportistaDAO() {
        con=new Conexion();
    }
    public void adicionarCliente(transportistaVO transportista){
        Connection acceso = con.obtenerConexion();
        String sql="INSERT INTO transportista (identificacion,nombre,direccion,telefono,correo,placa,zona) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, transportista.getIdentificacion());
            ps.setString(2, transportista.getNombre());
            ps.setString(3, transportista.getDireccion());
            ps.setString(4, transportista.getTelefono());
            ps.setString(5, transportista.getCorreo());
            ps.setString(6, transportista.getPlaca());
            ps.setString(7, transportista.getZona());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public void setServices(transportistaVO transportista) throws IOException {
        
        try {
            String url = "http://localhost:8080/Clientes/Homework/Carrier/createCarrier";
            
            Gson gson = new Gson();
            String JSON = gson.toJson(transportista);
            
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(JSON);
            wr.flush();
            wr.close();
        
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            
            System.out.println("Response Body : ");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
      } catch (MalformedURLException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    public ArrayList<transportistaVO> getServices() throws IOException {
        ArrayList<transportistaVO> services = null;
        try {
            String url = "http://localhost:8080/TransporteCarga/Acme/Carriers";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            Type tipoListaServicios = new TypeToken<List<transportistaVO>>() {}.getType();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            services = new Gson().fromJson(response.toString(), tipoListaServicios);
      } catch (MalformedURLException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(transportistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return services;
    }
    
    public boolean buscarClienteIdentificacion(transportistaVO transportista){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM transportista WHERE identificacion =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, transportista.getIdentificacion());
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

    public boolean buscarTransportistaPlaca(transportistaVO transportista){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM transportista WHERE placa =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, transportista.getPlaca());
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

    public boolean buscarClienteNombre(transportistaVO transportista){
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql="SELECT * FROM transportista WHERE nombre =? ";
        try{
            PreparedStatement ps= acceso.prepareStatement(sql);
            ps.setString(1, transportista.getNombre());
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
    
    public ArrayList<transportistaVO> mostrarTransportista(){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from transportista");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                transportista=new transportistaVO();
                transportista.setIdentificacion(rs.getString(1));
                transportista.setNombre(rs.getString(2));
                transportista.setDireccion(rs.getString(3));
                transportista.setTelefono(rs.getString(4));
                transportista.setCorreo(rs.getString(5));
                transportista.setPlaca(rs.getString(6));
                transportista.setZona(rs.getString(7));
                listaB.add(transportista);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }


    public ArrayList<transportistaVO> mostrarTransportistaCd(String dni){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from transportista where identificacion='" +dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                transportista=new transportistaVO();
                transportista.setIdentificacion(rs.getString(1));
                transportista.setNombre(rs.getString(2));
                transportista.setDireccion(rs.getString(3));
                transportista.setTelefono(rs.getString(4));
                transportista.setCorreo(rs.getString(5));
                transportista.setPlaca(rs.getString(6));
                transportista.setZona(rs.getString(7));
                listaB.add(transportista);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<transportistaVO> mostrarTransportistaNmbre(String dni){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from transportista where nombre='" +dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                transportista=new transportistaVO();
                transportista.setIdentificacion(rs.getString(1));
                listaB.add(transportista);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    

    public ArrayList<transportistaVO> mostrarTransportistaZona(String dni){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select * from transportista where zona='" +dni+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                transportista=new transportistaVO();
                transportista.setIdentificacion(rs.getString(1));
                transportista.setNombre(rs.getString(2));
                transportista.setDireccion(rs.getString(3));
                transportista.setTelefono(rs.getString(4));
                transportista.setCorreo(rs.getString(5));
                transportista.setPlaca(rs.getString(6));
                transportista.setZona(rs.getString(7));
                listaB.add(transportista);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }

    
    public void eliminarTranportistaIdentificacion(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from transportista where identificacion='" +dni+"'");
            ps.executeUpdate();
        } catch (SQLException e) {
         //   System.out.println(e);
        }
        
    }

    
    public void mostrarClienteComno(JComboBox combo){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        combo.removeAllItems();
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("select nombre from transportista");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                combo.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void eliminarTransportistaNombre(String dni){
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps= accesoDB.prepareStatement("DELETE from transportista where nombre=" +dni);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }   
    }
    
    public void modificarTransportistaIdentificacion(transportistaVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE transportista SET nombre='" +cli.getNombre()+"', direccion='"+cli.getDireccion()
                    +"', telefono='"+cli.getTelefono()+"', correo='"+cli.getCorreo()+"', placa='"+cli.getPlaca()+"', zona='"+cli.getZona()+"'WHERE identificacion='"+cli.getIdentificacion()+"'" );
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            //System.out.println(ex);
        }
    }
    
    public void modificarNombbre(transportistaVO cli){
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("UPDATE transportista SET identificacion='" +cli.getIdentificacion()+"', direccion='"+cli.getDireccion()
                    +"', telefono='"+cli.getTelefono()+"', correo='"+cli.getCorreo()+"', placa='"+cli.getPlaca()+"', zona='"+cli.getZona()+"'WHERE nombre='"+cli.getNombre()+"'" );
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }    
    
    public ArrayList<transportistaVO> mostrarTransportistaCarrier(String carrier){
        ArrayList <transportistaVO> listaB=new ArrayList <transportistaVO>();
        transportistaVO transportista;
        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT *, COUNT(cedulaTransportista) as TOTAL from guia WHERE cedulaCliente='"+carrier+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                transportista=new transportistaVO();
                transportista.setIdentificacion(rs.getString(1));
                transportista.setNombre(rs.getString(2));
                transportista.setDireccion(rs.getString(3));
                transportista.setTelefono(rs.getString(4));
                transportista.setCorreo(rs.getString(5));
                transportista.setZona(rs.getString(6));
                transportista.setPlaca(rs.getString(7));
                
                listaB.add(transportista);
                System.out.println(transportista.toString());
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return listaB;
    }
    
    
        public void consultarCombo(JComboBox cbox_paises){
                    transportistaVO transportista;

        try{
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps= acceso.prepareStatement("SELECT nombre FROM transportista ORDER BY nombre ASC");
            ResultSet rs=ps.executeQuery();
//            cbox_paises.addItem("Seleccione una opción");
    //        cbox_paises.
            while(rs.next()){

            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        

    

}

}
