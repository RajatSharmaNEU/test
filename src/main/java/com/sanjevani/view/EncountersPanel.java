/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Database;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import com.sanjevani.model.VitalSign;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class EncountersPanel extends javax.swing.JPanel {
    int selectedEncounterId;
    List<Integer> hospitalKeyList = new ArrayList<>();
    List<String> hospitalNameList = new ArrayList<>();
    
    List<Integer> patientKeyList = new ArrayList<>();
    List<String> patientNameList = new ArrayList<>();
    
    List<Integer> doctorKeyList = new ArrayList<>();
    List<String> doctorNameList = new ArrayList<>();
    /**
     * Creates new form HospitalsPanel
     */
    public EncountersPanel() {
        initComponents();
        setEncounterTable();
        initializeEncounterView();
    }
    
    private void initializeEncounterView() {
        // Populate Hospital
        DefaultComboBoxModel hospitalModel = new DefaultComboBoxModel();
        hospitalModel.removeAllElements();
        hospitalModel.addElement("--Select--");
        
        Database.hospitalList.forEach((key, hospital) -> {
            hospitalKeyList.add(key);
            hospitalNameList.add(hospital.getName());
            hospitalModel.addElement(hospital.getName());
        });
        
        hospitalComboBox.setModel(hospitalModel);
        
        // Populate Doctor
        DefaultComboBoxModel doctorModel = new DefaultComboBoxModel();
        doctorModel.removeAllElements();
        doctorModel.addElement("--Select--");
        
        Database.getPeople("Doctor").forEach((key, doctor) -> {
            doctorKeyList.add(key);
            doctorNameList.add(doctor.getName());
            doctorModel.addElement(doctor.getName());
        });
        
        doctorComboBox.setModel(doctorModel);
        
        // Populate Doctor
        DefaultComboBoxModel patientModel = new DefaultComboBoxModel();
        patientModel.removeAllElements();
        patientModel.addElement("--Select--");
        
        Database.getPeople("Patient").forEach((key, patient) -> {
            patientKeyList.add(key);
            patientNameList.add(patient.getName());
            patientModel.addElement(patient.getName());
        });
        
        patientComboBox.setModel(patientModel);
        
        
        if(ApplicationState.isPatient()){
            buttonPanel.setVisible(false);
        }
        
        
        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }
    
    private void resetEncounterForm() {
        
        hospitalComboBox.setSelectedIndex(0);
        doctorComboBox.setSelectedIndex(0);
        patientComboBox.setSelectedIndex(0);
        dateOfEncounterTxt.setText("");
        
        bloodPressureTxt.setText("");
        temperatureTxt.setText("");
        heartRateTxt.setText("");
        
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
        
        // Hide ID column
        encounterTable.getColumnModel().getColumn(0).setMinWidth(0);
        encounterTable.getColumnModel().getColumn(0).setMaxWidth(0);
        encounterTable.getColumnModel().getColumn(0).setWidth(0);
    }

    
    private void setEncounterTable() {
        HashMap<Integer,Encounter> list = Database.encounterList;
        String[] tableColumns = {"Id", "Patient Name", "Age", "Gender", "Temperatire", "Blood Pressure", "Heart Rate", "Encounter Date", "Status", "Doctor Name", "Hospital Name"};
        String[][] tableContent = new String[list.size()][tableColumns.length];

        int key = 0;
        for(Encounter encounter: list.values()) {
            Person patient = Database.personList.get(encounter.getPatientId());
            VitalSign vitalSign = Database.vitalSignList.get(encounter.getVitalSignId());
            Person doctor = Database.personList.get(encounter.getDoctorId());
            Hospital hospital = Database.hospitalList.get(encounter.getHospitalId());
            
            tableContent[key][0] = String.valueOf(encounter.getEncounterId());
            tableContent[key][1] = patient.getName();
            tableContent[key][2] = String.valueOf(patient.getAge());
            tableContent[key][3] = patient.getGender();
            tableContent[key][4] = String.valueOf(vitalSign.getTemperature());
            tableContent[key][5] = vitalSign.getBloodPressure();
            tableContent[key][6] = String.valueOf(vitalSign.getHeartRate());
            tableContent[key][7] = encounter.getDateOfEncounter();
            tableContent[key][8] = encounter.getStatus();
            
            tableContent[key][9] = doctor.getName();
            tableContent[key][10] = hospital.getName();
            key++;
        }
        
        encounterTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetEncounterForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EncountersOuterPanel = new javax.swing.JPanel();
        addEncounterPanel = new javax.swing.JPanel();
        hospitalLabel = new javax.swing.JLabel();
        hospitalComboBox = new javax.swing.JComboBox<>();
        doctorLabel = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox<>();
        patientLabel = new javax.swing.JLabel();
        patientComboBox = new javax.swing.JComboBox<>();
        dateOfEncounterLabel = new javax.swing.JLabel();
        dateOfEncounterTxt = new javax.swing.JTextField();
        bloodPressureLabel = new javax.swing.JLabel();
        bloodPressureTxt = new javax.swing.JTextField();
        temperatureLabel = new javax.swing.JLabel();
        temperatureTxt = new javax.swing.JTextField();
        heartRateLabel = new javax.swing.JLabel();
        heartRateTxt = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        encounterTable = new javax.swing.JTable();

        EncountersOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Encounters"));
        EncountersOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addEncounterPanel.setLayout(new java.awt.GridLayout(7, 2));

        hospitalLabel.setText("Hospital");
        addEncounterPanel.add(hospitalLabel);

        hospitalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addEncounterPanel.add(hospitalComboBox);

        doctorLabel.setText("Doctor");
        addEncounterPanel.add(doctorLabel);

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addEncounterPanel.add(doctorComboBox);

        patientLabel.setText("Patient");
        addEncounterPanel.add(patientLabel);

        patientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addEncounterPanel.add(patientComboBox);

        dateOfEncounterLabel.setText("Date of Encounter");
        addEncounterPanel.add(dateOfEncounterLabel);

        dateOfEncounterTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfEncounterTxtActionPerformed(evt);
            }
        });
        addEncounterPanel.add(dateOfEncounterTxt);

        bloodPressureLabel.setText("Blood Pressure");
        addEncounterPanel.add(bloodPressureLabel);
        addEncounterPanel.add(bloodPressureTxt);

        temperatureLabel.setText("Temperature");
        addEncounterPanel.add(temperatureLabel);

        temperatureTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperatureTxtActionPerformed(evt);
            }
        });
        addEncounterPanel.add(temperatureTxt);

        heartRateLabel.setText("Heart Rate");
        addEncounterPanel.add(heartRateLabel);

        heartRateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heartRateTxtActionPerformed(evt);
            }
        });
        addEncounterPanel.add(heartRateTxt);

        EncountersOuterPanel.add(addEncounterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 870, 370));

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

        EncountersOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 870, 70));

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
        encounterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encounterTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(encounterTable);

        EncountersOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 497, 878, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EncountersOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EncountersOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Encounter selectedEncounter = Database.encounterList.get(selectedEncounterId);
        
        int hospitalId = hospitalKeyList.get(hospitalComboBox.getSelectedIndex()-1);
        int doctorId = doctorKeyList.get(doctorComboBox.getSelectedIndex()-1);
        int patientId = patientKeyList.get(patientComboBox.getSelectedIndex()-1);
        
        
        Database.updateVitalSign(
                selectedEncounter.getVitalSignId(), 
                Double.parseDouble(temperatureTxt.getText()), 
                bloodPressureTxt.getText(), 
                Integer.parseInt(heartRateTxt.getText())
        );
        
        Database.updateEncounter(
                selectedEncounterId, 
                patientId, 
                selectedEncounter.getVitalSignId(), 
                dateOfEncounterTxt.getText(), 
                selectedEncounter.getStatus(),
                doctorId, 
                hospitalId
        );
        setEncounterTable();
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int hospitalId = hospitalKeyList.get(hospitalComboBox.getSelectedIndex()-1);
        int doctorId = doctorKeyList.get(doctorComboBox.getSelectedIndex()-1);
        int patientId = patientKeyList.get(patientComboBox.getSelectedIndex()-1);
        String dateOfEncounter = dateOfEncounterTxt.getText();
        
        Database.createVitalSign(Double.parseDouble(temperatureTxt.getText()), bloodPressureTxt.getText(), Integer.parseInt(heartRateTxt.getText()));
        
        Database.createEncounter(patientId, Database.lastVitalSignId - 1, dateOfEncounter, "Pending", doctorId, hospitalId);
        setEncounterTable();
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetEncounterForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        Database.deleteEncounter(selectedEncounterId);
        setEncounterTable();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void dateOfEncounterTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfEncounterTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfEncounterTxtActionPerformed

    private void encounterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encounterTableMouseClicked
        selectedEncounterId = Integer.parseInt(encounterTable.getValueAt(encounterTable.getSelectedRow(), 0 ).toString());
        Encounter encounter = Database.encounterList.get(selectedEncounterId);
        
        hospitalComboBox.setSelectedItem(Database.hospitalList.get(encounter.getHospitalId()).getName());
        doctorComboBox.setSelectedItem(Database.personList.get(encounter.getDoctorId()).getName());
        patientComboBox.setSelectedItem(Database.personList.get(encounter.getPatientId()).getName());
        dateOfEncounterTxt.setText(encounter.getDateOfEncounter());
        
        VitalSign vitalSign = Database.vitalSignList.get(encounter.getVitalSignId());
        bloodPressureTxt.setText(vitalSign.getBloodPressure());
        temperatureTxt.setText(String.valueOf(vitalSign.getTemperature()));
        heartRateTxt.setText(String.valueOf(vitalSign.getHeartRate()));
        
        // Hide and Show Button
        updateBtn.setVisible(true);
        deleteBtn.setVisible(true);
    }//GEN-LAST:event_encounterTableMouseClicked

    private void temperatureTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temperatureTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_temperatureTxtActionPerformed

    private void heartRateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heartRateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heartRateTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EncountersOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addEncounterPanel;
    private javax.swing.JLabel bloodPressureLabel;
    private javax.swing.JTextField bloodPressureTxt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel dateOfEncounterLabel;
    private javax.swing.JTextField dateOfEncounterTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JTable encounterTable;
    private javax.swing.JLabel heartRateLabel;
    private javax.swing.JTextField heartRateTxt;
    private javax.swing.JComboBox<String> hospitalComboBox;
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JComboBox<String> patientComboBox;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JTextField temperatureTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
