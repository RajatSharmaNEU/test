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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class PeoplePanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalsPanel
     */
    public PeoplePanel() {
        initComponents();
        setPeopleTable(Database.personList);
    }
    
    private void setPeopleTable(HashMap<Integer,Person> list) {
        String[] tableColumns = {"Person Name", "Age", "Gender", "Role", "House", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[list.size()][tableColumns.length];

        list.forEach((key, doctor) -> {
            tableContent[key][0] = doctor.getName();
            tableContent[key][1] = String.valueOf(Database.personList.get(doctor.getPersonId()).getAge());
            tableContent[key][2] = Database.personList.get(doctor.getPersonId()).getGender();
            tableContent[key][3] = Database.personList.get(doctor.getPersonId()).getRole();
            
            House house = Database.houseList.get(doctor.getHouseId());
            
            tableContent[key][4] = house.getAddress();
            
            Community community = Database.communityList.get(house.getCommunityId());
            tableContent[key][5] = community.getCommunityName();            
            tableContent[key][6] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][7] = String.valueOf(community.getZipcode());
            
        });
        
        peopleTable.setModel(new DefaultTableModel(tableContent, tableColumns));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PeopleOuterPanel = new javax.swing.JPanel();
        AddPeoplePanel = new javax.swing.JPanel();
        scrollTablePanel = new javax.swing.JScrollPane();
        peopleTable = new javax.swing.JTable();

        PeopleOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage People"));
        PeopleOuterPanel.setLayout(new java.awt.GridLayout(2, 1));

        javax.swing.GroupLayout AddPeoplePanelLayout = new javax.swing.GroupLayout(AddPeoplePanel);
        AddPeoplePanel.setLayout(AddPeoplePanelLayout);
        AddPeoplePanelLayout.setHorizontalGroup(
            AddPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );
        AddPeoplePanelLayout.setVerticalGroup(
            AddPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        PeopleOuterPanel.add(AddPeoplePanel);

        peopleTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTablePanel.setViewportView(peopleTable);

        PeopleOuterPanel.add(scrollTablePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PeopleOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PeopleOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPeoplePanel;
    private javax.swing.JPanel PeopleOuterPanel;
    private javax.swing.JTable peopleTable;
    private javax.swing.JScrollPane scrollTablePanel;
    // End of variables declaration//GEN-END:variables
}
