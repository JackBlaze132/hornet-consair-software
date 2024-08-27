package org.hornetsa.services;

import org.hornetsa.model.Automobile;
import org.hornetsa.model.Motorcycle;
import org.hornetsa.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {

    private ArrayList<Vehicle> vehicles;
    public VehicleService() {
        vehicles = new ArrayList<>();
    }


    public VehicleService(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle getVehicle( int idVehicle){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getIdVehicle() == idVehicle) {
                return vehicle;
            }
        }
        return null;
    }

    public void removeVehicle(int idVehicle) {
        Vehicle vehicle = getVehicle(idVehicle);
        if (vehicle != null) {
            vehicles.remove(vehicle);
        }
    }

    public List<Automobile> getAutomobiles() {
        List<Automobile> automobiles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Automobile) {
                automobiles.add((Automobile) vehicle);
            }
        }
        return automobiles;
    }

    public List<Motorcycle> getMotorcycles() {
        List<Motorcycle> motorcycles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                motorcycles.add((Motorcycle) vehicle);
            }
        }
        return motorcycles;
    }


}
