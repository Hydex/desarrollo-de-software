/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author geank
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public abstract class SistemaLogico 
{
    protected Conexion bd;
    
    public SistemaLogico()
    {
        bd=Conexion.inicializar();
        //bd = new BaseDatos();
        bd.conectar();
    }
    /**
     * @brief Método abstracto guardar en la Base de datos 
     * @return void
     */
    public abstract void guardarBD();
    
    
    
}

