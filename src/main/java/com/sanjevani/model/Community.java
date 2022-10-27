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
public class Community {
    private int communityId;
    private String name;
    private int zipcode;
    private List<Integer> hospitalIds;
    private List<Integer> houseIds;
    private int personId;
    private int cityId;
    
    public Community(int communityId, String name, int cityId, int zipcode, List<Integer> hospitalIds, List<Integer> houseIds, int personId) {
        this.communityId = communityId;
        this.name = name;
        this.cityId = cityId;
        this.zipcode = zipcode;
        this.hospitalIds = hospitalIds;
        this.houseIds = houseIds;
        this.personId = personId;
    }    

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<Integer> getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(List<Integer> hospitalIds) {
        this.hospitalIds = hospitalIds;
    }

    public List<Integer> getHouseIds() {
        return houseIds;
    }

    public void setHouseIds(List<Integer> houseIds) {
        this.houseIds = houseIds;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
