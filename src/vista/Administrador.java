/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Administrador.java
 *
 * Created on 12-dic-2011, 14:48:08
 */
package vista;

import modelo.ConexionAux;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alison
 */
public class Administrador extends javax.swing.JPanel {

    /** Creates new form Administrador */
    public Administrador() {
        initComponents();
        this.llenar_tabla();
        this.llenar_tabla_Terminal();
    }
    
    
   private void llenar_lista()
            {
      ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
       Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
     try {

 modelo.ConexionAux conex=new modelo.ConexionAux();//Para ejecutar la consulta
 Statement s = conex.conectar();

 ResultSet rs = s.executeQuery("select desCar from Cargos");////////////En vez de Contraseña deberia de ser apellido  nombres

        while (rs.next() ==true)
        {
            
                 String temp;//=rs.();
                 temp=rs.getString(1);
                 palabras1.add(temp);
                 //System.out.println(rs);

        }
        
        jList1.setListData(palabras1);
 

 rs.close();
 //conexion.class.close();
} catch (Exception ex) {
 ex.printStackTrace();
}
      //jList1.setListData();
}
    private void llenar_lista_modificar()
            {
      ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
      Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
     try {

 modelo.ConexionAux conex=new modelo.ConexionAux();//Para ejecutar la consulta
 Statement s = conex.conectar();

 ResultSet rs = s.executeQuery("select desCar from Cargos");////////////En vez de Contraseña deberia de ser apellido  nombres

        while (rs.next() ==true)
        {
            
                 String temp;//=rs.();
                 temp=rs.getString(1);
                 palabras1.add(temp);
                 //System.out.println(rs);

        }
        
        jList1.setListData(palabras1);
 

 rs.close();
 //conexion.class.close();
} catch (Exception ex) {
 ex.printStackTrace();
}
      //jList1.setListData();
}
   private String generar_Nivel_Acceso(){
       String nivel="0";
       
       for(int i=0;i<palabras2.size();i++){
           
               if(palabras2.elementAt(i).equals("Administrador"))
               nivel=nivel+"1";
              
               else if(palabras2.elementAt(i).equals("Ventas"))
                    nivel=nivel+"2";
               else if(palabras2.elementAt(i).equals("Reportes"))
               nivel=nivel+"3";
               else if(palabras2.elementAt(i).equals("Cajero"))
               nivel=nivel+"4|";
              
               else
                   nivel=nivel+"";
               
               
       }
       
   
       return nivel;
   }
    private void llenar_tabla()
            {
      ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
       Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
     try {
 //Para establecer el modelo al JTable
 DefaultTableModel modelo = new DefaultTableModel();
 this.jTable1.setModel(modelo);
 //Para conectarnos a nuestra base de datos
 modelo.ConexionAux conex=new modelo.ConexionAux();//Para ejecutar la consulta
 Statement s = conex.conectar();
 //Ejecutamos la consulta que escribimos en la caja de texto
 //y los datos lo almacenamos en un ResultSet
 ResultSet rs = s.executeQuery("select ideUsu, ideEmp,estBlqUsu,nivAccUsu from Usuario");////////////En vez de Contraseña deberia de ser apellido  nombres
 //Obteniendo la informacion de las columnas que estan siendo consultadasfa
 ResultSetMetaData rsMd = rs.getMetaData();
 //La cantidad de columnas que tiene la consulta
 int cantidadColumnas = rsMd.getColumnCount();
 //Establecer como cabezeras el nombre de las colimnas
 for (int i = 1; i <= cantidadColumnas; i++) {
  modelo.addColumn(rsMd.getColumnLabel(i));
 }
 //Creando las filas para el JTable
 while (rs.next()) {
  Object[] fila = new Object[cantidadColumnas];
  for (int i = 0; i < cantidadColumnas; i++) {
    fila[i]=rs.getObject(i+1);
  }
  modelo.addRow(fila);
 }
 rs.close();
 //conexion.class.close();
} catch (Exception ex) {
 ex.printStackTrace();
}
}
    
   
    private void llenar_tabla_Terminal()
            {
      ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
       Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
     try {
 //Para establecer el modelo al JTable
 DefaultTableModel modelo = new DefaultTableModel();
 this.jTable2.setModel(modelo);
 //Para conectarnos a nuestra base de datos
 modelo.ConexionAux conex=new modelo.ConexionAux();//Para ejecutar la consulta
 Statement s = conex.conectar();
 //Ejecutamos la consulta que escribimos en la caja de texto
 //y los datos lo almacenamos en un ResultSet
 ResultSet rs = s.executeQuery("select desTer, estBlqTer from Terminal");////////////En vez de Contraseña deberia de ser apellido  nombres
 //Obteniendo la informacion de las columnas que estan siendo consultadasfa
 ResultSetMetaData rsMd = rs.getMetaData();
 //La cantidad de columnas que tiene la consulta
 int cantidadColumnas = rsMd.getColumnCount();
 //Establecer como cabezeras el nombre de las colimnas
 for (int i = 1; i <= cantidadColumnas; i++) {
  modelo.addColumn(rsMd.getColumnLabel(i));
 }
 //Creando las filas para el JTable
 while (rs.next()) {
  Object[] fila = new Object[cantidadColumnas];
  for (int i = 0; i < cantidadColumnas; i++) {
    fila[i]=rs.getObject(i+1);
  }
  modelo.addRow(fila);
 }
 rs.close();
 //conexion.class.close();
} catch (Exception ex) {
 ex.printStackTrace();
}
}
    @SuppressWarnings("unchecked")
    
    
  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registro_Usuario = new javax.swing.JFrame();
        codigo_Empleado = new javax.swing.JTextField();
        idUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        verificarExistencia = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        contrasenia = new javax.swing.JTextField();
        oPredeterminado = new javax.swing.JRadioButton();
        oAutoGen = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        addEsp = new javax.swing.JButton();
        removeEsp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cancelarBoton = new javax.swing.JButton();
        registrarBoton = new javax.swing.JButton();
        campoNombresAp = new javax.swing.JTextField();
        campoIdSistema = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Modificar_Usuario = new javax.swing.JFrame();
        codigo_Empleado1 = new javax.swing.JTextField();
        idUsuario1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        verificarExistencia1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        contrasenia1 = new javax.swing.JTextField();
        oPredeterminado1 = new javax.swing.JRadioButton();
        oAutoGen1 = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        addEsp1 = new javax.swing.JButton();
        removeEsp1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cancelarBoton1 = new javax.swing.JButton();
        registrarBoton1 = new javax.swing.JButton();
        forzarCambioPass = new javax.swing.JCheckBox();
        Registro_Terminal = new javax.swing.JFrame();
        jLabel15 = new javax.swing.JLabel();
        nombreTerminal = new javax.swing.JTextField();
        cancelarBoton2 = new javax.swing.JButton();
        registrarBoton2 = new javax.swing.JButton();
        GEN_PASSWORD = new javax.swing.ButtonGroup();
        GEN_PASSWORD_R = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        Buscar_UsuarioBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Registar_UsuarioBoton = new javax.swing.JButton();
        Modificar_UsuarioBoton = new javax.swing.JButton();
        Bloquear_UsuarioBoton = new javax.swing.JButton();
        Eliminar_UsuarioBoton = new javax.swing.JButton();
        Desbloquear_UsuarioBoton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Bloquear_TerminalBoton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Buscar_TerminalBoton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        Registar_Terminal = new javax.swing.JButton();
        Eliminar_TerminalBoton = new javax.swing.JButton();
        Desbloquear_TerminalBoton = new javax.swing.JButton();
        trabajadorView1 = new vista.TrabajadorView();
        productosView1 = new vista.ProductosView();

