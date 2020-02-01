package com.divergents.eco.model.dao;

import java.util.List;

public interface Vehicle {

    public void insert(Vehicle vehicle);
    public Boolean update();
    public Student findById(int id);
    public Student findByVehicleNumber(String  vehicleNumber);
    
    List<Vehicle> selectAll();

}