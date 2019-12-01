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
public class guiaDAO {
    Conexion con;

    public guiaDAO() {
        con=new Conexion();
    }
    public void adicionarGuia(guiaVO guia) {
        Connection acceso = con.obtenerConexion();
        String sql = "INSERT INTO guia (numero,fecha,cedulaCliente,cedulaTransportista,codigoProducto,valorEnvio,destino,direccion,estadoReserva) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = acceso.prepareStatement(sql);
            ps.setInt(1, guia.getNumero());
            ps.setString(2, guia.getFecha());
            ps.setString(3, guia.getCedulaCliente());
            ps.setString(4, guia.getCedulaTransportista());
            ps.setString(5, guia.getCodigoProducto());
            ps.setString(6, guia.getValorEnvio());
            ps.setString(7, guia.getDestino());
            ps.setString(8, guia.getDireccion());
            ps.setString(9, guia.getEstadoReserva());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<guiaVO> mostrarGuiaUno() {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        String aux = "TOTAL";
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuia(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where numero = " + aux + ";");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaPorEstados(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            String est = aux;
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where estadoReserva='" + est + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }
    public ArrayList<guiaVO> mostrarGuiaActiva(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            String est = "ACTIVO";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where codigoProducto='" + aux + "'" + " and estadoReserva='" + est + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaAnulado(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            String est = "ANULADO";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where codigoProducto='" + aux + "'" + " and estadoReserva='" + est + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaT(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            String aux1 = "TOTAL";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where cedulaTransportista='" + aux + "'" + "and codigoProducto='" + aux1 + "'");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaCliente(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            String aux1 = "TOTAL";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where cedulaCliente='" + aux + "'" + "and codigoProducto='" + aux1 + "'");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaFecha(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {

            String aux1 = "TOTAL";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where fecha='" + aux + "'" + "and codigoProducto='" + aux1 + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarGuiaNumero(String aux) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia where numero='" + aux + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public void modificarGuia(String numero) {
        try {
            System.out.println("Entramos a modificar " + numero);
            String aux = "ANULADO";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("UPDATE guia SET estadoReserva= 'ANULADO' WHERE numero= '" + numero + "';");
            ps.executeUpdate();
            System.out.println("Dato modificado");
            JOptionPane.showMessageDialog(null, "Anulación Exitosa");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarGuiaPorNumero(int numero) {
        try {
            System.out.println("Entramos a modificar " + numero);
            String aux = "ANULADO";
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("UPDATE guia SET estadoReserva= 'ANULADO' WHERE numero= " + numero + ";");
            ps.executeUpdate();
            //System.out.println("Dato modificado, \n"+ps);            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void eliminarGuia(String dni, int numero) {
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE from guia where codigoProducto='" + dni + "'" + "and numero='" + numero + "'");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<guiaVO> mostrarClientePedidos() {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT *, COUNT(cedulaCliente) AS TOTAL from guia GROUP BY cedulaCliente ORDER BY TOTAL DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public ArrayList<guiaVO> mostrarClientePedidoMes(int mes) {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM guia WHERE MONTH(fecha)='" + mes + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }

    public float montoPedidoMes(int mes) {
        float total = 0;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT SUM(valorEnvio) FROM guia WHERE fecha like '%/" + mes + "/%' and codigoProducto='TOTAL';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return total;
    }

    public float montoPedidoAnio(int anio) {
        float total = 0;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT SUM(valorEnvio) FROM guia WHERE fecha like '%/" + anio + "%' and codigoProducto='TOTAL';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return total;
    }

    public ArrayList<String> ciudadesTotalPedidos() {
        ArrayList<String> lista = new ArrayList<String>();
        String ciudad;
        int cantidad;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT nombre,count(destino) FROM ciudad, guia where destino=nombre and codigoProducto='TOTAL' and numero=numero GROUP BY destino;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ciudad = rs.getString(1);
                cantidad = rs.getInt(2);
                lista.add(ciudad);
                lista.add(Integer.toString(cantidad));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public ArrayList<String> transportistasTotalEnvios() {
        ArrayList<String> lista = new ArrayList<String>();
        String nombre, id;
        float cantidad;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT nombre,cedulaTransportista,sum(valorEnvio) FROM transportista, guia where cedulaTransportista=identificacion and codigoProducto='TOTAL' GROUP BY cedulaTransportista;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(1);
                id = rs.getString(2);
                cantidad = rs.getFloat(3);
                lista.add(nombre);
                lista.add(id);
                lista.add(Float.toString(cantidad));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public ArrayList<String> productosMontoTotal() {
        ArrayList<String> lista = new ArrayList<String>();
        String nombre, id;
        float cantidad;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT descripcion,codigoProducto,sum(p.valorEnvio) FROM producto p, guia where codigoProducto=codigo GROUP BY codigoProducto;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombre = rs.getString(1);
                id = rs.getString(2);
                cantidad = rs.getFloat(3);
                lista.add(nombre);
                lista.add(id);
                lista.add(Float.toString(cantidad));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public void eliminarGuiaCodigo(String number) {
        try {
            Connection accesoDB = con.obtenerConexion();
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM guia WHERE numero like '" + number + "';");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<guiaVO> mostrarGuias() {
        ArrayList<guiaVO> listaB = new ArrayList<guiaVO>();
        guiaVO guia;
        try {
            Connection acceso = con.obtenerConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from guia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                guia = new guiaVO();
                guia.setNumero(rs.getInt(1));
                guia.setFecha(rs.getString(2));
                guia.setCedulaCliente(rs.getString(3));
                guia.setCedulaTransportista(rs.getString(4));
                guia.setCodigoProducto(rs.getString(5));
                guia.setValorEnvio(rs.getString(6));
                guia.setDestino(rs.getString(7));
                guia.setDireccion(rs.getString(8));
                guia.setEstadoReserva(rs.getString(9));
                listaB.add(guia);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaB;
    }
}