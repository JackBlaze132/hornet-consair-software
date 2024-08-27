package org.hornetsa.controller;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Bodywork;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.automobile.GUIAddAutomobile;
import org.hornetsa.view.automobile.GUIListAutomobile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AutomobileController implements ActionListener {

    private VehicleService vehicleService;
    private GUIAddAutomobile guiAddAutomobile;
    private GUIListAutomobile guiListAutomobile;
    private ArrayList<Bodywork> bodyworks = new ArrayList<>();


    public AutomobileController(GUIAddAutomobile guiAddAutomobile, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.guiAddAutomobile = guiAddAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;
        this.guiAddAutomobile.getjBtnAdd().addActionListener(this);
    }

    public AutomobileController(GUIListAutomobile guiListAutomobile, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.guiListAutomobile = guiListAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;
        this.guiListAutomobile.getBtnList().addActionListener(this);
    }

    private void addAutomobile() {

        guiAddAutomobile.getjListBodyWork().removeAllItems();
        guiAddAutomobile.getjListBodyWork().addItem("Select");
        for (Bodywork bodywork : bodyworks) {
            guiAddAutomobile.getjListBodyWork().addItem(bodywork.getDescription());
        }
        // Obtener el Bodywork seleccionado del JComboBox
        Bodywork selectedBodywork = bodyworks.get(guiAddAutomobile.getjListBodyWork().getSelectedIndex());

        // Verificar si se ha seleccionado un Bodywork
        if (selectedBodywork == null) {
            JOptionPane.showMessageDialog(guiAddAutomobile, "Please select a bodywork.");
            return;
        }

        try {
            // Obtener los datos del formulario
            String idCar = guiAddAutomobile.getjTxtIdCar().getText().trim();
            String brand = guiAddAutomobile.getjTxtBrand().getText().trim();
            String model = guiAddAutomobile.getjTxtModel().getText().trim();
            double price = Double.parseDouble(guiAddAutomobile.getjTxtPrice().getText().trim());
            boolean hasABS = guiAddAutomobile.getjBoxABS().isSelected();
            int doorCount = (Integer) guiAddAutomobile.getjSpinDoorCount().getValue();
            int airbagCount = (Integer) guiAddAutomobile.getjSpinAirbagCount().getValue();

            // Validar que los campos no estén vacíos
            if (idCar.isEmpty() || brand.isEmpty() || model.isEmpty()) {
                JOptionPane.showMessageDialog(guiAddAutomobile, "Please fill in all required fields.");
                return;
            }

            // Crear el nuevo objeto Automobile
            Automobile automobile = new Automobile(
                    Integer.parseInt(idCar),
                    brand,
                    price,
                    model,
                    hasABS,
                    doorCount,
                    selectedBodywork,
                    airbagCount
            );

            // Agregar el nuevo automóvil al servicio
            vehicleService.addVehicle(automobile);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(guiAddAutomobile, "Automobile added successfully.");

            // Limpiar los campos del formulario si es necesario
            clearForm();

        } catch (NumberFormatException ex) {
            // Manejar el caso donde el precio no es un número válido
            JOptionPane.showMessageDialog(guiAddAutomobile, "Invalid price format.");
        }
    }

    // Método para limpiar los campos del formulario
    private void clearForm() {
        guiAddAutomobile.getjTxtIdCar().setText("");
        guiAddAutomobile.getjTxtBrand().setText("");
        guiAddAutomobile.getjTxtModel().setText("");
        guiAddAutomobile.getjTxtPrice().setText("");
        guiAddAutomobile.getjBoxABS().setSelected(false);
        guiAddAutomobile.getjSpinDoorCount().setValue(0);
        guiAddAutomobile.getjSpinAirbagCount().setValue(0);
        guiAddAutomobile.getjListBodyWork().setSelectedIndex(-1);
    }


    private void listAutomobiles() {
        // Clear table
        guiListAutomobile.getjTable1().setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] { "Id", "Brand", "Price", "Model", "ABS", "Door Count", "Airbag Count", "Bodywork" }
        ));

        // Get automobiles and update table
        Object[][] data = vehicleService.getAutomobiles().stream().map(auto -> new Object[]{
                auto.getIdVehicle(),
                auto.getBrand(),
                auto.getPrice(),
                auto.getModel(),
                auto.isAbs(),
                auto.getDoorCount(),
                auto.getAirbagCount(),
                auto.getBodywork()
        }).toArray(Object[][]::new);

        DefaultTableModel model = (DefaultTableModel) guiListAutomobile.getjTable1().getModel();
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (guiAddAutomobile != null && e.getSource() == guiAddAutomobile.getjBtnAdd()) {
            addAutomobile();
        }
        if (guiListAutomobile != null && e.getSource() == guiListAutomobile.getBtnList()) {
            listAutomobiles();
        }
    }
}
