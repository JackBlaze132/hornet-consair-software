package org.hornetsa.controller;

import org.hornetsa.model.Bodywork;
import org.hornetsa.view.bodywork.GUIAddBodywork;
import org.hornetsa.view.bodywork.GUIListBodywork;
import org.hornetsa.services.BodyworkService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BodyworkController implements ActionListener {

    private BodyworkService bodyworkService;
    private GUIAddBodywork guiAddBodywork;
    private GUIListBodywork guiListBodywork;

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

    private void updateBodyworkTable() {
        DefaultTableModel model = (DefaultTableModel) guiListBodywork.getjTable1().getModel();
        model.setRowCount(0); // Clear existing rows
        for (Bodywork bodywork : bodyworkService.getBodyworks()) {
            model.addRow(new Object[]{bodywork.getIdBody(), bodywork.getDescription()});
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
    }

    private void clearAddBodyworkFields() {
        guiAddBodywork.getIdBodyworkField().setText("");
        guiAddBodywork.getDescriptionField().setText("");
    }
}
