package org.hornetsa.view.automobile;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Bodywork;
import org.hornetsa.services.VehicleService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIEditAutomobile extends JFrame {

    private JTextField jTxtIdCar, jTxtBrand, jTxtModel, jTxtPrice;
    private JCheckBox jBoxABS;
    private JSpinner jSpinDoorCount, jSpinAirbagCount;
    private JComboBox<String> jListBodyWork;
    private JButton jBtnSave;
    private VehicleService vehicleService;
    private ArrayList<Bodywork> bodyworks;
    private int idAutomobile;

    public GUIEditAutomobile(int idAutomobile, String brand, String model, double price, boolean hasAbs, String bodywork, int doorCount, int airbagCount, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.idAutomobile = idAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;

        initComponents();

        // Cargar datos en los campos
        jTxtIdCar.setText(String.valueOf(idAutomobile));
        jTxtIdCar.setEditable(false);
        jTxtBrand.setText(brand);
        jTxtModel.setText(model);
        jTxtPrice.setText(String.valueOf(price));
        jBoxABS.setSelected(hasAbs);
        jSpinDoorCount.setValue(doorCount);
        jSpinAirbagCount.setValue(airbagCount);
        jListBodyWork.setSelectedItem(bodywork);

        setTitle("Hornet Corsair | Edit Automobile");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/favicon.png")).getImage());
    }

    private void initComponents() {
        jTxtIdCar = new JTextField();
        jTxtBrand = new JTextField();
        jTxtModel = new JTextField();
        jTxtPrice = new JTextField();
        jBoxABS = new JCheckBox("ABS");
        jSpinDoorCount = new JSpinner();
        jSpinAirbagCount = new JSpinner();
        jListBodyWork = new JComboBox<>();
        jBtnSave = new JButton("Save");

        for (Bodywork bodywork : bodyworks) {
            jListBodyWork.addItem(bodywork.getDescription());
        }

        JLabel jLblIdCar1 = new JLabel("IdCar");
        JLabel jLblCar = new JLabel("Brand");
        JLabel jLblPrice = new JLabel("Price");
        JLabel jLblModel = new JLabel("Model");
        JLabel jLblAB = new JLabel("Does it have ABS?");
        JLabel jLblDoorCount = new JLabel("Number of doors");
        JLabel jLblBodyWork = new JLabel("Bodywork");
        JLabel jLblAirbag = new JLabel("Number of airbags");
        JLabel LblTitle = new JLabel("Edit Automobile", JLabel.CENTER);

        LblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        jBtnSave.setBackground(Color.BLACK);
        jBtnSave.setForeground(Color.WHITE);
        jBtnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAutomobile();  // Llama al método para guardar
            }
        });

        // Layout del formulario usando GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(jBtnSave, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblIdCar1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(107, 107, 107)
                                                        .addComponent(jTxtIdCar, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblCar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(107, 107, 107)
                                                        .addComponent(jTxtBrand, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblPrice, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(107, 107, 107)
                                                        .addComponent(jTxtPrice, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblModel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(107, 107, 107)
                                                        .addComponent(jTxtModel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblAB, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(70, 70, 70)
                                                        .addComponent(jBoxABS, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblDoorCount, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(90, 90, 90)
                                                        .addComponent(jSpinDoorCount, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblBodyWork, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(107, 107, 107)
                                                        .addComponent(jListBodyWork, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLblAirbag, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(70, 70, 70)
                                                        .addComponent(jSpinAirbagCount, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(91, 91, 91)))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LblTitle, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblIdCar1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtIdCar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblCar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtBrand, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtPrice, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblModel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtModel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblAB, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBoxABS, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblDoorCount, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinDoorCount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblBodyWork, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jListBodyWork, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblAirbag, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinAirbagCount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(30)
                                .addComponent(jBtnSave, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );

        pack();
    }

    // Método para guardar el automóvil actualizado
    private void saveAutomobile() {
        try {
            String brand = jTxtBrand.getText().trim();
            String model = jTxtModel.getText().trim();
            double price = Double.parseDouble(jTxtPrice.getText().trim());
            boolean hasABS = jBoxABS.isSelected();
            int doorCount = (Integer) jSpinDoorCount.getValue();
            int airbagCount = (Integer) jSpinAirbagCount.getValue();
            String selectedBodyworkDescription = (String) jListBodyWork.getSelectedItem();

            if (brand.isEmpty() || model.isEmpty() || selectedBodyworkDescription.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
                return;
            }

            // Buscar el Bodywork usando la descripción seleccionada
            Bodywork selectedBodywork = findBodyworkByDescription(selectedBodyworkDescription);
            if (selectedBodywork == null) {
                JOptionPane.showMessageDialog(this, "Invalid bodywork selected.");
                return;
            }

            // Crear el automóvil actualizado
            Automobile updatedAutomobile = new Automobile(idAutomobile, brand, price, model, hasABS, doorCount, selectedBodywork, airbagCount);

            // Llamar al método para actualizar en el servicio
            vehicleService.updateVehicle(updatedAutomobile);

            JOptionPane.showMessageDialog(this, "Automobile updated successfully.");
            dispose();  // Cierra la ventana al guardar

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid data format.");
        }
    }

    // Método para buscar Bodywork por descripción
    private Bodywork findBodyworkByDescription(String description) {
        for (Bodywork bodywork : bodyworks) {
            if (bodywork.getDescription().equals(description)) {
                return bodywork;
            }
        }
        return null;  // Retorna null si no se encuentra
    }
}
