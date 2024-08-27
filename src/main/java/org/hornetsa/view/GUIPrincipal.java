/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.hornetsa.view;

import org.hornetsa.controller.AutomobileController;
import org.hornetsa.controller.BodyworkController;
import org.hornetsa.model.Bodywork;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.automobile.GUIAddAutomobile;
import org.hornetsa.view.automobile.GUIDeleteAutomobile;
import org.hornetsa.view.automobile.GUIListAutomobile;
import org.hornetsa.view.automobile.GUISearchAutomobile;
import org.hornetsa.view.bodywork.GUIAddBodywork;
import org.hornetsa.view.bodywork.GUIListBodywork;
import org.hornetsa.view.motorcycle.GUIAddMotorcycle;
import org.hornetsa.view.motorcycle.GUIDeleteMotorcycle;
import org.hornetsa.view.motorcycle.GUIListMotorcycle;
import org.hornetsa.view.motorcycle.GUISearchMotorcycle;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class GUIPrincipal extends javax.swing.JFrame {
    private ArrayList<Bodywork> bodyworks = new ArrayList<>();
    private VehicleService vehicleService = new VehicleService();

    /**
     * Creates new form GUIPrincipal
     */
    public GUIPrincipal() {
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();
        jMenuAutomobile = new javax.swing.JMenu();
        jMenuItemAddAutomobile = new javax.swing.JMenuItem();
        jMenuItemSearchAutomobile = new javax.swing.JMenuItem();
        jMenuItemDeleteAutomobile = new javax.swing.JMenuItem();
        jMenuItemListAutomobile = new javax.swing.JMenuItem();
        jMenuItemInsuranceAutomobile = new javax.swing.JMenuItem();
        jMenuMotorcycle = new javax.swing.JMenu();
        jMenuItemAddMotorcylce = new javax.swing.JMenuItem();
        jMenuItemSearchMotorcylce = new javax.swing.JMenuItem();
        jMenuItemDeleteMotorcylce = new javax.swing.JMenuItem();
        jMenuItemListMotorcylce = new javax.swing.JMenuItem();
        jMenuItemInsuranceMotorcylce = new javax.swing.JMenuItem();
        jMenuItemDiscountMotorcycle = new javax.swing.JMenuItem();
        jMenuBodywork = new javax.swing.JMenu();
        jMenuItemAddBodywork = new javax.swing.JMenuItem();
        jMenuItemListBodywork = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HORNET CORSAIR");

        mnuArchivo.setText("Archivo");

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        jMenuBar1.add(mnuArchivo);

        jMenuAutomobile.setText("Automobile");

        jMenuItemAddAutomobile.setText("Add Automobile");
        jMenuItemAddAutomobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddAutomobileActionPerformed(evt);
            }
        });
        jMenuAutomobile.add(jMenuItemAddAutomobile);

        jMenuItemSearchAutomobile.setText("Search Automobile");
        jMenuItemSearchAutomobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSearchAutomobileActionPerformed(evt);
            }
        });
        jMenuAutomobile.add(jMenuItemSearchAutomobile);

        jMenuItemDeleteAutomobile.setText("Delete Automobile");
        jMenuItemDeleteAutomobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteAutomobileActionPerformed(evt);
            }
        });
        jMenuAutomobile.add(jMenuItemDeleteAutomobile);

        jMenuItemListAutomobile.setText("List Automobile");
        jMenuItemListAutomobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListAutomobileActionPerformed(evt);
            }
        });
        jMenuAutomobile.add(jMenuItemListAutomobile);

        jMenuItemInsuranceAutomobile.setText("Calculate Insurance");
        jMenuItemInsuranceAutomobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsuranceAutomobileActionPerformed(evt);
            }
        });
        jMenuAutomobile.add(jMenuItemInsuranceAutomobile);

        jMenuBar1.add(jMenuAutomobile);

        jMenuMotorcycle.setText("Motorcycle");

        jMenuItemAddMotorcylce.setText("Add Motorcycle");
        jMenuItemAddMotorcylce.setToolTipText("");
        jMenuItemAddMotorcylce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddMotorcylceActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemAddMotorcylce);

        jMenuItemSearchMotorcylce.setText("Search Motorcycle");
        jMenuItemSearchMotorcylce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSearchMotorcylceActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemSearchMotorcylce);

        jMenuItemDeleteMotorcylce.setText("Delete Motorcycle");
        jMenuItemDeleteMotorcylce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteMotorcylceActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemDeleteMotorcylce);

        jMenuItemListMotorcylce.setText("List Motorcycle");
        jMenuItemListMotorcylce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListMotorcylceActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemListMotorcylce);

        jMenuItemInsuranceMotorcylce.setText("Calculate Insurance");
        jMenuItemInsuranceMotorcylce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInsuranceMotorcylceActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemInsuranceMotorcylce);

        jMenuItemDiscountMotorcycle.setText("Calculate Discount");
        jMenuItemDiscountMotorcycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDiscountMotorcycleActionPerformed(evt);
            }
        });
        jMenuMotorcycle.add(jMenuItemDiscountMotorcycle);

        jMenuBar1.add(jMenuMotorcycle);

        jMenuBodywork.setText("Bodywork");

        jMenuItemAddBodywork.setText("Add Bodywork");
        jMenuItemAddBodywork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddBodyworkActionPerformed(evt);
            }
        });
        jMenuBodywork.add(jMenuItemAddBodywork);

        jMenuItemListBodywork.setText("List Bodywork");
        jMenuItemListBodywork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListBodyworkActionPerformed(evt);
            }
        });
        jMenuBodywork.add(jMenuItemListBodywork);

        jMenuBar1.add(jMenuBodywork);

        mnuAyuda.setText("Ayuda");

        mnuAcercaDe.setText("Acerca de...");
        mnuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAcercaDe);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void mnuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Desarrollado por Carlos Lugo");
    }

    private void jMenuItemListAutomobileActionPerformed(java.awt.event.ActionEvent evt) {
        GUIListAutomobile guiListAutomobile = new GUIListAutomobile();
        AutomobileController automobileController = new AutomobileController(guiListAutomobile, vehicleService, bodyworks);
        guiListAutomobile.setVisible(true);
    }

    private void jMenuItemAddAutomobileActionPerformed(java.awt.event.ActionEvent evt) {
        GUIAddAutomobile guiAddAutomobile = new GUIAddAutomobile();
        guiAddAutomobile.getjListBodyWork().removeAllItems();
        guiAddAutomobile.getjListBodyWork().addItem("Select");
        for (Bodywork bodywork : bodyworks) {
            guiAddAutomobile.getjListBodyWork().addItem(bodywork.getDescription());
        }
        AutomobileController automobileController = new AutomobileController(guiAddAutomobile, vehicleService, bodyworks);
        guiAddAutomobile.setVisible(true);
    }

    private void jMenuItemAddMotorcylceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUIAddMotorcycle guiAddMotorcycle = new GUIAddMotorcycle();
        guiAddMotorcycle.setVisible(true);
    }

    private void jMenuItemDeleteMotorcylceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUIDeleteMotorcycle guiDeleteMotorcycle = new GUIDeleteMotorcycle();
        guiDeleteMotorcycle.setVisible(true);
    }

    private void jMenuItemSearchAutomobileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUISearchAutomobile guiSearchAutomobile = new GUISearchAutomobile();
        guiSearchAutomobile.setVisible(true);
    }

    private void jMenuItemDeleteAutomobileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUIDeleteAutomobile guiDeleteAutomobile = new GUIDeleteAutomobile();
        AutomobileController automobileController = new AutomobileController(guiDeleteAutomobile, vehicleService, bodyworks);
        guiDeleteAutomobile.setVisible(true);
    }

    private void jMenuItemInsuranceAutomobileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItemSearchMotorcylceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUISearchMotorcycle guiSearchMotorcycle = new GUISearchMotorcycle();
        guiSearchMotorcycle.setVisible(true);
    }

    private void jMenuItemListMotorcylceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        GUIListMotorcycle guiListMotorcycle = new GUIListMotorcycle();
        guiListMotorcycle.setVisible(true);
    }

    private void jMenuItemInsuranceMotorcylceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItemAddBodyworkActionPerformed(java.awt.event.ActionEvent evt) {
        GUIAddBodywork guiAddBodywork = new GUIAddBodywork();
        BodyworkController bodyworkController = new BodyworkController(guiAddBodywork, bodyworks);
        guiAddBodywork.setVisible(true);
    }

    private void jMenuItemListBodyworkActionPerformed(java.awt.event.ActionEvent evt) {
        GUIListBodywork guiListBodywork = new GUIListBodywork();
        BodyworkController bodyworkController = new BodyworkController(guiListBodywork, bodyworks);
        guiListBodywork.setVisible(true);
    }

    private void jMenuItemDiscountMotorcycleActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuAutomobile;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuBodywork;
    private javax.swing.JMenuItem jMenuItemAddAutomobile;
    private javax.swing.JMenuItem jMenuItemAddBodywork;
    private javax.swing.JMenuItem jMenuItemAddMotorcylce;
    private javax.swing.JMenuItem jMenuItemDeleteAutomobile;
    private javax.swing.JMenuItem jMenuItemDeleteMotorcylce;
    private javax.swing.JMenuItem jMenuItemInsuranceAutomobile;
    private javax.swing.JMenuItem jMenuItemInsuranceMotorcylce;
    private javax.swing.JMenuItem jMenuItemListAutomobile;
    private javax.swing.JMenuItem jMenuItemListBodywork;
    private javax.swing.JMenuItem jMenuItemListMotorcylce;
    private javax.swing.JMenuItem jMenuItemSearchAutomobile;
    private javax.swing.JMenuItem jMenuItemSearchMotorcylce;
    private javax.swing.JMenuItem jMenuItemDiscountMotorcycle;
    private javax.swing.JMenu jMenuMotorcycle;
    private javax.swing.JMenuItem mnuAcercaDe;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration
}
