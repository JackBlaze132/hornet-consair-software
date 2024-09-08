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

    public Vehicle getAutomobile( int idVehicle){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getIdVehicle() == idVehicle && vehicle instanceof Automobile) {
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle getMotorcycle( int idVehicle){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getIdVehicle() == idVehicle && vehicle instanceof Motorcycle) {
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

    public void removeAutomobile(int idVehicle) {
        Vehicle vehicle = getVehicle(idVehicle);
        if (vehicle != null && vehicle instanceof Automobile) {
            vehicles.remove(vehicle);
        }
    }

    public void removeMotorcycle(int idVehicle) {
        Vehicle vehicle = getVehicle(idVehicle);
        if (vehicle != null && vehicle instanceof Motorcycle) {
            vehicles.remove(vehicle);
        }
    }

    public void updateVehicle(Automobile updatedAutomobile) {
        // Buscar el automóvil existente por su ID
        Vehicle existingVehicle = getAutomobile(updatedAutomobile.getIdVehicle());

        if (existingVehicle != null && existingVehicle instanceof Automobile) {
            // Actualizar los atributos del automóvil
            Automobile automobile = (Automobile) existingVehicle;
            automobile.setBrand(updatedAutomobile.getBrand());
            automobile.setModel(updatedAutomobile.getModel());
            automobile.setPrice(updatedAutomobile.getPrice());
            automobile.setAbs(updatedAutomobile.isAbs());
            automobile.setDoorCount(updatedAutomobile.getDoorCount());
            automobile.setAirbagCount(updatedAutomobile.getAirbagCount());
            automobile.setBodywork(updatedAutomobile.getBodywork());
        } else {
            throw new IllegalArgumentException("Automobile with ID " + updatedAutomobile.getIdVehicle() + " not found.");
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

    public List<Motorcycle> getMotorcyclesList() {
        List<Motorcycle> motorcycles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                motorcycles.add((Motorcycle) vehicle);
            }
        }
        return motorcycles;
    }


}
