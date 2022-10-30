/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.database;

import com.sanjevani.model.Community;
import com.sanjevani.model.Doctor;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.Person;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author rajatsharma
 */
public class ApplicationState {
    public static Person authenticatedPerson;
    
    public static boolean isSystemAdmin() {
        return authenticatedPerson.getRole().equals("SystemAdmin");
    }
    
    public static boolean isCommunityAdmin() {
        return authenticatedPerson.getRole().equals("CommunityAdmin");
    }
    
    public static boolean isHospitalAdmin() {
        return authenticatedPerson.getRole().equals("HospitalAdmin");
    }
    
    public static boolean isDoctor() {
        return authenticatedPerson.getRole().equals("Doctor");
    }
    
    public static boolean isPatient() {
        return authenticatedPerson.getRole().equals("Patient");
    }
    
    public static boolean isHospitasViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithDoctorsAccess = Arrays.asList("SystemAdmin", "CommunityAdmin", "HospitalAdmin", "Patient");
        return roleWithDoctorsAccess.contains(role);
    }
    
    public static boolean isDoctorsViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithDoctorsAccess = Arrays.asList("SystemAdmin", "CommunityAdmin", "HospitalAdmin", "Patient", "Doctor");
        return roleWithDoctorsAccess.contains(role);
    }
    
    public static boolean isPatientsViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithPatientsAccess = Arrays.asList("SystemAdmin", "Patient", "Doctor");
        return roleWithPatientsAccess.contains(role);
    }
    
    public static boolean isPeopleViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithPeopleAccess = Arrays.asList("SystemAdmin", "CommunityAdmin");
        return roleWithPeopleAccess.contains(role);
    }
    
    public static boolean isCommunitiesViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithPatientsAccess = Arrays.asList("SystemAdmin", "CommunityAdmin");
        return roleWithPatientsAccess.contains(role);
    }
    
    public static boolean isEncountersViewVisible(){
        String role = authenticatedPerson.getRole();
        List<String> roleWithEncountersAccess = Arrays.asList("SystemAdmin", "Patient", "Doctor");
        return roleWithEncountersAccess.contains(role);
    }
    
    
    public static void refreshCommunityList() {
        int communityId = Database.houseList.get(authenticatedPerson.getHouseId()).getCommunityId();
        
        HashMap<Integer, Community> filteredList = new HashMap<>();
        
        Database.communityList.forEach((key, value) -> {
            if(value.getCommunityId() == communityId){
                filteredList.put(value.getCommunityId(), value);
            } 
        });
        
        Database.communityList = filteredList;
    }
    
    public static void refreshHospitalList() {
        int communityId = Database.houseList.get(authenticatedPerson.getHouseId()).getCommunityId();
        
        HashMap<Integer, Hospital> filteredList = new HashMap<>();
        
        Database.hospitalList.forEach((key, value) -> {
            if(value.getCommunityId() == communityId){
                filteredList.put(value.getHospitalId(), value);
            } 
        });
        
        Database.hospitalList = filteredList;
    }
    
    public static void refreshPersonList(List<String> roleList) {
        int communityId = Database.houseList.get(authenticatedPerson.getHouseId()).getCommunityId();
        
        HashMap<Integer, Person> filteredList = new HashMap<>();
        
        Database.personList.forEach((key, value) -> {
            int doctorCommunityId = Database.houseList.get(value.getHouseId()).getCommunityId();
            
            if(doctorCommunityId == communityId && roleList.contains(value.getRole())){
                filteredList.put(value.getPersonId(), value);
            } 
        });
        
        Database.personList = filteredList;
    }
    
    public static void refreshHospitalListForHA(){
        List<Integer> hospitalIds = ApplicationState.authenticatedPerson.getHospitalIds();
        
        HashMap<Integer,Hospital> filteredList = new HashMap<>();
        
        for(int hospitalId: hospitalIds){
            filteredList.put(hospitalId, Database.hospitalList.get(hospitalId));
        }
        
        Database.hospitalList = filteredList;
    }
    
    public static void refreshDatabase() {
        if(isCommunityAdmin()) {
            refreshCommunityList();
            refreshHospitalList();
            refreshPersonList(Arrays.asList("Patient", "Doctor"));
            Database.roles = new String[]{"Patient", "Doctor"};
        }
        
        if(isHospitalAdmin()){
            refreshHospitalListForHA();
        }
    }
}
