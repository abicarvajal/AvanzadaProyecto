
package ec.edu.espe.transportecarga.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    static String us = "root";
    static String pass = "Proyecto2019";
    static String bd = "proyecto";
    static String url = "jdbc:mysql://proyecto.cxtbcy7v0lmi.us-east-1.rds.amazonaws.com:3306/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public Connection con = null;
    
    public Conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, us, pass);
            
            if(con!=null){
                System.out.println("En linea");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }
    
    public static void main(String[] args) {
        Conectar c = new Conectar();
        c.getConexion();
        
    }
    
}
