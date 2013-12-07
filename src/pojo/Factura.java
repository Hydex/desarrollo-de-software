/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class Factura {
    private String nroFac;
    private int idPedido ;
    private boolean estAnuFact;
    private boolean tipPagFac;
    private String fechaEmision;
    private double total;

    public Factura(){}
    public Factura(String nroFac, int idPedido, boolean estAnuFact, boolean tipPagFac, String fechaEmision, double total) {
        this.nroFac = nroFac;
        this.idPedido = idPedido;
        this.estAnuFact = estAnuFact;
        this.tipPagFac = tipPagFac;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public String getNroFac() {
        return nroFac;
    }

    public void setNroFac(String nroFac) {
        this.nroFac = nroFac;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public boolean isEstAnuFact() {
        return estAnuFact;
    }

    public void setEstAnuFact(boolean estAnuFact) {
        this.estAnuFact = estAnuFact;
    }

    public boolean isTipPagFac() {
        return tipPagFac;
    }

    public void setTipPagFac(boolean tipPagFac) {
        this.tipPagFac = tipPagFac;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
