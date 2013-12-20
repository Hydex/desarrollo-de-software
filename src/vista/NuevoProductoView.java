/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.ItemLogic;
import pojo.Item;
/**
 *
 * @author geank
 */
public class NuevoProductoView extends javax.swing.JPanel {

    /**
     * Creates new form NuevoProductoView
     */
    public boolean presionButtonSave;
    ItemLogic itemlogic=new ItemLogic();
    Item itemvar;
    public NuevoProductoView() {
        initComponents();
        inicializarComboBox();
    }
    public void inicializarComboBox(){
        ArrayList<String> list=itemlogic.getTiposItemAll();
        for(String str:list){
            comboTipoItem.addItem(str);
        }
    }
    public void setItemVar(Item item){
        itemvar=item;
    }
    public Item getItem(){
        return itemvar;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        comboTipoItem = new javax.swing.JComboBox();
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textDescuento = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        habilitar = new javax.swing.JCheckBox();

        jLabel1.setText("Nombre Item: ");

        jLabel2.setText("Precio Item: ");

        jLabel3.setText("Descuento:");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        habilitar.setText("habilitar");
        habilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboTipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(textNombre)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(textDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(habilitar)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(habilitar))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnSave))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarActionPerformed
        // TODO add your handling code here:
        if(habilitar.isSelected()){
            textDescuento.enable(true);
        }
        else{
            textDescuento.enable(false);
        }
    }//GEN-LAST:event_habilitarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try{
            if(textDescuento.getText().isEmpty() && textNombre.getText().isEmpty() 
                    && textPrecio.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
                return;
            }
            String select=(String)comboTipoItem.getSelectedItem();
            String copy=select;
            select=select.substring(0,select.indexOf(" "));
            //JOptionPane.showMessageDialog(null,select);
            Item item=new Item(Integer.parseInt(itemlogic.nextIdeItm()),Integer.parseInt(select),textNombre.getText(),Double.parseDouble( textPrecio.getText()));
            item.setNomIdeItm(copy.substring(copy.indexOf(" ")+1));
            setItemVar(item);
            itemlogic.insertItem(item);
            JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            presionButtonSave=true;
            JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
            frame.getWindowListeners()[0].windowClosing(null);//
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error al guardar");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
            presionButtonSave=false;
            JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
            frame.getWindowListeners()[0].windowClosing(null);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboTipoItem;
    private javax.swing.JCheckBox habilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField textDescuento;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}