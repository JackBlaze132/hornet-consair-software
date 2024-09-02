package org.hornetsa.controller;

import org.hornetsa.model.Motorcycle;
import org.hornetsa.model.Vehicle;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.motorcycle.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

public class MotorcycleController implements ActionListener{

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    private VehicleService vehicleService;
    private GUIAddMotorcycle guiAddMotorcycle;
    private GUIListMotorcycle guiListMotorcycle;
    private GUIDeleteMotorcycle guiDeleteMotorcycle;
    private GUISearchMotorcycle guiSearchMotorcycle;
    private GUICalculateDiscountMotorcycle guiCalculateDiscountMotorcycle;

    private GUICalculateInsuranceMotorcycle guiCalculateIsuranceMotorcycle;

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
        this.guiDeleteMotorcycle.getBtnSearch().addActionListener(this);
        this.guiDeleteMotorcycle.getjBtnDelete().addActionListener(this);
    }

    public MotorcycleController(GUISearchMotorcycle guiSearchMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiSearchMotorcycle = guiSearchMotorcycle;
        this.guiSearchMotorcycle.getBtnSearch().addActionListener(this);
    }

    public MotorcycleController(GUICalculateDiscountMotorcycle guiCalculateDiscountMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiCalculateDiscountMotorcycle = guiCalculateDiscountMotorcycle;
        this.guiCalculateDiscountMotorcycle.getBtnSearch().addActionListener(this);
        this.guiCalculateDiscountMotorcycle.getBtnCalculateDiscount().addActionListener(this);
    }

    public MotorcycleController(GUICalculateInsuranceMotorcycle guiCalculateInsuranceMotorcycle, VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.guiCalculateIsuranceMotorcycle = guiCalculateInsuranceMotorcycle;
        this.guiCalculateIsuranceMotorcycle.getBtnSearch().addActionListener(this);
        this.guiCalculateIsuranceMotorcycle.getBtnCalculateInsurance().addActionListener(this);
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

    private void clearFields() {
        guiAddMotorcycle.getjTxtIdMotorcycle().setText("");
        guiAddMotorcycle.getjTxtBrand().setText("");
        guiAddMotorcycle.getjTxtPrice().setText("");
        guiAddMotorcycle.getjTxtModel().setText("");
        guiAddMotorcycle.getjBoxABS().setSelected(false);
        guiAddMotorcycle.getjTxtForkType().setText("");
        guiAddMotorcycle.getjBoxHelmet().setSelected(false);
    }

    private void updateMotorcycleTable() {
        DefaultTableModel model = (DefaultTableModel) guiListMotorcycle.getTable().getModel();
        model.setRowCount(0);
        List<Motorcycle> motorcycles = vehicleService.getMotorcyclesList();

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

        if (guiDeleteMotorcycle.getTxtIdMotorcycle().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int vehicleNumber = Integer.parseInt(guiDeleteMotorcycle.getTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getMotorcycle(vehicleNumber);

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
            }else {
                JOptionPane.showMessageDialog(guiSearchMotorcycle, "Motorcycle not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Invalid vehicle number format.");
        }
    }

    private void resetDeleteTable() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteMotorcycle.getjTableDeleteMotorcycle().getModel();
        model.setRowCount(0);
    }

    private void DeleteMotorcycle() {
        int selectedRow = guiDeleteMotorcycle.getjTableDeleteMotorcycle().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Please select a row to delete.");
            return;
        }
        int id = (int) guiDeleteMotorcycle.getjTableDeleteMotorcycle().getValueAt(selectedRow, 0);
        vehicleService.removeVehicle(id);
        resetDeleteTable();
        JOptionPane.showMessageDialog(guiDeleteMotorcycle, "Motorbike deleted successfully.");
    }

    private void updateMotorcycleTableSearch(){
        DefaultTableModel model = (DefaultTableModel) guiSearchMotorcycle.getjTable1().getModel();
        model.setRowCount(0);

        if (guiSearchMotorcycle.getjTxtIdMotorcycle().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiSearchMotorcycle, "Please enter a valid number.");
        }else try {
            int vehicleNumber = Integer.parseInt(guiSearchMotorcycle.getjTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getMotorcycle(vehicleNumber);

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

    private void updateMotorcycleTableCalculateDiscount(){
        DefaultTableModel model = (DefaultTableModel) guiCalculateDiscountMotorcycle.getTableCalculateDiscount().getModel();
        model.setRowCount(0);

        if (guiCalculateDiscountMotorcycle.getTxtIdMotorcycle().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiCalculateDiscountMotorcycle, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int vehicleNumber = Integer.parseInt(guiCalculateDiscountMotorcycle.getTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getMotorcycle(vehicleNumber);

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

    private void updateMotorcycleTableCalculateInsurance(){
        DefaultTableModel model = (DefaultTableModel) guiCalculateIsuranceMotorcycle.getjTableCalculateInsurance().getModel();
        model.setRowCount(0);

        if (guiCalculateIsuranceMotorcycle.getTxtIdMotorcycle().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiCalculateIsuranceMotorcycle, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int vehicleNumber = Integer.parseInt(guiCalculateIsuranceMotorcycle.getTxtIdMotorcycle().getText());
            Vehicle vehicle = vehicleService.getMotorcycle(vehicleNumber);

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

    public void getMotorcycleDiscount() {
        int selectedRow = guiCalculateDiscountMotorcycle.getTableCalculateDiscount().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiCalculateDiscountMotorcycle, "Please select a row to calculate discount.");
            return;
        }
        int id = (int) guiCalculateDiscountMotorcycle.getTableCalculateDiscount().getValueAt(selectedRow, 0);
        Vehicle vehicle = vehicleService.getMotorcycle(id);
        StringBuilder message = new StringBuilder();
        if (vehicle instanceof Motorcycle motorcycle) {
            message.append("ID: ").append(motorcycle.getIdVehicle()).append("\n")
                    .append("Price: ").append(formatter.format(motorcycle.getPrice())).append("\n")
                    .append("Brand: ").append(motorcycle.getBrand()).append("\n")
                    .append("Includes Helmet: ").append(motorcycle.isHelmetIncluded()).append("\n")
                    .append("Discount: ").append(formatter.format(motorcycle.calculateDiscount())).append("\n\n")
                    .append("Total: ").append(formatter.format(motorcycle.getPrice() - motorcycle.calculateDiscount()));
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Motorcycle Discount", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getMotorcycleInsurance(){
        int selectedRow = guiCalculateIsuranceMotorcycle.getjTableCalculateInsurance().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiCalculateIsuranceMotorcycle, "Please select a row to calculate insurance.");
            return;
        }
        int id = (int) guiCalculateIsuranceMotorcycle.getjTableCalculateInsurance().getValueAt(selectedRow, 0);
        Vehicle vehicle = vehicleService.getMotorcycle(id);
        StringBuilder message = new StringBuilder();
        if (vehicle instanceof Motorcycle motorcycle) {
            message.append("ID: ").append(motorcycle.getIdVehicle()).append("\n")
                    .append("Price: ").append(formatter.format(motorcycle.getPrice())).append("\n")
                    .append("Brand: ").append(motorcycle.getBrand()).append("\n")
                    .append("Insurance: ").append(formatter.format(motorcycle.calculateInsurance()));
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Motorcycle Insurance", JOptionPane.INFORMATION_MESSAGE);
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
        if (guiDeleteMotorcycle != null && e.getSource() == guiDeleteMotorcycle.getBtnSearch()) {
            updateMotorcycleDeleteTable();
        }
        if (guiSearchMotorcycle != null && e.getSource() == guiSearchMotorcycle.getBtnSearch()) {
            updateMotorcycleTableSearch();
        }
        if (guiCalculateDiscountMotorcycle != null && e.getSource() == guiCalculateDiscountMotorcycle.getBtnSearch()) {
            updateMotorcycleTableCalculateDiscount();
        }
        if (guiCalculateIsuranceMotorcycle != null && e.getSource() == guiCalculateIsuranceMotorcycle.getBtnSearch()) {
            updateMotorcycleTableCalculateInsurance();
        }
        if (guiCalculateDiscountMotorcycle != null && e.getSource() == guiCalculateDiscountMotorcycle.getBtnCalculateDiscount()) {
            getMotorcycleDiscount();
        }
        if (guiCalculateIsuranceMotorcycle != null && e.getSource() == guiCalculateIsuranceMotorcycle.getBtnCalculateInsurance()) {
            getMotorcycleInsurance();
        }
    }
}

