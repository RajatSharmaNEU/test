/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Constants;
import com.sanjevani.database.Database;
import com.sanjevani.exceptions.CustomException;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class HospitalsPanel extends javax.swing.JPanel {

    List<Integer> doctorKeyList = new ArrayList<>();
    List<String> doctorNameList = new ArrayList<>();
    List<Integer> communityKeyList = new ArrayList<>();
    List<String> communityNameList = new ArrayList<>();
    
    /**
     * Creates new form HospitalsPanel
     */
    int selectedHospitalId;
    public HospitalsPanel() {
        initComponents();
        setHospitalsTable();
        initializeHospitalView();
    }
    
    private void initializeHospitalView() {
        // Populate Communities
        DefaultComboBoxModel communityModel = new DefaultComboBoxModel();
        communityModel.removeAllElements();
        communityModel.addElement("--Select--");
        
        Database.communityList.forEach((key, community) -> {
            communityKeyList.add(key);
            communityModel.addElement(community.getCommunityName());
        });
        
        communityComboBox.setModel(communityModel);
        
        // Populate Doctors
        DefaultListModel doctorsListModel = new DefaultListModel();
        doctorsListModel.removeAllElements();
        
        int key = 0;
        
        for(Person person: Database.personList.values()) {
            if(person.getRole() == "Doctor") {
                doctorKeyList.add(person.getPersonId());
                doctorNameList.add(person.getName());
                doctorsListModel.addElement(person.getName());
            }
            key++;
        }
        
        doctorsList.setModel(doctorsListModel);
        
        if(ApplicationState.isPatient()){
            buttonsPanel.setVisible(false);
        }
        
        if(ApplicationState.isHospitalAdmin()){
            addBtn.setVisible(false);
            resetBtn.setVisible(false);
        }
        
        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }
    
    
    private void setHospitalsTable() {
        HashMap<Integer,Hospital> list = Database.hospitalList;
        String[] tableColumns = {"Id", "Hospital Name", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[list.size()][tableColumns.length];
        
        int key = 0;
        for(Hospital hospital: list.values() ) {
            tableContent[key][0] = String.valueOf(hospital.getHospitalId());
            tableContent[key][1] = hospital.getName();
            
            Community community = Database.communityList.get(hospital.getCommunityId());
            
            tableContent[key][2] = community.getCommunityName();
            tableContent[key][3] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][4] = community.getZipcode();
            key++;
        }
        
        hospitalsTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetHospitalForm();
    }

    private void resetHospitalForm() {
        hospitalNameTxt.setText("");
        communityComboBox.setSelectedIndex(0);
        doctorsList.setSelectedIndices(new int[0]);
        hospitalsTable.getSelectionModel().clearSelection();
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
        
        // Hide ID column
        hospitalsTable.getColumnModel().getColumn(0).setMinWidth(0);
        hospitalsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        hospitalsTable.getColumnModel().getColumn(0).setWidth(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HospitalsOuterPanel = new javax.swing.JPanel();
        addHospitalPanel = new javax.swing.JPanel();
        hospitalNameLabel = new javax.swing.JLabel();
        hospitalNameTxt = new javax.swing.JTextField();
        communityLabel = new javax.swing.JLabel();
        communityComboBox = new javax.swing.JComboBox<>();
        doctorLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctorsList = new javax.swing.JList<>();
        buttonsPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        hospitalsTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(900, 1280));

        HospitalsOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Hospitals"));
        HospitalsOuterPanel.setPreferredSize(new java.awt.Dimension(900, 1280));
        HospitalsOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addHospitalPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        addHospitalPanel.setLayout(new java.awt.GridLayout(4, 2));

        hospitalNameLabel.setText("Hospital Name");
        addHospitalPanel.add(hospitalNameLabel);
        addHospitalPanel.add(hospitalNameTxt);

        communityLabel.setText("Community");
        addHospitalPanel.add(communityLabel);

        communityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addHospitalPanel.add(communityComboBox);

        doctorLabel.setText("Doctors");
        addHospitalPanel.add(doctorLabel);

        doctorsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(doctorsList);

        addHospitalPanel.add(jScrollPane1);

        HospitalsOuterPanel.add(addHospitalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, -1, 380));

        buttonsPanel.setPreferredSize(new java.awt.Dimension(900, 180));
        buttonsPanel.setLayout(new java.awt.GridLayout(1, 3));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        buttonsPanel.add(updateBtn);

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        buttonsPanel.add(addBtn);

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        buttonsPanel.add(resetBtn);

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        buttonsPanel.add(deleteBtn);

        HospitalsOuterPanel.add(buttonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 409, 915, 60));

        scrollTablePanel.setPreferredSize(new java.awt.Dimension(900, 600));

        hospitalsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        hospitalsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hospitalsTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(hospitalsTable);

        HospitalsOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 484, 915, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HospitalsOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HospitalsOuterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hospitalsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hospitalsTableMouseClicked
        selectedHospitalId = Integer.parseInt(hospitalsTable.getValueAt(hospitalsTable.getSelectedRow(), 0 ).toString());

        Hospital selectedItem = Database.hospitalList.get(selectedHospitalId);

        hospitalNameTxt.setText(selectedItem.getName());
        communityComboBox.setSelectedItem(Database.communityList.get(selectedItem.getCommunityId()).getCommunityName());
        
        // set doctors belongs to selected hospital
        int i = 0;
        int[] indices = new int[selectedItem.getDoctorIds().size()];        
        for(Integer doctorId: selectedItem.getDoctorIds()) {
            if(Database.personList.containsKey(doctorId)){
                String personName = Database.personList.get(doctorId).getName();
                int index = ((DefaultListModel)doctorsList.getModel()).indexOf(personName);
                indices[i++] = index;
            }
        }
        doctorsList.setSelectedIndices(indices);
        
        // Hide and Show Button
        updateBtn.setVisible(true);
        deleteBtn.setVisible(true);
        
        if(ApplicationState.isHospitalAdmin()){
            deleteBtn.setVisible(false);
        }
    }//GEN-LAST:event_hospitalsTableMouseClicked

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetHospitalForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Hospital selectedHospital = Database.hospitalList.get(selectedHospitalId);
        
        int selectedCommunityId = communityComboBox.getSelectedIndex();        
        String hospitalName = hospitalNameTxt.getText();
        List<Integer> selectedDoctorIds = new ArrayList<>();
        for(int index: doctorsList.getSelectedIndices()){
            selectedDoctorIds.add(doctorKeyList.get(index));
        }
        
        try {
            if (!hospitalName.isBlank() && selectedCommunityId > 0) {
                int communityId = communityKeyList.get(selectedCommunityId-1);        
                Database.updateHospital(
                selectedHospitalId,
                hospitalName,
                communityId, 
                selectedDoctorIds);
                setHospitalsTable();
            } else {
                throw new CustomException("Invalid Hospital Details");
            }
        } catch(CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            JOptionPane.showMessageDialog(this, Constants.INVALID_HOSPITAL_DETAIL);
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        List<Integer> selectedDoctorIds = new ArrayList<>();
        String hospitalName = hospitalNameTxt.getText();
        
        for(int index: doctorsList.getSelectedIndices()){
            selectedDoctorIds.add(doctorKeyList.get(index));
        }
        int selectedCommunityId = communityComboBox.getSelectedIndex();        
        
        try {
            if (!hospitalName.isBlank() && selectedCommunityId > 0) {
                int communityId = communityKeyList.get(selectedCommunityId-1);        
                Database.createHospital(hospitalNameTxt.getText(), communityId, selectedDoctorIds );
            } else {
                throw new CustomException("Invalid Hospital Details");
            }
        } catch(CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            JOptionPane.showMessageDialog(this, Constants.INVALID_DOCTOR_DETAIL);
        }
        
        
        setHospitalsTable();
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        
        int key = 0;
        boolean isUsed = false;
        
        for(Encounter encounter: Database.encounterList.values()) {
            if(encounter.getHospitalId() == selectedHospitalId) {
                JOptionPane.showMessageDialog(this, Constants.CANNOT_DELETE_HOSPITAL);
                isUsed = true;
            }
            key++;
        }
        
        if(!isUsed) {
            Database.deleteHospital(selectedHospitalId);
            setHospitalsTable();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HospitalsOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addHospitalPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JComboBox<String> communityComboBox;
    private javax.swing.JLabel communityLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel doctorLabel;
    private javax.swing.JList<String> doctorsList;
    private javax.swing.JLabel hospitalNameLabel;
    private javax.swing.JTextField hospitalNameTxt;
    private javax.swing.JTable hospitalsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetBtn;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
