/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import static com.sanjevani.database.ApplicationState.authenticatedPerson;
import com.sanjevani.database.Constants;
import com.sanjevani.database.Database;
import com.sanjevani.exceptions.CustomException;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.House;
import com.sanjevani.model.Person;
import com.sanjevani.model.VitalSign;
import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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

    JCalendar calendar = new JCalendar();

    /**
     * Creates new form HospitalsPanel
     */
    public EncountersPanel() {
        initComponents();
        setEncounterTable();
        initializeEncounterView();
    }

    private void initializeEncounterView() {
        //Add calendar
        calendarPanel.add(calendar);
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.add(calendar, BorderLayout.CENTER);

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

        if (ApplicationState.isDoctor()) {
            doctorKeyList.add(ApplicationState.authenticatedPerson.getPersonId());
            doctorNameList.add(ApplicationState.authenticatedPerson.getName());
            doctorModel.addElement(ApplicationState.authenticatedPerson.getName());
        } else {
            Database.getPeople("Doctor").forEach((key, doctor) -> {
                doctorKeyList.add(key);
                doctorNameList.add(doctor.getName());
                doctorModel.addElement(doctor.getName());
            });
        }
        
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

        if (ApplicationState.isPatient()) {
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
        calendar.setDate(new Date());

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
        HashMap<Integer, Encounter> list = Database.encounterList;
        String[] tableColumns = {"Id", "Patient Name", "Age", "Gender", "Temperatire", "Blood Pressure", "Heart Rate", "Encounter Date", "Status", "Doctor Name", "Hospital Name"};
        String[][] tableContent = new String[list.size()][tableColumns.length];
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        int key = 0;
        for (Encounter encounter : list.values()) {
            Person patient = Database.personList.get(encounter.getPatientId());
            VitalSign vitalSign = Database.vitalSignList.get(encounter.getVitalSignId());
            Person doctor = Database.personList.get(encounter.getDoctorId());
            Hospital hospital = Database.hospitalList.get(encounter.getHospitalId());

            System.out.println(ApplicationState.isDoctor());
            System.out.println(ApplicationState.authenticatedPerson.getPersonId());
            System.out.println(encounter.getDoctorId());

            if ((ApplicationState.isDoctor() && ApplicationState.authenticatedPerson.getPersonId() == encounter.getDoctorId())
                    || !ApplicationState.isDoctor()) {
                tableContent[key][0] = String.valueOf(encounter.getEncounterId());
                tableContent[key][1] = patient.getName();
                tableContent[key][2] = String.valueOf(patient.getAge());
                tableContent[key][3] = patient.getGender();
                tableContent[key][4] = String.valueOf(vitalSign.getTemperature());
                tableContent[key][5] = vitalSign.getBloodPressure();
                tableContent[key][6] = String.valueOf(vitalSign.getHeartRate());
                tableContent[key][7] = String.valueOf(dateOnly.format(encounter.getDateOfEncounter()));
                tableContent[key][8] = encounter.getStatus();

                tableContent[key][9] = doctor.getName();
                tableContent[key][10] = hospital.getName();
            }

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
        bloodPressureLabel = new javax.swing.JLabel();
        bloodPressureTxt = new javax.swing.JTextField();
        temperatureLabel = new javax.swing.JLabel();
        temperatureTxt = new javax.swing.JTextField();
        heartRateLabel = new javax.swing.JLabel();
        heartRateTxt = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        calendarControlPanel = new javax.swing.JPanel();
        dateOfEncounterLabel = new javax.swing.JLabel();
        calendarPanel = new javax.swing.JLabel();
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
        hospitalComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hospitalComboBoxItemStateChanged(evt);
            }
        });
        addEncounterPanel.add(hospitalComboBox);

        doctorLabel.setText("Doctor");
        addEncounterPanel.add(doctorLabel);

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctorComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                doctorComboBoxItemStateChanged(evt);
            }
        });
        addEncounterPanel.add(doctorComboBox);

        patientLabel.setText("Patient");
        addEncounterPanel.add(patientLabel);

        patientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addEncounterPanel.add(patientComboBox);

        bloodPressureLabel.setText("Blood Pressure");
        addEncounterPanel.add(bloodPressureLabel);
        addEncounterPanel.add(bloodPressureTxt);

        temperatureLabel.setText("Temperature (0 F - 200 F)");
        addEncounterPanel.add(temperatureLabel);

        temperatureTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temperatureTxtActionPerformed(evt);
            }
        });
        addEncounterPanel.add(temperatureTxt);

        heartRateLabel.setText("Heart Rate (0 - 160)");
        addEncounterPanel.add(heartRateLabel);

        heartRateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heartRateTxtActionPerformed(evt);
            }
        });
        addEncounterPanel.add(heartRateTxt);

        statusLabel.setText("Status");
        addEncounterPanel.add(statusLabel);

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Diagnosed", "Leave" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });
        addEncounterPanel.add(statusComboBox);

        EncountersOuterPanel.add(addEncounterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 870, 240));

        dateOfEncounterLabel.setText("Date of Encounter");

        calendarPanel.setMixingCutoutShape(null);

        javax.swing.GroupLayout calendarControlPanelLayout = new javax.swing.GroupLayout(calendarControlPanel);
        calendarControlPanel.setLayout(calendarControlPanelLayout);
        calendarControlPanelLayout.setHorizontalGroup(
            calendarControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calendarControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateOfEncounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(calendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        calendarControlPanelLayout.setVerticalGroup(
            calendarControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarControlPanelLayout.createSequentialGroup()
                .addComponent(dateOfEncounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 188, Short.MAX_VALUE))
            .addGroup(calendarControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        EncountersOuterPanel.add(calendarControlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 880, 240));

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

        EncountersOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 870, 60));

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

        EncountersOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 587, 878, 310));

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

        int selectedHospitalId = hospitalComboBox.getSelectedIndex();
        int selectedDoctorId = doctorComboBox.getSelectedIndex();
        int selectedPatientId = patientComboBox.getSelectedIndex();

        String heartRateText = heartRateTxt.getText();
        String temperatureText = temperatureTxt.getText();

        try {
            if (!Pattern.matches(Constants.numberReg, heartRateText) || Integer.parseInt(heartRateText) < 0 || Integer.parseInt(heartRateText) > 160) {
                throw new CustomException(Constants.INVALID_HEART_RATE);
            }

            if (!Pattern.matches(Constants.decimalReg, temperatureText) || Double.parseDouble(temperatureText) < 0 || Double.parseDouble(temperatureText) > 200) {
                throw new CustomException(Constants.INVALID_TEMP);
            }

            if (selectedHospitalId == 0
                    || selectedDoctorId == 0
                    || selectedPatientId == 0
                    || temperatureTxt.getText().isBlank()
                    || bloodPressureTxt.getText().isBlank()
                    || heartRateTxt.getText().isBlank()) {
                throw new CustomException(Constants.INVALID_ENCOUNTER_DETAIL);
            }
            int hospitalId = hospitalKeyList.get(selectedHospitalId - 1);
            int doctorId = doctorKeyList.get(selectedDoctorId - 1);
            int patientId = patientKeyList.get(selectedPatientId - 1);

            Double temperature = Double.parseDouble(temperatureTxt.getText());
            String bloodPressure = bloodPressureTxt.getText();

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
                    calendar.getDate(),
                    statusComboBox.getSelectedItem().toString(),
                    doctorId,
                    hospitalId
            );
            setEncounterTable();

        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_HEART_RATE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_HEART_RATE);
            } else if (e.getMessage().endsWith(Constants.INVALID_TEMP)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_TEMP);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_ENCOUNTER_DETAIL);
            }
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        int selectedHospitalId = hospitalComboBox.getSelectedIndex();
        int selectedDoctorId = doctorComboBox.getSelectedIndex();
        int selectedPatientId = patientComboBox.getSelectedIndex();

        String heartRateText = heartRateTxt.getText();
        String temperatureText = temperatureTxt.getText();

        try {
            if (!Pattern.matches(Constants.numberReg, heartRateText) || Integer.parseInt(heartRateText) < 0 || Integer.parseInt(heartRateText) > 160) {
                throw new CustomException(Constants.INVALID_HEART_RATE);
            }

            if (!Pattern.matches(Constants.decimalReg, temperatureText) || Double.parseDouble(temperatureText) < 0 || Double.parseDouble(temperatureText) > 200) {
                throw new CustomException(Constants.INVALID_TEMP);
            }

            if (selectedHospitalId == 0
                    || selectedDoctorId == 0
                    || selectedPatientId == 0
                    || temperatureTxt.getText().isBlank()
                    || bloodPressureTxt.getText().isBlank()
                    || heartRateTxt.getText().isBlank()) {
                throw new CustomException(Constants.INVALID_ENCOUNTER_DETAIL);
            }

            int hospitalId = hospitalKeyList.get(selectedHospitalId - 1);
            int doctorId = doctorKeyList.get(selectedDoctorId - 1);
            int patientId = patientKeyList.get(selectedPatientId - 1);

            Double temperature = Double.parseDouble(temperatureTxt.getText());
            String bloodPressure = bloodPressureTxt.getText();
            Integer heartRate = Integer.parseInt(heartRateTxt.getText());

            Date dateOfEncounter = calendar.getDate();

            Database.createVitalSign(temperature, bloodPressure, heartRate);

            Database.createEncounter(patientId, Database.lastVitalSignId - 1, dateOfEncounter, statusComboBox.getSelectedItem().toString(), doctorId, hospitalId);
            setEncounterTable();

        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_HEART_RATE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_HEART_RATE);
            } else if (e.getMessage().endsWith(Constants.INVALID_TEMP)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_TEMP);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_ENCOUNTER_DETAIL);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetEncounterForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        Database.deleteEncounter(selectedEncounterId);
        setEncounterTable();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void encounterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encounterTableMouseClicked
        selectedEncounterId = Integer.parseInt(encounterTable.getValueAt(encounterTable.getSelectedRow(), 0).toString());
        Encounter encounter = Database.encounterList.get(selectedEncounterId);

        hospitalComboBox.setSelectedItem(Database.hospitalList.get(encounter.getHospitalId()).getName());
        doctorComboBox.setSelectedItem(Database.personList.get(encounter.getDoctorId()).getName());
        patientComboBox.setSelectedItem(Database.personList.get(encounter.getPatientId()).getName());
        calendar.setDate(encounter.getDateOfEncounter());

        VitalSign vitalSign = Database.vitalSignList.get(encounter.getVitalSignId());
        bloodPressureTxt.setText(vitalSign.getBloodPressure());
        temperatureTxt.setText(String.valueOf(vitalSign.getTemperature()));
        heartRateTxt.setText(String.valueOf(vitalSign.getHeartRate()));

        statusComboBox.setSelectedItem(encounter.getStatus());

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

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void hospitalComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hospitalComboBoxItemStateChanged
        int index = hospitalComboBox.getSelectedIndex();
        int key = 0;

        // Populate Doctor
        DefaultComboBoxModel doctorModel = new DefaultComboBoxModel();
        doctorModel.removeAllElements();
        doctorModel.addElement("--Select--");

        if (index == 0) {
            for (Person person : Database.getPeople("Doctor").values()) {

                doctorKeyList.add(key);
                doctorNameList.add(person.getName());
                doctorModel.addElement(person.getName());

                key++;
            }
        } else {
            int doctorId = doctorKeyList.get(index - 1);
            for (Person person : Database.getPeople("Doctor").values()) {
                if (person.getHospitalIds().contains(doctorId)) {
                    doctorKeyList.add(key);
                    doctorNameList.add(person.getName());
                    doctorModel.addElement(person.getName());
                }

                key++;
            }

        }
        doctorComboBox.setModel(doctorModel);
    }//GEN-LAST:event_hospitalComboBoxItemStateChanged

    private void doctorComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_doctorComboBoxItemStateChanged
    }//GEN-LAST:event_doctorComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EncountersOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addEncounterPanel;
    private javax.swing.JLabel bloodPressureLabel;
    private javax.swing.JTextField bloodPressureTxt;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel calendarControlPanel;
    private javax.swing.JLabel calendarPanel;
    private javax.swing.JLabel dateOfEncounterLabel;
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
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JTextField temperatureTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
