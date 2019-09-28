/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diego
 */
public class Conexion {
    String bd="proyecto";
    String login="root";
    String passw="12345678";
    String url="jdbc:mysql://localhost/" + bd;
    
    Connection objConex=null;
    
    public Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            objConex = DriverManager.getConnection(url,login,passw);
            if(objConex!=null)
                System.out.println("Conexion a BD ok");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException o){
            System.out.println(o);
        }
    }
 

    public Connection obtenerConexion()
    {
        return objConex;
    }
}

