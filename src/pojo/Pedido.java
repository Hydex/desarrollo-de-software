/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class Pedido {
    private int ideped; 
    private String nomPed;
    private int nuroMesPed;
    private int ideEmp;
    private int estado;
    private String fecha;

    public Pedido(String nomPed, int nuroMesPed, int ideEmp, int estado, String fecha) {
        this.nomPed = nomPed;
        this.nuroMesPed = nuroMesPed;
        this.ideEmp = ideEmp;
        this.estado = estado;
        this.fecha = fecha;
    }
    
    
    public Pedido(int ideped, String nomPed, int nuroMesPed, int ideEmp, int estado,String fecha) {
        this.ideped = ideped;
        this.nomPed = nomPed;
        this.nuroMesPed = nuroMesPed;
        this.ideEmp = ideEmp;
        this.estado = estado;
        this.fecha=fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public int getIdeped() {
        return ideped;
    }

    public void setIdeped(int ideped) {
        this.ideped = ideped;
    }

    public String getNomPed() {
        return nomPed;
    }

    public void setNomPed(String nomPed) {
        this.nomPed = nomPed;
    }

    public int getNuroMesPed() {
        return nuroMesPed;
    }

    public void setNuroMesPed(int nuroMesPed) {
        this.nuroMesPed = nuroMesPed;
    }

    public int getIdeEmp() {
        return ideEmp;
    }

    public void setIdeEmp(int ideEmp) {
        this.ideEmp = ideEmp;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
