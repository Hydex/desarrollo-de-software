/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author geank
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static Conexion instance=null;
    //BaseDatos* instance;
    private Connection conexion;
    private ResultSet rpta;
    
    private Conexion ()
    {
        
    }
    public ResultSet getRespuesta()
    {
        return rpta;
    }
    public static Conexion inicializar()
    {
        if(instance==null)
            instance = new Conexion();
        
        return instance;
    }
    public boolean consulta(String consul)
    {
        System.out.println(consul);
        try
        {
            Statement statement = conexion.createStatement();
            rpta =statement.executeQuery(consul);
            return true;
        }
        catch(SQLException sqle)
        {
            return false;
        }

    }
    public boolean insertar(String consul){
        System.out.println(consul);
        try
        {
            Statement statement = conexion.createStatement();
            statement.execute(consul);
            return true;
        }
        catch(SQLException sqle)
        {
            return false;
        }
    }
    /**
* @brief Método que se conecta a la Base de Datos, en éste caso a Postgresql
* @return
*/
    public String conectar()
    {
        try
        {
            // Load the driver class
            Class.forName("com.mysql.jdbc.Driver");
 
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mms" ,"root","root");

            // Create a connection through the DriverManager
            //conexion = DriverManager.getConnection(sourceURL,"root","triko12");
            //Connection databaseConnection = DriverManager.getConnection(sourceURL);
            System.out.println("Connection is: "+conexion);
            return "Connection is: "+conexion;
        }
        catch(ClassNotFoundException cnfe)
        {
            //System.out.println(cnfe.toString());
            return "Error 1: "+cnfe;
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.toString());
            return "Error 1: "+sqle;
        }
    }
}