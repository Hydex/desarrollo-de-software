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
    
    public Item(){}

    public Item(int ideItm, String desItm, double preItm) {
        this.ideItm = ideItm;
        this.desItm = desItm;
        this.preItm = preItm;
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
    
}
