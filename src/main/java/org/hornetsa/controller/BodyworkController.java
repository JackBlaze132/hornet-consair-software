package org.hornetsa.controller;

import org.hornetsa.model.Bodywork;
import org.hornetsa.view.bodywork.*;
import org.hornetsa.services.BodyworkService;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class BodyworkController implements ActionListener {

    private BodyworkService bodyworkService;
    private GUIAddBodywork guiAddBodywork;
    private GUIListBodywork guiListBodywork;
    private GUISearchBodywork guiSearchBodywork;
    private GUIDeleteBodywork guiDeleteBodywork;
    
    private GUIUpdateBodywork guiUpdateBodywork;

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

    public BodyworkController(GUIUpdateBodywork guiUpdateBodywork, BodyworkService bodyworkService) {
        this.guiUpdateBodywork = guiUpdateBodywork;
        this.bodyworkService = bodyworkService;
        this.guiUpdateBodywork.getBtnSearch().addActionListener(this);
        this.guiUpdateBodywork.getBtnUpdate().addActionListener(this);
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
                Logger.getLogger(BodyworkController.class.getName()).severe(e.getMessage());
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

    private void refreshBodyworkTable() {
        DefaultTableModel model = (DefaultTableModel) guiListBodywork.getjTable1().getModel();
        model.setRowCount(0); // Clear existing rows
        for (Bodywork bodywork : bodyworkService.getBodyworks()) {
            model.addRow(new Object[]{bodywork.getIdBody(), bodywork.getDescription()});
        }
    }

    private void updateBodywork() {
        int selectedRow = guiUpdateBodywork.getjTableUpdateBodywork().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(guiUpdateBodywork, "Please select a row to update.");
            return;
        }

        int idBodywork = (int) guiUpdateBodywork.getjTableUpdateBodywork().getValueAt(selectedRow, 0);
        String description = (String) guiUpdateBodywork.getjTableUpdateBodywork().getValueAt(selectedRow, 1);

        GUIEditBodywork guiEditBodywork = new GUIEditBodywork(idBodywork, description, bodyworkService);
        guiEditBodywork.setVisible(true);
    }

    private void refreshBodyworkTableSearch(){
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

    private void refreshBodyworkTableDelete() {
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

    private void refreshBodyworkTableUpdate() {
        DefaultTableModel model = (DefaultTableModel) guiUpdateBodywork.getjTableUpdateBodywork().getModel();
        model.setRowCount(0);

        if (guiUpdateBodywork.getTxtIdBodywork().getText().isEmpty()){
            JOptionPane.showMessageDialog(guiUpdateBodywork, "Please enter a valid number.","Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                int idBody = Integer.parseInt(guiUpdateBodywork.getTxtIdBodywork().getText());
                Bodywork bodywork = bodyworkService.getBodywork(idBody);

                if(bodywork != null) {
                    model.addRow(new Object[]{
                            bodywork.getIdBody(),
                            bodywork.getDescription()
                    });
                } else {
                    JOptionPane.showMessageDialog(guiUpdateBodywork, "Bodywork not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(guiUpdateBodywork, "Invalid vehicle number format.");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (guiAddBodywork != null && e.getSource() == guiAddBodywork.getBtnAdd()) {
            addBodywork();
        }
        if (guiListBodywork != null && e.getSource() == guiListBodywork.getBtnList()) {
            refreshBodyworkTable();
        }
        if (guiSearchBodywork != null && e.getSource() == guiSearchBodywork.getBtnSearch()) {
            refreshBodyworkTableSearch();
        }
        if (guiDeleteBodywork != null && e.getSource() == guiDeleteBodywork.getBtnDelete()) {
            deleteBodywork();
        }
        if (guiDeleteBodywork != null && e.getSource() == guiDeleteBodywork.getBtnSearch()) {
            refreshBodyworkTableDelete();
        }
        if (guiUpdateBodywork != null && e.getSource() == guiUpdateBodywork.getBtnSearch()) {
            refreshBodyworkTableUpdate();
        }
        if (guiUpdateBodywork != null && e.getSource() == guiUpdateBodywork.getBtnUpdate()) {
            updateBodywork();
        }
    }

    private void clearAddBodyworkFields() {
        guiAddBodywork.getIdBodyworkField().setText("");
        guiAddBodywork.getDescriptionField().setText("");
    }
}
