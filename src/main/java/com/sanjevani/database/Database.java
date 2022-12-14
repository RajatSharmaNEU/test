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
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author rajatsharma
 */
public class Database {   
    // Initial IDs
    private static int lastPersonId = 0;
    public static int lastHouseId = 0;
    private static int lastCityId = 0;
    private static int lastCommunityId = 0;
    private static int lastHospitalId = 0;
    public static int lastVitalSignId = 0;
    private static int lastEncounterId = 0;
    
    // Tables
    public static HashMap<Integer,House> masterHouseList = new HashMap<>();
    public static HashMap<Integer, City> masterCityList = new HashMap<>();
    public static HashMap<Integer, Community> masterCommunityList = new HashMap<>();
    public static HashMap<Integer,Hospital> masterHospitalList = new HashMap<>();
    public static HashMap<Integer,VitalSign> masterVitalSignList= new HashMap<>();
    public static HashMap<Integer,Person> masterPersonList = new HashMap<>();
    public static HashMap<Integer,Encounter> masterEncounterList = new HashMap<>();  
    
    public static HashMap<Integer,House> houseList = new HashMap<>();
    public static HashMap<Integer, City> cityList = new HashMap<>();
    public static HashMap<Integer, Community> communityList = new HashMap<>();
    public static HashMap<Integer,Hospital> hospitalList = new HashMap<>();
    public static HashMap<Integer,VitalSign> vitalSignList= new HashMap<>();
    public static HashMap<Integer,Person> personList = new HashMap<>();
    public static HashMap<Integer,Encounter> encounterList = new HashMap<>();  
    public static String[] roles = {"Doctor", "Patient", "SystemAdmin", "CommunityAdmin", "HospitalAdmin"};
    
    //Refresh Database
    public static void refreshDatabase(){
        houseList = masterHouseList;
        cityList = masterCityList;
        communityList = masterCommunityList;
        hospitalList = masterHospitalList;
        vitalSignList= masterVitalSignList;
        personList = masterPersonList;
        encounterList = masterEncounterList;
        Database.roles = new String[]{"Doctor", "Patient", "SystemAdmin", "CommunityAdmin", "HospitalAdmin"};
    }
    // Create Instance Methods
    // House CRUD Method
    public static House createHouse(int communityId, String address) {
        masterHouseList.put(lastHouseId, new House(lastHouseId, communityId, address));
        return houseList.put(lastHouseId, new House(lastHouseId++, communityId, address));
    }
    public static House updateHouse(int houseId, int communityId, String address) {
        masterHouseList.put(houseId, new House(houseId, communityId, address));
        return houseList.put(houseId, new House(houseId, communityId, address));
    }
    public static House deleteHouse(int houseId) {
        masterHouseList.remove(houseId);
        return houseList.remove(houseId);
    }
    
    public static City createCity(String cityName) {
        masterCityList.put(lastCityId, new City(lastCityId, cityName));
        return cityList.put(lastCityId, new City(lastCityId++, cityName));
    }
    
    // Community CRUD Method
    public static Community createCommunity(String name, int cityId, String zipcode) {
        masterCommunityList.put(lastCommunityId, new Community(lastCommunityId, name, cityId, zipcode));
        return communityList.put(lastCommunityId, new Community(lastCommunityId++, name, cityId, zipcode));
    }
    public static Community updateCommunity(int communityId, String name, int cityId, String zipcode) {
        masterCommunityList.put(communityId, new Community(communityId, name, cityId, zipcode));
        return communityList.put(communityId, new Community(communityId, name, cityId, zipcode));
    }
    public static Community deleteCommunity(int communityId) {
        masterCommunityList.remove(communityId);
        return communityList.remove(communityId);
    }
    
    // Hospital CRUD Method
    public static Hospital createHospital(String name, int communityId, List<Integer> doctorIds) {
        masterHospitalList.put(lastHospitalId, new Hospital(lastHospitalId, name, communityId, doctorIds));
        return hospitalList.put(lastHospitalId, new Hospital(lastHospitalId++, name, communityId, doctorIds));
    }
    public static Hospital updateHospital(int hospitalId, String name, int communityId, List<Integer> doctorIds) {
        masterHospitalList.put(hospitalId, new Hospital(hospitalId, name, communityId, doctorIds));
        return hospitalList.put(hospitalId, new Hospital(hospitalId, name, communityId, doctorIds));
    }
    public static Hospital deleteHospital(int hospitalId) {
        masterHospitalList.remove(hospitalId);
        return hospitalList.remove(hospitalId);
    }
    
