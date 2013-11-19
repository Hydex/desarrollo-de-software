package modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import Conexion.conexion;
import java.sql.*;
import java.math.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alison
 */

//Este no es un POJO puro 
public class HistorialLog{
  
  String cHoraIni;
  String cHoraFin;
  String user;
  String terminalID;
  int tiempoLog;
  int hor_ini,min_ini,seg_ini;  
  int hor_fin,min_fin,seg_fin;
  
  
  public HistorialLog()
  {
      
  }
   void saveTimeIni()
  {
        Date  inicio =new Date();
        SimpleDateFormat formato = new SimpleDateFormat("H:mm:ss");
        cHoraIni= formato.format(inicio);
        hor_ini=inicio.getHours();
        min_ini=inicio.getMinutes();
        seg_ini=inicio.getSeconds();
   
      
  }
  void saveTimeFin()
  {
        Date  fin=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("H:mm:ss");
        cHoraFin= formato.format(fin);
        hor_fin=fin.getHours();
         min_fin=fin.getMinutes();
         seg_fin=fin.getSeconds();
         
  }
  String getHoraIni()
  {
      return cHoraIni;
  }
    String getHoraFin()
  {
      return cHoraFin;
  }
  String getUser(){
      return user;
  }
  
  String getTime()
  {
      String time="00:00:00";
         System.out.println(hor_ini+" "+min_ini+" "+seg_ini);       
         System.out.println(hor_fin+" "+min_fin+" "+seg_fin);       
        int  ts=Math.abs((hor_fin-hor_ini)*3600)+Math.abs((min_fin-min_ini)*60)+Math.abs(seg_fin-seg_ini);        
        int hrs= (ts/3600);
        System.out.println(".............."+hrs);
        int min=(ts-(3600*hrs))/60;
        int seg=(ts-(3600*hrs)-(60*min));
        
        System.out.println("Hora" +hrs+min+seg);
        
        time=((hrs<=9)?("0"+hrs+":"):(hrs+":"));
        time+=((min<=9)?("0"+min+":"):(min+":"));
        time+= ((seg<=9)?("0"+seg):(seg));
        
      return time;
  }

  String getTerminalID()
  {
      return terminalID;
  }

 
  void setUser(String user)
  {
      this.user=user;
  }
 
  void setTerminalID(String terminalID)
  {
     this.terminalID=terminalID;
  }

 
  void saveOnHistorialHMS() 
  {

        try {
            conexion cnHistorial =new conexion();   
            Statement st = cnHistorial.conectar();
               // se guarda la hora, cuando se va a guardar a la base de datos
               int rsSeg= st.executeUpdate(" insert into historialLoguinHMS values('"+this.getHoraIni()+"','"+this.getHoraFin()+"','"+
                                                                       this.getUser()+"','"+this.getTerminalID()+"','"+this.getTime()+"');");
               
               
        } catch (SQLException ex) {
            Logger.getLogger(HistorialGen.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
                              
  }
  
  

}


