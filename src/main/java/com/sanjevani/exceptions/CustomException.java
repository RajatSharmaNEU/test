package com.sanjevani.exceptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rajatsharma
 */
public class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomException(String message) {
        super(message);
    }
    public CustomException(Throwable cause) {
        super(cause);
    }
}
