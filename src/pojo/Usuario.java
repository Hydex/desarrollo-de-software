/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class Usuario extends Empleado{
    
    private String ideUsu;
    private String pssUsu;
    private int estBlqusu;
    private int blqAutUsu;
    private String nivAccUsu;
    public Usuario(String ideUsu, String pssUsu, int estBlqusu, int blqAutUsu, String nivAccUsu, int idEmp) {
        super(idEmp);
        this.ideUsu = ideUsu;
        this.pssUsu = pssUsu;
        this.estBlqusu = estBlqusu;
        this.blqAutUsu = blqAutUsu;
        this.nivAccUsu = nivAccUsu;
        this.idEmp = idEmp;
    }

    public String getIdeUsu() {
        return ideUsu;
    }

    public void setIdeUsu(String ideUsu) {
        this.ideUsu = ideUsu;
    }

    public String getPssUsu() {
        return pssUsu;
    }

    public void setPssUsu(String pssUsu) {
        this.pssUsu = pssUsu;
    }

    public int getEstBlqusu() {
        return estBlqusu;
    }

    public void setEstBlqusu(int estBlqusu) {
        this.estBlqusu = estBlqusu;
    }

    public int getBlqAutUsu() {
        return blqAutUsu;
    }

    public void setBlqAutUsu(int blqAutUsu) {
        this.blqAutUsu = blqAutUsu;
    }

    public String getNivAccUsu() {
        return nivAccUsu;
    }

    public void setNivAccUsu(String nivAccUsu) {
        this.nivAccUsu = nivAccUsu;
    }
    
}
