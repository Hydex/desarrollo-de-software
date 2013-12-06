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

public class conexion 
{
    public String bd = "MMS";
    public String login = "root";
    public String password = "123456aaa";
    public String url = "jdbc:mysql://localhost/"+bd;
    public static conexion conect = new conexion();
    public static Statement st= conect.conectar();


public Statement conectar() {
Connection conn = null;
Statement st=null;

    try {
       Class.forName("org.gjt.mm.mysql.Driver");
     //  Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, login, password);
        if (conn != null)
        {
             //System.out.println("Ok....Conectado con  "+url+" ... Ok");
             st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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

public void terminarConexion()
{
        System.out.println("Fin de conexion");
  
 }
}