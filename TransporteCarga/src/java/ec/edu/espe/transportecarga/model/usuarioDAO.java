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
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author nycha
 */
public class usuarioDAO {

    Conexion con;

    public usuarioDAO() {
        con = new Conexion();
    }

    public void adicionarUsuario(usuarioVO usuario) {
        Connection acceso = con.obtenerConexion();
        String sql = "INSERT INTO usuario (usuarios,password,tipo) VALUES(?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getTipo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean buscarUsuarioAdmin(usuarioVO usuario) {
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql = "SELECT * FROM usuario WHERE usuarios =? AND password=? AND tipo=1";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.executeQuery();

            if (ps.executeQuery().next()) {
                band = true;
            } else {
                band = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return band;
    }

    public boolean buscarUsuarioLoguistica(usuarioVO usuario) {
        boolean band = false;
        Connection acceso = con.obtenerConexion();
        String sql = "SELECT * FROM usuario WHERE usuarios =? AND password=? AND tipo=2";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.executeQuery();

            if (ps.executeQuery().next()) {
                band = true;
            } else {
                band = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return band;
    }

    public ArrayList<usuarioVO> mostrarUsuario() {
        ArrayList<usuarioVO> listaB = new ArrayList<usuarioVO>();
        usuarioVO usuario;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new usuarioVO();
                usuario.setUsuario(rs.getString(1));
                usuario.setPassword(rs.getString(2));
                usuario.setTipo(rs.getInt(3));
                listaB.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<usuarioVO> mostrarTipoUsuario(String login, String pass) {
        
        ArrayList<usuarioVO> listaB = new ArrayList<usuarioVO>();
        usuarioVO usuario;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from usuario where usuarios ='" + login + "' AND password= '" + pass + "' limit 1;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new usuarioVO();
                usuario.setUsuario(rs.getString(1));
                usuario.setPassword(rs.getString(2));
                usuario.setTipo(rs.getInt(3));
                listaB.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        usuarioVO usuarioAUX = new usuarioVO();
        usuarioVO e;
        Iterator<usuarioVO> i = listaB.iterator();
        int validar = 0;
        while (i.hasNext()) {
            e = i.next();
            if ((e.getUsuario().equals(login)) && (e.getPassword().equals(pass))) {
                validar = 1;
                System.out.println("e.getUsuario():"+e.getUsuario() + "login: "+login+ "\ne.getPassword():"+e.getPassword()+ "pass: "+pass);
                System.out.println(e.getUsuario().equals(login) +"\n"+e.getPassword().equals(pass));
                System.out.println("Entramos dato correcto");
            }

        }
        if (validar == 0) {
            listaB.clear();
            listaB.add(usuarioAUX);
        }

        return listaB;
    }

    public void eliminarUsuario(String dni) {
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE from usuario where usuarios=" + dni);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void modificarUsuario(usuarioVO usuario) {
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("UPDATE usuario SET password='" + usuario.getPassword()
                    + "', tipo='" + usuario.getTipo() + "'WHERE usuarios='" + usuario.getUsuario() + "'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