    // Person CRUD Method
    public static Person createPerson(String name, String emailId, String password, String role, int age, String gender, int houseId, List<Integer> hospitalIds) {
        masterPersonList.put(lastPersonId, new Person(lastPersonId, name, emailId, password, role, age, gender, houseId, hospitalIds));
        return personList.put(lastPersonId, new Person(lastPersonId++, name, emailId, password, role, age, gender, houseId, hospitalIds));
    }
    public static Person updatePerson(int personId, String name, String emailId, String password, String role, int age, String gender, int houseId, List<Integer> hospitalIds) {
        masterPersonList.put(personId, new Person(personId, name, emailId, password, role, age, gender, houseId, hospitalIds));
        return personList.put(personId, new Person(personId, name, emailId, password, role, age, gender, houseId, hospitalIds));
    }
    public static Person deletePerson(int doctorId) {
        masterPersonList.remove(doctorId);
        return personList.remove(doctorId);
    }
    
    // Doctor CRUD Method
    public static Doctor createDoctor(String name, String emailId, String password, int age, String gender, int houseId, List<Integer> hospitalIds) {
        Doctor doctor = new Doctor(lastPersonId, name, emailId, password, age, gender, houseId, hospitalIds);
        masterPersonList.put(lastPersonId, doctor);
        personList.put(lastPersonId++, doctor);
        return doctor;
    }
    public static Doctor updateDoctor(int doctorId, String name, String emailId, String password, int age, String gender, int houseId, List<Integer> hospitalIds) {
        Doctor doctor = new Doctor(doctorId, name, emailId, password, age, gender, houseId, hospitalIds);
        masterPersonList.put(doctorId, doctor);
        personList.put(doctorId, doctor);
        return doctor;
    }
    public static Person deleteDoctor(int doctorId) {
        masterPersonList.remove(doctorId);
        return personList.remove(doctorId);
    }
    
    // Vital Sign
    public static VitalSign createVitalSign(double temperature, String bloodPressure, int heartRate){
        masterVitalSignList.put(lastVitalSignId, new VitalSign(lastVitalSignId, temperature, bloodPressure, heartRate));
        return vitalSignList.put(lastVitalSignId, new VitalSign(lastVitalSignId++, temperature, bloodPressure, heartRate));
    }
    public static VitalSign updateVitalSign(int vitalSignId, double temperature, String bloodPressure, int heartRate){
        masterVitalSignList.put(vitalSignId, new VitalSign(vitalSignId, temperature, bloodPressure, heartRate));
        return vitalSignList.put(vitalSignId, new VitalSign(vitalSignId, temperature, bloodPressure, heartRate));
    }
    public static VitalSign deleteVitalSign(int vitalSignId){
        masterVitalSignList.remove(vitalSignId);
        return vitalSignList.remove(vitalSignId);
    }
    
    //Patient CRUD Method
    public static Patient createPatient(String name, String emailId, String password, int age, String gender, int houseId) {
        Patient patient = new Patient(lastPersonId, name, emailId, password, age, gender, houseId, null);
        masterPersonList.put(lastPersonId, patient);
        personList.put(lastPersonId++, patient);
        return patient;
    }
    public static Patient updatePatient(int personId, String name, String emailId, String password, int age, String gender, int houseId) {
        Patient patient = new Patient(personId, name, emailId, password, age, gender, houseId, null);
        masterPersonList.put(personId, patient);
        personList.put(personId, patient);
        return patient;
    }
    public static Person deletePatient(int personId) {
        masterPersonList.remove(personId);
        return personList.remove(personId);
    }
    
    //Admin CRUD Method
    public static Person createAdmin(String name, String emailId, String password, String role, int age, String gender, int houseId, List<Integer> hospitalIds) {
        masterPersonList.put(lastPersonId, new Person(lastPersonId, name, emailId, password, role, age, gender, houseId, hospitalIds));
        return personList.put(lastPersonId, new Person(lastPersonId++, name, emailId, password, role, age, gender, houseId, hospitalIds));
    }
    public static Person updateAdmin(int personId, String name, String emailId, String password, String role, int age, String gender, int houseId, List<Integer> hospitalIds) {
        masterPersonList.put(personId, new Person(personId, name, emailId, password, role, age, gender, houseId, hospitalIds));
        return personList.put(personId, new Person(personId, name, emailId, password, role, age, gender, houseId, hospitalIds));
    }
    public static Person deleteAdmin(int personId) {
        masterPersonList.remove(personId);
        return personList.remove(personId);
    }
    
