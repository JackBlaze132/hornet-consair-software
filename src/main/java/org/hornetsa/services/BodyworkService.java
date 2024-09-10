package org.hornetsa.services;

import org.hornetsa.view.IIntersetedGUI;
import org.hornetsa.model.Bodywork;

import java.util.ArrayList;

public class BodyworkService {

    private ArrayList<Bodywork> bodyworks;

    private ArrayList<IIntersetedGUI> interestedTables = new ArrayList<>();

    public BodyworkService() {
        bodyworks = new ArrayList<>();
    }

    public BodyworkService(ArrayList<Bodywork> bodyworks) {
        this.bodyworks = bodyworks;
    }

    public void addBodywork(Bodywork bodywork) {
        bodyworks.add(bodywork);
        notifyGUI();
    }

    public void updateBodywork(Bodywork updatedBodywork) {
        // Buscar el automóvil existente por su ID
        Bodywork existingBodywork = getBodywork(updatedBodywork.getIdBody());

        if (existingBodywork != null) {
            // Actualizar los atributos del automóvil
            Bodywork bodywork = existingBodywork;
            bodywork.setDescription(updatedBodywork.getDescription());
            notifyGUI();

        } else {
            throw new IllegalArgumentException("Automobile with ID " + updatedBodywork.getIdBody() + " not found.");
        }
    }

    public ArrayList<Bodywork> getBodyworks() {
        return bodyworks;
    }

    public Bodywork getBodywork(int idBody) {
        for (Bodywork bodywork : bodyworks) {
            if (bodywork.getIdBody() == idBody) {
                return bodywork;
            }
        }
        return null;
    }

    public void removeBodywork(int idBody) {
        Bodywork bodywork = getBodywork(idBody);
        if (bodywork != null) {
            bodyworks.remove(bodywork);
            notifyGUI();
        }
    }

    public void clearBodyworks() {
        bodyworks.clear();
    }

    public void addGUIInterested(IIntersetedGUI intersetedGUI) {
        interestedTables.add(intersetedGUI);
        System.out.println("GUI's interested: " + interestedTables.size());
    }

    public void removeGUIInterested(IIntersetedGUI intersetedGUI) {
        interestedTables.remove(intersetedGUI);
        System.out.println("GUI's interested: " + interestedTables.size());
    }

    public void notifyGUI() {
        for (IIntersetedGUI interestedTable : interestedTables) {
            interestedTable.changeTable();
        }
    }


}
