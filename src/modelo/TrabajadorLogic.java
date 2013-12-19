/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import pojo.Trabajador;

/**
 *
 * @author Hydex
 */
public class TrabajadorLogic extends SistemaLogico{

    private Trabajador tb;
    @Override
   
    public void guardarBD() {
         String sql="INSERT INTO `Empleado` (`dniEmp`, `nomEmp`, `apeMatEmp`, `apePatEmp`, `sexEmp`, `estCivEmp`, `dirEmp`, `disEmp`, `emaEmp`, `telEmp`) "
                 + "VALUES ('"+tb.getDniEmpleado()+"', '"+tb.getNomEmp() +"', '"+tb.getApeMatEmp()+"', '"+tb.getApePatEmp()+"', '"+tb.getSexEmp()+"', '"+tb.getEstCiviEmp()
                 +"', '"+tb.getDirEmp()+"', '"+tb.getDisEmp()+"', '"+tb.getEmaEmp()+"', '"+tb.getTelEmp()+"');";
            //   pedido.getNuroMesPed()+","+pedido.getIdeEmp()+","+pedido.getEstado()+",'"+pedido.getFecha()+"');";
          bd.insertar(sql);
    }
    
    public void setTrabajador(Trabajador trabajador){
        //INSERT INTO `mms`.`Empleado` (`dniEmp`, `nomEmp`, `apeMatEmp`, `apePatEmp`, `sexEmp`, `estCivEmp`, `dirEmp`, `disEmp`, `emaEmp`, `telEmp`) VALUES ('22222222', 'Ed', 'Cornejo', 'Mayta', 'M', 'S', 'Pc', 'Paucarpata', '@gmail.com', '333333');
        tb = trabajador;
    }
    
    public void actualizarDB(String DNI){
        //   tb.getSexEmp()+"', '"+tb.getEstCiviEmp()
          //       +"', '"+tb.getDirEmp()+"', '"+tb.getDisEmp()+"', '"+tb.getEmaEmp()+"', '"+tb.getTelEmp()+"');";
          String sqlUpdate="UPDATE `Empleado` SET `dniEmp`='"+tb.getDniEmpleado()+
                  "', `nomEmp`='"+tb.getNomEmp()+"', `apeMatEmp`='"+tb.getApeMatEmp()+"', `apePatEmp`='"+tb.getApePatEmp()+"', `dirEmp`='"+tb.getDirEmp() +"', `disEmp`='"+tb.getDisEmp() +"', `emaEmp`='"+tb.getEmaEmp() +"' WHERE `dniEmp`='"+DNI+"'";  
          
          bd.insertar(sqlUpdate);
          
    }
    
}
