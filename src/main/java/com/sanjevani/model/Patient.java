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
public class Patient extends Person {

    public Patient(int personId, String name, String userName, String password, int age, String gender, int houseId, List<Integer> hospitalIds) {
        super(personId, name, userName, password, "Patient", age, gender, houseId, hospitalIds);
    }
    
}