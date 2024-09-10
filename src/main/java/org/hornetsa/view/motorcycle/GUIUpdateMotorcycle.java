package org.hornetsa.view.motorcycle;

import org.hornetsa.model.Motorcycle;
import org.hornetsa.model.Vehicle;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.IIntersetedGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GUIUpdateMotorcycle extends JFrame implements IIntersetedGUI {

    private JLabel LblTitle;
    private JButton btnSearch;
    private JButton jBtnUpdate;
    private JLabel jLabelIdMotorcycle;
    private JTextField jTxtIdMotorcycle;
    private JScrollPane jScrollPane1;
    private JTable jTableUpdateMotorcycle;
    VehicleService vehicleService;

    public GUIUpdateMotorcycle(VehicleService vehicleService) {
        initComponents();
        setLocationRelativeTo(this);
        setSize(800,500);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/favicon.png")).getImage());
        setTitle("Hornet Corsair | Update Motorcycle");
        this.vehicleService = vehicleService;
        vehicleService.addGUIInterested(this);
    }

    private void initComponents() {
        LblTitle = new JLabel();
        btnSearch = new JButton();
        jLabelIdMotorcycle = new JLabel();
        jTxtIdMotorcycle = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTableUpdateMotorcycle = new JTable();
        jBtnUpdate = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        LblTitle.setFont(new Font("Arial", 1, 24));
        LblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        LblTitle.setText("Update Motorcycle");

        jLabelIdMotorcycle.setFont(new Font("Arial", 1, 13));
        jLabelIdMotorcycle.setText("Id motorcycle:");

        btnSearch.setText("Search");
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);

        jBtnUpdate.setText("Update");
        jBtnUpdate.setBackground(new Color(58, 32, 222));
        jBtnUpdate.setForeground(Color.WHITE);

        jTableUpdateMotorcycle.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Id", "Brand", "Model", "Price", "Abs", "ForkType", "HelmetIncluded"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, String.class, String.class, Float.class, Boolean.class, String.class, Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableUpdateMotorcycle);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelIdMotorcycle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTxtIdMotorcycle, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jBtnUpdate, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIdMotorcycle, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtIdMotorcycle, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBtnUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))
        );
        pack();
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnUpdate() {
        return jBtnUpdate;
    }

    public JTextField getTxtIdMotorcycle() {
        return jTxtIdMotorcycle;
    }

    public JTable getjTableUpdateMotorcycle() {
        return jTableUpdateMotorcycle;
    }

    @Override
    public void changeTable() {
        DefaultTableModel model = (DefaultTableModel) jTableUpdateMotorcycle.getModel();
        model.setRowCount(0);
        if(!getTxtIdMotorcycle().getText().isEmpty()){
            int vehicleNumber = Integer.parseInt(getTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getMotorcycle(vehicleNumber);
            if(vehicle instanceof Motorcycle motorcycle) {
                model.addRow(new Object[]{
                        motorcycle.getIdVehicle(),
                        motorcycle.getBrand(),
                        motorcycle.getModel(),
                        motorcycle.getPrice(),
                        motorcycle.isAbs(),
                        motorcycle.getForkType(),
                        motorcycle.isHelmetIncluded()
                });
            } else {
                JOptionPane.showMessageDialog(this, "Motorcycle not found.");
            }
        }
    }

    @Override
    public void dispose() {
        vehicleService.removeGUIInterested(this);
        super.dispose();
    }
}
