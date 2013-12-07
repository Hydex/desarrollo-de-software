/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import modelo.EmpleadoLogic;
import pojo.Empleado;
import pojo.Pedido;
import modelo.PedidoLogic;
import pojo.ItemPedido;
/**
 *
 * @author geank
 */
public class VentasView extends javax.swing.JPanel {

    /**
     * Creates new form VentasView
     */
    JFrame frame;
    AddProductView apv;
    AddPedidoView apedv;
    
    EmpleadoLogic empleadologic;
    PedidoLogic pedidologic;
    Empleado empleado;
    int count;
    public VentasView() {
        empleadologic= new EmpleadoLogic();
        pedidologic=new PedidoLogic();
        empleado=empleadologic.getEmpleado(1);
        initComponents();
        codUserLabel.setText(String.valueOf(empleado.getIdEmp()));
        nombreUserLabel.setText(String.valueOf(empleado.getNomEmp()));
        iniButtons();
        Date ahora = new Date();
        dateChooser.setDate(ahora);
        
        Date dt=dateChooser.getDate();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(dt);
        iniTabla(currentTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidoTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        fechaButton = new javax.swing.JButton();
        userPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codUserLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUserLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cargoUserLabel = new javax.swing.JLabel();

        contentPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contentPanel.setName("contentPanel"); // NOI18N

        optionPanel.setName("optionPanel"); // NOI18N

        addButton.setText("Agregar");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton.setName("addButton"); // NOI18N
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Eliminar");
        deleteButton.setName("deleteButton"); // NOI18N

        editButton.setText("Editar");
        editButton.setName("editButton"); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        sellButton.setText("Venta");
        sellButton.setName("sellButton"); // NOI18N
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sellButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.setName("tablePanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        pedidoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Num. Pedido", "Cliente", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel4.setText("Lista de pedidos:");
        jLabel4.setName("jLabel4"); // NOI18N

        dateChooser.setName("dateChooser"); // NOI18N

        fechaButton.setText("Ir");
        fechaButton.setName("fechaButton"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fechaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void iniButtons(){
        ImageIcon[] iconos={new ImageIcon("icons/add.jpeg"),
            new ImageIcon("icons/delete.jpeg"),new ImageIcon("icons/edit.jpeg"),
            new ImageIcon("icons/sell.jpeg")};
        addButton.setIcon(iconos[0]);
        deleteButton.setIcon(iconos[1]);
        editButton.setIcon(iconos[2]);
        sellButton.setIcon(iconos[3]);
    }
    private void iniTabla(String fecha){
        ArrayList<Pedido> listapedido=pedidologic.getPedidoFecha(fecha);
        DefaultTableModel temp =(DefaultTableModel) pedidoTable.getModel();
        
        for(Pedido pedido: listapedido){
            String estado;
            if(pedido.getEstado()==0)
                estado="pendiente";
            else estado="realizado";
            Object temps[]={new Boolean(false),pedido.getIdeped(),pedido.getNomPed(),estado};
            temp.addRow(temps);
        }
        pedidoTable.setModel(temp);
        
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        apedv=new AddPedidoView();
        apedv.setEmpleado(empleado);
        
        final JFrame frameNewPedido=new JFrame();
        frameNewPedido.setContentPane(apedv);
        frameNewPedido.setVisible(true);
        frameNewPedido.setSize(780,500);
        
        frame=(JFrame)SwingUtilities.getAncestorOfClass(JFrame.class,this);
        frame.setEnabled(false);
        
        frameNewPedido.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    frame.setEnabled(true);
                    actualizarTabla();
                    frameNewPedido.dispose();
                }
        });
        /**/
    }//GEN-LAST:event_addButtonActionPerformed
    public void actualizarTabla(){
        if(apedv.cerrar)return;
        Pedido pedido=pedidologic.getUltimoPedido();
        DefaultTableModel temp =(DefaultTableModel) pedidoTable.getModel();
        String estado;
        if(pedido.getEstado()==0)
            estado="pendiente";
        else estado="realizado";
        Object[] fila={new Boolean(false),pedido.getIdeped(),pedido.getNomPed(),estado};
        temp.addRow(fila);
        pedidoTable.setModel(temp);
        count++;
    }
    public void actualizarDato(){
        String msm=apv.mostrar();
        System.out.println(msm);
    }
    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        // TODO add your handling code here:
        //RealizarVentaView rvv=new RealizarVentaView();
        //rvv.setVisible(true);
        
    }//GEN-LAST:event_sellButtonActionPerformed

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_addButtonMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)pedidoTable.getModel();
        int row=pedidoTable.getSelectedRow();
        boolean avanzar=true;
        if(row==-1)
            avanzar=false;
        else{
            int idePed=(Integer)model.getValueAt(row,1);
            apedv=new AddPedidoView();
            apedv.setEmpleado(empleado); 
            apedv.isUpdate=true;
            Pedido pedidoa=pedidologic.getPedido(idePed);
            ArrayList<ItemPedido> listitems=pedidologic.getDetallePedido(idePed);
            apedv.actualizarTablaPedido(listitems,pedidoa.getNomPed(),String.valueOf(pedidoa.getNuroMesPed()));
            final JFrame frameNewPedido=new JFrame();
            frameNewPedido.setContentPane(apedv);
            frameNewPedido.setVisible(true);
            frameNewPedido.setSize(780,500);
            frame=(JFrame)SwingUtilities.getAncestorOfClass(JFrame.class,this);
            frame.setEnabled(false);
            frameNewPedido.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent we){
                        frame.setEnabled(true);
                        actualizarTabla();
                        frameNewPedido.dispose();
                    }
            });   
        }
    }//GEN-LAST:event_editButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel cargoUserLabel;
    private javax.swing.JLabel codUserLabel;
    private javax.swing.JPanel contentPanel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton fechaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreUserLabel;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JTable pedidoTable;
    private javax.swing.JButton sellButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