        codigo_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_EmpleadoActionPerformed(evt);
            }
        });
        codigo_Empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                goto_verificar(evt);
            }
        });

        idUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI Usuario");

        jLabel2.setText("Id Usuario");

        verificarExistencia.setText("Verificar!");
        verificarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarExistenciaActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña");

        contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaActionPerformed(evt);
            }
        });

        GEN_PASSWORD_R.add(oPredeterminado);
        oPredeterminado.setText("Predeterminado");
        oPredeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oPredeterminadoActionPerformed(evt);
            }
        });

        GEN_PASSWORD_R.add(oAutoGen);
        oAutoGen.setText("Autogenerar");
        oAutoGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oAutoGenActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jScrollPane3.setViewportView(jList2);

        addEsp.setText(">>");
        addEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEspActionPerformed(evt);
            }
        });

        removeEsp.setText("<<");
        removeEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEspActionPerformed(evt);
            }
        });

        jLabel4.setText("Especialidades Disponibles");

        jLabel5.setText("Especialidades Usuario");

        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        registrarBoton.setText("Registrar");
        registrarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBotonActionPerformed(evt);
            }
        });

        campoNombresAp.setEditable(false);
        campoNombresAp.setBackground(new java.awt.Color(253, 251, 251));

        campoIdSistema.setEditable(false);

        jLabel6.setText("Nombre");

        jLabel7.setText("ID Sistema");

        javax.swing.GroupLayout Registro_UsuarioLayout = new javax.swing.GroupLayout(Registro_Usuario.getContentPane());
        Registro_Usuario.getContentPane().setLayout(Registro_UsuarioLayout);
        Registro_UsuarioLayout.setHorizontalGroup(
            Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(registrarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(52, 52, 52)
                                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                                        .addComponent(contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(oPredeterminado)
                                        .addGap(18, 18, 18)
                                        .addComponent(oAutoGen))
                                    .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(idUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoIdSistema, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoNombresAp, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Registro_UsuarioLayout.createSequentialGroup()
                                            .addComponent(codigo_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)
                                            .addComponent(verificarExistencia)))))
                            .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Registro_UsuarioLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(addEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(removeEsp, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        Registro_UsuarioLayout.setVerticalGroup(
            Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Registro_UsuarioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigo_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verificarExistencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoNombresAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oPredeterminado)
                    .addComponent(oAutoGen))
                .addGap(28, 28, 28)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Registro_UsuarioLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(addEsp)
                        .addGap(18, 18, 18)
                        .addComponent(removeEsp))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Registro_UsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Registro_UsuarioLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(Registro_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarBoton)
                    .addComponent(cancelarBoton))
                .addContainerGap())
        );

        codigo_Empleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_Empleado1ActionPerformed(evt);
            }
        });

        idUsuario1.setEditable(false);
        idUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUsuario1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Id Usuario");

        jLabel9.setText("Id Usuario");

        verificarExistencia1.setText("Buscar");
        verificarExistencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarExistencia1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Contraseña");

        contrasenia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenia1ActionPerformed(evt);
            }
        });

        GEN_PASSWORD.add(oPredeterminado1);
        oPredeterminado1.setText("Predeterminado");
        oPredeterminado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oPredeterminado1ActionPerformed(evt);
            }
        });

        GEN_PASSWORD.add(oAutoGen1);
        oAutoGen1.setText("Autogenerar");
        oAutoGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oAutoGen1ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jList3);

        jScrollPane6.setViewportView(jList4);

        addEsp1.setText(">>");
        addEsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEsp1ActionPerformed(evt);
            }
        });

        removeEsp1.setText("<<");
        removeEsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEsp1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Especialidades Disponibles");

        jLabel12.setText("Especialidades Usuario");

        cancelarBoton1.setText("Cancelar");
        cancelarBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBoton1ActionPerformed(evt);
            }
        });

        registrarBoton1.setText("Modificar");
        registrarBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBoton1ActionPerformed(evt);
            }
        });

        forzarCambioPass.setText("Forzar Cambio de Constraseña");
        forzarCambioPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forzarCambioPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Modificar_UsuarioLayout = new javax.swing.GroupLayout(Modificar_Usuario.getContentPane());
        Modificar_Usuario.getContentPane().setLayout(Modificar_UsuarioLayout);
        Modificar_UsuarioLayout.setHorizontalGroup(
            Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Modificar_UsuarioLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(forzarCambioPass)
                            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                        .addComponent(contrasenia1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(oPredeterminado1)
                                        .addGap(18, 18, 18)
                                        .addComponent(oAutoGen1))
                                    .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                        .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(idUsuario1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(codigo_Empleado1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                                        .addGap(37, 37, 37)
                                        .addComponent(verificarExistencia1))))
                            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(removeEsp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(addEsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Modificar_UsuarioLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(cancelarBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(registrarBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        Modificar_UsuarioLayout.setVerticalGroup(
            Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(codigo_Empleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verificarExistencia1))
                .addGap(25, 25, 25)
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(idUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(contrasenia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oPredeterminado1)
                    .addComponent(oAutoGen1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(forzarCambioPass)
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(addEsp1)
                        .addGap(18, 18, 18)
                        .addComponent(removeEsp1))
                    .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                        .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(7, 7, 7))
                            .addGroup(Modificar_UsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
                .addGap(27, 27, 27)
                .addGroup(Modificar_UsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBoton1)
                    .addComponent(registrarBoton1))
                .addGap(42, 42, 42))
        );

        jLabel15.setText("Nombre Terminal");

        nombreTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTerminalActionPerformed(evt);
            }
        });

        cancelarBoton2.setText("Cancelar");
        cancelarBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBoton2ActionPerformed(evt);
            }
        });

        registrarBoton2.setText("Registrar");
        registrarBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBoton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Registro_TerminalLayout = new javax.swing.GroupLayout(Registro_Terminal.getContentPane());
        Registro_Terminal.getContentPane().setLayout(Registro_TerminalLayout);
        Registro_TerminalLayout.setHorizontalGroup(
            Registro_TerminalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registro_TerminalLayout.createSequentialGroup()
                .addGroup(Registro_TerminalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Registro_TerminalLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(nombreTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Registro_TerminalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelarBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(registrarBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        Registro_TerminalLayout.setVerticalGroup(
            Registro_TerminalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registro_TerminalLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(Registro_TerminalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(28, 28, 28)
                .addGroup(Registro_TerminalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBoton2)
                    .addComponent(registrarBoton2))
                .addGap(46, 46, 46))
        );

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Enter_Buscar(evt);
            }
        });

        Buscar_UsuarioBoton.setText("Buscar");
        Buscar_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_UsuarioBotonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuarios", "Nombres y Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Registar_UsuarioBoton.setText("Registrar Usuario");
        Registar_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registar_UsuarioBotonActionPerformed(evt);
            }
        });

        Modificar_UsuarioBoton.setText("Modificar Usuario");
        Modificar_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_UsuarioBotonActionPerformed(evt);
            }
        });

        Bloquear_UsuarioBoton.setText("Bloquear Usuario");
        Bloquear_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bloquear_UsuarioBotonActionPerformed(evt);
            }
        });

        Eliminar_UsuarioBoton.setText("Eliminar Usuario");
        Eliminar_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_UsuarioBotonActionPerformed(evt);
            }
        });

        Desbloquear_UsuarioBoton.setText("Desbloquear Usuario");
        Desbloquear_UsuarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Desbloquear_UsuarioBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Eliminar_UsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Desbloquear_UsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bloquear_UsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Modificar_UsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registar_UsuarioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buscar_UsuarioBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Buscar_UsuarioBoton)
                        .addGap(18, 18, 18)
                        .addComponent(Registar_UsuarioBoton)
                        .addGap(55, 55, 55)
                        .addComponent(Modificar_UsuarioBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Bloquear_UsuarioBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Desbloquear_UsuarioBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eliminar_UsuarioBoton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuario", jPanel1);

        Bloquear_TerminalBoton.setText("Bloquear Terminal");
        Bloquear_TerminalBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bloquear_TerminalBotonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Terminal", "Otros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        Buscar_TerminalBoton.setText("Buscar");
        Buscar_TerminalBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_TerminalBotonActionPerformed(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2Enter_Buscar(evt);
            }
        });

        Registar_Terminal.setText("Registrar Terminal");
        Registar_Terminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registar_TerminalActionPerformed(evt);
            }
        });

        Eliminar_TerminalBoton.setText("Eliminar Terminal");
        Eliminar_TerminalBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_TerminalBotonActionPerformed(evt);
            }
        });

        Desbloquear_TerminalBoton.setText("Desbloquear Terminal");
        Desbloquear_TerminalBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Desbloquear_TerminalBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Eliminar_TerminalBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Desbloquear_TerminalBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bloquear_TerminalBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registar_Terminal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buscar_TerminalBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Buscar_TerminalBoton)
                        .addGap(18, 18, 18)
                        .addComponent(Registar_Terminal)
                        .addGap(98, 98, 98)
                        .addComponent(Bloquear_TerminalBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Desbloquear_TerminalBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eliminar_TerminalBoton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Terminales", jPanel2);
        jTabbedPane1.addTab("Empleados", trabajadorView1);
        jTabbedPane1.addTab("Productos", productosView1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Registar_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registar_UsuarioBotonActionPerformed
        // TODO add your handling code here:
        Registro_Usuario.setSize(750, 650);
        Registro_Usuario.setLocationRelativeTo(this);
     ////////////LLenar Lista        
      

            Registro_Usuario.setTitle("Registro de Usuario");
            Registro_Usuario.setVisible(true);
        
            codigo_Empleado.setText("");
            idUsuario.setText("");
            contrasenia.setText("");
            campoIdSistema.setText("");
            campoNombresAp.setText("");
        
        
        
        palabras1=new Vector<String>();
        palabras2=new Vector<String>();
        //jList2.removeAll();
        this.llenar_lista();
       // Cargar_palabras1();
        
        jList2.setListData(palabras2);
        jList1.setListData(palabras1);
        
    }//GEN-LAST:event_Registar_UsuarioBotonActionPerformed
//////////////////////// BUSCAR EN LA TABLA////////////////////////////////////////
    private void Buscar_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_UsuarioBotonActionPerformed
         String ele = jTextField1.getText();
         
        for (int i = 0; i < jTable1.getRowCount(); i++) {
          for(int j=0; j< jTable1.getColumnCount(); j++){  
            if (jTable1.getValueAt(i, j).equals(ele)) {
                jTable1.changeSelection(i, j, false, false);/////////// el i deberia de repsentar la columna
              usuario =(String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);//(jTable1.getSelectedRow(), jTable1.getSelectedColumn())
              ////////////////////////////////////////////////////////////////////////////////////////// Deberia de quedar asi pero como solo trabajamos mediante el id le ponemos 0
             
                break;
                
            }
           
          }
        }
        
        if (usuario==null)
            JOptionPane.showMessageDialog(null,"No se encontro coincidencias\nIntente de nuevo");
       
      
    }//GEN-LAST:event_Buscar_UsuarioBotonActionPerformed

    private void Bloquear_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bloquear_UsuarioBotonActionPerformed
        // TODO add your handling code here:
       
                    ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            usuario =(String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma Bloquear Usuario?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                   //int cambioExitoso = st.executeUpdate("DELETE FROM UsuariosHMS WHERE ID='"+usuario+"'");
                                   int cambioExitoso = st.executeUpdate("UPDATE Usuario SET estBlqUsu=true WHERE ideUsu='"+usuario+"'");                   
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla();
                                 
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                  
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
                              System.out.println("Error01");
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
                                            
       
        
        
    }//GEN-LAST:event_Bloquear_UsuarioBotonActionPerformed

    private void Desbloquear_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Desbloquear_UsuarioBotonActionPerformed
        // TODO add your handling code here:
       
               ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            usuario =(String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma Bloquear Usuario?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                   //int cambioExitoso = st.executeUpdate("DELETE FROM UsuariosHMS WHERE ID='"+usuario+"'");
                                   int cambioExitoso = st.executeUpdate("UPDATE Usuario SET estBlqUsu=false WHERE ideUsu='"+usuario+"'");                   
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla();
                                 
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                  
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
                              System.out.println("Error01");
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
                                            
       
                                            
    }//GEN-LAST:event_Desbloquear_UsuarioBotonActionPerformed

    private void Eliminar_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_UsuarioBotonActionPerformed
        // TODO add your handling code here:
            ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            usuario =(String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma eliminar el Usuario?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                   int cambioExitoso = st.executeUpdate("DELETE FROM Usuario WHERE ideUsu='"+usuario+"'");
                                                                                              
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla();
                                     
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                   
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
                              System.out.println("Error01");
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
    }//GEN-LAST:event_Eliminar_UsuarioBotonActionPerformed

    private void Enter_Buscar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter_Buscar
        // TODO add your handling code here:
        if(evt.getKeyCode ()== KeyEvent.VK_ENTER) //saltar al jb_password_cambiar
        { 
              this.Buscar_UsuarioBoton.doClick();
         }
    }//GEN-LAST:event_Enter_Buscar

    private void addEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEspActionPerformed

        int i=jList1.getSelectedIndex();
        jList2.removeAll();
        palabras2.add(palabras1.get(i));
        palabras1.remove(palabras1.get(i));
        jList2.setListData(palabras2);
        jList1.setListData(palabras1);
    }//GEN-LAST:event_addEspActionPerformed

    private void codigo_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_EmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_EmpleadoActionPerformed

    private void removeEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEspActionPerformed
         int i=jList2.getSelectedIndex();
                jList1.removeAll();
                palabras1.add(palabras2.get(i));
                palabras2.remove(palabras2.get(i));
                jList2.setListData(palabras2);
                jList1.setListData(palabras1);        // TODO add your handling code here:
    }//GEN-LAST:event_removeEspActionPerformed

    private void verificarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarExistenciaActionPerformed
         
           String CodigoEmpleado = codigo_Empleado.getText();
        
                  ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
             try
            {
              
                   ResultSet rsSeg= st.executeQuery("SELECT ideEmp,nomEmp,apePatEmp,apeMatEmp,dniEmp FROM Empleado WHERE dniEmp='"+CodigoEmpleado+"'");
                   if(rsSeg.next() ==true){
               
                       campoNombresAp.setText(rsSeg.getString("apePatEmp")+" "+rsSeg.getString("apeMatEmp")+", "+rsSeg.getString("nomEmp"));     
                       campoIdSistema.setText(rsSeg.getString("ideEmp"));
                    
                     
                   }
                   else{
                         JOptionPane.showMessageDialog(null,"Codigo no valido");
                         campoNombresAp.setText("");
                         campoIdSistema.setText("");
                   }
                 
                        System.out.println(rsSeg);
                        
                  
                     rsSeg.close();
             }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
        
        
           
           
           
           
        
    }//GEN-LAST:event_verificarExistenciaActionPerformed

    private void Modificar_UsuarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_UsuarioBotonActionPerformed
        // TODO add your handling code here:
         Modificar_Usuario.setSize(750, 650);
        Modificar_Usuario.setLocationRelativeTo(this);
     ////////////LLenar Lista        
      

            Modificar_Usuario.setTitle("Modificar de Usuario");
            Modificar_Usuario.setVisible(true);
        
            codigo_Empleado1.setText("");
            idUsuario1.setText("");
            contrasenia1.setText("");
            
        
        
        
        palabras1=new Vector<String>();
        palabras2=new Vector<String>();
        
        this.llenar_lista_modificar();
       
        
        jList4.setListData(palabras2);
        jList3.setListData(palabras1);
        
        
    }//GEN-LAST:event_Modificar_UsuarioBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
        // TODO add your handling code here:
         Registro_Usuario.setVisible(false);
       
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void registrarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBotonActionPerformed
            
            if(idUsuario.getText().length()==0||contrasenia.getText().length()==0)
              JOptionPane.showMessageDialog(null,"Faltan llenar algunos datos");
            
            else if(idUsuario.getText().length()>15||contrasenia.getText().length()>15)
                  JOptionPane.showMessageDialog(null,"Algunos de los datos ingresados Es demasido largo\n el tamaño maximo es:\nID : 15 caracteres\nContraseña: 6 caracteres");
                    
            else{
            ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement stmt =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
             try
            {

                int confirmado = JOptionPane.showConfirmDialog(null,"¿Lo confirmas?");

                if (JOptionPane.OK_OPTION == confirmado){
                       ResultSet rsSeg= stmt.executeQuery("SELECT * FROM Usuario WHERE ideUsu='"+idUsuario.getText()+"'");
                   if(rsSeg.next() ==false){
                    String nivel=this.generar_Nivel_Acceso();   
                        rsSeg= stmt.executeQuery("SELECT ideEmp FROM Empleado WHERE dniEmp='"+codigo_Empleado.getText()+"'");
                        
                        
                    stmt.executeUpdate("INSERT INTO Usuario (`ideUsu`, `pssUsu`, `ideEmp`, `estBlqUsu`, `blqAutUsu`,`nivAccUsu`) VALUES ('"+idUsuario.getText()+"','"+contrasenia.getText()+"',"+campoIdSistema.getText()+",0,0,'"+nivel+"');");
                                              //  + idUsuario.getText()+"',"+rsSeg.toString()+",'" + contrasenia.getText()+ "',0,0,'"+nivel+"');");.getString("dniEmp")
               
                         JOptionPane.showMessageDialog(null,"Usuario Creado");
                         this.llenar_tabla();
                         for(int i=0;i<palabras2.size();i++)
                         System.out.println(palabras2.elementAt(i));
                         
                         
                       
                   }
                   else
                         JOptionPane.showMessageDialog(null,"Usuario ya existe");
            
                }
                else
                   
                       JOptionPane.showMessageDialog(null,"Usuario no registrado");
            

            }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
             this.Registro_Usuario.hide();
}
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarBotonActionPerformed

    private void oPredeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oPredeterminadoActionPerformed
        // TODO add your handling code here:
        contrasenia.setText("123456");
        oAutoGen.setSelected(false);
        //oPredeterminado.setSeleted(true);
    }//GEN-LAST:event_oPredeterminadoActionPerformed

    private void contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseniaActionPerformed

    private void oAutoGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oAutoGenActionPerformed
        // TODO add your handling code here:
        
        char[] elementos={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

        char[] conjunto = new char[6];
        String pass;

        for(int i=0;i<6;i++){
        int el = (int)(Math.random()*37);
        conjunto[i] = (char)elementos[el];
        }
         pass = new String(conjunto);
        
       
    
        contrasenia.setText(pass);
        
       
        oPredeterminado.setSelected(false);
    }//GEN-LAST:event_oAutoGenActionPerformed

    private void idUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUsuarioActionPerformed

    private void Bloquear_TerminalBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bloquear_TerminalBotonActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
       
                    ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            terminal =(String) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma Bloquear Terminal?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                   //int cambioExitoso = st.executeUpdate("DELETE FROM UsuariosHMS WHERE ID='"+usuario+"'");
                                   int cambioExitoso = st.executeUpdate("UPDATE Terminal SET estBlqTer=3 WHERE desTer='"+terminal+"'");                   
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla_Terminal();
                                 
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                  
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
//                              System.out.println("Error01");
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
                                            

    }//GEN-LAST:event_Bloquear_TerminalBotonActionPerformed

    private void Buscar_TerminalBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_TerminalBotonActionPerformed
        // TODO add your handling code here:
            String ele = jTextField2.getText();
         
        for (int i = 0; i < jTable2.getRowCount(); i++) {
          for(int j=0; j< jTable2.getColumnCount(); j++){  
            if (jTable2.getValueAt(i, j).equals(ele)) {
                jTable2.changeSelection(i, j, false, false);/////////// el i deberia de repsentar la columna
              terminal =(String) jTable2.getValueAt(jTable2.getSelectedRow(), 0);//(jTable1.getSelectedRow(), jTable1.getSelectedColumn())
            
                break;
                
            }
           
          }
        }
        
        if (terminal==null)
            JOptionPane.showMessageDialog(null,"No se encontro coincidencias\nIntente de nuevo");
    }//GEN-LAST:event_Buscar_TerminalBotonActionPerformed

    private void jTextField2Enter_Buscar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2Enter_Buscar
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2Enter_Buscar

    private void Registar_TerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registar_TerminalActionPerformed
        
        Registro_Terminal.setSize(380, 200);
        Registro_Terminal.setLocationRelativeTo(this);

            Registro_Terminal.setTitle("Registro de Terminal");
            Registro_Terminal.setVisible(true);
        
            nombreTerminal.setText("");
         
        
        palabras1=new Vector<String>();
        palabras2=new Vector<String>();
       
       //this.llenar_lista();
       this.llenar_tabla_Terminal();
        
        jList2.setListData(palabras2);
        jList1.setListData(palabras1);
    }//GEN-LAST:event_Registar_TerminalActionPerformed

    private void Eliminar_TerminalBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_TerminalBotonActionPerformed
     
            ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            terminal =(String) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma eliminar el Terminal?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                   int cambioExitoso = st.executeUpdate("DELETE FROM Terminal WHERE desTer='"+terminal+"'");
                                                                                              
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla_Terminal();
                                     
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                   
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
                           
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
    }//GEN-LAST:event_Eliminar_TerminalBotonActionPerformed

    private void Desbloquear_TerminalBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Desbloquear_TerminalBotonActionPerformed

                    ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
            terminal =(String) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            int confirmado = JOptionPane.showConfirmDialog(null,"Advertencia!\nConfirma desBloquear Terminal?");

    if (JOptionPane.OK_OPTION == confirmado){

        
          try
                               {
                              
                                     int cambioExitoso = st.executeUpdate("UPDATE Terminal SET estBlqTer=0 WHERE desTer='"+terminal+"'");                   
                                     if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla_Terminal();
                                 
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                  
                                     System.exit(0);
                                     }
                                 
                                 st.close();
                               }
                               catch (Exception e)
                          {
//                              System.out.println("Error01");
                              e.printStackTrace();
                      }
    }
    else
         JOptionPane.showMessageDialog(null, "No se continuo con la accion!");
                                            

    }//GEN-LAST:event_Desbloquear_TerminalBotonActionPerformed

    private void codigo_Empleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_Empleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_Empleado1ActionPerformed

    private void idUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUsuario1ActionPerformed

    private void verificarExistencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarExistencia1ActionPerformed
        // TODO add your handling code here:
          String idUsuario = codigo_Empleado1.getText();
        
                  ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement st =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
             try
            {
              
                   ResultSet rsSeg= st.executeQuery("SELECT ideUsu,ideEmp,pssUsu,estBlqUsu,nivAccUsu FROM Usuario WHERE ideUsu='"+idUsuario+"'");
                   if(rsSeg.next() ==true){
                   //    rsSeg=st.executeQuery("SELECT nombres FROM empleadosHMS WHERE id_empleado='"+CodigoEmpleado+"'");
                       
                     //  campoNombresAp1.setText(rsSeg.getString("apellido_p")+" "+rsSeg.getString("apellido_m")+", "+rsSeg.getString("nombres"));     
                       //campoDoc1.setText(rsSeg.getString("dnipassaporte_empleado"));
                       idUsuario1.setText(rsSeg.getString("ideUsu"));
                       contrasenia1.setText(rsSeg.getString("pssUsu"));
                      // JOptionPane.showMessageDialog(null,"el codigo es valido");
                     
                   }
                   else{
                         JOptionPane.showMessageDialog(null,"Codigo no valido");
                       
                   }
                  
                        System.out.println(rsSeg);
                        
                  
                     rsSeg.close();
             }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
        
    }//GEN-LAST:event_verificarExistencia1ActionPerformed

    
    private void contrasenia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenia1ActionPerformed

    private void oAutoGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oAutoGen1ActionPerformed
        // TODO add your handling code here:
            
        char[] elementos={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

        char[] conjunto = new char[6];
        String pass;

        for(int i=0;i<6;i++){
        int el = (int)(Math.random()*37);
        conjunto[i] = (char)elementos[el];
        }
         pass = new String(conjunto);
        
       
    
        contrasenia1.setText(pass);
        
       
        oPredeterminado1.setSelected(false);
    }//GEN-LAST:event_oAutoGen1ActionPerformed

    private void addEsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEsp1ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        int i=jList3.getSelectedIndex();
        jList4.removeAll();
        palabras2.add(palabras1.get(i));
        palabras1.remove(palabras1.get(i));
        jList4.setListData(palabras2);
        jList3.setListData(palabras1);
    }//GEN-LAST:event_addEsp1ActionPerformed

    private void removeEsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEsp1ActionPerformed
        // TODO add your handling code here:
         int i=jList4.getSelectedIndex();
                jList3.removeAll();
                palabras1.add(palabras2.get(i));
                palabras2.remove(palabras2.get(i));
                jList4.setListData(palabras2);
                jList3.setListData(palabras1); 
    }//GEN-LAST:event_removeEsp1ActionPerformed

    private void cancelarBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBoton1ActionPerformed
        // TODO add your handling code here:
         Registro_Usuario.setVisible(false);
    }//GEN-LAST:event_cancelarBoton1ActionPerformed

    private void registrarBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBoton1ActionPerformed
        // TODO add your handling code here:
                 if(idUsuario1.getText().length()==0||contrasenia1.getText().length()==0)
              JOptionPane.showMessageDialog(null,"Faltan llenar algunos datos");
            
            else if(idUsuario1.getText().length()>15||contrasenia1.getText().length()> 15)
                  JOptionPane.showMessageDialog(null,"Algunos de los datos ingresados Es demasido largo\n el tamaño maximo es:\nID : 15 caracteres\nContraseña: 6 caracteres");
                    
            else{
            ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement stmt =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
             try
            {

                int confirmado = JOptionPane.showConfirmDialog(null,"¿Lo confirmas?");

                if (JOptionPane.OK_OPTION == confirmado){
                    String nivel=this.generar_Nivel_Acceso(); 
                    String Estado="1";
                    if(forzarCambioPass.isSelected())
                        Estado="0";
                    //ResultSet rsSeg= stmt.executeQuery("SELECT * FROM UsuariosHMS WHERE ID='"+idUsuario1.getText()+"'");
                  int cambioExitoso = stmt.executeUpdate("UPDATE Usuario SET ideUsu='"+ idUsuario1.getText()+"', pssUsu='"+contrasenia1.getText()+"',estBlqUsu='"+Estado+"', nivAccUsu='"+nivel+"' WHERE ideUsu='"+idUsuario1.getText()+"'");
                  //                  stmt.executeUpdate("UPDATE UsuariosHMS SET BloqueoAutomatico=3 WHERE ID='"+idUsuario1.getText()+"'");                   
                      
                                          
                   if(cambioExitoso==1){
                                         JOptionPane.showMessageDialog(null, "Operacion Exitosa\n");
                                         this.llenar_tabla();
                                 
                                     }
                                     else{
                                     JOptionPane.showMessageDialog(null, "Sucedio un error no se pudo concretar el cambio\nVuelva a intentarlo mas tarde\no comuniquese con el administrador!");
                                  
                                     System.exit(0);
                                     }
                   //int cambioExitoso = st.executeUpdate("UPDATE UsuariosHMS SET BloqueoAutomatico=3 WHERE ID='"+usuario+"'");                   
                                   
                     //    JOptionPane.showMessageDialog(null,"Usuario actualizado");
                         this.llenar_tabla();
                         for(int i=0;i<palabras2.size();i++)
                         System.out.println(palabras2.elementAt(i));
                         
                         /////////////////////////////////// aqui deberia de generar la cadena de privilegios
                         
                       
                   
            
                }
                else
                   
                       JOptionPane.showMessageDialog(null,"Usuario no registrado");
            

            }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
             
        
            }   
                 
              this.Modificar_Usuario.hide();   
    }//GEN-LAST:event_registrarBoton1ActionPerformed

    private void oPredeterminado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oPredeterminado1ActionPerformed
        contrasenia1.setText("123456");
        oAutoGen1.setSelected(false);
        // TODO add your handling code here:}//GEN-LAST:event_oPredeterminado1ActionPerformed
    }
        private void forzarCambioPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forzarCambioPassActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_forzarCambioPassActionPerformed

    private void nombreTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTerminalActionPerformed

    private void cancelarBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBoton2ActionPerformed
        // TODO add your handling code here:
        Registro_Terminal.setVisible(false);
    }//GEN-LAST:event_cancelarBoton2ActionPerformed

    private void registrarBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBoton2ActionPerformed
        // TODO add your handling code here:
          if(nombreTerminal.getText().length()==0)
              JOptionPane.showMessageDialog(null,"Faltan llenar algunos datos");
                
                    
            else{
            ConexionAux conectar = new ConexionAux();//La ConexionAux tiene que mejorarse termina ni bien entra al sistema 
            Statement stmt =conectar.conectar();// o asi son siempre las conexiones de ser asi se tendria que hacer una llamado enc ada accion 
             try
            {

                int confirmado = JOptionPane.showConfirmDialog(null,"¿Lo confirmas?");

                if (JOptionPane.OK_OPTION == confirmado){
                       ResultSet rsSeg= stmt.executeQuery("SELECT * FROM Terminal WHERE ideTer='"+nombreTerminal.getText()+"'");
                   if(rsSeg.next() ==false){
                    String nivel=this.generar_Nivel_Acceso();   
                       
                    stmt.executeUpdate("INSERT INTO Terminal(desTer,estBlqTer)VALUES('"+nombreTerminal.getText()+"',0);");
               
                         JOptionPane.showMessageDialog(null,"Terminal Creado");
                         //this.llenar_tabla();
                         this.llenar_tabla_Terminal();
                         for(int i=0;i<palabras2.size();i++)
                         System.out.println(palabras2.elementAt(i));
                         
                         
                       
                   }
                   else
                         JOptionPane.showMessageDialog(null,"Terminal ya existe");
            
                }
                else
                   
                       JOptionPane.showMessageDialog(null,"Terminal no registrado");
            

            }
            catch (Exception e)
            {
                   e.printStackTrace();
             }
          }
          this.Registro_Terminal.hide();
          
    }//GEN-LAST:event_registrarBoton2ActionPerformed

