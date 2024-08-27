package org.hornetsa.model;

public class Bodywork {
    private int idBody;
    private String description;

    public Bodywork() {
    }

    public Bodywork(int idBody, String description) {
        this.idBody = idBody;
        this.description = description;
    }

    public int getIdBody() {
        return idBody;
    }

    public void setIdBody(int idBody) {
        this.idBody = idBody;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
