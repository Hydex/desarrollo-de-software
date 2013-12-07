/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.Item;
/**
 *
 * @author geank
 */
public class ItemLogic extends SistemaLogico{
    
    public ItemLogic(){
        super();
    }
    @Override
    public void guardarBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<String> getItemNames(){
        String sql="select desItm from Item where 1";
        ArrayList<String> listNames=new ArrayList<String>();            
        this.bd.consulta(sql);
        ResultSet rpta=this.bd.getRespuesta();
        try{
            while(rpta.next()){
                listNames.add(rpta.getString("desItm"));
            }
            return listNames;
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listNames;
        }
    }
    public ArrayList<String> getTiposItem(){
        String sql="select* from TipoItem where 1";
        ArrayList<String> listTipos=new ArrayList<String>();            
        this.bd.consulta(sql);
        ResultSet result= bd.getRespuesta();
        try{
            while(result.next()){
                listTipos.add(result.getString("desTipItm"));
            }
            return listTipos;
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listTipos;
        }
        
    }
    public ArrayList<Item> getItemsDescripcion(String nombre){
        String sql="select* from Item where desItm like '"+nombre+"%'";
        ArrayList<Item> listItems=new ArrayList<Item>();            
        this.bd.consulta(sql);
        ResultSet rpta=this.bd.getRespuesta();
        try{
            while(rpta.next()){
                Item item=new Item(rpta.getInt("ideItm"),rpta.getInt("ideTipItm"),
                        rpta.getString("desItm"),rpta.getDouble("preItm"));
                listItems.add(item);
                
            }
            return listItems;
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listItems;
        }
    }
    public ArrayList<Item>getItemsPrice(String price){
        String sql="select* from Item where preItm="+price;
        ArrayList<Item> listItems=new ArrayList<Item>();            
        this.bd.consulta(sql);
        ResultSet rpta=this.bd.getRespuesta();
        try{
            while(rpta.next()){
                Item item=new Item(rpta.getInt("ideItm"),rpta.getInt("ideTipItm"),
                        rpta.getString("desItm"),rpta.getDouble("preItm"));
                listItems.add(item);
                
            }
            return listItems;
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listItems;
        }
    }
    public ArrayList<Item> getItemsCode(String cod){
        String sql="select* from Item where ideItm="+cod;
        ArrayList<Item> listItems=new ArrayList<Item>();            
        this.bd.consulta(sql);
        ResultSet rpta=this.bd.getRespuesta();
        try{
            while(rpta.next()){
                Item item=new Item(rpta.getInt("ideItm"),rpta.getInt("ideTipItm"),
                        rpta.getString("desItm"),rpta.getDouble("preItm"));
                listItems.add(item);
                
            }
            return listItems;
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listItems;
        }
    }
    public ArrayList<Item> getItemsTipo(String tipo){
        String sql1="select ideTipItm from TipoItem where desTipItm='"+tipo+"'";
        this.bd.consulta(sql1);
        ResultSet rpta=this.bd.getRespuesta();
        int ideTipItm=0;
        try{
            while(rpta.next()){
                ideTipItm=rpta.getInt("ideTipItm");
            }
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
        }
        rpta=null;
        
        String sql="select* from Item where ideTipItm="+ideTipItm;
        ArrayList<Item> listItems=new ArrayList<Item>();            
        this.bd.consulta(sql);
        rpta=this.bd.getRespuesta();
        try{
            while(rpta.next()){
                Item item=new Item(rpta.getInt("ideItm"),rpta.getInt("ideTipItm"),
                        rpta.getString("desItm"),rpta.getDouble("preItm"));
                listItems.add(item);
                
            }
            return listItems;
        }catch(SQLException sqle){
            System.out.println(sqle.toString());
            return listItems;
        }
    }
}
