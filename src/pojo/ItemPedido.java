/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author geank
 */
public class ItemPedido {
    private int ideItm;
    private String desItm;
    private int cantidad;
    private double precio;
    private double total;
    public ItemPedido(){
        
    }
    public ItemPedido(int ideItm, String desItm, int cantidad, double precio, double total) {
        this.ideItm = ideItm;
        this.desItm = desItm;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getIdeItm() {
        return ideItm;
    }

    public void setIdeItm(int ideItm) {
        this.ideItm = ideItm;
    }

    public String getDesItm() {
        return desItm;
    }

    public void setDesItm(String desItm) {
        this.desItm = desItm;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
