package org.hornetsa.controller;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Bodywork;
import org.hornetsa.model.Vehicle;
import org.hornetsa.services.VehicleService;
import org.hornetsa.view.automobile.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AutomobileController implements ActionListener {

    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    private VehicleService vehicleService;
    private GUIAddAutomobile guiAddAutomobile;
    private GUIListAutomobile guiListAutomobile;
    private GUIDeleteAutomobile guiDeleteAutomobile;
    private GUISearchAutomobile guiSearchAutomobile;
    private GUICalculateInsuranceAutomobile guiCalculateInsuranceAutomobile;
    private ArrayList<Bodywork> bodyworks;


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

    public AutomobileController(GUIDeleteAutomobile guiDeleteAutomobile, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.guiDeleteAutomobile = guiDeleteAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;
        this.guiDeleteAutomobile.getBtnSearch().addActionListener(this);
        this.guiDeleteAutomobile.getjBtnDelete().addActionListener(this);
    }

    public AutomobileController(GUISearchAutomobile guiSearchAutomobile, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.guiSearchAutomobile = guiSearchAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;
        this.guiSearchAutomobile.getBtnSearch().addActionListener(this);
    }

    public AutomobileController(GUICalculateInsuranceAutomobile guiCalculateInsuranceAutomobile, VehicleService vehicleService, ArrayList<Bodywork> bodyworks) {
        this.guiCalculateInsuranceAutomobile = guiCalculateInsuranceAutomobile;
        this.vehicleService = vehicleService;
        this.bodyworks = bodyworks;
        this.guiCalculateInsuranceAutomobile.getBtnSearch().addActionListener(this);
        this.guiCalculateInsuranceAutomobile.getBtnCalculateInsurance().addActionListener(this);
    }


    private void addAutomobile() {

        guiAddAutomobile.getjListBodyWork().removeAllItems();
        guiAddAutomobile.getjListBodyWork().addItem("Select");
        for (Bodywork bodywork : bodyworks) {
            guiAddAutomobile.getjListBodyWork().addItem(bodywork.getDescription());
        }
        Bodywork selectedBodywork = bodyworks.get(guiAddAutomobile.getjListBodyWork().getSelectedIndex());
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
            if (idCar.isEmpty() || brand.isEmpty() || model.isEmpty()) {
                JOptionPane.showMessageDialog(guiAddAutomobile, "Please fill in all required fields.");
                return;
            }
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
            vehicleService.addVehicle(automobile);
            JOptionPane.showMessageDialog(guiAddAutomobile, "Automobile added successfully.");
            clearForm();

        } catch (NumberFormatException ex) {
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


    private void updateAutomobileTable() {
        DefaultTableModel model = (DefaultTableModel) guiListAutomobile.getjTable1().getModel();
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

    private void updateAutomobileTableDelete() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteAutomobile.getjTableDeleteAutomobile().getModel();
        model.setRowCount(0);

        if (guiDeleteAutomobile.getjTxtIdAutomobile().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiDeleteAutomobile, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int vehicleNumber = Integer.parseInt(guiDeleteAutomobile.getjTxtIdAutomobile().getText());
            Vehicle vehicle = vehicleService.getAutomobile(vehicleNumber);

            if(vehicle instanceof Automobile automobile) {
                Object[] rowData = {
                        automobile.getIdVehicle(),
                        automobile.getBrand(),
                        automobile.getModel(),
                        automobile.getPrice(),
                        automobile.isAbs(),
                        automobile.getBodywork().getDescription(),
                        automobile.getDoorCount(),
                        automobile.getAirbagCount()
                };
                model.addRow(rowData);
            }else {
                JOptionPane.showMessageDialog(guiDeleteAutomobile, "Motorcycle not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiDeleteAutomobile, "Invalid vehicle number format.");
        }
    }

    private void resetDeleteTable() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteAutomobile.getjTableDeleteAutomobile().getModel();
        model.setRowCount(0);
    }

    private void updateAutomobileTableSearch(){
        DefaultTableModel model = (DefaultTableModel) guiSearchAutomobile.getjTableSearchAutomobile().getModel();
        model.setRowCount(0);

        if (guiSearchAutomobile.getjTxtIdAutomobile().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiSearchAutomobile, "Please enter a valid number.");
        }else try {
            int vehicleNumber = Integer.parseInt(guiSearchAutomobile.getjTxtIdAutomobile().getText());
            Vehicle vehicle = vehicleService.getAutomobile(vehicleNumber);

            if(vehicle instanceof Automobile automobile) {
                model.addRow(new Object[]{
                        automobile.getIdVehicle(),
                        automobile.getBrand(),
                        automobile.getPrice(),
                        automobile.getModel(),
                        automobile.isAbs(),
                        automobile.getDoorCount(),
                        automobile.getAirbagCount(),
                        automobile.getBodywork().getDescription()
                });
            } else {
                JOptionPane.showMessageDialog(guiSearchAutomobile, "Automobile not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiSearchAutomobile, "Invalid vehicle number format.");
        }

    }

    private void updateAutomobileTableCalculateInsurance(){
        DefaultTableModel model = (DefaultTableModel) guiCalculateInsuranceAutomobile.getjTableCalculateInsuranceAutomobile().getModel();
        model.setRowCount(0);

        if (guiCalculateInsuranceAutomobile.getTxtIdAutomobile().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiCalculateInsuranceAutomobile, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int vehicleNumber = Integer.parseInt(guiCalculateInsuranceAutomobile.getTxtIdAutomobile().getText());
            Vehicle vehicle = vehicleService.getAutomobile(vehicleNumber);

            if(vehicle instanceof Automobile automobile) {
                Object[] rowData = {
                        automobile.getIdVehicle(),
                        automobile.getBrand(),
                        automobile.getModel(),
                        automobile.getPrice(),
                        automobile.isAbs(),
                        automobile.getBodywork().getDescription(),
                        automobile.getDoorCount(),
                        automobile.getAirbagCount()

                };
                model.addRow(rowData);
            } else {
                JOptionPane.showMessageDialog(guiSearchAutomobile, "Automobile not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiSearchAutomobile, "Invalid vehicle number format.");
        }
    }

    private void deleteAutomobile() {
        int selectedRow = guiDeleteAutomobile.getjTableDeleteAutomobile().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiDeleteAutomobile, "Please select a row to delete.");
            return;
        }
        int id = (int) guiDeleteAutomobile.getjTableDeleteAutomobile().getValueAt(selectedRow, 0);
        vehicleService.removeAutomobile(id);
        resetDeleteTable();
        JOptionPane.showMessageDialog(guiDeleteAutomobile, "Automobile deleted successfully.");
    }

    public void getAutomobileInsurance(){
        int selectedRow = guiCalculateInsuranceAutomobile.getjTableCalculateInsuranceAutomobile().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiCalculateInsuranceAutomobile, "Please select a row to calculate insurance.");
            return;
        }
        int id = (int) guiCalculateInsuranceAutomobile.getjTableCalculateInsuranceAutomobile().getValueAt(selectedRow, 0);
        Vehicle vehicle = vehicleService.getAutomobile(id);
        StringBuilder message = new StringBuilder();
        if (vehicle instanceof Automobile automobile) {
            message.append("ID: ").append(automobile.getIdVehicle()).append("\n")
                    .append("Price: ").append(formatter.format(automobile.getPrice())).append("\n")
                    .append("Brand: ").append(automobile.getBrand()).append("\n")
                    .append("Insurance: ").append(formatter.format(automobile.calculateInsurance()));
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Motorcycle Insurance", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (guiAddAutomobile != null && e.getSource() == guiAddAutomobile.getjBtnAdd()) {
            addAutomobile();
        }
        if (guiListAutomobile != null && e.getSource() == guiListAutomobile.getBtnList()) {
            System.out.println("List button clicked");
            updateAutomobileTable();
        }
        if (guiDeleteAutomobile != null && e.getSource() == guiDeleteAutomobile.getjBtnDelete()) {
            deleteAutomobile();
        }
        if (guiDeleteAutomobile != null && e.getSource() == guiDeleteAutomobile.getBtnSearch()) {
            updateAutomobileTableDelete();
        }
        if (guiSearchAutomobile != null && e.getSource() == guiSearchAutomobile.getBtnSearch()) {
            updateAutomobileTableSearch();
        }
        if (guiCalculateInsuranceAutomobile != null && e.getSource() == guiCalculateInsuranceAutomobile.getBtnSearch()) {
            updateAutomobileTableCalculateInsurance();
        }
        if (guiCalculateInsuranceAutomobile != null && e.getSource() == guiCalculateInsuranceAutomobile.getBtnCalculateInsurance()) {
            getAutomobileInsurance();
        }
    }
}
