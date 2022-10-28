/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.model;

import java.util.List;

/**
 *
 * @author rajatsharma
 */
public class Doctor extends Person {
    private int doctorId;
    private List<Integer> hospitalIds;
    
    public Doctor(int doctorId, int personId, String name, String userName, String password, int age, String gender, int houseId, List<Integer> hospitalIds) {
        super(personId, name, userName, password, "Doctor", age, gender, houseId);
        this.doctorId = doctorId;
        this.hospitalIds = hospitalIds;
    }
    
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    
    public List<Integer> getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(List<Integer> hospitalIds) {
        this.hospitalIds = hospitalIds;
    }
}
