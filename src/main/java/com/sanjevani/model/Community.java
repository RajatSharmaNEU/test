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
    private String address;
    private String city;
    private String zipcode;
    private List<Integer> hospitalIds;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Integer> getHospitalIds() {
        return hospitalIds;
    }

    public void setHospitalIds(List<Integer> hospitalIds) {
        this.hospitalIds = hospitalIds;
    }
}
