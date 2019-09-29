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
public class productoVO {
    private String codigo;
    private String descrpcion;
    private float valorEnvio;
    private String claseProducto;

    public productoVO() {
    }

    public productoVO(String codigo, String descrpcion, float valorEnvio, String claseProducto) {
        this.codigo = codigo;
        this.descrpcion = descrpcion;
        this.valorEnvio = valorEnvio;
        this.claseProducto = claseProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public float getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(float valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public String getClaseProducto() {
        return claseProducto;
    }

    public void setClaseProducto(String claseProducto) {
        this.claseProducto = claseProducto;
    }

    @Override
    public String toString() {
        return "productoVO{" + "codigo=" + codigo + ", descrpcion=" + descrpcion + ", valorEnvio=" + valorEnvio + ", claseProducto=" + claseProducto + '}';
    }
    
    
    
}
