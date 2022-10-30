/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sanjevani.view;
import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Database;
import java.awt.CardLayout;

/**
 *
 * @author rajatsharma
 */
public class HomeFrame extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    
    public HomeFrame() {
        initComponents();
        setCardVisibility();
        
        nameLabel.setText("Name - " + ApplicationState.authenticatedPerson.getName());
        roleLabel.setText("Role - " + ApplicationState.authenticatedPerson.getRole());
        
        cardLayout = (CardLayout)(viewPanel.getLayout());
        
    }
    
    private void setCardVisibility(){
        showHospitalsBtn.setVisible(ApplicationState.isHospitasViewVisible());
        showDoctorsBtn.setVisible(ApplicationState.isDoctorsViewVisible());
        showPatientsBtn.setVisible(ApplicationState.isPatientsViewVisible());
        showPeopleBtn.setVisible(ApplicationState.isPeopleViewVisible());
        showCommunitiesBtn.setVisible(ApplicationState.isCommunitiesViewVisible());
        showEncountersBtn.setVisible(ApplicationState.isEncountersViewVisible());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directoryPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        showHospitalsBtn = new javax.swing.JButton();
        showDoctorsBtn = new javax.swing.JButton();
        showPeopleBtn = new javax.swing.JButton();
        showPatientsBtn = new javax.swing.JButton();
        showCommunitiesBtn = new javax.swing.JButton();
        showEncountersBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        directoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Directory"));
        directoryPanel.setLayout(new java.awt.GridLayout(10, 1, 10, 10));
        directoryPanel.add(nameLabel);
        directoryPanel.add(roleLabel);

        showHospitalsBtn.setText("Hospitals");
        showHospitalsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHospitalsBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showHospitalsBtn);

        showDoctorsBtn.setText("Doctors");
        showDoctorsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDoctorsBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showDoctorsBtn);

        showPeopleBtn.setText("People");
        showPeopleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPeopleBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showPeopleBtn);

        showPatientsBtn.setText("Patients");
        showPatientsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPatientsBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showPatientsBtn);

        showCommunitiesBtn.setText("Communities");
        showCommunitiesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCommunitiesBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showCommunitiesBtn);

        showEncountersBtn.setText("Encounters");
        showEncountersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEncountersBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(showEncountersBtn);

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        directoryPanel.add(logoutBtn);

        viewPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(directoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(directoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDoctorsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDoctorsBtnActionPerformed
        cardLayout = (CardLayout)(viewPanel.getLayout());
        viewPanel.add("Doctors", new DoctorsPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showDoctorsBtnActionPerformed

    private void showHospitalsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showHospitalsBtnActionPerformed
        // TODO add your handling code here:
        viewPanel.add("Hospitals", new HospitalsPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showHospitalsBtnActionPerformed

    private void showPeopleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPeopleBtnActionPerformed
        // TODO add your handling code here:
        viewPanel.add("People", new PeoplePanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showPeopleBtnActionPerformed

    private void showPatientsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPatientsBtnActionPerformed
        // TODO add your handling code here:
        viewPanel.add("Patient", new PatientsPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showPatientsBtnActionPerformed

    private void showCommunitiesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCommunitiesBtnActionPerformed
        // TODO add your handling code here:
        viewPanel.add("Communities", new CommunitiesPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showCommunitiesBtnActionPerformed

    private void showEncountersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEncountersBtnActionPerformed
        // TODO add your handling code here:
        viewPanel.add("Encounter", new EncountersPanel());
        cardLayout.next(viewPanel);
    }//GEN-LAST:event_showEncountersBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new LoginFrame().setVisible(true);
        Database.refreshDatabase();
        dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel directoryPanel;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton showCommunitiesBtn;
    private javax.swing.JButton showDoctorsBtn;
    private javax.swing.JButton showEncountersBtn;
    private javax.swing.JButton showHospitalsBtn;
    private javax.swing.JButton showPatientsBtn;
    private javax.swing.JButton showPeopleBtn;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
