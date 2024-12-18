/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author Jesus
 */
public class ConsignarEn extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public String id;
    public String operacion;
    public ConsignarEn() {
        initComponents();
    }
    public ConsignarEn(String id,String operacion)
    {
        this.id = id;
        this.operacion= operacion;
        initComponents();
        lblNum.setText(id);
        lblOpName.setText(operacion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        btnBackInicio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblOpName = new javax.swing.JLabel();
        btnConsDeb = new javax.swing.JButton();
        btnConsCred = new javax.swing.JButton();
        lblOpName2 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(112, 136, 113));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BankIt");
        jLabel1.setAlignmentY(0.0F);

        lblNum.setBackground(new java.awt.Color(255, 255, 255));
        lblNum.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("0000000000");
        lblNum.setAlignmentY(0.0F);

        btnBackInicio.setBackground(new java.awt.Color(112, 136, 113));
        btnBackInicio.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnBackInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnBackInicio.setText("Atras");
        btnBackInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackInicio))
                .addGap(20, 20, 20))
        );

        jPanel1.setBackground(new java.awt.Color(254, 243, 226));
        jPanel1.setFocusTraversalPolicyProvider(true);

        lblOpName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblOpName.setForeground(new java.awt.Color(0, 102, 118));
        lblOpName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOpName.setText("Nombre operacion");

        btnConsDeb.setBackground(new java.awt.Color(112, 136, 113));
        btnConsDeb.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnConsDeb.setForeground(new java.awt.Color(255, 255, 255));
        btnConsDeb.setText("Debito");
        btnConsDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsDebActionPerformed(evt);
            }
        });

        btnConsCred.setBackground(new java.awt.Color(112, 136, 113));
        btnConsCred.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnConsCred.setForeground(new java.awt.Color(255, 255, 255));
        btnConsCred.setText("Credito");
        btnConsCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsCredActionPerformed(evt);
            }
        });

        lblOpName2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblOpName2.setForeground(new java.awt.Color(0, 102, 118));
        lblOpName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOpName2.setText("Consignar en:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsCred, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsDeb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOpName)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOpName2)
                        .addGap(17, 17, 17)))
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblOpName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOpName2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnConsDeb, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnConsCred, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackInicioActionPerformed
        // TODO add your handling code here:
        OperacionInOut consignar =new OperacionInOut(this.id,"Consignar dinero");
        consignar.setVisible(true);
        consignar.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackInicioActionPerformed

    private void btnConsDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsDebActionPerformed
            Recibo reciboDeb =new Recibo(this.id,this.operacion,"debito");
            reciboDeb.setVisible(true);
            reciboDeb.setLocationRelativeTo(null);
            this.setVisible(false);

    }//GEN-LAST:event_btnConsDebActionPerformed

    private void btnConsCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsCredActionPerformed
        Recibo reciboCred =new Recibo(this.id,this.operacion,"credito");
        reciboCred.setVisible(true);
        reciboCred.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsCredActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackInicio;
    private javax.swing.JButton btnConsCred;
    private javax.swing.JButton btnConsDeb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblOpName;
    private javax.swing.JLabel lblOpName2;
    // End of variables declaration//GEN-END:variables
}
