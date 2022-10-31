/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.database;

/**
 *
 * @author rajatsharma
 */
public class Constants {
    public static String CANNOT_DELETE_HOSPITAL = "Hospital can not be deleted as it is in use.";
    public static String CANNOT_DELETE_DOCTOR = "Doctor can not be deleted as it is in use.";
    public static String INVALID_HOSPITAL_DETAIL = "Please provide all hospital details.";
    public static String INVALID_DOCTOR_DETAIL = "Please provide all doctor details.";
    public static String INVALID_PERSON_DETAIL = "Please provide all person details.";
    public static String INVALID_COMMUNITY_DETAIL = "Please provide all community details.";
    public static String INVALID_ENCOUNTER_DETAIL = "Please provide all encounter details.";
    public static String INVALID_ZIPCODE = "Zipcode must be a number";
    public static String INVALID_HEART_RATE = "Heart rate must be a number and between 0 to 160";
    public static String INVALID_TEMP = "Temperature must be a number and between 0 to 200";
    public static String INVALID_AGE = "Age must be a number and between 10 to 99";
    public static String INVALID_EMAILID = "Email id is already used.";
    public static final String heartRateRegex = "[0-1]{1}[0-9]{1}[0-9]{1}";
    public static final String temperatureRegex = "^([0-1]{1}[0-9]{1}[0-9]{1}\\.[0-9]?[0-9])";
    public static final String ageRegex = "[1-9]{1}[0-9]{1}";
    public static final String dateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
    public static final String cellPhoneRegex = "[1-9][0-9]{9}";
    public static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

    public static final String numberReg = "\\d+";
    public static final String decimalReg = "^\\d*\\.?\\d*";
    
}
