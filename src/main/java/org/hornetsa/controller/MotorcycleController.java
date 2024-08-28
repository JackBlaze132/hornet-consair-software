package org.hornetsa.controller;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Motorcycle;
import org.hornetsa.model.Vehicle;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.automobile.GUISearchAutomobile;
import org.hornetsa.view.motorcycle.GUIAddMotorcycle;
import org.hornetsa.view.motorcycle.GUIDeleteMotorcycle;
import org.hornetsa.view.motorcycle.GUIListMotorcycle;
import org.hornetsa.view.motorcycle.GUISearchMotorcycle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MotorcycleController implements ActionListener{

    private VehicleService vehicleService;
    private GUIAddMotorcycle guiAddMotorcycle;
    private GUIListMotorcycle guiListMotorcycle;
    private GUIDeleteMotorcycle guiDeleteMotorcycle;
    private GUISearchMotorcycle guiSearchMotorcycle;

    public MotorcycleController(GUIAddMotorcycle guiAddMotorcycle, VehicleService vehicleService) {
        this.guiAddMotorcycle = guiAddMotorcycle;
        this.vehicleService = vehicleService;
        this.guiAddMotorcycle.getBtnAdd().addActionListener(this);
    }

    public MotorcycleController(GUIListMotorcycle guiListMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiListMotorcycle = guiListMotorcycle;
        this.guiListMotorcycle.getBtnList().addActionListener(this);
    }

    public MotorcycleController(GUIDeleteMotorcycle guiDeleteMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiDeleteMotorcycle = guiDeleteMotorcycle;
        this.guiDeleteMotorcycle.getBtnList().addActionListener(this);
        this.guiDeleteMotorcycle.getjBtnDelete().addActionListener(this);
    }

    public MotorcycleController(GUISearchMotorcycle guiSearchMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiSearchMotorcycle = guiSearchMotorcycle;
        this.guiSearchMotorcycle.getBtnSearch().addActionListener(this);
    }

    private void addMotorcycle() {
        try {
            int idMotorcycle = Integer.parseInt(guiAddMotorcycle.getjTxtIdMotorcycle().getText());
            String brand = guiAddMotorcycle.getjTxtBrand().getText();
            double price = Double.parseDouble(guiAddMotorcycle.getjTxtPrice().getText());
            String model = guiAddMotorcycle.getjTxtModel().getText();
            boolean hasABS = guiAddMotorcycle.getjBoxABS().isSelected();
            String forkType = guiAddMotorcycle.getjTxtForkType().getText();
            boolean includesHelmet = guiAddMotorcycle.getjBoxHelmet().isSelected();

            Motorcycle motorcycle = new Motorcycle(idMotorcycle, brand, price, model, hasABS, forkType, includesHelmet);
            vehicleService.addVehicle(motorcycle);

            JOptionPane.showMessageDialog(guiAddMotorcycle, "Motorcycle added successfully!");

            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiAddMotorcycle, "Please enter valid data for all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(guiAddMotorcycle, "An error occurred while adding the motorcycle.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateMotorcycleTable() {
        DefaultTableModel model = (DefaultTableModel) guiListMotorcycle.getTable().getModel();
        model.setRowCount(0);
        List<Motorcycle> motorcycles = vehicleService.getMotorcycles();

        for (Motorcycle motorcycle : motorcycles) {
            Object[] rowData = {
                    motorcycle.getIdVehicle(),
                    motorcycle.getBrand(),
                    motorcycle.getPrice(),
                    motorcycle.getModel(),
                    motorcycle.isAbs(),
                    motorcycle.getForkType(),
                    motorcycle.isHelmetIncluded()
            };
            model.addRow(rowData);
        }
    }

    private void updateMotorcycleDeleteTable() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteMotorcycle.getjTableDeleteMotorcycle().getModel();
        model.setRowCount(0);
        List<Motorcycle> motorcycles = vehicleService.getMotorcycles();

        for (Motorcycle motorcycle : motorcycles) {
            Object[] rowData = {
                    motorcycle.getIdVehicle(),
                    motorcycle.getBrand(),
                    motorcycle.getPrice(),
                    motorcycle.getModel(),
                    motorcycle.isAbs(),
                    motorcycle.getForkType(),
                    motorcycle.isHelmetIncluded()
            };
            model.addRow(rowData);
        }
    }


    private void clearFields() {
        guiAddMotorcycle.getjTxtIdMotorcycle().setText("");
        guiAddMotorcycle.getjTxtBrand().setText("");
        guiAddMotorcycle.getjTxtPrice().setText("");
        guiAddMotorcycle.getjTxtModel().setText("");
        guiAddMotorcycle.getjBoxABS().setSelected(false);
        guiAddMotorcycle.getjTxtForkType().setText("");
        guiAddMotorcycle.getjBoxHelmet().setSelected(false);
    }

    private void DeleteMotorcycle() {
        int selectedRow = guiDeleteMotorcycle.getjTableDeleteMotorcycle().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Please select a row to delete.");
            return;
        }
        int id = (int) guiDeleteMotorcycle.getjTableDeleteMotorcycle().getValueAt(selectedRow, 0);
        vehicleService.removeVehicle(id);
        updateMotorcycleDeleteTable();
        JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Motorbike deleted successfully.");
    }

    private void updateMotorcycleTableSearch(){
        DefaultTableModel model = (DefaultTableModel) guiSearchMotorcycle.getjTable1().getModel();
        model.setRowCount(0);

        if (guiSearchMotorcycle.getjTxtIdMotorcycle().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiSearchMotorcycle, "Please enter a valid number.");
        }else try {
            int vehicleNumber = Integer.parseInt(guiSearchMotorcycle.getjTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

            if(vehicle instanceof Motorcycle motorcycle) {
                Object[] rowData = {
                        motorcycle.getIdVehicle(),
                        motorcycle.getBrand(),
                        motorcycle.getPrice(),
                        motorcycle.getModel(),
                        motorcycle.isAbs(),
                        motorcycle.getForkType(),
                        motorcycle.isHelmetIncluded()
                };
                model.addRow(rowData);
            } else {
                JOptionPane.showMessageDialog(guiSearchMotorcycle, "Motorcycle not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiSearchMotorcycle, "Invalid vehicle number format.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (guiAddMotorcycle != null && e.getSource() == guiAddMotorcycle.getBtnAdd()) {
            System.out.println("Add motorcycle");
            addMotorcycle();

        }
        if (guiListMotorcycle != null && e.getSource() == guiListMotorcycle.getBtnList()) {
            updateMotorcycleTable();
        }
        if (guiDeleteMotorcycle != null && e.getSource() == guiDeleteMotorcycle.getjBtnDelete()) {
            DeleteMotorcycle();
        }
        if (guiDeleteMotorcycle != null && e.getSource() == guiDeleteMotorcycle.getBtnList()) {
            updateMotorcycleDeleteTable();
        }
        if (guiSearchMotorcycle != null && e.getSource() == guiSearchMotorcycle.getBtnSearch()) {
            updateMotorcycleTableSearch();
        }
    }
}

