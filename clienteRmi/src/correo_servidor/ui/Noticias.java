/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package correo_servidor.ui;


import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus
 */
public class Noticias extends javax.swing.JFrame {
    int id;
    String userName;
    String sltId = "N/A";
    String sltTitle="N/A";
    String sltCont="N/A";
    String sltAutor="N/A";
    
    public Noticias(int id,String userName) {
        this.id=id;
        this.userName=userName;
        initComponents();
        lblUserName.setText(userName);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Contenido", "Autor"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Noticias");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("Nombre usuario");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir noticia");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear noticia");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAbrir)
                        .addGap(227, 227, 227)
                        .addComponent(btnCrear)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrear)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAbrir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login vistainicio= new Login();
        this.setVisible(false);
        vistainicio.setLocationRelativeTo(null); 
        vistainicio.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if(!sltTitle.equals("N/A")){
            // en caso de que el autor sea diferente al usuario actual, se leera normarl
            if(!sltAutor.equals(userName)){
                LeerNoticia vistaNoticia= new LeerNoticia(id,userName,sltTitle,sltCont,sltAutor);
                this.setVisible(false);
                vistaNoticia.setLocationRelativeTo(null); 
                vistaNoticia.setVisible(true);  
            }
            // de lo contrario, osea si el autor y el usuario actual son la misma persona, se podra editar/borrar
            else{
                GestionarNoticia gesNoticia = new GestionarNoticia(id,userName,sltId,sltTitle,sltCont);
                this.setVisible(false);
                gesNoticia.setLocationRelativeTo(null); 
                gesNoticia.setVisible(true);
            }
            
            
        }else{
            System.out.println("Selecciona una noticia");
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        CrearNoticia crearNoticia =new CrearNoticia(id, userName);
        this.setVisible(false);
        crearNoticia.setLocationRelativeTo(null); 
        crearNoticia.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
            int i= tabla.getSelectedRow();
            DefaultTableModel modelo= (DefaultTableModel) tabla.getModel();
            sltId= modelo.getValueAt(i, 0).toString();
            sltTitle = modelo.getValueAt(i, 1).toString();
            sltCont = modelo.getValueAt(i, 2).toString();
            sltAutor = modelo.getValueAt(i, 3).toString();             
    }//GEN-LAST:event_tablaMouseClicked
     public void listarNoticias(){
        Client client = new Client("localhost", "5000", "nws");
        List<Object[]> datos = client.getNoticias();
        
        DefaultTableModel modelo =recModelo(datos);
        tabla.setModel(modelo);
    }
    public DefaultTableModel recModelo(List<Object[]> datos) {
    String[] columnas = {"Id", "Titulo","contenido","Autor"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    
    for (Object[] fila : datos) {
        modelo.addRow(fila);
    }
    
    return modelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
