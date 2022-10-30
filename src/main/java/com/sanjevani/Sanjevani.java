/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sanjevani;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.sanjevani.database.Database;
import com.sanjevani.view.LoginFrame;

/**
 *
 * @author rajatsharma
 */
public class Sanjevani {

    public static void main(String[] args) {
        FlatMoonlightIJTheme.setup();
        
        Database.createDatabase();
        new LoginFrame().setVisible(true);
    }
}
