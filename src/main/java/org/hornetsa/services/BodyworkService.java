package org.hornetsa.services;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Bodywork;
import org.hornetsa.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class BodyworkService {

    private ArrayList<Bodywork> bodyworks;

    public BodyworkService() {
        bodyworks = new ArrayList<>();
    }

    public BodyworkService(ArrayList<Bodywork> bodyworks) {
        this.bodyworks = bodyworks;
    }

    public void addBodywork(Bodywork bodywork) {
        bodyworks.add(bodywork);
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
        }
    }

    public void clearBodyworks() {
        bodyworks.clear();
    }


}
