/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

/**
 *
 * @author nycha
 */
public class guiaVO {
    private int numero;
    private String fecha;
    private String cedulaCliente;
    private String cedulaTransportista;
    private String codigoProducto;
    private String valorEnvio;
    private String destino;
    private String direccion;
    private String estadoReserva;
    
    
    public guiaVO() {
    }

    public guiaVO(int numero, String fecha, String cedulaCliente, String cedulaTransportista, String codigoProducto, String valorEnvio, String destino, String direccion, String estadoReserva) {
        this.numero = numero;
        this.fecha = fecha;
        this.cedulaCliente = cedulaCliente;
        this.cedulaTransportista = cedulaTransportista;
        this.codigoProducto = codigoProducto;
        this.valorEnvio= valorEnvio;
        this.destino=destino;
        this.direccion=direccion;
        this.estadoReserva=estadoReserva;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCedulaTransportista() {
        return cedulaTransportista;
    }

    public void setCedulaTransportista(String cedulaTransportista) {
        this.cedulaTransportista = cedulaTransportista;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(String valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public String toString() {
        return "guiaVO{" + "numero=" + numero + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente + ", cedulaTransportista=" + cedulaTransportista + ", codigoProducto=" + codigoProducto + ", valorEnvio=" + valorEnvio + ", destino=" + destino + ", direccion=" + direccion + ", estadoReserva=" + estadoReserva + '}';
    }

    
    
    
}
