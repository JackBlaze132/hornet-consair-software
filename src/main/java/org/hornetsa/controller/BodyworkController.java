package org.hornetsa.controller;

import org.hornetsa.model.Bodywork;
import org.hornetsa.model.Bodywork;
import org.hornetsa.model.Bodywork;
import org.hornetsa.model.Vehicle;
import org.hornetsa.view.bodywork.GUIAddBodywork;
import org.hornetsa.view.bodywork.GUIDeleteBodywork;
import org.hornetsa.view.bodywork.GUIListBodywork;
import org.hornetsa.services.BodyworkService;
import org.hornetsa.view.bodywork.GUISearchBodywork;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BodyworkController implements ActionListener {

    private BodyworkService bodyworkService;
    private GUIAddBodywork guiAddBodywork;
    private GUIListBodywork guiListBodywork;
    private GUISearchBodywork guiSearchBodywork;
    private GUIDeleteBodywork guiDeleteBodywork;

    // Constructor para GUIAddBodywork
    public BodyworkController(GUIAddBodywork guiAddBodywork, BodyworkService bodyworkService) {
        this.guiAddBodywork = guiAddBodywork;
        this.bodyworkService = bodyworkService;
        this.guiAddBodywork.getBtnAdd().addActionListener(this);
    }

    // Constructor para GUIListBodywork
    public BodyworkController(GUIListBodywork guiListBodywork, BodyworkService bodyworkService) {
        this.guiListBodywork = guiListBodywork;
        this.bodyworkService = bodyworkService;
        this.guiListBodywork.getBtnList().addActionListener(this);
    }

    public BodyworkController(GUISearchBodywork guiSearchBodywork, BodyworkService bodyworkService) {
        this.guiSearchBodywork = guiSearchBodywork;
        this.bodyworkService = bodyworkService;
        this.guiSearchBodywork.getBtnSearch().addActionListener(this);
    }

    public BodyworkController(GUIDeleteBodywork guiDeleteBodywork, BodyworkService bodyworkService) {
        this.guiDeleteBodywork = guiDeleteBodywork;
        this.bodyworkService = bodyworkService;
        this.guiDeleteBodywork.getBtnSearch().addActionListener(this);
        this.guiDeleteBodywork.getBtnDelete().addActionListener(this);
    }

    private void addBodywork() {
        String idText = guiAddBodywork.getIdBodyworkField().getText();
        String description = guiAddBodywork.getDescriptionField().getText();

        if (!idText.isEmpty() && !description.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);
                Bodywork bodywork = new Bodywork(id, description);
                bodyworkService.addBodywork(bodywork);
                JOptionPane.showMessageDialog(guiAddBodywork, "Bodywork added successfully");
                clearAddBodyworkFields();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(guiAddBodywork, "ID must be a valid number");
            }
        } else {
            JOptionPane.showMessageDialog(guiAddBodywork, "Please fill in all the fields");
        }
    }

    private void deleteBodywork() {
        int selectedRow = guiDeleteBodywork.getTableDeleteBodywork().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiDeleteBodywork, "Please select a row to delete.");
            return;
        }
        int id = (int) guiDeleteBodywork.getTableDeleteBodywork().getValueAt(selectedRow, 0);
        bodyworkService.removeBodywork(id);
        resetDeleteTable();
        JOptionPane.showMessageDialog(guiDeleteBodywork, "Bodywork deleted successfully.");
    }

    private void resetDeleteTable() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteBodywork.getTableDeleteBodywork().getModel();
        model.setRowCount(0);
    }

    private void updateBodyworkTable() {
        DefaultTableModel model = (DefaultTableModel) guiListBodywork.getjTable1().getModel();
        model.setRowCount(0); // Clear existing rows
        for (Bodywork bodywork : bodyworkService.getBodyworks()) {
            model.addRow(new Object[]{bodywork.getIdBody(), bodywork.getDescription()});
        }
    }

    private void updateBodyworkTableSearch(){
        DefaultTableModel model = (DefaultTableModel) guiSearchBodywork.getjTableSearchBodywork().getModel();
        model.setRowCount(0);

        if (guiSearchBodywork.getjTxtIdBodywork().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiSearchBodywork, "Please enter a valid number.");
        }else try {
            int bodyworkNumber = Integer.parseInt(guiSearchBodywork.getjTxtIdBodywork().getText());
            Bodywork bodywork = bodyworkService.getBodywork(bodyworkNumber);

            if(bodywork != null) {
                model.addRow(new Object[]{
                        bodywork.getIdBody(),
                        bodywork.getDescription()

                });
            } else {
                JOptionPane.showMessageDialog(guiSearchBodywork, "Bodywork not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiSearchBodywork, "Invalid vehicle number format.");
        }

    }

    private void updateBodyworkTableDelete() {
        DefaultTableModel model = (DefaultTableModel) guiDeleteBodywork.getTableDeleteBodywork().getModel();
        model.setRowCount(0);

        if (guiDeleteBodywork.getTxtIdBodywork().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiDeleteBodywork, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        }else try {
            int bodyworkNumber = Integer.parseInt(guiDeleteBodywork.getTxtIdBodywork().getText());
            Bodywork bodywork = bodyworkService.getBodywork(bodyworkNumber);

            if(bodywork != null) {
                model.addRow(new Object[]{
                        bodywork.getIdBody(),
                        bodywork.getDescription()
                });
            }else {
                JOptionPane.showMessageDialog(guiDeleteBodywork, "Bodywork not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(guiDeleteBodywork, "Invalid bodywork number format.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (guiAddBodywork != null && e.getSource() == guiAddBodywork.getBtnAdd()) {
            addBodywork();
        }
        if (guiListBodywork != null && e.getSource() == guiListBodywork.getBtnList()) {
            updateBodyworkTable();
        }
        if (guiSearchBodywork != null && e.getSource() == guiSearchBodywork.getBtnSearch()) {
            updateBodyworkTableSearch();
        }
        if (guiDeleteBodywork != null && e.getSource() == guiDeleteBodywork.getBtnDelete()) {
            deleteBodywork();
        }
        if (guiDeleteBodywork != null && e.getSource() == guiDeleteBodywork.getBtnSearch()) {
            updateBodyworkTableDelete();
        }
    }

    private void clearAddBodyworkFields() {
        guiAddBodywork.getIdBodyworkField().setText("");
        guiAddBodywork.getDescriptionField().setText("");
    }
}
