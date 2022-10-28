/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.model;

/**
 *
 * @author rajatsharma
 */
public class Patient extends Person {
    private int patientId;

    public Patient(int patientId, int personId, String name, String userName, String password, int age, String gender, int houseId) {
        super(personId, name, userName, password, "Patient", age, gender, houseId);
        this.patientId = patientId;
    }
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
}
