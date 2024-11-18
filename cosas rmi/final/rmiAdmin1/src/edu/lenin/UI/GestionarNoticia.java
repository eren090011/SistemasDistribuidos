/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.lenin.UI;

import edu.lenin.Client;

/**
 *
 * @author Jesus
 */
public class GestionarNoticia extends javax.swing.JFrame {
    
    String autor;
    String idNoticia;
    String titulo;
    String contenido;
    
    public GestionarNoticia(String autor,String idNoticia,String titulo,String contenido) {
        this.autor=autor;
        this.idNoticia=idNoticia;
        this.titulo=titulo;
        this.contenido=contenido;
        initComponents();
        txtTitulo.setText(titulo);
        txtArea.setText(contenido);
        lblAutor.setText(autor);
        lblError.setVisible(false);
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        txtTitulo = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblAutor = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea.setColumns(20);
        txtArea.setLineWrap(true);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnEditar.setText("Guardar cambios");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblAutor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutor.setText("Autor noticia");

        lblError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Llena todos los campos");

        btnEliminar.setText("Eliminar noticia");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAutor)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addGap(9, 9, 9)
                .addComponent(lblError)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        GestionNoticias noticias=new GestionNoticias();
        this.setVisible(false);
        noticias.listarNoticias();
        noticias.setLocationRelativeTo(null); 
        noticias.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int idNews= Integer.parseInt(idNoticia);
        String titulo = txtTitulo.getText();
        String contenido = txtArea.getText();
        
        if(titulo.isEmpty()||contenido.isEmpty()){
            lblError.setVisible(true);
        }else{
            // se cambia este metodo por un update
            if(actualizarNoticia(idNews, titulo, contenido)){
                GestionNoticias noticias=new GestionNoticias();
                this.setVisible(false);
                noticias.listarNoticias();
                noticias.setLocationRelativeTo(null); 
                noticias.setVisible(true);
            }else{
                System.out.println("Hubo un error creando las noticias");
            }
        }
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idNews= Integer.parseInt(idNoticia);
        if(eliminarNoticia(idNews)){
            GestionNoticias noticias=new GestionNoticias();
            this.setVisible(false);
            noticias.listarNoticias();
            noticias.setLocationRelativeTo(null); 
            noticias.setVisible(true);
            
        }else{
            System.out.println("hubo un error borrando la noticia");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    public boolean actualizarNoticia( int idNoticia,String titulo,String contenido){
        Client client = new Client("25.44.181.220", "5000", "nws");
        return client.actualizarrNoticia(idNoticia,titulo, contenido );
    }
    public boolean eliminarNoticia(int id){
       Client client = new Client("25.44.181.220", "5000", "nws");
       return client.borrarNoticia(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
