/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package org.hornetsa.view.automobile;

import org.hornetsa.view.IIntersetedGUI;
import org.hornetsa.Main;
import org.hornetsa.model.Automobile;
import org.hornetsa.services.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author ASUS
 */
public class GUIListAutomobile extends javax.swing.JFrame implements IIntersetedGUI {

    VehicleService vehicleService;
    /** Creates new form GUIListarB */
    public GUIListAutomobile(VehicleService vehicleService) {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Hornet Corsair | List Automobiles");
        setSize(800, 500);
        setIconImage(new ImageIcon(Main.class.getClassLoader().getResource("img/favicon.png")).getImage());
        this.vehicleService = vehicleService;
        vehicleService.addGUIInterested(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        LblTitle = new javax.swing.JLabel();
        btnList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAutomobiles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar B");

        LblTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitle.setText("List Automobiles");

        btnList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnList.setText("List");
        btnList.setBackground(Color.BLACK);
        btnList.setForeground(Color.WHITE);
        jTableAutomobiles.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Id", "Brand", "Price", "Model", "Abs", "DoorCount", "BodyWork", "AirbagCount"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAutomobiles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(352, 352, 352)
                                                                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(149, 149, 149)
                                                                .addComponent(LblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 145, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(LblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>



    // Variables declaration - do not modify
    private javax.swing.JLabel LblTitle;
    private javax.swing.JButton btnList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAutomobiles;
    // End of variables declaration

    public JTable getjTable1() {
        return jTableAutomobiles;
    }

    public void setjTable1(JTable jTable1) {
        this.jTableAutomobiles = jTable1;
    }

    public JButton getBtnList() {
        return btnList;
    }

    @Override
    public void changeTable() {
        DefaultTableModel model = (DefaultTableModel) getjTable1().getModel();
        model.setRowCount(0);

        for (Automobile automobile : vehicleService.getAutomobiles()) {
            model.addRow(new Object[]{
                    automobile.getIdVehicle(),
                    automobile.getBrand(),
                    automobile.getPrice(),
                    automobile.getModel(),
                    automobile.isAbs(),
                    automobile.getDoorCount(),
                    automobile.getBodywork().getDescription(),
                    automobile.getAirbagCount()
            });
        }
    }
}
