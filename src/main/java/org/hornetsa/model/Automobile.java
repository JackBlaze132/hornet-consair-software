package org.hornetsa.model;

public class Automobile extends Vehicle{
    private int doorCount;
    private float trunkCapacity;
    private Bodywork bodywork;
    private int airbagCount;

    public Automobile(int idVehicle, String brand, float price, String model, int capacity, String brakeType, boolean abs, int doorCount, float trunkCapacity, Bodywork bodywork, int airbagCount) {
        super(idVehicle, brand, price, model, capacity, brakeType, abs);
        this.doorCount = doorCount;
        this.trunkCapacity = trunkCapacity;
        this.bodywork = bodywork;
        this.airbagCount = airbagCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public float getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(float trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
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
}
