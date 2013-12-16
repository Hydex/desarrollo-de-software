/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.Factura;
import modelo.FacturaLogic;
/**
 *
 * @author geank
 */
public class CajaView extends javax.swing.JPanel {

    /**
     * Creates new form CajaView
     */
    Factura factura=new Factura();
    FacturaLogic facturaLogic=new FacturaLogic();
    public CajaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPricipal = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facturaTable = new javax.swing.JTable();
        panelFEcha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        panelOpciones = new javax.swing.JPanel();
        salirButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        PanelPricipal.setName("PanelPricipal"); // NOI18N

        panelTabla.setName("panelTabla"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        facturaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Tipo Pago", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        facturaTable.setName("facturaTable"); // NOI18N
        jScrollPane1.setViewportView(facturaTable);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelFEcha.setName("panelFEcha"); // NOI18N

        jLabel1.setText("Buscar por fecha:");
        jLabel1.setName("jLabel1"); // NOI18N

        dateChooser.setName("dateChooser"); // NOI18N

        jButton1.setText("buscar");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFEchaLayout = new javax.swing.GroupLayout(panelFEcha);
        panelFEcha.setLayout(panelFEchaLayout);
        panelFEchaLayout.setHorizontalGroup(
            panelFEchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFEchaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFEchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFEchaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFEchaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        panelFEchaLayout.setVerticalGroup(
            panelFEchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFEchaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFEchaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelOpciones.setName("panelOpciones"); // NOI18N

        salirButton.setText("Salir");
        salirButton.setName("salirButton"); // NOI18N

        eliminarButton.setText("Eliminar");
        eliminarButton.setName("eliminarButton"); // NOI18N
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(eliminarButton)
                .addGap(18, 18, 18)
                .addComponent(salirButton))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(eliminarButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPricipalLayout = new javax.swing.GroupLayout(PanelPricipal);
        PanelPricipal.setLayout(PanelPricipalLayout);
        PanelPricipalLayout.setHorizontalGroup(
            PanelPricipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPricipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPricipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelFEcha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelPricipalLayout.setVerticalGroup(
            PanelPricipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPricipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFEcha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPricipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPricipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void actualizarTabla(ArrayList<Factura> listpedido){
        DefaultTableModel model = (DefaultTableModel) facturaTable.getModel();
        for(Factura fact: listpedido){
            String tipoPago =fact.isTipPagFac()?"Efectivo":"Targeta";
            Object temp[]={fact.getNroFac(),tipoPago,fact.getFechaEmision(),fact.getTotal()};
            model.addRow(temp);
        }
        facturaTable.setModel(model);
    }
    private void limpiarTabla(){
        //resultTable.remove//
        DefaultTableModel modelo=(DefaultTableModel)facturaTable.getModel();
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Factura> listfact=facturaLogic.getFactura(sdf.format(dateChooser.getDate()));
        limpiarTabla();
        actualizarTabla(listfact);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model=(DefaultTableModel)facturaTable.getModel();
        int row=facturaTable.getSelectedRow();
        if(row==-1)
            JOptionPane.showMessageDialog(null, "Debe seleccionar una factura");
        else{
            String num=(String)model.getValueAt(row,0);
            facturaLogic.cambiarEstadoFacura(num);
            limpiarTabla();
            jButton1.doClick();
        }
        
    }//GEN-LAST:event_eliminarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPricipal;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JTable facturaTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFEcha;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
