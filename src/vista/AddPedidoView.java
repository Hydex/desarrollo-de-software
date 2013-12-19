/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import pojo.Item;
import pojo.ItemPedido;
import pojo.Pedido;
import modelo.PedidoLogic;
import pojo.Empleado;
/**
 *
 * @author geank
 */
public class AddPedidoView extends javax.swing.JPanel {

    /**
     * Creates new form AddPedidoView
     */
 JFrame frame;
    AddProductView apv;
    PedidoLogic pedidologic;
    Empleado empleado =new Empleado(1);
    public boolean isUpdate=false;
    public boolean presionButtonSave;
    public AddPedidoView() {
        pedidologic=new PedidoLogic();
        initComponents();
        iniButtons();
        inicializarTabla();
        
    }
    public void iniButtons(){
        ImageIcon[] iconos={new ImageIcon("icons/add.jpeg"),
            new ImageIcon("icons/delete.jpeg"),new ImageIcon("icons/edit.jpeg")};
        addButton.setIcon(iconos[0]);
        deleteButton.setIcon(iconos[1]);
        saveButton.setIcon(iconos[2]);
        //ImageIcon icono1=new ImageIcon("icons/delete.jpeg");
        //addButton.setIcon(icono1);
        //deleteButton.setIcon(icono1);
    }
    private void opcionTabla(){
        pedidoTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "ProjSave");
        pedidoTable.getActionMap().put("ProjSave", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tecla F2 presionada");
            }
        });
        
    }
    public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
        codUserLabel.setText(String.valueOf(empleado.getIdEmp()));
        nombreUserLabel.setText(String.valueOf(empleado.getNomEmp()));
    }
    private void inicializarTabla(){
        
        CustomTableModel tablemodel= new CustomTableModel();
        pedidoTable.setModel(tablemodel);
        
        JTableHeader th=pedidoTable.getTableHeader();
        TableColumnModel tcm=th.getColumnModel();
        TableColumn tc=tcm.getColumn(0);
        tc.setHeaderValue("Cod. Prod");
        tc=tcm.getColumn(1);
        tc.setHeaderValue("Nombre");
        tc=tcm.getColumn(2);
        tc.setHeaderValue("Unidades");
        tc=tcm.getColumn(3);
        tc.setHeaderValue("Precio");
        tc=tcm.getColumn(4);
        tc.setHeaderValue("Total");
        
        th.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codUserLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cargoUserLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidoTable = new javax.swing.JTable();
        clientePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numPedLabel = new javax.swing.JLabel();
        clienteText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        editMesa = new javax.swing.JTextField();

        mainPanel.setName("mainPanel"); // NOI18N

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        contentPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contentPanel.setName("contentPanel"); // NOI18N

        optionPanel.setName("optionPanel"); // NOI18N

        addButton.setText("Agregar");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton.setName("addButton"); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Eliminar");
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Guardar");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.setName("salirButton"); // NOI18N
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablePanel.setName("tablePanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        pedidoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Prod", "Nombre", "Unidades", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedidoTable.setName("pedidoTable"); // NOI18N
        jScrollPane1.setViewportView(pedidoTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        clientePanel.setName("clientePanel"); // NOI18N

        jLabel4.setText("N° Pedido:");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Cliente:");
        jLabel5.setName("jLabel5"); // NOI18N

        numPedLabel.setText("#####");
        numPedLabel.setName("numPedLabel"); // NOI18N

        clienteText.setName("clienteText"); // NOI18N
        clienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteTextActionPerformed(evt);
            }
        });

        jLabel6.setText("Mesa");
        jLabel6.setName("jLabel6"); // NOI18N

        editMesa.setName("editMesa"); // NOI18N
        editMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(numPedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clienteText, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(editMesa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(clienteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(editMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addComponent(clientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        apv=new AddProductView();
        apv.setEmpleado(empleado);
        final JFrame newframeProduct=new JFrame();
        newframeProduct.setContentPane(apv);
        newframeProduct.setVisible(true);
        newframeProduct.setSize(600,500);
        
        frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
        frame.setVisible(false);
        
      
        
        newframeProduct.setDefaultCloseOperation (WindowConstants.DO_NOTHING_ON_CLOSE);

        newframeProduct.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    frame.setVisible(true);
                    if(apv.presionButtonSave){
                        actualizarTabla();
                    }
                    newframeProduct.dispose();
                }
        });
    }//GEN-LAST:event_addButtonActionPerformed

    private void editMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMesaActionPerformed

    private void clienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteTextActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        presionButtonSave=true;
        if(!isUpdate){
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            Pedido pedido=new Pedido(clienteText.getText(),Integer.parseInt(editMesa.getText()),
                    Integer.parseInt(codUserLabel.getText()),0,currentTime);
            System.out.println("mierdadadsdfsafsd");
            pedidologic.setPedido(pedido);  
            pedidologic.guardarBD();
            pedido=null;
            pedido=pedidologic.getUltimoPedido();
            System.out.println("Este es el id de empleado: "+pedido.getIdeEmp());
            ArrayList<ItemPedido> itemsp=getListItemPedidos();
            for(ItemPedido item: itemsp){
                pedidologic.insertarDetalle(pedido.getIdeped(), item);
            }
            JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
            frame.getWindowListeners()[0].windowClosing(null);//
        }
        else{
            //eliminar todos los registros en la tabla y volverlos a insertar mas los nuevos;
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        // TODO add your handling code here:
       JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
       frame.getWindowListeners()[0].windowClosing(null);//
    }//GEN-LAST:event_salirButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int row=pedidoTable.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(null,"debe seleccionar una tabla");
        }
        else{
            CustomTableModel tablemodel=(CustomTableModel)pedidoTable.getModel();
            
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    public void actualizarElemento(){
        String nombre=apv.getTexto();
        //clientLabel.setText(nombre);
    }
    //public Pedido getPedido(){}
    public void actualizarTabla(){
        ArrayList<Item> listitem=apv.getListaItems();
        CustomTableModel temp =(CustomTableModel) pedidoTable.getModel();
        for(Item item:listitem){
            ItemPedido ipedido=new ItemPedido();
            
            ipedido.setIdeItm(item.getIdeItm());
            ipedido.setDesItm(item.getDesItm());
            ipedido.setCantidad(1);
            ipedido.setPrecio(item.getPreItm());
            ipedido.setTotal(item.getPreItm());
            temp.setProducto(ipedido);
        }
        pedidoTable.setModel(temp);
    }
    public void actualizarTablaPedido(ArrayList<ItemPedido> lista,String nombre,String numMes){
        editMesa.setText(numMes);
        clienteText.setText(nombre);
        CustomTableModel temp =(CustomTableModel) pedidoTable.getModel();
        for(ItemPedido ipedido:lista){
            temp.setProducto(ipedido);
        }
        pedidoTable.setModel(temp);
    }
    public ArrayList<ItemPedido> getListItemPedidos(){
        ArrayList<ItemPedido> listitem=new ArrayList<ItemPedido>();
        CustomTableModel model =(CustomTableModel) pedidoTable.getModel();
        int numfilas=model.getRowCount();
        for(int i=0;i<numfilas;i++){
            model.getValueAt(i,0);
            ItemPedido item=new ItemPedido((Integer)model.getValueAt(i,0),(String)model.getValueAt(i,1),
                    (Integer)model.getValueAt(i,2),(Double)model.getValueAt(i,3),(Double)model.getValueAt(i,4));
            listitem.add(item);
        }
        return listitem;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel cargoUserLabel;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JTextField clienteText;
    private javax.swing.JLabel codUserLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField editMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nombreUserLabel;
    private javax.swing.JLabel numPedLabel;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JTable pedidoTable;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
