/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pojo.ItemPedido;
/**
 *
 * @author geank
 */
public class CustomTableModel extends AbstractTableModel{
    private ArrayList<ItemPedido> registros = new ArrayList();
    private String columnas[] = {"codigo","nombre","unidades","precio","total"};
    public CustomTableModel(){
        super();
    }
    public int getColumnCount() {
        return columnas.length;
    }

    public int getRowCount() {
        return registros.size();
    } 
    public Object getValueAt(int rowIndex, int columnIndex){
        ItemPedido item = registros.get(rowIndex);
        switch(columnIndex){
            case 0:
                return item.getIdeItm();
            case 1:
                return item.getDesItm();
            case 2:
                return item.getCantidad();
            case 3:
                return item.getPrecio();
            case 4:
                return  item.getTotal();
            default:
                return null;
        } 
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ItemPedido item = registros.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                item.setIdeItm((Integer)aValue);
            case 1:
                item.setDesItm(aValue.toString());
            case 2:
                // Si la columna es "CANTIDAD", se actualiza el precio total automaticamente.
                int nuevaCantidad = Integer.valueOf(aValue.toString());
                item.setCantidad(nuevaCantidad);
                item.setTotal(item.getPrecio()*nuevaCantidad);
            case 3:
                item.getPrecio();
            case 4:
                item.getTotal();
        }
        // Disparamos el Evento TableDataChanged (La tabla ha cambiado)
        fireTableDataChanged();

    } 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return false;
            case 1:return false;
            case 2:return true;
            case 3:return false;        
            case 4:return false;    
            default: return true;
        }
        //return true;
    }
    
    

    public void setProducto(ItemPedido item){
        registros.add(item);
        fireTableDataChanged();
    } 
    public void removeRow(int row){
        registros.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
}
