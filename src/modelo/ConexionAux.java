package modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alison
 */
import java.sql.*;

public class ConexionAux 
{
    public String bd = "matahambredb";
    public String login = "root";
    public String password = "kira";
    public String url = "jdbc:mysql://localhost:3306/"+bd;
    
    public static Connection cn;
    public static Statement st;


public Statement conectar() {
    st=null;

    try {
        Class.forName("org.gjt.mm.mysql.Driver");
        
        cn = DriverManager.getConnection(url, login, password);
        if (cn != null)
        {
             //System.out.println("Ok....Conectado con  "+url+" ... Ok");
             st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
    }
    catch(SQLException ex) {
        System.out.println("Problema al conectar con la base "+url);
    }
    catch(ClassNotFoundException ex) {
        System.out.println(ex);
    }
       return st;
 }

public void cerrar()
{
   try{
        if (st != null) {
        st.close();
      }

      if (cn != null) {
        cn.close();
      }
    } catch (SQLException e) {
    }
  
 }
}