package org.hornetsa.model;

public class Automobile extends Vehicle{
    private int doorCount;
    private Bodywork bodywork;
    private int airbagCount;

    public Automobile(int idVehicle, String brand, float price, String model, boolean abs, int doorCount, Bodywork bodywork, int airbagCount) {
        super(idVehicle, brand, price, model, abs);
        this.doorCount = doorCount;
        this.bodywork = bodywork;
        this.airbagCount = airbagCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public Bodywork getBodywork() {
        return bodywork;
    }

    public void setBodywork(Bodywork bodywork) {
        this.bodywork = bodywork;
    }

    public int getAirbagCount() {
        return airbagCount;
    }

    public void setAirbagCount(int airbagCount) {
        this.airbagCount = airbagCount;
    }

    @Override
    public float calculateInsurance() {
        return getPrice() * 0.04f + (getAirbagCount() * 50000);
    }
}
