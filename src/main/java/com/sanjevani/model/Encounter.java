/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.model;

/**
 *
 * @author rajatsharma
 */
public class Encounter {
    private int encounterID;
    private int personId;
    private int vitalSignsId;
    private String dateOfEncounter;
    private String status; //can be enum("accepted","rejected","pending")
    private int doctorId;
    private int hospitalId;

}
