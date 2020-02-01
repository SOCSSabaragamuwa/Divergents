package com.divergents.eco.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String vehicleNumber;

    //getter and setters

    public int getId() {
        return id;
    }

    public String vehicleNumber() {
        return vehicleNumber;
    }

    public void vehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}