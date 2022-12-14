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
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rajatsharma
 */
public class DoctorsPanel extends javax.swing.JPanel {
    List<Integer> hospitalKeyList = new ArrayList<>();
    List<String> hospitalNameList = new ArrayList<>();
    List<Integer> communityKeyList = new ArrayList<>();
    
    int selectedDoctorId;
    
    /**
     * Creates new form DoctorsPanel
     */
    public DoctorsPanel() {
        initComponents();
        setDoctorsTable();
        initializeDoctorView();
    }
    
    private void initializeDoctorView() {
        // Populate Communities
        DefaultComboBoxModel communityModel = new DefaultComboBoxModel();
        communityModel.removeAllElements();
        communityModel.addElement("--Select--");
        
        Database.communityList.forEach((key, community) -> {
            communityKeyList.add(key);
            communityModel.addElement(community.getCommunityName());
        });
        
        communityComboBox.setModel(communityModel);
        
        // Populate Hospitals
        DefaultListModel hospitalsListModel = new DefaultListModel();
        hospitalsListModel.removeAllElements();
        
        int key = 0;
        
        for(Hospital hospital: Database.hospitalList.values()) {
            hospitalKeyList.add(hospital.getHospitalId());
            hospitalNameList.add(hospital.getName());
            hospitalsListModel.addElement(hospital.getName());

            key++;
        }
        
        hospitalsList.setModel(hospitalsListModel);
        
        
        if(ApplicationState.isDoctor() || ApplicationState.isPatient()){
            buttonPanel.setVisible(false);
            passwordLabel.setVisible(false);
            passwordTxt.setVisible(false);
        }
        
        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }
    
    private void setDoctorsTable() {
        Map<Integer,Person> list = Database.getPeople("Doctor");
        String[] tableColumns = {"Id", "Doctor Name", "Age", "Gender", "House", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[list.size()][tableColumns.length];

        int key = 0;
        
        for(Map.Entry<Integer, Person> entry: list.entrySet()) {
            Person doctor = entry.getValue();
            tableContent[key][0] = String.valueOf(doctor.getPersonId());
            tableContent[key][1] = doctor.getName();
            tableContent[key][2] = String.valueOf(Database.personList.get(doctor.getPersonId()).getAge());
            tableContent[key][3] = Database.personList.get(doctor.getPersonId()).getGender();
            
            House house = Database.houseList.get(doctor.getHouseId());
            
            tableContent[key][4] = house.getAddress();
            
            Community community = Database.communityList.get(house.getCommunityId());
            tableContent[key][5] = community.getCommunityName();            
            tableContent[key][6] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][7] = String.valueOf(community.getZipcode());
            key++;
        }
        
        doctorsTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetDoctorForm();
    }
    
    private void resetDoctorForm() {
        doctorNameTxt.setText("");
        emailIdTxt.setText("");
        passwordTxt.setText("");
        ageTxt.setText("");
        genderComboBox.setSelectedIndex(0);
        houseTxt.setText("");
        communityComboBox.setSelectedIndex(0);
        hospitalsList.setSelectedIndices(new int[0]);
        doctorsTable.getSelectionModel().clearSelection();
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
        
        // Hide ID column
        doctorsTable.getColumnModel().getColumn(0).setMinWidth(0);
        doctorsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        doctorsTable.getColumnModel().getColumn(0).setWidth(0);
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
        doctorNameLabel = new javax.swing.JLabel();
        doctorNameTxt = new javax.swing.JTextField();
        emailIdLabel = new javax.swing.JLabel();
        emailIdTxt = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        houseLabel = new javax.swing.JLabel();
        houseTxt = new javax.swing.JTextField();
        communityLabel = new javax.swing.JLabel();
        communityComboBox = new javax.swing.JComboBox<>();
        hospitalsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalsList = new javax.swing.JList<>();
        buttonPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        doctorsTable = new javax.swing.JTable();

        DoctorsOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Doctors"));
        DoctorsOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addDoctorPanel.setPreferredSize(new java.awt.Dimension(900, 550));
        addDoctorPanel.setLayout(new java.awt.GridLayout(9, 2));

        doctorNameLabel.setText("Doctor Name");
        addDoctorPanel.add(doctorNameLabel);
        addDoctorPanel.add(doctorNameTxt);

        emailIdLabel.setText("EmailID");
        addDoctorPanel.add(emailIdLabel);
        addDoctorPanel.add(emailIdTxt);

        passwordLabel.setText("Password");
        addDoctorPanel.add(passwordLabel);

        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        addDoctorPanel.add(passwordTxt);

        ageLabel.setText("Age");
        addDoctorPanel.add(ageLabel);
        addDoctorPanel.add(ageTxt);

        genderLabel.setText("Gender");
        addDoctorPanel.add(genderLabel);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Male", "Female" }));
        addDoctorPanel.add(genderComboBox);

        houseLabel.setText("House");
        addDoctorPanel.add(houseLabel);
        addDoctorPanel.add(houseTxt);

        communityLabel.setText("Community");
        addDoctorPanel.add(communityLabel);

        communityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addDoctorPanel.add(communityComboBox);

        hospitalsLabel.setText("Hospitals");
        addDoctorPanel.add(hospitalsLabel);

        hospitalsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(hospitalsList);

        addDoctorPanel.add(jScrollPane1);

        DoctorsOuterPanel.add(addDoctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 890, 370));

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

        DoctorsOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 70));

        scrollTablePanel.setPreferredSize(new java.awt.Dimension(900, 550));

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
        doctorsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorsTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(doctorsTable);

        DoctorsOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 465, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DoctorsOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DoctorsOuterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doctorsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorsTableMouseClicked
        selectedDoctorId = Integer.parseInt(doctorsTable.getValueAt(doctorsTable.getSelectedRow(), 0 ).toString());

        Person selectedItem = Database.personList.get(selectedDoctorId);

        doctorNameTxt.setText(selectedItem.getName());
        emailIdTxt.setText(selectedItem.getEmailId());
        passwordTxt.setText(selectedItem.getPassword());
        
        ageTxt.setText(String.valueOf(selectedItem.getAge()));
        genderComboBox.setSelectedItem(selectedItem.getGender());
        
        House house = Database.houseList.get(selectedItem.getHouseId());
        
        houseTxt.setText(house.getAddress());
        
        Community community = Database.communityList.get(house.getCommunityId());
        communityComboBox.setSelectedItem(community.getCommunityName());
        
        // set hospitals belongs to selected doctor
        int i = 0;
        int[] indices = new int[selectedItem.getHospitalIds().size()];        
        for(Integer hospitalId: selectedItem.getHospitalIds()) {
            if(Database.hospitalList.containsKey(hospitalId)){
                String hospitalName = Database.hospitalList.get(hospitalId).getName();
                int index = ((DefaultListModel)hospitalsList.getModel()).indexOf(hospitalName);
                indices[i++] = index;
            }
        }
        hospitalsList.setSelectedIndices(indices);
        
        // Hide and Show Button
        updateBtn.setVisible(true);
        deleteBtn.setVisible(true);
    }//GEN-LAST:event_doctorsTableMouseClicked

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Person selectedPerson = Database.personList.get(selectedDoctorId);
        List<Integer> selectedHospitalIds = new ArrayList<>();
        for(int index: hospitalsList.getSelectedIndices()){
            selectedHospitalIds.add(hospitalKeyList.get(index));
        }
        
        
        String doctorName = doctorNameTxt.getText(),
                doctorEmailId = emailIdTxt.getText(),
                doctorPassword = passwordTxt.getText(),
                age = ageTxt.getText(),
                gender = genderComboBox.getSelectedItem().toString();
        
        int selectedCommunityId = communityComboBox.getSelectedIndex();
        
        
        try {
            if (!Pattern.matches(Constants.ageRegex, age) || !Pattern.matches(Constants.numberReg, age)){
                throw new CustomException(Constants.INVALID_AGE);
            }
            
            if (doctorName.isBlank()
                    || doctorEmailId.isBlank()
                    || doctorPassword.isBlank()
                    || age.isBlank()
                    || houseTxt.getText().isBlank()
                    || genderComboBox.getSelectedIndex() == 0
                    || selectedCommunityId == 0) 
            {
                throw new CustomException("Invalid Doctor Details");
            }
            
            int communityId = communityKeyList.get(selectedCommunityId-1);
            Database.updateHouse(selectedPerson.getHouseId(), communityComboBox.getSelectedIndex()-1, houseTxt.getText());
            Database.updateDoctor(
                selectedDoctorId, 
                doctorNameTxt.getText(),
                selectedPerson.getEmailId(),
                selectedPerson.getPassword(),
                Integer.parseInt(ageTxt.getText()), 
                genderComboBox.getSelectedItem().toString(),
                selectedPerson.getHouseId(),
                selectedHospitalIds);
            
            setDoctorsTable();
            
        } catch(CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if(e.getMessage().endsWith(Constants.INVALID_AGE)){
                JOptionPane.showMessageDialog(this, Constants.INVALID_AGE);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_DOCTOR_DETAIL);
            }
            
        }       
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        List<Integer> selectedHospitalIds = new ArrayList<>();
        for(int index: hospitalsList.getSelectedIndices()){
            selectedHospitalIds.add(hospitalKeyList.get(index));
        }
        String doctorName = doctorNameTxt.getText(),
                doctorEmailId = emailIdTxt.getText(),
                doctorPassword = passwordTxt.getText(),
                age = ageTxt.getText(),
                gender = genderComboBox.getSelectedItem().toString();
        
        int selectedCommunityId = communityComboBox.getSelectedIndex();
        
        try {
            if (!Pattern.matches(Constants.ageRegex, age) || !Pattern.matches(Constants.numberReg, age)){
                throw new CustomException(Constants.INVALID_AGE);
            }
            
            if (doctorName.isBlank()
                    || doctorEmailId.isBlank()
                    || doctorPassword.isBlank()
                    || age.isBlank()
                    || houseTxt.getText().isBlank()
                    || genderComboBox.getSelectedIndex() == 0
                    || selectedCommunityId == 0) 
            {
                throw new CustomException("Invalid Doctor Details");
            } 
            
            if(Database.isEmailIdExist(doctorEmailId)) {
                throw new CustomException(Constants.INVALID_EMAILID);
            }
 
            int communityId = communityKeyList.get(selectedCommunityId-1);
            Database.createHouse(communityId, houseTxt.getText());
            Database.createDoctor(
                doctorName,
                doctorEmailId,
                doctorPassword,
                Integer.parseInt(age),
                genderComboBox.getSelectedItem().toString(),
                Database.lastHouseId-1,
                selectedHospitalIds );
            setDoctorsTable();
            
        } catch(CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if(e.getMessage().endsWith(Constants.INVALID_AGE)){
                JOptionPane.showMessageDialog(this, Constants.INVALID_AGE);
            } else if(e.getMessage().endsWith(Constants.INVALID_EMAILID)){
                JOptionPane.showMessageDialog(this, Constants.INVALID_EMAILID);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_DOCTOR_DETAIL);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetDoctorForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int key = 0;
        boolean isUsed = false;
        
        for(Encounter encounter: Database.encounterList.values()) {
            if(encounter.getDoctorId() == selectedDoctorId) {
                JOptionPane.showMessageDialog(this, Constants.CANNOT_DELETE_DOCTOR);
                isUsed = true;
            }
            key++;
        }
        
        if(!isUsed) {
            Database.deleteDoctor(selectedDoctorId);
            setDoctorsTable();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DoctorsOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addDoctorPanel;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTxt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> communityComboBox;
    private javax.swing.JLabel communityLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JTextField doctorNameTxt;
    private javax.swing.JTable doctorsTable;
    private javax.swing.JLabel emailIdLabel;
    private javax.swing.JTextField emailIdTxt;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel hospitalsLabel;
    private javax.swing.JList<String> hospitalsList;
    private javax.swing.JLabel houseLabel;
    private javax.swing.JTextField houseTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JButton resetBtn;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
