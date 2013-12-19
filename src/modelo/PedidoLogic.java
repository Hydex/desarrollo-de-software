/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import pojo.ItemPedido;
import pojo.Pedido;
/**
 *
 * @author geank
 */

public class PedidoLogic extends SistemaLogico{

    Pedido pedido;
    
    public PedidoLogic(){
        super();
    }
    public PedidoLogic(Pedido pedido){
        super();
        this.pedido=pedido;
    }
    @Override
    public void guardarBD() {
      
       String sql="insert into Pedido(nomPed,nroMesPed,ideEmp,estado,fecHorPed) values('"+pedido.getNomPed()+"',"+
               pedido.getNuroMesPed()+","+pedido.getIdeEmp()+","+pedido.getEstado()+",'"+pedido.getFecha()+"');";
       bd.insertar(sql);
    }
    public void insertarPedido(Pedido pedido){
        String sql="";
    }
    public Pedido getUltimoPedido(){
        Pedido ped=null;
        String sql="SELECT * FROM Pedido ORDER BY idePed DESC LIMIT 1;";
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try {
            while(rpta.next()){
                //int ideped, String nomPed, int nuroMesPed, int ideEmp, int estado,String fecha
                ped=new Pedido(rpta.getInt("idePed"),rpta.getString("nomPed"),rpta.getInt("nroMesPed"),rpta.getInt("ideEmp"),rpta.getInt("estado"),
                        rpta.getString("fecHorPed"));
            }
            return ped;
        } catch (SQLException ex) {
            return ped;
        }
        
    }
    public Pedido getPedido(int idePe){
        Pedido ped=null;
        String sql="SELECT * FROM Pedido where idePed="+idePe+";";
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try {
            while(rpta.next()){
                //int ideped, String nomPed, int nuroMesPed, int ideEmp, int estado,String fecha
                ped=new Pedido(rpta.getInt("idePed"),rpta.getString("nomPed"),rpta.getInt("nroMesPed"),rpta.getInt("ideEmp"),rpta.getInt("estado"),
                        rpta.getString("fecHorPed"));
            }
            return ped;
        } catch (SQLException ex) {
            return ped;
        }
    }
    public ArrayList<Pedido> getPedidoFecha(String fecha){
        String sql="SELECT * FROM Pedido where fecHorPed like '"+fecha+"%';";
        ArrayList<Pedido> listpedidos=new ArrayList<Pedido>();
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try {
            while(rpta.next()){
                //int ideped, String nomPed, int nuroMesPed, int ideEmp, int estado,String fecha
                Pedido pedido=new Pedido(rpta.getInt("idePed"),rpta.getString("nomPed"),rpta.getInt("nroMesPed"),rpta.getInt("ideEmp"),rpta.getInt("estado"),
                        rpta.getString("fecHorPed"));
                listpedidos.add(pedido);
            }
            return listpedidos;
        } catch (SQLException ex) {
            return listpedidos;
        }
    }
    public ArrayList<Pedido> getPedidoFechaPendientes(String fecha){
        String sql="SELECT * FROM Pedido where fecHorPed like '"+fecha+"%' and estado=0;";
        ArrayList<Pedido> listpedidos=new ArrayList<Pedido>();
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try {
            while(rpta.next()){
                //int ideped, String nomPed, int nuroMesPed, int ideEmp, int estado,String fecha
                Pedido pedido=new Pedido(rpta.getInt("idePed"),rpta.getString("nomPed"),rpta.getInt("nroMesPed"),rpta.getInt("ideEmp"),rpta.getInt("estado"),
                        rpta.getString("fecHorPed"));
                listpedidos.add(pedido);
            }
            return listpedidos;
        } catch (SQLException ex) {
            return listpedidos;
        }
    }
    public void setPedido(Pedido pedido){
        this.pedido=pedido;
    }
    public void insertarDetalle(int idePed,ItemPedido item){
        String sql="insert into DetalleDelPedido values("+item.getIdeItm()+","+idePed+","+item.getCantidad()+
                ",'"+item.getDesItm()+"',"+item.getTotal()+")";
        bd.insertar(sql);
    }
    public ItemPedido getDetallePedidoItem(int idePed, int ideItem){
        String sql="select dp.*,i.preItm from DetalleDelPedido dp inner join Item i on dp.ideItm=i.ideItm"
                + " where dp.idePed="+idePed +" and dp.ideItm="+ideItem+";";
        ItemPedido item=null;
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        try{
            while(rpta.next()){
                item=new ItemPedido(rpta.getInt("ideItm"),rpta.getString("nomItm"),rpta.getInt("cntDetPed"),
                        rpta.getDouble("preItm"),rpta.getDouble("total"));
            }
            return item;
        }
        catch(SQLException ex){
            return item;
        }
    }
    public void actualizarDetalleDelPedido(int idePed,ItemPedido item){
        String sql="update DetalleDelPedido set cntDetPed="+item.getCantidad()+
                ",total="+item.getTotal()+" where idePed="+idePed +" and ideItm="+item.getIdeItm();
        try{
            bd.insertar(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar la base de datos");
        }
    }
    public ArrayList<ItemPedido> getDetallePedido(int id){
        String sql="select* from DetalleDelPedido where idePed="+id;
        ArrayList<ItemPedido> listitems=new ArrayList<ItemPedido>();
        bd.consulta(sql);
        ResultSet rpta=bd.getRespuesta();
        ItemLogic il=new ItemLogic();
        try{
            while(rpta.next()){
                double precio=il.getItemsCode(String.valueOf(rpta.getInt("ideItm"))).get(0).getPreItm();
                ItemPedido item=new ItemPedido(rpta.getInt("ideItm"),rpta.getString("nomItm"),rpta.getInt("cntDetPed"),
                        precio,rpta.getDouble("total"));
                listitems.add(item);
            }
            return listitems;
        }
        catch(SQLException ex){
            return listitems;
        }
        
    }
    public void actualizarEstadoPedido(int idPed,boolean estado){
        String sql="update Pedido set estado="+estado+" where idePed="+idPed+";";
        bd.insertar(sql);
    }
    public void eliminarPedido(int idePed){
        String sql="delete from  DetalleDelPedido where idePed="+idePed;
        String sql2="delete from Pedido where idePed="+idePed;
        try{
            bd.insertar(sql);
            bd.insertar(sql2);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Error al borrar detalles");
        }
    }

}