private void goto_verificar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_goto_verificar
// TODO add your handling code here:
      if(evt.getKeyCode ()== KeyEvent.VK_ENTER) //saltar al siguiente text field 
        {
              this.verificarExistencia.doClick();
        }
}//GEN-LAST:event_goto_verificar
    
   
    private String usuario=null;
    private String terminal=null;
    
    //////////////////////////////////////////
    Vector palabras1;
    Vector palabras2;
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bloquear_TerminalBoton;
    private javax.swing.JButton Bloquear_UsuarioBoton;
    private javax.swing.JButton Buscar_TerminalBoton;
    private javax.swing.JButton Buscar_UsuarioBoton;
    private javax.swing.JButton Desbloquear_TerminalBoton;
    private javax.swing.JButton Desbloquear_UsuarioBoton;
    private javax.swing.JButton Eliminar_TerminalBoton;
    private javax.swing.JButton Eliminar_UsuarioBoton;
    private javax.swing.ButtonGroup GEN_PASSWORD;
    private javax.swing.ButtonGroup GEN_PASSWORD_R;
    private javax.swing.JFrame Modificar_Usuario;
    private javax.swing.JButton Modificar_UsuarioBoton;
    private javax.swing.JButton Registar_Terminal;
    private javax.swing.JButton Registar_UsuarioBoton;
    private javax.swing.JFrame Registro_Terminal;
    private javax.swing.JFrame Registro_Usuario;
    private javax.swing.JButton addEsp;
    private javax.swing.JButton addEsp1;
    private javax.swing.JTextField campoIdSistema;
    private javax.swing.JTextField campoNombresAp;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JButton cancelarBoton1;
    private javax.swing.JButton cancelarBoton2;
    private javax.swing.JTextField codigo_Empleado;
    private javax.swing.JTextField codigo_Empleado1;
    private javax.swing.JTextField contrasenia;
    private javax.swing.JTextField contrasenia1;
    private javax.swing.JCheckBox forzarCambioPass;
    private javax.swing.JTextField idUsuario;
    private javax.swing.JTextField idUsuario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nombreTerminal;
    private javax.swing.JRadioButton oAutoGen;
    private javax.swing.JRadioButton oAutoGen1;
    private javax.swing.JRadioButton oPredeterminado;
    private javax.swing.JRadioButton oPredeterminado1;
    private vista.ProductosView productosView1;
    private javax.swing.JButton registrarBoton;
    private javax.swing.JButton registrarBoton1;
    private javax.swing.JButton registrarBoton2;
    private javax.swing.JButton removeEsp;
    private javax.swing.JButton removeEsp1;
    private vista.TrabajadorView trabajadorView1;
    private javax.swing.JButton verificarExistencia;
    private javax.swing.JButton verificarExistencia1;
    // End of variables declaration//GEN-END:variables
}
