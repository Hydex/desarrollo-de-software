package modelo;


//import Login_Seguridad.HistorialGen;
import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alison
 */

public class Seguridad {
    
    int cTerminal;
    int cCuenta;
    boolean bloqueoTerminal;
    boolean bloqueoCuenta;
    boolean systemEXIT,Dialog_loginVISIBLE,Dialog_passwordVISBLE,thisVISIBLE;
    ConexionAux ini_conexion;
    Statement st ;
    //otros datos 
    String usuario;
    String password;
    String terminalID;
    String re_password, vf_password;
    HistorialGen historial_login;
    HistorialGen historial_restablecer;
    HistorialLog historial_time;
    
    public Seguridad (){}
   
    public Seguridad (String usuario,String password,String terminalID)
    {
      
        this.usuario=usuario;
        this.password=password;
        this.terminalID=terminalID;
        this.systemEXIT=false;
        this.Dialog_loginVISIBLE=true;
        this.Dialog_passwordVISBLE=false;
        this.thisVISIBLE=false;
        historial_login =new HistorialGen();
        historial_restablecer=new HistorialGen();
        historial_time =new HistorialLog();
        
        this.historial_login.setUser(usuario);
        this.historial_login.setTerminalID(terminalID);
        this.historial_login.setPass(password);
        
        this.historial_restablecer.setUser(usuario);
        this.historial_restablecer.setTerminalID(terminalID);
        this.historial_restablecer.setPass(password);
        
        this.historial_time.setUser(usuario);
        this.historial_time.setTerminalID(terminalID);
        ini_conexion =new ConexionAux();
        st=ini_conexion.conectar();
          
          System.out.println(" user"+usuario+"  "+password+" - "+terminalID);
    }
    
