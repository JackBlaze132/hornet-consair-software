package org.hornetsa.view.bodywork;

import org.hornetsa.model.Bodywork;
import org.hornetsa.services.BodyworkService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEditBodywork extends JFrame {

    private JTextField jTxtIdBodywork, jTxtDescription;
    private JButton jBtnSave;
    private BodyworkService bodyworkService;

    private int idBodywork;
    private String description;

    public GUIEditBodywork(int idBodywork, String description, BodyworkService bodyworkService) {
        this.idBodywork = idBodywork;
        this.bodyworkService = bodyworkService;  // Inicializar el servicio
        initComponents();

        // Cargar datos en los campos
        jTxtIdBodywork.setText(String.valueOf(idBodywork));
        jTxtIdBodywork.setEditable(false);
        jTxtDescription.setText(description);

        setTitle("Hornet Corsair | Edit Bodywork");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/favicon.png")).getImage());
    }


    private void initComponents() {
        jTxtIdBodywork = new JTextField();
        jTxtDescription = new JTextField();
        jBtnSave = new JButton("Save");

        JLabel jLblIdBodywork = new JLabel("IdBodywork");
        JLabel jLblDescription = new JLabel("Description");
        JLabel LblTitle = new JLabel("Edit Bodywork", JLabel.CENTER);
        LblTitle.setFont(new Font("Arial", Font.BOLD, 24));

        jBtnSave = new JButton("Save");
        jBtnSave.setBackground(Color.BLACK);
        jBtnSave.setForeground(Color.WHITE);
        jBtnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBodywork();
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
                                                .addComponent(jLblIdBodywork, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtIdBodywork, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLblDescription, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(jTxtDescription, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(jLblIdBodywork, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtIdBodywork, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLblDescription, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTxtDescription, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGap(26, 26, 26)
                                .addComponent(jBtnSave, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
        pack();
    }

    private void saveBodywork() {
        try {
            // Recoger los datos del formulario
            String description = jTxtDescription.getText().trim();

            // Verificar que los campos obligatorios estén completos
            if (description.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto Bodywork actualizado
            Bodywork updatedBodywork = new Bodywork(idBodywork, description);

            // Usar el servicio para actualizar la motocicleta
            bodyworkService.updateBodywork(updatedBodywork);  // Aquí se usa vehicleService

            JOptionPane.showMessageDialog(this, "Bodywork updated successfully.");
            dispose();  // Cierra la ventana al guardar
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid data format for price or ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the Bodywork.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
