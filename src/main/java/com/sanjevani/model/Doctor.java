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
    
    public Doctor(int personId, String name, String emailId, String password, int age, String gender, int houseId, List<Integer> hospitalIds) {
        super(personId, name, emailId, password, "Doctor", age, gender, houseId, hospitalIds);
    }
}