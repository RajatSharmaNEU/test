/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sanjevani;

import com.sanjevani.database.Database;
import com.sanjevani.view.HomeFrame;

/**
 *
 * @author rajatsharma
 */
public class Sanjevani {

    public static void main(String[] args) {
        Database.createDatabase();
        new HomeFrame().setVisible(true);
        
    }
}
