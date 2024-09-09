package org.hornetsa.view.motorcycle;

import org.hornetsa.model.Motorcycle;
import org.hornetsa.services.VehicleService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEditMotorcycle extends JFrame {

    private JTextField jTxtIdMotorcycle, jTxtBrand, jTxtModel, jTxtPrice, jTxtForkType;
    private JCheckBox jBoxABS, jBoxHelmet;
    private JButton jBtnSave;
    private VehicleService vehicleService;

    private int idMotorcycle;

    public GUIEditMotorcycle(int idMotorcycle, String brand, String model, double price, boolean hasAbs, String forkType, boolean helmetIncluded, VehicleService vehicleService) {
        this.idMotorcycle = idMotorcycle;
        this.vehicleService = vehicleService;  // Inicializar el servicio
        initComponents();

        // Cargar datos en los campos
        jTxtIdMotorcycle.setText(String.valueOf(idMotorcycle));
        jTxtIdMotorcycle.setEditable(false);
        jTxtBrand.setText(brand);
        jTxtModel.setText(model);
        jTxtPrice.setText(String.valueOf(price));
        jBoxABS.setSelected(hasAbs);
        jTxtForkType.setText(forkType);
        jBoxHelmet.setSelected(helmetIncluded);

        setTitle("Hornet Corsair | Edit Motorcycle");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/favicon.png")).getImage());
    }


    private void initComponents() {
        jTxtIdMotorcycle = new JTextField();
        jTxtBrand = new JTextField();
        jTxtModel = new JTextField();
        jTxtPrice = new JTextField();
        jBoxABS = new JCheckBox("ABS");
        jTxtForkType = new JTextField();
        jBoxHelmet = new JCheckBox("Helmet");
        jBtnSave = new JButton("Save");

        JLabel jLblIdMotorcycle = new JLabel("IdMotorcycle");
        JLabel jLblBrand = new JLabel("Brand");
        JLabel jLblModel = new JLabel("Model");
        JLabel jLblPrice = new JLabel("Price");
        JLabel jLblABS = new JLabel("ABS?");
        JLabel jLblForkType = new JLabel("Fork Type");
        JLabel jLblHelmet = new JLabel("Helmet Included?");
        JLabel LblTitle = new JLabel("Edit Motorcycle", JLabel.CENTER);
        LblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        jBtnSave = new JButton("Save");
        jBtnSave.setBackground(Color.BLACK);
        jBtnSave.setForeground(Color.WHITE);
        jBtnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMotorcycle();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblIdMotorcycle, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtIdMotorcycle, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblBrand, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtBrand, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblModel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtModel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblPrice, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtPrice, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblABS, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70)
                                                .addComponent(jBoxABS, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblForkType, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(90, 90, 90)
                                                .addComponent(jTxtForkType, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblHelmet, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jBoxHelmet, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(91, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                                .addComponent(jBtnSave, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblIdMotorcycle, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtIdMotorcycle, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblBrand, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtBrand, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblModel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtModel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtPrice, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblABS, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBoxABS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblForkType, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtForkType, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblHelmet, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBoxHelmet, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jBtnSave, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
        pack();
    }

    private void saveMotorcycle() {
        try {
            // Recoger los datos del formulario
            String brand = jTxtBrand.getText().trim();
            String model = jTxtModel.getText().trim();
            double price = Double.parseDouble(jTxtPrice.getText().trim());
            boolean hasABS = jBoxABS.isSelected();
            String forkType = jTxtForkType.getText().trim();
            boolean includesHelmet = jBoxHelmet.isSelected();

            // Verificar que los campos obligatorios estén completos
            if (brand.isEmpty() || model.isEmpty() || forkType.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto Motorcycle actualizado
            Motorcycle updatedMotorcycle = new Motorcycle(idMotorcycle, brand, price, model, hasABS, forkType, includesHelmet);

            // Usar el servicio para actualizar la motocicleta
            vehicleService.updateMotorcycle(updatedMotorcycle);  // Aquí se usa vehicleService

            JOptionPane.showMessageDialog(this, "Motorcycle updated successfully.");
            dispose();  // Cierra la ventana al guardar
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid data format for price or ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the motorcycle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
