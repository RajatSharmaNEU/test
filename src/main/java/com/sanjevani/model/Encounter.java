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
    private int encounterId;
    private int patientId;
    private int vitalSignId;
    private String dateOfEncounter;
    private String status; //can be enum("accepted","rejected","pending")
    private int doctorId;
    private int hospitalId;

    public Encounter(int encounterId, int patientId, int vitalSignId, String dateOfEncounter, String status, int doctorId, int hospitalId) {
        this.encounterId = encounterId;
        this.patientId = patientId;
        this.vitalSignId = vitalSignId;
        this.dateOfEncounter = dateOfEncounter;
        this.status = status;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
    }

    public int getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(int encounterId) {
        this.encounterId = encounterId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getVitalSignId() {
        return vitalSignId;
    }

    public void setVitalSignId(int vitalSignId) {
        this.vitalSignId = vitalSignId;
    }

    public String getDateOfEncounter() {
        return dateOfEncounter;
    }

    public void setDateOfEncounter(String dateOfEncounter) {
        this.dateOfEncounter = dateOfEncounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }
}
