/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class Empleado {
    protected int idEmp;
    protected String dniEmpleado;
    protected String nomEmp;
    protected String apeMatEmp;
    protected String apePatEmp;
    protected char sexEmp;
    protected char estCiviEmp;
    protected String dirEmp;
    protected String disEmp;
    protected String emaEmp;
    protected String telEmp;

    public Empleado(int idEmp) {
        this.idEmp = idEmp;
    }

    public Empleado(int idEmp, String dniEmpleado, String nomEmp, String apeMatEmp, String apePatEmp) {
        this.idEmp = idEmp;
        this.dniEmpleado = dniEmpleado;
        this.nomEmp = nomEmp;
        this.apeMatEmp = apeMatEmp;
        this.apePatEmp = apePatEmp;
    }
    
    public Empleado(int idEmp, String dniEmpleado, String nomEmp, String apeMatEmp, String apePatEmp, char sexEmp, char estCiviEmp, String dirEmp, String disEmp, String emaEmp, String telEmp) {
        this.idEmp = idEmp;
        this.dniEmpleado = dniEmpleado;
        this.nomEmp = nomEmp;
        this.apeMatEmp = apeMatEmp;
        this.apePatEmp = apePatEmp;
        this.sexEmp = sexEmp;
        this.estCiviEmp = estCiviEmp;
        this.dirEmp = dirEmp;
        this.disEmp = disEmp;
        this.emaEmp = emaEmp;
        this.telEmp = telEmp;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApeMatEmp() {
        return apeMatEmp;
    }

    public void setApeMatEmp(String apeMatEmp) {
        this.apeMatEmp = apeMatEmp;
    }

    public String getApePatEmp() {
        return apePatEmp;
    }

    public void setApePatEmp(String apePatEmp) {
        this.apePatEmp = apePatEmp;
    }

    public char getSexEmp() {
        return sexEmp;
    }

    public void setSexEmp(char sexEmp) {
        this.sexEmp = sexEmp;
    }

    public char getEstCiviEmp() {
        return estCiviEmp;
    }

    public void setEstCiviEmp(char estCiviEmp) {
        this.estCiviEmp = estCiviEmp;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    public String getDisEmp() {
        return disEmp;
    }

    public void setDisEmp(String disEmp) {
        this.disEmp = disEmp;
    }

    public String getEmaEmp() {
        return emaEmp;
    }

    public void setEmaEmp(String emaEmp) {
        this.emaEmp = emaEmp;
    }

    public String getTelEmp() {
        return telEmp;
    }

    public void setTelEmp(String telEmp) {
        this.telEmp = telEmp;
    }
    
}
