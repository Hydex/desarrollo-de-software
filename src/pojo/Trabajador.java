/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import modelo.TrabajadorLogic;

/**
 *
 * @author Hydex
 */
public class Trabajador extends Empleado {

    private TrabajadorLogic tb;
    
    public Trabajador(int idEmp) {
        super(idEmp);
        tb = new TrabajadorLogic();
    }

    //public Trabajador(int i, int i0, String edwin, String mayta, String cornejo) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    
    public Boolean Registrar(){
            tb.setTrabajador(this);
            tb.guardarBD();
          //  System.out.println("Registrando GO!");
        return true;
    }
    public Boolean Actualizar(String DNI){
            tb.setTrabajador(this);
            tb.actualizarDB(DNI);
          //  System.out.println("Registrando GO!");
        return true;
    }
    
    
}
