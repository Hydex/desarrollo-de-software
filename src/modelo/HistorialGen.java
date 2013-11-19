package modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alison
 */

//Este no es un POJO puro 
public class HistorialGen {
  
  String cadenaFecha;
  String user;
  String pass;
  String terminalID;
  String accion;
 
  public HistorialGen()
  {
      
  }
   public enum ACCION {
   INICIO_EXITOSO,
    BLOQUEO_TERMINAL ,
    BLOQUEO_CUENTA ,
    DATOS_INCORRECTOS,
    REESTABLECER_EXITOSO,
    REESTABLECER_FALLO,
    REESTABLECER_NO_COINCIDE,
    REESTABLECER_MAL_TAMANIO,
}
  String getHoraSistema()
  {
         Date  fechaActual =new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
         cadenaFecha = formato.format(fechaActual);
         System.out.println("Fecha:  "+cadenaFecha);
      return cadenaFecha;
  }
  String getUser(){
      return user;
  }
  
  String getPassword()
  {
      return pass;
  }
  String getTerminalID()
  {
      return terminalID;
  }
  String getAccion()
  {
      return accion;
  }
  void setHoraSistema(Date fecha)
  {
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
         cadenaFecha = formato.format(fecha);
  }  
  void setUser(String user)
  {
      this.user=user;
  }
  void setPass(String pass)
  {
      this.pass=pass;
  }
  void setTerminalID(String terminalID)
  {
     this.terminalID=terminalID;
  }
   void setAccion (ACCION accion_actual)
  {
      
       switch (accion_actual) {
           case  INICIO_EXITOSO:
               accion="Se inicio sesion exitosamente ,arraca sistema.";
               break;
           case BLOQUEO_TERMINAL:
               accion="Se bloqueo el terminal se denego el acceso al sistema.";
               break;
           case BLOQUEO_CUENTA :
               accion="La cuenta actual fue bloqueada,se supero el nº de intentos.";
               break;
           case DATOS_INCORRECTOS:
               accion="Los datos de usuario o contraseña fueron incorrectos.";
               break;
           case REESTABLECER_EXITOSO:
               accion="Cambio de contraseña: Se reestablecio contraseña exitosamente,";
               break;
           case REESTABLECER_FALLO:
               accion="Cambio de contraseña: Fallo restablecer contraseña del usuario.";
               break;
           case REESTABLECER_NO_COINCIDE:
               accion="Cambio de contraseña: La verficación de contraseñas  no coinciden.";
               break;
           case REESTABLECER_MAL_TAMANIO:
                accion="Cambio de contraseña: Tamaño de la contraseña incorrecto, menor de 6.";
               break;        
            default:
                accion="Accion desconocida sobre el sistema  ";
               break;
        }
    }
  
  void saveOnHistorialHMS() 
  {
  
        try {
            conexion cnHistorial =new conexion();   
            Statement st = cnHistorial.conectar();
               // se guarda la hora, cuando se va a guardar a la base de datos
               int rsSeg= st.executeUpdate(" insert into historialAccessosHMS values('"+this.getHoraSistema()+"','"+this.getUser()+"','"+
                                                                       this.getPassword()+"','"+this.getTerminalID()+"','"+this.getAccion()+"');");
        } catch (SQLException ex) {
            Logger.getLogger(HistorialGen.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("error al guardar historial ");
        }
      
       
                              
  }
  
  

}

