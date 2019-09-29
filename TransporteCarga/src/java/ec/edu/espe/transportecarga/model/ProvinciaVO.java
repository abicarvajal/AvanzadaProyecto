/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

/**
 *
 * @author David
 */
public class ProvinciaVO{
    
    private int idProvincia;
    private String provincia;
    private int idDepartamento;
    
    public ProvinciaVO(){}
    
    public ProvinciaVO(int id, String name){
        this.idProvincia = id;
        this.provincia = name;
    }

    public ProvinciaVO(int idProvincia, String provincia, int idDepartamento) {
        this.idProvincia = idProvincia;
        this.provincia = provincia;
        this.idDepartamento = idDepartamento;
    }

    
    
    /**
     * @return the idProvincia
     */
    public int getIdProvincia() {
        return idProvincia;
    }

    /**
     * @param idProvincia the idProvincia to set
     */
    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public String toString(){
        return this.provincia;
    }
    
}