    public int getcTerminal() {
            return cTerminal;
    }
    public void setcTerminal(int cTerminal) {
            this.cTerminal = cTerminal;
    }
    public int getcCuenta() {
            return cCuenta;
    }
    public void setcCuenta(int cCuenta) {
            this.cCuenta = cCuenta;
    }
    public boolean isBloqueoTerminal() {
            return bloqueoTerminal;
    }
    public void setBloqueoTerminal(boolean bloqueoTerminal) {
            this.bloqueoTerminal = bloqueoTerminal;
    }
    public boolean isBloqueoCuenta() {
            return bloqueoCuenta;
    }
    public void setBloqueoCuenta(boolean bloqueoCuenta) {
            this.bloqueoCuenta = bloqueoCuenta;
    }
    public boolean isSystemEXIT() {
            return systemEXIT;
    }
    public void setSystemEXIT(boolean systemEXIT) {
            this.systemEXIT = systemEXIT;
    }
    public boolean isDialog_loginVISIBLE() {
            return Dialog_loginVISIBLE;
    }
    public void setDialog_loginVISIBLE(boolean dialog_loginVISIBLE) {
            Dialog_loginVISIBLE = dialog_loginVISIBLE;
    }
    public boolean isDialog_passwordVISBLE() {
            return Dialog_passwordVISBLE;
    }
    public void setDialog_passwordVISBLE(boolean dialog_passwordVISBLE) {
            Dialog_passwordVISBLE = dialog_passwordVISBLE;
    }
    public boolean isThisVISIBLE() {
            return thisVISIBLE;
    }
    public void setThisVISIBLE(boolean thisVISIBLE) {
            this.thisVISIBLE = thisVISIBLE;
    }
   public  boolean verificarTerminal () 
   {
       
       int verificado=0;
        
       try{
            
             ResultSet rs = st.executeQuery("SELECT * FROM Terminal WHERE desTer='"+terminalID+"'");
            
             rs.last();
             verificado=rs.getRow();
             rs.close();
             
       }
       catch (Exception e)
            {
                   e.printStackTrace();
            }
       return  (verificado==1);
   } 
   public boolean terminalEstaBloqueado() {
       
        try
           { 
              
                ResultSet rs= st.executeQuery("SELECT estBlqTer FROM Terminal WHERE desTer='"+terminalID+"'");
                rs.next();
                cTerminal=rs.getInt("estBlqTer");
                rs.close();
            }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
              bloqueoTerminal= (cTerminal>=3);  // True= El temrinal esta bloqueado 
              
     return  bloqueoTerminal; 
   }
   public boolean accesoCuenta (){
         int encontrado=0;
          try
           {
          
               ResultSet rs = st.executeQuery("SELECT * FROM Usuario WHERE ideUsu='"+usuario+"' AND pssUsu='"+password+"'");
               rs.last();
                encontrado=rs.getRow();
                rs.close();
           }
           catch (Exception e)
            {
                   e.printStackTrace();
             }
          return (encontrado==1);
       
   }
   public boolean primerAccesoCuenta (){
         int acceso1=0;
          try
           {
               
                ResultSet rs = st.executeQuery("SELECT * FROM Usuario WHERE ideUsu='"+usuario+"'AND estBlqUsu");
                rs.last();
                acceso1=rs.getRow();
                rs.close();
           }
           catch (Exception e)
            {
                   e.printStackTrace();
             }
          return (acceso1==0);
   }
   public boolean cuentaEstaBloqueada() {
            try
            {
              
                   ResultSet rsSeg= st.executeQuery("SELECT blqAutUsu FROM Usuario WHERE ideUsu='"+usuario+"'");
                   boolean verificadorExistencia=rsSeg.next();
                    if(verificadorExistencia){
                     cCuenta=rsSeg.getInt("blqAutUsu");
                    } 
                     rsSeg.close();
             }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
             bloqueoCuenta=(cCuenta>=3);
            
     return bloqueoCuenta;// True= La cuenta actual esta bloqueada  
   }  
   public void actualizar() {
          try
            {
 
               if (this.accesoCuenta()){
                   st.executeUpdate("UPDATE Usuario  SET blqAutUsu=0 WHERE ideUsu='"+usuario+"'");
                   st.executeUpdate("UPDATE Terminal SET estBlqTer=0 WHERE desTer='"+terminalID+"'");
               }
               else{
                    st.executeUpdate("UPDATE Usuario  SET blqAutUsu=blqAutUsu+1 WHERE ideUsu='"+usuario+"'");
                    st.executeUpdate("UPDATE Terminal SET estBlqTer=estBlqTer+1 WHERE desTer='"+terminalID+"'");
               }
               
             }
             
            catch (Exception e)
            {
                   e.printStackTrace();
             }
   }
   public void verificaAccesoCuenta(){
       if (!this.cuentaEstaBloqueada() ){  
           if(this.accesoCuenta()  && this.primerAccesoCuenta()){
               this.Dialog_loginVISIBLE=false;
               this.Dialog_passwordVISBLE=true;
               this.actualizar();
           }
           else if(this.accesoCuenta())
           {
                     this.historial_login.setAccion(HistorialGen.ACCION.INICIO_EXITOSO);
                     this.historial_login.saveOnHistorialHMS();
                     this.historial_time.saveTimeIni();   
                     this.Dialog_loginVISIBLE=false;
                     this.thisVISIBLE=true;
                     this.actualizar();
             }
             else
             {
                  JOptionPane.showMessageDialog(null, "Sus datos son incorrectos, reviselos");         
                  this.historial_login.setAccion(HistorialGen.ACCION.DATOS_INCORRECTOS);
                  this.historial_login.saveOnHistorialHMS();
                  this.actualizar();
                  if(cuentaEstaBloqueada()){
                   JOptionPane.showMessageDialog(null, "Ud. a superado el numero maximo de intentos\n");
                  this.historial_login.setAccion(HistorialGen.ACCION.BLOQUEO_CUENTA);
                  this.historial_login.saveOnHistorialHMS();
                   systemEXIT=true;}
               }                   
         }
        else{  
           JOptionPane.showMessageDialog(null, "su cuenta esta bloqueda pongase en contacto con un administrador!\n");
            systemEXIT=true;  // System.exit(0);
         }   
   }
   public void verificacionSistema () {
         if (this.verificarTerminal()){
         if(this.terminalEstaBloqueado())
         {
                JOptionPane.showMessageDialog(null,"Terminal Bloqueado!\n"
                                                                        + "Pongase en Contacto con un administrador");
                 this.historial_login.setAccion(HistorialGen.ACCION.BLOQUEO_TERMINAL);
                 this.historial_login.saveOnHistorialHMS();
                systemEXIT=true; // System.exit(0);
           }else if((usuario.isEmpty())||(password.isEmpty())){
               JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña  ");
           }else{
               this.verificaAccesoCuenta();
           }
         }else{
             JOptionPane.showMessageDialog(null, "Este Terminal no esta registrado.\n");
             systemEXIT=true; // System.exit(0);
         }
   }
      
