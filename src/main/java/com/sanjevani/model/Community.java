/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.model;

/**
 *
 * @author rajatsharma
 */
public class Community {
    private int communityId;
    private String communityName;
    private String zipcode;
    private int cityId;
    
    public Community(int communityId, String name, int cityId, String zipcode) {
        this.communityId = communityId;
        this.communityName = name;
        this.cityId = cityId;
        this.zipcode = zipcode;
    }    

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
