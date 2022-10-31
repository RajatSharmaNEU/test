/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.Constants;
import com.sanjevani.database.Database;
import com.sanjevani.exceptions.CustomException;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class PeoplePanel extends javax.swing.JPanel {

    int selectedPersonId;
    Person selectedItem;
    List<String> roleWithHospitalIds = Arrays.asList("HospitalAdmin", "Doctor", "SystemAdmin");
    List<Integer> communityKeyList = new ArrayList<>();
    List<Integer> hospitalKeyList = new ArrayList<>();
    List<String> hospitalNameList = new ArrayList<>();

    /**
     * Creates new form HospitalsPanel
     */
    public PeoplePanel() {
        initComponents();
        setPeopleTable();
        initializePeopleView();
    }

    private void initializePeopleView() {
        // Populate Roles
        DefaultComboBoxModel roleModel = new DefaultComboBoxModel();
        roleModel.removeAllElements();
        roleModel.addElement("--Select--");

        for (String role : Database.roles) {
            roleModel.addElement(role);
        }

        roleComboBox.setModel(roleModel);

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

        for (Hospital hospital : Database.hospitalList.values()) {
            hospitalKeyList.add(hospital.getHospitalId());
            hospitalNameList.add(hospital.getName());
            hospitalsListModel.addElement(hospital.getName());

            key++;
        }

        hospitalsList.setModel(hospitalsListModel);

        // hide hospital panels
        hospitalLabel.setVisible(false);
        hospitalScrollPane.setVisible(false);

        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
    }

    private void resetPersonForm() {
        personNameTxt.setText("");
        emailIdTxt.setText("");
        passwordTxt.setText("");
        ageTxt.setText("");
        roleComboBox.setSelectedIndex(0);
        genderComboBox.setSelectedIndex(0);
        houseTxt.setText("");
        communityComboBox.setSelectedIndex(0);
        peopleTable.getSelectionModel().clearSelection();

        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);

        // hide hospital panels
        hospitalLabel.setVisible(false);
        hospitalScrollPane.setVisible(false);

        // Hide ID column
        peopleTable.getColumnModel().getColumn(0).setMinWidth(0);
        peopleTable.getColumnModel().getColumn(0).setMaxWidth(0);
        peopleTable.getColumnModel().getColumn(0).setWidth(0);
    }

    private void setPeopleTable() {
        HashMap<Integer, Person> list = Database.personList;
        String[] tableColumns = {"Id", "Person Name", "EmailId", "Age", "Gender", "Role", "House", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[list.size()][tableColumns.length];

        int key = 0;

        for (Map.Entry<Integer, Person> entry : list.entrySet()) {
            Person person = entry.getValue();
            tableContent[key][0] = String.valueOf(person.getPersonId());
            tableContent[key][1] = person.getName();
            tableContent[key][2] = person.getEmailId();
            tableContent[key][3] = String.valueOf(Database.personList.get(person.getPersonId()).getAge());
            tableContent[key][4] = Database.personList.get(person.getPersonId()).getGender();
            tableContent[key][5] = Database.personList.get(person.getPersonId()).getRole();
            House house = Database.houseList.get(person.getHouseId());

            tableContent[key][6] = house.getAddress();

            Community community = Database.communityList.get(house.getCommunityId());
            tableContent[key][7] = community.getCommunityName();
            tableContent[key][8] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][9] = String.valueOf(community.getZipcode());
            key++;
        }

        peopleTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetPersonForm();
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
        personNameLabel = new javax.swing.JLabel();
        personNameTxt = new javax.swing.JTextField();
        emailIdLabel = new javax.swing.JLabel();
        emailIdTxt = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        ageLabel = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        roleLabel = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        houseLabel = new javax.swing.JLabel();
        houseTxt = new javax.swing.JTextField();
        communityLabel = new javax.swing.JLabel();
        communityComboBox = new javax.swing.JComboBox<>();
        hospitalLabel = new javax.swing.JLabel();
        hospitalScrollPane = new javax.swing.JScrollPane();
        hospitalsList = new javax.swing.JList<>();
        buttonPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        peopleTable = new javax.swing.JTable();

        PeopleOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage People"));
        PeopleOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddPeoplePanel.setLayout(new java.awt.GridLayout(9, 2));

        personNameLabel.setText("Name");
        AddPeoplePanel.add(personNameLabel);
        AddPeoplePanel.add(personNameTxt);

        emailIdLabel.setText("EmailID");
        AddPeoplePanel.add(emailIdLabel);
        AddPeoplePanel.add(emailIdTxt);

        passwordLabel.setText("Password");
        AddPeoplePanel.add(passwordLabel);

        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        AddPeoplePanel.add(passwordTxt);

        ageLabel.setText("Age");
        AddPeoplePanel.add(ageLabel);
        AddPeoplePanel.add(ageTxt);

        roleLabel.setText("Role");
        AddPeoplePanel.add(roleLabel);

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roleComboBoxItemStateChanged(evt);
            }
        });
        AddPeoplePanel.add(roleComboBox);

        genderLabel.setText("Gender");
        AddPeoplePanel.add(genderLabel);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Male", "Female" }));
        AddPeoplePanel.add(genderComboBox);

        houseLabel.setText("House");
        AddPeoplePanel.add(houseLabel);
        AddPeoplePanel.add(houseTxt);

        communityLabel.setText("Community");
        AddPeoplePanel.add(communityLabel);

        communityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddPeoplePanel.add(communityComboBox);

        hospitalLabel.setText("Hospital");
        AddPeoplePanel.add(hospitalLabel);

        hospitalsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        hospitalScrollPane.setViewportView(hospitalsList);

        AddPeoplePanel.add(hospitalScrollPane);

        PeopleOuterPanel.add(AddPeoplePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 900, 360));

        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

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

        PeopleOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 900, 60));

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
        peopleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                peopleTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(peopleTable);

        PeopleOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 458, 900, 439));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PeopleOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PeopleOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void peopleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peopleTableMouseClicked
        selectedPersonId = Integer.parseInt(peopleTable.getValueAt(peopleTable.getSelectedRow(), 0).toString());

        selectedItem = Database.personList.get(selectedPersonId);

        personNameTxt.setText(selectedItem.getName());
        emailIdTxt.setText(selectedItem.getEmailId());
        passwordTxt.setText(selectedItem.getPassword());
        ageTxt.setText(String.valueOf(selectedItem.getAge()));
        genderComboBox.setSelectedItem(selectedItem.getGender());
        roleComboBox.setSelectedItem(selectedItem.getRole());

        House house = Database.houseList.get(selectedItem.getHouseId());

        houseTxt.setText(house.getAddress());

        Community community = Database.communityList.get(house.getCommunityId());
        communityComboBox.setSelectedItem(community.getCommunityName());

        // set hospitals belongs to selected doctor
        if (roleWithHospitalIds.contains(selectedItem.getRole())) {
            // hide hospital panels
            hospitalLabel.setVisible(true);
            hospitalScrollPane.setVisible(true);
            int i = 0;
            int[] indices = new int[selectedItem.getHospitalIds().size()];
            for (Integer hospitalId : selectedItem.getHospitalIds()) {
                if (Database.hospitalList.containsKey(hospitalId)) {
                    String hospitalName = Database.hospitalList.get(hospitalId).getName();
                    int index = ((DefaultListModel) hospitalsList.getModel()).indexOf(hospitalName);
                    indices[i++] = index;
                }
            }
            hospitalsList.setSelectedIndices(indices);

        } else {
            // hide hospital panels
            hospitalLabel.setVisible(false);
            hospitalScrollPane.setVisible(false);
        }

        // Hide and Show Button
        updateBtn.setVisible(true);
        deleteBtn.setVisible(true);
    }//GEN-LAST:event_peopleTableMouseClicked

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Person selectedPerson = Database.personList.get(selectedPersonId);

        int communityId = communityKeyList.get(communityComboBox.getSelectedIndex() - 1);

        List<Integer> selectedHospitalIds = new ArrayList<>();
        for (int index : hospitalsList.getSelectedIndices()) {
            selectedHospitalIds.add(hospitalKeyList.get(index));
        }

        String personName = personNameTxt.getText(),
                personEmailId = emailIdTxt.getText(),
                personPassword = passwordTxt.getText(),
                age = ageTxt.getText(),
                gender = genderComboBox.getSelectedItem().toString();

        int selectedCommunityId = communityComboBox.getSelectedIndex();

        try {
            if (!Pattern.matches(Constants.ageRegex, age) || !Pattern.matches(Constants.numberReg, age)) {
                throw new CustomException(Constants.INVALID_AGE);
            }

            if (personName.isBlank()
                    || personEmailId.isBlank()
                    || personPassword.isBlank()
                    || age.isBlank()
                    || roleComboBox.getSelectedIndex() == 0
                    || houseTxt.getText().isBlank()
                    || genderComboBox.getSelectedIndex() == 0
                    || selectedCommunityId == 0) {
                throw new CustomException("Invalid Person Details");
            }

            Database.updateHouse(
                    selectedPerson.getHouseId(),
                    communityId,
                    houseTxt.getText()
            );

            Database.updateAdmin(
                    selectedPersonId,
                    personNameTxt.getText(),
                    emailIdTxt.getText(),
                    passwordTxt.getText(),
                    roleComboBox.getSelectedItem().toString(),
                    Integer.parseInt(ageTxt.getText()),
                    genderComboBox.getSelectedItem().toString(),
                    Database.lastHouseId - 1,
                    selectedHospitalIds
            );
            setPeopleTable();

        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_AGE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_AGE);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_PERSON_DETAIL);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        List<Integer> selectedHospitalIds = new ArrayList<>();
        for (int index : hospitalsList.getSelectedIndices()) {
            selectedHospitalIds.add(hospitalKeyList.get(index));
        }

        String personName = personNameTxt.getText(),
                personEmailId = emailIdTxt.getText(),
                doctorPassword = passwordTxt.getText(),
                age = ageTxt.getText(),
                gender = genderComboBox.getSelectedItem().toString();

        int selectedCommunityId = communityComboBox.getSelectedIndex();

        try {
            if (!Pattern.matches(Constants.ageRegex, age) || !Pattern.matches(Constants.numberReg, age)) {
                throw new CustomException(Constants.INVALID_AGE);
            }

            if (personName.isBlank()
                    || personEmailId.isBlank()
                    || doctorPassword.isBlank()
                    || age.isBlank()
                    || houseTxt.getText().isBlank()
                    || genderComboBox.getSelectedIndex() == 0
                    || selectedCommunityId == 0) {
                throw new CustomException(Constants.INVALID_PERSON_DETAIL);
            }

            if (Database.isEmailIdExist(personEmailId)) {
                throw new CustomException(Constants.INVALID_EMAILID);
            }

            int communityId = communityKeyList.get(selectedCommunityId - 1);
            Database.createHouse(communityId, houseTxt.getText());
            Database.createAdmin(
                    personNameTxt.getText(),
                    emailIdTxt.getText(),
                    passwordTxt.getText(),
                    roleComboBox.getSelectedItem().toString(),
                    Integer.parseInt(ageTxt.getText()),
                    genderComboBox.getSelectedItem().toString(),
                    Database.lastHouseId - 1,
                    selectedHospitalIds
            );
            setPeopleTable();

        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_AGE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_AGE);
            } else if (e.getMessage().endsWith(Constants.INVALID_EMAILID)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_EMAILID);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_PERSON_DETAIL);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetPersonForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        if (selectedItem.getRole() == "Doctor") {
            int key = 0;
            boolean isUsed = false;

            for (Encounter encounter : Database.encounterList.values()) {
                if (encounter.getDoctorId() == selectedPersonId) {
                    JOptionPane.showMessageDialog(this, Constants.CANNOT_DELETE_DOCTOR);
                    isUsed = true;
                }
                key++;
            }

            if (!isUsed) {
                Database.deletePerson(selectedPersonId);
                setPeopleTable();
            }
        }

        if (selectedItem.getRole() == "Patient") {
            int key = 0;
            HashMap<Integer, Encounter> encounterList = new HashMap<>();

            for (Encounter encounter : Database.encounterList.values()) {
                int patientId = encounter.getPatientId();
                int encounterId = encounter.getEncounterId();
                if (patientId != selectedPersonId) {
                    encounterList.put(encounterId, encounter);
                }
                key++;
            }

            Database.encounterList = encounterList;
            Database.deletePatient(selectedPersonId);
            setPeopleTable();
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void roleComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roleComboBoxItemStateChanged
        if (roleWithHospitalIds.contains(roleComboBox.getSelectedItem().toString())) {
            // hide hospital panels
            hospitalLabel.setVisible(true);
            hospitalScrollPane.setVisible(true);
        } else {
            // hide hospital panels
            hospitalLabel.setVisible(false);
            hospitalScrollPane.setVisible(false);
        }
    }//GEN-LAST:event_roleComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPeoplePanel;
    private javax.swing.JPanel PeopleOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTxt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> communityComboBox;
    private javax.swing.JLabel communityLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel emailIdLabel;
    private javax.swing.JTextField emailIdTxt;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel hospitalLabel;
    private javax.swing.JScrollPane hospitalScrollPane;
    private javax.swing.JList<String> hospitalsList;
    private javax.swing.JLabel houseLabel;
    private javax.swing.JTextField houseTxt;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JTable peopleTable;
    private javax.swing.JLabel personNameLabel;
    private javax.swing.JTextField personNameTxt;
    private javax.swing.JButton resetBtn;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
