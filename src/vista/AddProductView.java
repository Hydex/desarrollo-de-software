/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
//import modelo.ItemLogic;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import modelo.ItemLogic;
import pojo.Empleado;
import pojo.Item;
/**
 *
 * @author geank
 */
public class AddProductView extends javax.swing.JPanel {

    /**
     * Creates new form AddProductView
     */
    ItemLogic itemlogic;
    TextAutoCompleter textAutoAcompleter;
    String texto;
    ArrayList<Item>listaitems=new ArrayList<Item>();
    public boolean presionButtonSave;
    Empleado empleado;
    public AddProductView() {
        initComponents();
        itemlogic= new ItemLogic();
        textAutoAcompleter = new TextAutoCompleter(nameEdit);
        inicializarTipoBox();
        inicializarAutoCompleter();
        //cargarTabla();
    }
    public String mostrar(){
        return this.nameEdit.getText();
    }
    protected void inicializarAutoCompleter(){
        ArrayList<String> lista=itemlogic.getItemNames();
        for(String des:lista){
            textAutoAcompleter.addItem(des);
        }
    }
    protected void inicializarTipoBox(){
        //itemlogic.getTiposItem();
        ArrayList<String> lista=itemlogic.getTiposItem();
        for(String tipo:lista){
            tipoBox.addItem(tipo);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codUserLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cargoUserLabel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codEdit = new javax.swing.JTextField();
        nameEdit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        priceEdit = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        tipoBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        producPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        userPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userPanel.setName("userPanel"); // NOI18N

        jLabel1.setText("Usuario:");
        jLabel1.setName("jLabel1"); // NOI18N

        codUserLabel.setBackground(new java.awt.Color(130, 125, 193));
        codUserLabel.setText("Usuario 1");
        codUserLabel.setName("codUserLabel"); // NOI18N

        jLabel3.setText("Nombre:");
        jLabel3.setName("jLabel3"); // NOI18N

        nombreUserLabel.setText("usuario nombre");
        nombreUserLabel.setName("nombreUserLabel"); // NOI18N

        jLabel2.setText("Cargo:");
        jLabel2.setName("jLabel2"); // NOI18N

        cargoUserLabel.setText("Admin/Vendedor");
        cargoUserLabel.setName("cargoUserLabel"); // NOI18N

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(codUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreUserLabel)))
                .addGap(58, 58, 58)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargoUserLabel)
                    .addComponent(jLabel2))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codUserLabel)
                    .addComponent(nombreUserLabel)
                    .addComponent(cargoUserLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchPanel.setName("searchPanel"); // NOI18N

        jLabel4.setText("Codigo:");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Nombre:");
        jLabel5.setName("jLabel5"); // NOI18N

        codEdit.setName("codEdit"); // NOI18N

        nameEdit.setName("nameEdit"); // NOI18N
        nameEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameEditKeyReleased(evt);
            }
        });

        jLabel6.setText("Precio:");
        jLabel6.setName("jLabel6"); // NOI18N

        priceEdit.setName("priceEdit"); // NOI18N

        buscarButton.setText("Buscar");
        buscarButton.setName("buscarButton"); // NOI18N
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        tipoBox.setName("tipoBox"); // NOI18N

        jLabel7.setText("Tipo:");
        jLabel7.setName("jLabel7"); // NOI18N

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(codEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameEdit)))
                .addGap(46, 46, 46)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoBox, 0, 146, Short.MAX_VALUE)
                    .addComponent(priceEdit))
                .addGap(18, 18, 18)
                .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buscarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(codEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(priceEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(nameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        producPanel.setName("producPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nombre", "Precio", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.setName("resultTable"); // NOI18N
        jScrollPane1.setViewportView(resultTable);

        addButton.setText("Agregar");
        addButton.setName("addButton"); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Salir");
        exitButton.setName("exitButton"); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout producPanelLayout = new javax.swing.GroupLayout(producPanel);
        producPanel.setLayout(producPanelLayout);
        producPanelLayout.setHorizontalGroup(
            producPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, producPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, producPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );
        producPanelLayout.setVerticalGroup(
            producPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(producPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(producPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(producPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(producPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
      JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
      frame.getWindowListeners()[0].windowClosing(null);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        ArrayList<Item> listitems=null;
        if(codEdit.getText().isEmpty() && priceEdit.getText().isEmpty()){
            String tipo=(String) tipoBox.getItemAt(tipoBox.getSelectedIndex());
            listitems=itemlogic.getItemsTipo(tipo);
        }
        else if(!codEdit.getText().isEmpty()){
            listitems=itemlogic.getItemsCode(codEdit.getText());
        }
        else {
            listitems=itemlogic.getItemsPrice(priceEdit.getText());
        }
        cargarTabla(listitems);
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void nameEditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameEditKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ArrayList<Item> listitems=itemlogic.getItemsDescripcion(nameEdit.getText());
            limpiarTabla();
            cargarTabla(listitems);
        }
    }//GEN-LAST:event_nameEditKeyReleased

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        //texto=nameEdit.getText();
        presionButtonSave=true;
        JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
        frame.getWindowListeners()[0].windowClosing(null);//
    }//GEN-LAST:event_addButtonActionPerformed
    public String getTexto(){
        return nameEdit.getText();
    }
    public ArrayList<Item> getListaItems(){
        //this.listaitems;
        DefaultTableModel modelo =(DefaultTableModel) resultTable.getModel();
        int numFila=modelo.getRowCount();
        for(int i=0;i<numFila;i++){
            if((Boolean)modelo.getValueAt(i,3)==true){
                Item item=new Item((Integer)modelo.getValueAt(i,0),(String)modelo.getValueAt(i, 1),
                        (Double)modelo.getValueAt(i,2));
                this.listaitems.add(item);
            }
        }
       
        return this.listaitems;
    }
    private void cargarTabla(ArrayList<Item> items){
        //int size=items.size();
        DefaultTableModel temp =(DefaultTableModel) resultTable.getModel();
        for(Item item:items){
            Object[] fila={item.getIdeItm(),item.getDesItm(),item.getPreItm(),new Boolean(false)};
            temp.addRow(fila);
        }
        resultTable.setModel(temp);
    }
    private void limpiarTabla(){
        //resultTable.remove//
        DefaultTableModel modelo=(DefaultTableModel)resultTable.getModel();
        try{
            int filas=modelo.getRowCount();
            System.out.println("numero de filas: "+filas);
            for(int i=0;i<filas;i++)
                modelo.removeRow(0);
        }
        catch(Exception e){
            System.out.println("Este es el error: "+e.getMessage());
            JOptionPane.showMessageDialog(null,"Error al limpiar la tabla");
        }
    }
     public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
        codUserLabel.setText(String.valueOf(empleado.getIdEmp()));
        nombreUserLabel.setText(String.valueOf(empleado.getNomEmp()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JLabel cargoUserLabel;
    private javax.swing.JTextField codEdit;
    private javax.swing.JLabel codUserLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameEdit;
    private javax.swing.JLabel nombreUserLabel;
    private javax.swing.JTextField priceEdit;
    private javax.swing.JPanel producPanel;
    private javax.swing.JTable resultTable;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JComboBox tipoBox;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
