package org.hornetsa.view.bodywork;

import javax.swing.*;
import java.awt.*;

public class GUIUpdateBodywork extends JFrame {

    private JLabel LblTitle;
    private JButton btnSearch;
    private JButton jBtnUpdate;
    private JLabel jLabelIdBodywork;
    private JTextField jTxtIdBodywork;
    private JScrollPane jScrollPane1;
    private JTable jTableUpdateBodywork;

    public GUIUpdateBodywork() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(800,500);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/favicon.png")).getImage());
        setTitle("Hornet Corsair | Update Bodywork");
    }

    private void initComponents() {
        LblTitle = new JLabel();
        btnSearch = new JButton();
        jLabelIdBodywork = new JLabel();
        jTxtIdBodywork = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTableUpdateBodywork = new JTable();
        jBtnUpdate = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        LblTitle.setFont(new Font("Arial", 1, 24));
        LblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        LblTitle.setText("Update Bodywork");

        jLabelIdBodywork.setFont(new Font("Arial", 1, 13));
        jLabelIdBodywork.setText("Id Bodywork:");

        btnSearch.setText("Search");
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);

        jBtnUpdate.setText("Update");
        jBtnUpdate.setBackground(new Color(58, 32, 222));
        jBtnUpdate.setForeground(Color.WHITE);

        jTableUpdateBodywork.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Id", "Description"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTableUpdateBodywork);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelIdBodywork, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTxtIdBodywork, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(jLabelIdBodywork, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtIdBodywork, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
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

    public JTextField getTxtIdBodywork() {
        return jTxtIdBodywork;
    }

    public JTable getjTableUpdateBodywork() {
        return jTableUpdateBodywork;
    }
}
