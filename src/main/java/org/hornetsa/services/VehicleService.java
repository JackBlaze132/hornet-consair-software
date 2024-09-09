package org.hornetsa.services;

import org.hornetsa.IIntersetedGUI;
import org.hornetsa.model.Automobile;
import org.hornetsa.model.Motorcycle;
import org.hornetsa.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private ArrayList<IIntersetedGUI> interestedTables = new ArrayList<>();
    private ArrayList<Vehicle> vehicles;
    public VehicleService() {
        vehicles = new ArrayList<>();
    }


    public VehicleService(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        notifyGUI();
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
            notifyGUI();
        }
    }

    public void removeMotorcycle(int idVehicle) {
        Vehicle vehicle = getVehicle(idVehicle);
        if (vehicle != null && vehicle instanceof Motorcycle) {
            vehicles.remove(vehicle);
            notifyGUI();
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

    public void updateMotorcycle(Motorcycle updatedMotorcycle) {
        // Buscar la motocicleta existente por su ID
        Vehicle existingVehicle = getMotorcycle(updatedMotorcycle.getIdVehicle());

        if (existingVehicle != null && existingVehicle instanceof Motorcycle) {
            // Actualizar los atributos de la motocicleta
            Motorcycle motorcycle = (Motorcycle) existingVehicle;
            motorcycle.setBrand(updatedMotorcycle.getBrand());
            motorcycle.setModel(updatedMotorcycle.getModel());
            motorcycle.setPrice(updatedMotorcycle.getPrice());
            motorcycle.setAbs(updatedMotorcycle.isAbs());
            motorcycle.setForkType(updatedMotorcycle.getForkType());
            motorcycle.setHelmetIncluded(updatedMotorcycle.isHelmetIncluded());
        } else {
            throw new IllegalArgumentException("Motorcycle with ID " + updatedMotorcycle.getIdVehicle() + " not found.");
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

    public void addGUIInterested(IIntersetedGUI intersestedGUI) {
        interestedTables.add(intersestedGUI);
        System.out.println("GUI's interested: " + interestedTables.size());
    }

    public void removeGUIInterested(IIntersetedGUI intersestedGUI) {
        interestedTables.remove(intersestedGUI);
        System.out.println("GUI's interested: " + interestedTables.size());
    }

    public void notifyGUI() {
        for (IIntersetedGUI interestedTable : interestedTables) {
            interestedTable.changeTable();
        }
    }


}
