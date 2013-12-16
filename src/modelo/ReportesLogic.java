/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hydex
 */
public class ReportesLogic extends SistemaLogico{

    @Override
    public void guardarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void retornarAlgo(){
        String sql="select p.idePed, v.ideEmp, SUM(I.preItm) from Pedido p, DetalleDelPedido dd,Empleado v, Item I where dd.idePed = p.idePed group by p.idePed";
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try{
            while(rpta.next()){
                
            }
        }
        catch(SQLException ex){
            
        }
    }
    
    public void Procesar_reporte_ventas(DefaultTableModel mi_modelo, String tiempo)
    {
        String consultasql="";
        
        
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(dt);
        if(tiempo.equals("General"))
             consultasql  = "select p.idePed, v.ideEmp, SUM(I.preItm) from Pedido p, DetalleDelPedido dd,Empleado v, Item I where dd.idePed = p.idePed group by p.idePed";
        else if(tiempo.equals("Dia"))
        {
            
           
           System.out.println("holaaaaa: " + dt.getMonth());
            
            consultasql  = "select I.ideItm, I.desItm, sum(dp.cntDetPed) as Cantidad\n" +
" from (DetalleDelPedido dp natural join Item I), Pedido pe\n" +
"where pe.idePed = dp.idePed and pe.fecHorPed like '%"+fecha+"%' group by I.ideItm order by dp.cntDetPed ";
        }else
        {
            consultasql = "select I.ideItm, I.desItm, sum(dp.cntDetPed) as Cantidad\n" +
" from (DetalleDelPedido dp natural join Item I), Pedido pe\n" +
"where pe.idePed = dp.idePed and Month(pe.fecHorPed) = "+dt.getMonth() + " group by I.ideItm order by dp.cntDetPed ";
        }
        bd.consulta(consultasql);
        
        try {
            ResultSet rs = bd.getRespuesta();
            ResultSetMetaData datos = rs.getMetaData();
            int num_columnas = datos.getColumnCount();
            
            for(int i = 1; i <= num_columnas; i++)
                   mi_modelo.addColumn(datos.getColumnLabel(i));
            
            while (rs.next()) {
              Object[] fila = new Object[num_columnas];
              for (int i = 0; i < num_columnas; i++) {
                fila[i]=rs.getObject(i+1);
              }
              mi_modelo.addRow(fila);
             }
             rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportesLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Reportes-Ventas");
        }
    }
    
    
    public void cargar_datos_venta(DefaultTableModel mi_modelo)
    {
        
        String consultasql = "select pe.idePed, pe.nomPed, sum(I.preItm * dp.cntDetPed) as Total from Item I natural join DetalleDelPedido dp , Pedido pe where pe.idePed = dp.idePed group by pe.idePed";
            try {
            
            bd.consulta(consultasql);
            ResultSet rpta = bd.getRespuesta();
            ResultSetMetaData datos = rpta.getMetaData();
            int num_columnas = datos.getColumnCount();
            
            for(int i = 1; i <= num_columnas; i++)
                   mi_modelo.addColumn(datos.getColumnLabel(i));
            
            while (rpta.next()) {
              Object[] fila = new Object[num_columnas];
              for (int i = 0; i < num_columnas; i++) {
                fila[i]=rpta.getObject(i+1);
              }
              mi_modelo.addRow(fila);
            }
             rpta.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportesLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Reportes-Ventas");
        }
    }
    
    public ResultSet datos_empleado()
    {
        ResultSet rpta = null;
        
        String consultasql = "select * from Empleado";
        try{
            
        
        bd.consulta(consultasql);
        return bd.getRespuesta();
        
        }catch(Exception ex)
        {
            System.out.println("Error en consulta empleados" + ex);
            return rpta;
        }
    }
    
    public void cargar_datos_producto(DefaultTableModel mi_modelo)
    {
        //this.jComboBox4.addItem("fabian");
        
        String consultasql = "select I.ideItm, I.desItm, sum(dp.cntDetPed) as Cantidad from DetalleDelPedido dp natural join Item I group by I.ideItm order by dp.cntDetPed";
        
        try {
            
            
           // String emp = this.jComboBox3.getSelectedItem().toString();
       
            bd.consulta(consultasql);
                     
            ResultSet rs = bd.getRespuesta();
             ResultSetMetaData datos = rs.getMetaData();
            int num_columnas = datos.getColumnCount();
            
            for(int i = 1; i <= num_columnas; i++)
                   mi_modelo.addColumn(datos.getColumnLabel(i));
            
            while (rs.next()) {
              Object[] fila = new Object[num_columnas];
              for (int i = 0; i < num_columnas; i++) {
                fila[i]=rs.getObject(i+1);
              }
              mi_modelo.addRow(fila);
            }
       
       
       rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportesLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en cargar pestañas de reportes-Item");
        }
        
        
    }
    
    public void llenar_meses_graficos(Double []totales)
    {
        String consultasql = "select MONTH(pe.fecHorPed) , sum(dp.cntDetPed * I.preItm) from DetalleDelPedido dp natural join Item I, Pedido pe where pe.idePed = dp.idePed group by MONTH(pe.fecHorPed)";
        
        try {
            
            
           // String emp = this.jComboBox3.getSelectedItem().toString();
       
            bd.consulta(consultasql);
                     
            ResultSet rs = bd.getRespuesta();
             ResultSetMetaData datos = rs.getMetaData();
            int num_columnas = datos.getColumnCount();
            
             while (rs.next()) {
              Object[] fila = new Object[num_columnas];
              for (int i = 0; i < num_columnas; i++) {
                totales[Integer.parseInt(""+rs.getObject(1))] = Double.parseDouble(""+rs.getObject(2));
              }
            }
       
       
       rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportesLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en cargar pestañas de reportes-Item-graficos");
        }
    }
    
}
