/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.model;

/**
 *
 * @author rajatsharma
 */
public class House {
    private int houseId;
    private int communityId;
    private String address;

    public House(int houseId, int communityId, String address) {
        this.houseId = houseId;
        this.communityId = communityId;
        this.address = address;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int CommunityId) {
        this.communityId = CommunityId;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
