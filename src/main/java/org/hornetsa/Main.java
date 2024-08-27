package org.hornetsa;

import org.hornetsa.view.GUIPrincipal;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ImageIcon img = new ImageIcon(Main.class.getClassLoader().getResource("img/favicon.png"));
        GUIPrincipal guiPrincipal = new GUIPrincipal();
        guiPrincipal.setVisible(true);
        guiPrincipal.setTitle("Hornet Corsair");
        guiPrincipal.setLocationRelativeTo(null);

    }
}