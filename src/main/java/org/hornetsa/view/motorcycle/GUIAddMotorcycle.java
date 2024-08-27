/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.hornetsa.view.motorcycle;

import javax.swing.*;

/**
 *
 * @author jaime
 */
public class GUIAddMotorcycle extends javax.swing.JFrame {

    /**
     * Creates new form GUIAddMoto
     */
    public GUIAddMotorcycle() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        LblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jTxtIdMotorcycle = new javax.swing.JTextField();
        jTxtBrand = new javax.swing.JTextField();
        jTxtPrice = new javax.swing.JTextField();
        jTxtModel = new javax.swing.JTextField();
        jBoxABS = new javax.swing.JCheckBox();
        jTxtForkType = new javax.swing.JTextField();
        jBoxHelmet = new javax.swing.JCheckBox();
        jLblIdMoto = new javax.swing.JLabel();
        jLblBrand = new javax.swing.JLabel();
        jLblPrice = new javax.swing.JLabel();
        jLblModel = new javax.swing.JLabel();
        jLblABS = new javax.swing.JLabel();
        jLblForkType = new javax.swing.JLabel();
        jLblBodyWork = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LblTitle.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        LblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitle.setText("Add Motorcycle");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jTxtIdMotorcycle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTxtIdMotorcycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdMotorcycleActionPerformed(evt);
            }
        });

        jTxtBrand.setToolTipText("");
        jTxtBrand.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTxtPrice.setToolTipText("Price");
        jTxtPrice.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTxtModel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBoxABS.setText("ABS");

        jTxtForkType.setToolTipText("Price");
        jTxtForkType.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBoxHelmet.setText("Helmet");

        jLblIdMoto.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblIdMoto.setText("IdMoto");

        jLblBrand.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblBrand.setText("Brand");

        jLblPrice.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblPrice.setText("Price");

        jLblModel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblModel.setText("Model");

        jLblABS.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblABS.setText("Does it have ABS?");

        jLblForkType.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblForkType.setText("ForkType");

        jLblBodyWork.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLblBodyWork.setText("Does it include a helmet?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(260, 260, 260)
                                                .addComponent(LblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblIdMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(107, 107, 107)
                                                                .addComponent(jTxtIdMotorcycle, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(107, 107, 107)
                                                                .addComponent(jTxtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(107, 107, 107)
                                                                .addComponent(jTxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblModel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(107, 107, 107)
                                                                .addComponent(jTxtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblABS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(70, 70, 70)
                                                                .addComponent(jBoxABS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblForkType, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(90, 90, 90)
                                                                .addComponent(jTxtForkType, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLblBodyWork, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jBoxHelmet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblIdMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTxtIdMotorcycle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTxtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblModel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTxtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblABS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jBoxABS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblForkType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTxtForkType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLblBodyWork, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jBoxHelmet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Holasss");
    }

    private void jTxtIdMotorcycleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JLabel LblTitle;
    private javax.swing.JButton btnAdd;
    private javax.swing.JCheckBox jBoxABS;
    private javax.swing.JCheckBox jBoxHelmet;
    private javax.swing.JLabel jLblABS;
    private javax.swing.JLabel jLblBodyWork;
    private javax.swing.JLabel jLblBrand;
    private javax.swing.JLabel jLblForkType;
    private javax.swing.JLabel jLblIdMoto;
    private javax.swing.JLabel jLblModel;
    private javax.swing.JLabel jLblPrice;
    private javax.swing.JTextField jTxtBrand;
    private javax.swing.JTextField jTxtForkType;
    private javax.swing.JTextField jTxtIdMotorcycle;
    private javax.swing.JTextField jTxtModel;
    private javax.swing.JTextField jTxtPrice;
    // End of variables declaration

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JTextField getjTxtIdMotorcycle() {
        return jTxtIdMotorcycle;
    }

    public JTextField getjTxtBrand() {
        return jTxtBrand;
    }

    public JTextField getjTxtPrice() {
        return jTxtPrice;
    }

    public JTextField getjTxtModel() {
        return jTxtModel;
    }

    public JCheckBox getjBoxABS() {
        return jBoxABS;
    }

    public JTextField getjTxtForkType() {
        return jTxtForkType;
    }

    public JCheckBox getjBoxHelmet() {
        return jBoxHelmet;
    }
}
