package org.hornetsa.model;

public class Motorcycle extends Vehicle implements IAplicable{
    private String forkType;
    private boolean helmetIncluded;

    public Motorcycle(int idVehicle, String brand, float price, String model, boolean abs, String forkType, boolean helmetIncluded) {
        super(idVehicle, brand, price, model, abs);
        this.forkType = forkType;
        this.helmetIncluded = helmetIncluded;
    }

    public String getForkType() {
        return forkType;
    }

    public void setForkType(String forkType) {
        this.forkType = forkType;
    }

    public boolean isHelmetIncluded() {
        return helmetIncluded;
    }

    public void setHelmetIncluded(boolean helmetIncluded) {
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public float calculateInsurance() {
        return getPrice() * 0.02f + (isHelmetIncluded() ? 50 : 100);
    }

    @Override
    public float calculateDiscount() {
        return 0;
    }

    @Override
    public void applyDiscont() {

    }
}
