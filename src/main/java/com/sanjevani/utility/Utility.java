/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjevani.utility;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajatsharma
 */
public class Utility {

    public static List<Integer> convertIntegerListToIntArray(int[] n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            list.add(n[i]); // always returns 0
        }
        return list;
    }
}
