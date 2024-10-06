
package Interfa;

//import java.util.List;
import basededatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.ControladoraL;
import logica.Usuario;


public class PrincipalAdmin extends javax.swing.JFrame {
    ControladoraL control;
    Usuario user;
    DefaultTableModel modeloTabla;
    
    public PrincipalAdmin(ControladoraL control, Usuario user) {
        initComponents();
        this.control = control;
        this.user = user;
        configurarTabla(); // Configurar la tabla
   
    }
    private void configurarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Rol");
        
        
        List <Usuario> listaUsuario = control.TraerUsuarios();
        if(listaUsuario != null){
            for( Usuario i : listaUsuario){
                if(i.getUnRol().getNombreR().equals("Votantes")){
                    Object[] objet= {i.getId(),i.getNombreU(),i.getUnRol().getNombreR()};
                    modeloTabla.addRow(objet);
                }
           }
                
        }
        
            
        Tabla.setModel(modeloTabla);
        

    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnCrearPregunta = new javax.swing.JButton();
        BtnCreaUser = new javax.swing.JButton();
        BtnEditarUser = new javax.swing.JButton();
        BtnBorrarUser = new javax.swing.JButton();
        BtnRecargar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("Registro de Votantes");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(Tabla);

        BtnCrearPregunta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnCrearPregunta.setText("Crear Pregunta");
        BtnCrearPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearPreguntaActionPerformed(evt);
            }
        });

        BtnCreaUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnCreaUser.setText("Crear nuevo usuario");
        BtnCreaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCreaUserActionPerformed(evt);
            }
        });

        BtnEditarUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnEditarUser.setText("Editar Usuario");
        BtnEditarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarUserActionPerformed(evt);
            }
        });

        BtnBorrarUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnBorrarUser.setText("Borrar Usuario");
        BtnBorrarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBorrarUserActionPerformed(evt);
            }
        });

        BtnRecargar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnRecargar.setText("Examinar Usuario");
        BtnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRecargarActionPerformed(evt);
            }
        });

        BtnSalir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Recargar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnBorrarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnEditarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCreaUser, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(BtnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCrearPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnCreaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEditarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBorrarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCrearPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCrearPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCrearPreguntaActionPerformed

    private void BtnCreaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreaUserActionPerformed
        
        CrearUsu crearU = new CrearUsu(control);
        crearU.setVisible(true);
        crearU.setLocationRelativeTo(null);
        //this.dispose();
        
    }//GEN-LAST:event_BtnCreaUserActionPerformed
    
    private void BtnEditarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarUserActionPerformed
        if(Tabla.getRowCount()>0){
            if(Tabla.getSelectedRow() != -1){
                long id_u = Integer.parseInt(String.valueOf(Tabla.getValueAt(Tabla.getSelectedRow(),0)));
                
                EdicionU pantallaE = new EdicionU(control,id_u);
                pantallaE.setVisible(true);
                pantallaE.setLocationRelativeTo(null);
                
                
            }
        }
    }//GEN-LAST:event_BtnEditarUserActionPerformed
   
    private void BtnBorrarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBorrarUserActionPerformed
        if(Tabla.getRowCount()>0){
            if(Tabla.getSelectedRow() != -1){
                long id_u = Integer.parseInt(String.valueOf(Tabla.getValueAt(Tabla.getSelectedRow(),0)));
                try {
                    control.borrarUsuario(id_u);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                configurarTabla();
            }
        }
    }//GEN-LAST:event_BtnBorrarUserActionPerformed

    private void BtnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRecargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRecargarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        configurarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBorrarUser;
    private javax.swing.JButton BtnCreaUser;
    private javax.swing.JButton BtnCrearPregunta;
    private javax.swing.JButton BtnEditarUser;
    private javax.swing.JButton BtnRecargar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
