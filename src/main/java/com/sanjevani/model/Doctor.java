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
    
    private List<Integer> hospitalIds;
    
    public Doctor(int personId, String name, String userName, String password, int age, String gender, int houseId, int communityId, List<Integer> hospitalIds) {
        super(personId, name, userName, password, "Doctor", age, gender, houseId, communityId);
        this.hospitalIds = hospitalIds;
    }
    
    public List<Integer> getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(List<Integer> hospitalIds) {
        this.hospitalIds = hospitalIds;
    }
}
