/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.Database;
import com.sanjevani.model.Community;
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class DoctorsPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorsPanel
     */
    public DoctorsPanel() {
        initComponents();
        setDoctorsTable(Database.getPeople("Doctor"));
    }
    
    private void setDoctorsTable(Map<Integer, Person> list) {
        String[] tableColumns = {"Doctor Name", "Age", "Gender", "House", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[list.size()][tableColumns.length];

        list.forEach((key, doctor) -> {
            tableContent[key][0] = doctor.getName();
            tableContent[key][1] = String.valueOf(Database.personList.get(doctor.getPersonId()).getAge());
            tableContent[key][2] = Database.personList.get(doctor.getPersonId()).getGender();
            
            House house = Database.houseList.get(doctor.getHouseId());
            
            tableContent[key][3] = house.getAddress();
            
            Community community = Database.communityList.get(house.getCommunityId());
            tableContent[key][4] = community.getCommunityName();            
            tableContent[key][5] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][6] = String.valueOf(community.getZipcode());
            
        });
        
        doctorsTable.setModel(new DefaultTableModel(tableContent, tableColumns));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DoctorsOuterPanel = new javax.swing.JPanel();
        addDoctorPanel = new javax.swing.JPanel();
        scrollTablePanel = new javax.swing.JScrollPane();
        doctorsTable = new javax.swing.JTable();

        DoctorsOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Doctors"));
        DoctorsOuterPanel.setLayout(new java.awt.GridLayout(2, 1));

        javax.swing.GroupLayout addDoctorPanelLayout = new javax.swing.GroupLayout(addDoctorPanel);
        addDoctorPanel.setLayout(addDoctorPanelLayout);
        addDoctorPanelLayout.setHorizontalGroup(
            addDoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 884, Short.MAX_VALUE)
        );
        addDoctorPanelLayout.setVerticalGroup(
            addDoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        DoctorsOuterPanel.add(addDoctorPanel);

        doctorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollTablePanel.setViewportView(doctorsTable);

        DoctorsOuterPanel.add(scrollTablePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DoctorsOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DoctorsOuterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DoctorsOuterPanel;
    private javax.swing.JPanel addDoctorPanel;
    private javax.swing.JTable doctorsTable;
    private javax.swing.JScrollPane scrollTablePanel;
    // End of variables declaration//GEN-END:variables
}
