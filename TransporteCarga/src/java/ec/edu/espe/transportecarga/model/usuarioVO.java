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
public class usuarioVO {
    private String usuario;
    private String password;
    private int tipo;

    public usuarioVO() {
    }  
    
    public usuarioVO(String usuario, String password, int tipo) {
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    

    @Override
    public String toString() {
        return "usuarioVO{" + "usuario=" + usuario + ", password=" + password + ", tipo=" + tipo + '}';
    }
    
    
    
    
}
