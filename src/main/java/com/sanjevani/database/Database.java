/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.database;

import com.sanjevani.model.City;
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
    private static int lastPersonId = 0;
    private static int lastHouseId = 0;
    private static int lastCityId = 0;
    private static int lastCommunityId = 0;
    private static int lastHospitalId = 0;
    private static int lastVitalSignId = 0;
    private static int lastEncounterId = 0;
    
    // Tables
    public static HashMap<Integer,House> houseList = new HashMap<>();
    public static HashMap<Integer, City> cityList = new HashMap<>();
    public static HashMap<Integer, Community> communityList = new HashMap<>();
    public static HashMap<Integer,Hospital> hospitalList = new HashMap<>();
    public static HashMap<Integer,VitalSign> vitalSignList= new HashMap<>();
    public static HashMap<Integer,Person> personList = new HashMap<>();
    public static HashMap<Integer,Encounter> encounterList = new HashMap<>();  
    
    // Create Instance Methods
    public static House createHouse(int communityId, String address) {
        return houseList.put(lastHouseId, new House(lastHouseId++, communityId, address));
    }
    public static City createCity(String cityName) {
        return cityList.put(lastCityId, new City(lastCityId++, cityName));
    }
    public static Community createCommunity(String name, int cityId, int zipcode, List<Integer> houseIds, List<Integer> hospitalIds, int personId) {
        return communityList.put(lastCommunityId, new Community(lastCommunityId++, name, cityId, zipcode, houseIds, hospitalIds, personId));
    }
    public static Hospital createHospital(String name, int cityId, int communityId, List<Integer> doctorIds) {
        return hospitalList.put(lastHospitalId, new Hospital(lastHospitalId++, name, cityId, communityId, doctorIds));
    }
    public static Doctor createDoctor(String name, String userName, String password, int age, String gender, int houseId, int communityId, List<Integer> hospitalIds) {
        Doctor doctor = new Doctor(lastPersonId, name, userName, password, age, gender, houseId, communityId, hospitalIds);
        personList.put(lastPersonId, doctor );
        lastPersonId++;
        return doctor;
    }
    public static VitalSign createVitalSign(double temperature, String bloodPressure, int heartRate){
        return vitalSignList.put(lastVitalSignId, new VitalSign(lastVitalSignId++, temperature, bloodPressure, heartRate));
    }
    public static Patient createPatient(String name, String userName, String password, int age, String gender, int houseId, int communityId) {
        Patient patient = new Patient(lastPersonId, name, userName, password, age, gender, houseId, communityId);
        personList.put(lastPersonId, patient);
        lastPersonId++;
        return patient;
    }
    public static Person createAdmin(String name, String userName, String password, String role, int age, String gender, int houseId, int communityId) {
        return personList.put(lastPersonId, new Person(lastPersonId++, name, userName, password, role, age, gender, houseId, communityId));
    }
    public static Encounter createEncounter(int patientId, int vitalSignId, String dateOfEncounter, String status, int doctorId, int hospitalId) {
        return encounterList.put(lastEncounterId, new Encounter(lastEncounterId++, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
    }

    public static void createDatabase() {
        // House Data
    // Patient House
    House house1 = createHouse(0, "Apartment-201");
    House house2 = createHouse(1, "Apartment-301");
    
    // Doctor House
    House house3 = createHouse(2, "Apartment-401");
    House house4 = createHouse(3, "Apartment-501");
    
    // City Data
    City city1 = createCity("Boston");
    City city2 = createCity("NewYork");
    
    // Community Data
    Community community1 = createCommunity("Jvue", 0, 02120, Arrays.asList(0,1), Arrays.asList(0,1), 0);
    Community community2 = createCommunity("Mission Main", 1, 02120, Arrays.asList(0,1), Arrays.asList(0,1), 1);
    
    // Hospital Data
    Hospital hospital1 = createHospital("Max Hospital", 0, 0, Arrays.asList(0,1));
    Hospital hospital2 = createHospital("Fortis Hospital", 1, 1, Arrays.asList(0,1));
    
    // Doctor Data
    Doctor doctor1 = createDoctor("Dr. Rajeev Aggarwal", "rajeevAggarwal", "test@1234", 30, "Male", 2, 0, Arrays.asList(0,1));
    Doctor doctor2 = createDoctor("Dr. Sunita Williams", "sunitawilliams", "test@1234", 25, "Female", 3, 1, Arrays.asList(0,1));
    
    // Vital Sign Data
    VitalSign vitalSign1 = createVitalSign(98.97, "80-120", 72);
    VitalSign vitalSign2 = createVitalSign(99.99, "70-110", 77);
    
    // Patient Data
    Patient patient1 = createPatient("Rajat Sharma", "rajatsharma", "test@1234", 30, "Male", 0, 0);
    Patient patient2 = createPatient("Yash Pawar", "yashpawar", "test@1234", 25, "Male", 1, 1);
    
    // Encounter Data
    Encounter encounter1 = createEncounter(0, 0, "08-23-2022", "Pending", 0, 0);
    Encounter encounter2 = createEncounter(1, 1, "09-26-2022", "Pending", 1, 1);    
    
    // Admin Data
    Person systemAdmin = createAdmin("Rajat Sharma", "rajatsharma", "test@1234", "SystemAdmin", 30, "Male", 4, 1);
    Person communityAdmin = createAdmin("Yash Pawar", "rajatsharma", "test@1234", "CommunityAdmin", 30, "Male", 5, 1);
    Person hospitalAdmin = createAdmin("Nitin Sharma", "rajatsharma", "test@1234", "HospitalAdmin", 30, "Male", 6, 1);
    }
}

