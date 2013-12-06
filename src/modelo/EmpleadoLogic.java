/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Empleado;
/**
 *
 * @author geank
 */
public class EmpleadoLogic extends SistemaLogico{
    
    public EmpleadoLogic(){
        super();
    }

    @Override
    public void guardarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Empleado getEmpleado(int id){
        String sql= "select ideEmp,dniEmp,nomEmp,apePatEmp,apeMatEmp from Empleado where ideEmp="+id;
        Empleado empleado=null;
        bd.consulta(sql);
        ResultSet rpta= bd.getRespuesta();
        try {
            while(rpta.next()){
                empleado=new Empleado(rpta.getInt("ideEmp"),rpta.getString("dniEmp"),rpta.getString("nomEmp"),
                        rpta.getString("apePatEmp"),rpta.getString("apeMatEmp"));
            }
            return empleado;
        } catch (SQLException ex) {
            return empleado;
        }
    }
    
}