    // Encounter CRUD Method
    public static Encounter createEncounter(int patientId, int vitalSignId, Date dateOfEncounter, String status, int doctorId, int hospitalId) {
        masterEncounterList.put(lastEncounterId, new Encounter(lastEncounterId, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
        return encounterList.put(lastEncounterId, new Encounter(lastEncounterId++, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
    }
    public static Encounter updateEncounter(int encounterId, int patientId, int vitalSignId, Date dateOfEncounter, String status, int doctorId, int hospitalId) {
        masterEncounterList.put(encounterId, new Encounter(encounterId, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
        return encounterList.put(encounterId, new Encounter(encounterId, patientId, vitalSignId, dateOfEncounter, status, doctorId, hospitalId));
    }
    public static Encounter deleteEncounter(int encounterId) {
        masterEncounterList.remove(encounterId);
        return encounterList.remove(encounterId);
    }
    
    public static Map<Integer, Person> getPeople(String role){
        if(role == null) {
            return personList;
        }
        return Database.personList.entrySet().stream()
                .filter(x -> Database.personList.get(x.getKey()).getRole() == role)
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    public static List<Encounter> getEncounterByPatientId(int patientId){
        List<Encounter> patientEncounterList = new ArrayList<>();
        for(Encounter encounter: Database.encounterList.values()) {
            if(encounter.getPatientId() == patientId){
                patientEncounterList.add(encounter);
            }
        }
        return patientEncounterList;
    }
    
    public static boolean isEmailIdExist(String emailId){
        int key = 0;
        
        for(Person person: personList.values()) {
            if(person.getEmailId().trim().equalsIgnoreCase(emailId.trim().toLowerCase())){
                return true;
            }
            key++;
        }
        
        return false;
    }

    public static void createDatabase() {
    // City Data
    City city1 = createCity("Boston");
    City city2 = createCity("NewYork");
    
    // Community Data
    Community community1 = createCommunity("Jvue", 0, "02120");
    Community community2 = createCommunity("Mission Main", 1, "02122");
    
    // Hospital Data
    Hospital hospital1 = createHospital("Max Hospital", 0, Arrays.asList(0,1, 7));
    Hospital hospital2 = createHospital("Fortis Hospital", 1, Arrays.asList(1, 8));
    
    // House Data
    // Patient House
    House house1 = createHouse(0, "Apartment-001");
    House house2 = createHouse(1, "Apartment-101");
    
    // Doctor House
    House house3 = createHouse(0, "Apartment-201");
    House house4 = createHouse(1, "Apartment-301");
    
    // Admin House
    House house5 = createHouse(0, "Apartment-401");
    House house6 = createHouse(1, "Apartment-501");
    House house7 = createHouse(1, "Apartment-601");
    
    
    // Doctor Data
    Doctor doctor1 = createDoctor("Dr. Rajeev Aggarwal", "rajeev@gmail.com", "test@123", 30, "Male", 0, Arrays.asList(0));
    Doctor doctor2 = createDoctor("Dr. Sunita Williams", "sunitawilliams@gmail.com", "test@123", 25, "Female", 1, Arrays.asList(0,1));
    
    // Vital Sign Data
    VitalSign vitalSign1 = createVitalSign(98.97, "80-120", 72);
    VitalSign vitalSign2 = createVitalSign(99.99, "70-110", 77);
    
    // Patient Data
    Patient patient1 = createPatient("Manthan", "manthan@gmail.com", "test@123", 30, "Male", 2);
    Patient patient2 = createPatient("Yash Pawar", "yashpawar", "test@123", 25, "Male", 3);
    
    // Encounter Data
    Encounter encounter1 = createEncounter(2, 0, new Date(), "Pending", 0, 0);
    Encounter encounter2 = createEncounter(3, 1, new Date(), "Pending", 1, 1);    
    
    // Admin Data
    Person systemAdmin = createAdmin("Rajat Sharma", "rajat@gmail.com", "test@123", "SystemAdmin", 30, "Male", 4, null);
    Person communityAdmin = createAdmin("Gaurang Londhe", "gaurang@gmail.com", "test@123", "CommunityAdmin", 30, "Male", 5, null);
    Person hospitalAdmin = createAdmin("Chakradhar Grandhi", "chakri@gmail.com", "test@123", "HospitalAdmin", 30, "Male", 6, Arrays.asList(0));
    
    
    // More Doctor Data
    Doctor doctor3 = createDoctor("Dr. Diljit Singh", "diljitsingh@gmail.com", "test@123", 30, "Male", 0, Arrays.asList(0));
    Doctor doctor4 = createDoctor("Dr. Rina Singh", "rinasingh@gmail.com", "test@123", 25, "Female", 1, Arrays.asList(0, 1));
    }
}

