package org.hornetsa.model;

public abstract class Vehicle {
    private int idVehicle;
    private String brand;
    private float price;
    private String model;
    private boolean abs;

    public Vehicle(int idVehicle, String brand, float price, String model, boolean abs) {
        this.idVehicle = idVehicle;
        this.brand = brand;
        this.price = price;
        this.model = model;
        this.abs = abs;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    public abstract double calculateInsurance();
}
