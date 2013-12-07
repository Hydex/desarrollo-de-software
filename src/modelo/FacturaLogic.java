/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.Factura;
/**
 *
 * @author geank
 */
public class FacturaLogic extends SistemaLogico{

    @Override
    public void guardarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void insertarFactura(Factura factura){
        int esta;
        String sql="insert into Factura values('"+factura.getNroFac()+"',"+factura.getIdPedido()+","+
                (esta= factura.isEstAnuFact()?1:0)+","+(esta= factura.isTipPagFac()?1:0)+
                ",'"+factura.getFechaEmision()+"',"+factura.getTotal()+")";
        if(bd.insertar(sql)){
            JOptionPane.showMessageDialog(null,"Se guardo Correctamente");
        }
        else{
             JOptionPane.showMessageDialog(null,"Error al guardar la factura");
        }
    }
    public int getNumFactura(){
        String sql="select count(nroFac) as numfacts from Factura;";
        bd.consulta(sql);
        
        ResultSet rpta=bd.getRespuesta();
        int count=0;
        try {
            while(rpta.next()){
                count=rpta.getInt("numfacts");
            }
            return count;
        } catch (SQLException ex) {
            return 0;
        }
    }
}
