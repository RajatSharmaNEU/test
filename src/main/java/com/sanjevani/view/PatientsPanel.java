/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Database;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class PatientsPanel extends javax.swing.JPanel {

    int selectedPatientId;
    String[] tableColumns = {"Doctor Name", "Date of Encounter", "Hospital Name"};
    /**
     * Creates new form PatientsPanel
     */
    public PatientsPanel() {
        initComponents();
        setPatientsTable();
        initializePatientView();
    }
    
    private void initializePatientView() {
        // Populate Communities
        DefaultComboBoxModel communityModel = new DefaultComboBoxModel();
        communityModel.removeAllElements();
        communityModel.addElement("--Select--");
        
        Database.communityList.forEach((key, community) -> {
            communityModel.addElement(community.getCommunityName());
        });
        
        communityComboBox.setModel(communityModel);
        
        if(ApplicationState.isDoctor() || ApplicationState.isPatient()){
            buttonPanel.setVisible(false);
        }
        
        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }
    
    private void setPatientsTable() {
        Map<Integer,Person> patientsList = Database.getPeople("Patient");
        String[] tableColumns = {"Id", "Patient Name", "Age", "Gender", "House", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[patientsList.size()][tableColumns.length];
        int key = 0;
        
        for(Person person: patientsList.values()) {
            tableContent[key][0] = String.valueOf(person.getPersonId());
            tableContent[key][1] = person.getName();
            tableContent[key][2] = String.valueOf(Database.personList.get(person.getPersonId()).getAge());
            tableContent[key][3] = Database.personList.get(person.getPersonId()).getGender();
            
            House house = Database.houseList.get(person.getHouseId());
            
            tableContent[key][4] = house.getAddress();
            
            Community community = Database.communityList.get(house.getCommunityId());
            tableContent[key][5] = community.getCommunityName();            
            tableContent[key][6] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][7] = String.valueOf(community.getZipcode());
            key++;
        }
        
        patientsTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetPatientForm();
    }
    
    private void resetPatientForm() {
        patientNameTxt.setText("");
        ageTxt.setText("");
        genderComboBox.setSelectedIndex(0);
        houseTxt.setText("");
        communityComboBox.setSelectedIndex(0);
        encounterTable.clearSelection();
        
        DefaultTableModel model = (DefaultTableModel) encounterTable.getModel();
        model.setRowCount(0);

        patientsTable.getSelectionModel().clearSelection();
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
        
        // Hide ID column
        patientsTable.getColumnModel().getColumn(0).setMinWidth(0);
        patientsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        patientsTable.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PatientsOuterPanel = new javax.swing.JPanel();
        addPatientPanel = new javax.swing.JPanel();
        patientNameLabel = new javax.swing.JLabel();
        patientNameTxt = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        houseLabel = new javax.swing.JLabel();
        houseTxt = new javax.swing.JTextField();
        communityLabel = new javax.swing.JLabel();
        communityComboBox = new javax.swing.JComboBox<>();
        encountersLabel = new javax.swing.JLabel();
        scrollEncounterPane = new javax.swing.JScrollPane();
        encounterTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();

        PatientsOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Patients"));
        PatientsOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addPatientPanel.setPreferredSize(new java.awt.Dimension(900, 550));
        addPatientPanel.setLayout(new java.awt.GridLayout(6, 2));

        patientNameLabel.setText("Patient Name");
        addPatientPanel.add(patientNameLabel);
        addPatientPanel.add(patientNameTxt);

        ageLabel.setText("Age");
        addPatientPanel.add(ageLabel);
        addPatientPanel.add(ageTxt);

        genderLabel.setText("Gender");
        addPatientPanel.add(genderLabel);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Male", "Female" }));
        addPatientPanel.add(genderComboBox);

        houseLabel.setText("House");
        addPatientPanel.add(houseLabel);
        addPatientPanel.add(houseTxt);

        communityLabel.setText("Community");
        addPatientPanel.add(communityLabel);

        communityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addPatientPanel.add(communityComboBox);

        encountersLabel.setText("Encounters");
        addPatientPanel.add(encountersLabel);

        encounterTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollEncounterPane.setViewportView(encounterTable);

        addPatientPanel.add(scrollEncounterPane);

        PatientsOuterPanel.add(addPatientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 890, 340));

        buttonPanel.setPreferredSize(new java.awt.Dimension(900, 180));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 4));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(updateBtn);

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(addBtn);

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(resetBtn);

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(deleteBtn);

        PatientsOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 60));

        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        patientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientsTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(patientsTable);

        PatientsOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 425, 884, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PatientsOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PatientsOuterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Person selectedPerson = Database.personList.get(selectedPatientId);
        Database.updateHouse(
                selectedPerson.getHouseId(), 
                communityComboBox.getSelectedIndex()-1, 
                houseTxt.getText());
        
        Database.updatePatient(
                selectedPatientId,
                patientNameTxt.getText(),
                selectedPerson.getEmailId(),
                selectedPerson.getPassword(),
                Integer.parseInt(ageTxt.getText()), 
                genderComboBox.getSelectedItem().toString(), 
                selectedPerson.getHouseId()
        );
        setPatientsTable();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Database.createHouse(communityComboBox.getSelectedIndex()-1, houseTxt.getText());

        // TODO: Fix lasthouseID
        Database.createPatient(
            patientNameTxt.getText(),
            "",
            "",
            Integer.parseInt(ageTxt.getText()),
            genderComboBox.getSelectedItem().toString(),
            Database.lastHouseId-1
        );
        setPatientsTable();
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetPatientForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        Database.deletePatient(selectedPatientId);
        setPatientsTable();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void patientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientsTableMouseClicked
        selectedPatientId = Integer.parseInt(patientsTable.getValueAt(patientsTable.getSelectedRow(), 0 ).toString());

        Person selectedItem = Database.personList.get(selectedPatientId);

        patientNameTxt.setText(selectedItem.getName());
        ageTxt.setText(String.valueOf(selectedItem.getAge()));
        genderComboBox.setSelectedItem(selectedItem.getGender());
        
        House house = Database.houseList.get(selectedItem.getHouseId());
        
        houseTxt.setText(house.getAddress());
        
        Community community = Database.communityList.get(house.getCommunityId());
        communityComboBox.setSelectedItem(community.getCommunityName());
        
        // Populate encounter table for a patient
        List<Encounter> patientEncounterList = Database.getEncounterByPatientId(selectedPatientId);
        String[][] tableContent = new String[patientEncounterList.size()][tableColumns.length];

        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        
        int key = 0;
        
        for(Encounter encounter: patientEncounterList) {
            tableContent[key][0] = Database.getPeople("Doctor").get(encounter.getDoctorId()).getName();
            tableContent[key][1] = String.valueOf(dateOnly.format(encounter.getDateOfEncounter()));
            tableContent[key][2] = Database.hospitalList.get(encounter.getHospitalId()).getName();
            key++;
        }
        
        encounterTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        
        // Hide and Show Button
        updateBtn.setVisible(true);
        deleteBtn.setVisible(true);
    }//GEN-LAST:event_patientsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatientsOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addPatientPanel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTxt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> communityComboBox;
    private javax.swing.JLabel communityLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable encounterTable;
    private javax.swing.JLabel encountersLabel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel houseLabel;
    private javax.swing.JTextField houseTxt;
    private javax.swing.JLabel patientNameLabel;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JTable patientsTable;
    private javax.swing.JButton resetBtn;
    private javax.swing.JScrollPane scrollEncounterPane;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
