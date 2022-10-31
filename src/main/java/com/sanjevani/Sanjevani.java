/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sanjevani;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedLightIJTheme;
import com.sanjevani.database.Database;
import com.sanjevani.view.HomeFrame;
import com.sanjevani.view.LoginFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajatsharma
 */
public class Sanjevani {

    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.setup();
        
        Database.createDatabase();
        
        try {
            new LoginFrame().setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(Sanjevani.class.getName()).log(Level.SEVERE, "Some error occured");
        }
        
    }
}
