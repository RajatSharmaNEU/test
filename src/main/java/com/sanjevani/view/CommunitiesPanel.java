/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Constants;
import com.sanjevani.database.Database;
import com.sanjevani.exceptions.CustomException;
import com.sanjevani.model.City;
import com.sanjevani.model.Community;
import com.sanjevani.model.Encounter;
import com.sanjevani.model.Hospital;
import com.sanjevani.model.Person;
import java.util.HashMap;
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
public class CommunitiesPanel extends javax.swing.JPanel {
    int selectedCommunityId;
    /**
     * Creates new form HospitalsPanel
     */
    public CommunitiesPanel() {
        initComponents();
        setCommunitiesTable();
        initializeCommunityView();
    }
    
    private void initializeCommunityView() {
        // Populate Communities
        DefaultComboBoxModel cityModel = new DefaultComboBoxModel();
        cityModel.removeAllElements();
        cityModel.addElement("--Select--");
        
        Database.cityList.forEach((key, city) -> {
            cityModel.addElement(city.getCityName());
        });
        
        cityComboBox.setModel(cityModel);
        
        // hide update and delete btn
        updateBtn.setVisible(false);
        deleteBtn.setVisible(false);
        
        if(ApplicationState.isCommunityAdmin()) {
            addBtn.setVisible(false);
            resetBtn.setVisible(false);
        }
    }
    
    private void setCommunitiesTable() {
        HashMap<Integer,Community> communityList= Database.communityList;
        String[] tableColumns = {"Id", "Community Name", "City Name", "Zip Code"};
        String[][] tableContent = new String[communityList.size()][tableColumns.length];

        int key = 0;
        for(Community community: communityList.values()) {
            tableContent[key][0] = String.valueOf(community.getCommunityId());            
            tableContent[key][1] = community.getCommunityName();            
            tableContent[key][2] = Database.cityList.get(community.getCityId()).getCityName();
            tableContent[key][3] = String.valueOf(community.getZipcode());
            key++;
        }
        
        communitiesTable.setModel(new DefaultTableModel(tableContent, tableColumns));
        resetCommunityForm();
    }
    
    private void resetCommunityForm() {
        communityNameTxt.setText("");
        zipcodeTxt.setText("");
        cityComboBox.setSelectedIndex(0);
        // Hide ID column
        communitiesTable.getColumnModel().getColumn(0).setMinWidth(0);
        communitiesTable.getColumnModel().getColumn(0).setMaxWidth(0);
        communitiesTable.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CommunitiesOuterPanel = new javax.swing.JPanel();
        addDoctorPanel = new javax.swing.JPanel();
        communityNameLabel = new javax.swing.JLabel();
        communityNameTxt = new javax.swing.JTextField();
        zipcodeLabel = new javax.swing.JLabel();
        zipcodeTxt = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        buttonPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        scrollTablePanel = new javax.swing.JScrollPane();
        communitiesTable = new javax.swing.JTable();

        CommunitiesOuterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage Community"));
        CommunitiesOuterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addDoctorPanel.setPreferredSize(new java.awt.Dimension(900, 550));
        addDoctorPanel.setLayout(new java.awt.GridLayout(3, 2));

        communityNameLabel.setText("Community Name");
        addDoctorPanel.add(communityNameLabel);
        addDoctorPanel.add(communityNameTxt);

        zipcodeLabel.setText("Zip Code");
        addDoctorPanel.add(zipcodeLabel);
        addDoctorPanel.add(zipcodeTxt);

        cityLabel.setText("City");
        addDoctorPanel.add(cityLabel);

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addDoctorPanel.add(cityComboBox);

        CommunitiesOuterPanel.add(addDoctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 19, 890, 160));

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

        CommunitiesOuterPanel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 60));

        communitiesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        communitiesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                communitiesTableMouseClicked(evt);
            }
        });
        scrollTablePanel.setViewportView(communitiesTable);

        CommunitiesOuterPanel.add(scrollTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 458, 890, 439));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommunitiesOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CommunitiesOuterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String communityName = communityNameTxt.getText();
        String zipcode = zipcodeTxt.getText();
        int cityIndex = cityComboBox.getSelectedIndex();
        try{
            if (!Pattern.matches(Constants.numberReg, zipcode)) {
                throw new CustomException(Constants.INVALID_ZIPCODE);
            }

            if(communityName.isBlank() || zipcode.isBlank() || cityIndex == 0){
                throw new CustomException(Constants.INVALID_COMMUNITY_DETAIL);
            } {
            Database.updateCommunity(
                selectedCommunityId, 
                communityName, 
                cityIndex-1,
                zipcode);
        
            setCommunitiesTable();
            }
        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_ZIPCODE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_ZIPCODE);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_COMMUNITY_DETAIL);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
        String communityName = communityNameTxt.getText();
        String zipcode = zipcodeTxt.getText();
        int cityIndex = cityComboBox.getSelectedIndex();
        try{
            if (!Pattern.matches(Constants.numberReg, zipcode)) {
                throw new CustomException(Constants.INVALID_ZIPCODE);
            }

            if(communityName.isBlank() || zipcode.isBlank() || cityIndex == 0){
                throw new CustomException(Constants.INVALID_COMMUNITY_DETAIL);
            } {
                Database.createCommunity(communityName,cityIndex-1, zipcode);
                setCommunitiesTable();
            }
        } catch (CustomException e) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, "INFO", e);
            if (e.getMessage().endsWith(Constants.INVALID_ZIPCODE)) {
                JOptionPane.showMessageDialog(this, Constants.INVALID_ZIPCODE);
            } else {
                JOptionPane.showMessageDialog(this, Constants.INVALID_COMMUNITY_DETAIL);
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        resetCommunityForm();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int key = 0;
        boolean isUsed = false;
        
        for(Hospital hospital: Database.hospitalList.values()) {
            if(hospital.getCommunityId() == selectedCommunityId) {
                isUsed = true;
            }
            key++;
        }
        
        for(Person person: Database.personList.values()) {
            if(Database.houseList.get(person.getHouseId()).getCommunityId() == selectedCommunityId) {
                isUsed = true;
            }
            key++;
        }
        
        if(!isUsed) {
            Database.deleteCommunity(selectedCommunityId);
            setCommunitiesTable();
        } else {
            JOptionPane.showMessageDialog(this, Constants.CANNOT_DELETE_COMMUNITY);
        }
        
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void communitiesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_communitiesTableMouseClicked
        selectedCommunityId = Integer.parseInt(communitiesTable.getValueAt(communitiesTable.getSelectedRow(), 0 ).toString());
        Community community = Database.communityList.get(selectedCommunityId);
        communityNameTxt.setText(community.getCommunityName());
        zipcodeTxt.setText(community.getZipcode());
        City city = Database.cityList.get(community.getCityId());
        
        cityComboBox.setSelectedItem(city.getCityName());
        
        // Hide and Show Button
        updateBtn.setVisible(true);
        
        if(!ApplicationState.isCommunityAdmin()) {
            deleteBtn.setVisible(true);
        }
        
        
    }//GEN-LAST:event_communitiesTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CommunitiesOuterPanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addDoctorPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTable communitiesTable;
    private javax.swing.JLabel communityNameLabel;
    private javax.swing.JTextField communityNameTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JScrollPane scrollTablePanel;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel zipcodeLabel;
    private javax.swing.JTextField zipcodeTxt;
    // End of variables declaration//GEN-END:variables
}
