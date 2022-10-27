/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.database;

import com.sanjevani.model.Community;
import com.sanjevani.model.Doctor;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.House;
import com.sanjevani.model.Patient;
import com.sanjevani.model.Person;
import com.sanjevani.model.VitalSign;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rajatsharma
 */
public class Database {   
    // Initial IDs
    private static int lastPersonId = 1;
    private static int lastHouseId = 1;
    private static int lastCommunityId = 1;
    private static int lastHospitalId = 1;
    private static int lastVitalSignId = 1;
    private static int lastEncounterId = 1;
    
    // Tables
    public static HashMap<Integer,House> houseList = new HashMap<>();
    public static HashMap<Integer, Community> communityList = new HashMap<>();
    public static HashMap<Integer,Hospital> hospitalList = new HashMap<>();
    public static HashMap<Integer,VitalSign> vitalSignList= new HashMap<>();
    public static HashMap<Integer,Person> personList = new HashMap<>();
    public static HashMap<Integer,Encounter> encounterList = new HashMap<>();  
    
    // Create Instance Methods
    public static House createHouse(int communityId, String address) {
        return houseList.put(lastHouseId, new House(lastHouseId++, communityId, address));
    }
    public static Community createCommunity(String name, String city, int zipcode, List<Integer> houseIds, List<Integer> hospitalIds, int personId) {
        return communityList.put(lastCommunityId, new Community(lastCommunityId++, name, city, zipcode, houseIds, hospitalIds, personId));
    }
    public static Hospital createHospital(String name, int communityId, List<Integer> doctorIds) {
        return hospitalList.put(lastHospitalId, new Hospital(lastHospitalId++, name, communityId, doctorIds));
    }
    public static Doctor createDoctor(String name, String userName, String password, int age, String gender, int houseId, int communityId, List<Integer> hospitalIds) {
        Doctor doctor = new Doctor(lastPersonId++, name, userName, password, age, gender, houseId, communityId, hospitalIds);
        personList.put(lastPersonId, doctor );
        return doctor;
    }
    public static VitalSign createVitalSign(double temperature, String bloodPressure, int heartRate){
        return vitalSignList.put(lastVitalSignId, new VitalSign(lastVitalSignId++, temperature, bloodPressure, heartRate));
    }
    public static Patient createPatient(String name, String userName, String password, int age, String gender, int houseId, int communityId) {
        Patient patient = new Patient(lastPersonId++, name, userName, password, age, gender, houseId, communityId);
        personList.put(lastPersonId, patient);
        return patient;
    }
    public static Person createAdmin(String name, String userName, String password, String role, int age, String gender, int houseId, int communityId) {
        return personList.put(lastPersonId, new Person(lastPersonId++, name, userName, password, role, age, gender, houseId, communityId));
    }
    public static Encounter createEncounter(int patientId, int vitalSignId, String dateOfEncounter, String status, int doctorId, int hospitalId) {
        return encounterList.put(lastEncounterId, new Encounter(lastEncounterId++, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
    }
    
    // House Data
    // Patient House
    House house1 = createHouse(1, "Apartment-201");
    House house2 = createHouse(2, "Apartment-301");
    
    // Doctor House
    House house3 = createHouse(3, "Apartment-401");
    House house4 = createHouse(4, "Apartment-501");
    
    
    // Community Data
    Community community1 = createCommunity("Jvue", "Boston", 02120, Arrays.asList(1,2), Arrays.asList(1,2), 1);
    Community community2 = createCommunity("Mission Main", "Boston", 02120, Arrays.asList(1,2), Arrays.asList(1,2), 2);
    
    // Hospital Data
    Hospital hospital1 = createHospital("Max Hospital", 1, Arrays.asList(1,2));
    Hospital hospital2 = createHospital("Fortis Hospital", 2, Arrays.asList(1,2));
    
    // Doctor Data
    Doctor doctor1 = createDoctor("Dr. Rajeev Aggarwal", "rajeevAggarwal", "test@1234", 30, "Male", 3, 1, Arrays.asList(1,2));
    Doctor doctor2 = createDoctor("Dr. Sunita Williams", "sunitawilliams", "test@1234", 25, "Female", 4, 2, Arrays.asList(1,2));
    
    // Vital Sign Data
    VitalSign vitalSign1 = createVitalSign(98.97, "80-120", 72);
    VitalSign vitalSign2 = createVitalSign(99.99, "70-110", 77);
    
    // Patient Data
    Patient patient1 = createPatient("Rajat Sharma", "rajatsharma", "test@1234", 30, "Male", 1, 1);
    Patient patient2 = createPatient("Yash Pawar", "yashpawar", "test@1234", 25, "Male", 2, 2);
    
    // Encounter Data
    Encounter encounter1 = createEncounter(1, 1, "08-23-2022", "Pending", 1, 1);
    Encounter encounter2 = createEncounter(2, 2, "09-26-2022", "Pending", 2, 2);    
    
    // Admin Data
    Person systemAdmin = createAdmin("Rajat Sharma", "rajatsharma", "test@1234", "SystemAdmin", 30, "Male", 5, 1);
    Person communityAdmin = createAdmin("Yash Pawar", "rajatsharma", "test@1234", "CommunityAdmin", 30, "Male", 6, 1);
    Person hospitalAdmin = createAdmin("Nitin Sharma", "rajatsharma", "test@1234", "HospitalAdmin", 30, "Male", 7, 1);
}