   public void actualizaPassword(){ 
           try
           {
             
               int cambioExitoso = st.executeUpdate("UPDATE Usuario SET estBlqUsu=TRUE , pssUsu='"+vf_password+"'WHERE ideUsu='"+usuario+"'");
  
                         if(cambioExitoso==1){
                             JOptionPane.showMessageDialog(null, "Operacion Exitosa\nBienvenido al Sistema HMS!");
                             this.thisVISIBLE=true;
                             this.Dialog_passwordVISBLE=false;
                             
                             this.historial_restablecer.setAccion(HistorialGen.ACCION.REESTABLECER_EXITOSO);
                             this.historial_restablecer.saveOnHistorialHMS();
                            
                         }
                         else{
                         JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                             this.systemEXIT=true;
                             this.historial_restablecer.setAccion(HistorialGen.ACCION.REESTABLECER_FALLO);
                             this.historial_restablecer.saveOnHistorialHMS();
                              
                         }
              }
              catch (Exception e)
              {
                  e.printStackTrace();
               }
   
   }
   public void restablecerPassword(String re_password,String vf_password){
       this.re_password=re_password;
       this.vf_password=vf_password;
      
        if((re_password.isEmpty())||(vf_password.isEmpty()))
       {
         JOptionPane.showMessageDialog(null, "Ingrese todos los campos!");
       }
       
       
       else if(!re_password.equals(vf_password))
       {
         JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden\nIngrese de nuevo!");   
         this.historial_restablecer.setAccion(HistorialGen.ACCION.REESTABLECER_NO_COINCIDE);
         this.historial_restablecer.saveOnHistorialHMS();
        
       }
       
       else if(re_password.length()<6)
       {
         JOptionPane.showMessageDialog(null, "La cantida minima de caracteres es 6!");
           this.historial_restablecer.setAccion(HistorialGen.ACCION.REESTABLECER_MAL_TAMANIO);
           this.historial_restablecer.saveOnHistorialHMS();
       
       }
       
       else
        {     
           this.actualizaPassword();
        }
       
   }
   public void finSesion()
   {
       this.historial_time.saveTimeFin();
       this.historial_time.saveOnHistorialHMS();
   }
   

         public int[] getNivelDeAcceso(int nro_tabs)
   {
          String privilegiosS;
          int [] privilegios = null;
          int [] tabs=null;
          try
           {
          
               ResultSet rs = st.executeQuery("SELECT nivAccUsu FROM Usuario WHERE ideUsu='"+usuario+"'");
               rs.next();
               privilegiosS=rs.getString("nivAccUsu");  
               privilegios = new int [privilegiosS.length()];
                tabs=new int [nro_tabs];
               rs.close();
               System.out.println("/ "+nro_tabs);
               System.out.println("`"+privilegios.length);
               for (int i=0;i<privilegiosS.length();i++){privilegios[i]=privilegiosS.charAt(i)-'0';}   
               for(int i=0;i<nro_tabs;i++){tabs[i]=1;}
               for(int i=0;i<privilegios.length;i++){
                   tabs[privilegios[i]]=0;
               }   
           }
           catch (Exception e)
            {
                   e.printStackTrace();
             }

              return tabs;

  }

}