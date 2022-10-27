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

    public Patient(int personId, String name, String userName, String password, int age, String gender, int houseId, int communityId) {
        super(personId, name, userName, password, "Patient", age, gender, houseId, communityId);
    }
    
}
