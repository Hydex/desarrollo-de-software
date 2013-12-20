/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class Item {
    private int ideItm;
    private int ideTipItm;
    private String desItm;
    private double preItm;
    private int idePro;
    private double descuento;
    private String nomIdeItm;
    private String nomProveedor;
    public Item(){}

    public Item(int ideItm, String desItm, double preItm) {
        this.ideItm = ideItm;
        this.desItm = desItm;
        this.preItm = preItm;
    }
    public Item(int ideItm, String nomIdeItm, String desItm, double preItm,int ideProv,double descuento) {
        this.ideItm = ideItm;
        this.nomIdeItm = nomIdeItm;
        this.desItm = desItm;
        this.preItm = preItm;
        this.idePro = ideProv;
        this.descuento=descuento;
    }
    
    public Item(int ideItm, int ideTipItm, String desItm, double preItm) {
        this.ideItm = ideItm;
        this.ideTipItm = ideTipItm;
        this.desItm = desItm;
        this.preItm = preItm;
        this.idePro = 0;
    }

    public int getIdeItm() {
        return ideItm;
    }

    public void setIdeItm(int ideItm) {
        this.ideItm = ideItm;
    }

    public int getIdeTipItm() {
        return ideTipItm;
    }

    public void setIdeTipItm(int ideTipItm) {
        this.ideTipItm = ideTipItm;
    }

    public String getDesItm() {
        return desItm;
    }

    public void setDesItm(String desItm) {
        this.desItm = desItm;
    }

    public double getPreItm() {
        return preItm;
    }

    public void setPreItm(double preItm) {
        this.preItm = preItm;
    }

    public int getIdePro() {
        return idePro;
    }

    public void setIdePro(int idePro) {
        this.idePro = idePro;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getNomIdeItm() {
        return nomIdeItm;
    }

    public void setNomIdeItm(String nomIdeItm) {
        this.nomIdeItm = nomIdeItm;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }
    
}
