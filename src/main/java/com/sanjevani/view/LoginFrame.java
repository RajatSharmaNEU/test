/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sanjevani.view;

import com.sanjevani.database.ApplicationState;
import com.sanjevani.database.Database;
import com.sanjevani.model.Person;

/**
 *
 * @author rajatsharma
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        emailIdLabel = new javax.swing.JLabel();
        emailIdTxt = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JTextField();
        signInBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emailIdLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        emailIdLabel.setText("Email ID");

        emailIdTxt.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        passwordLabel.setText("Password");

        passwordTxt.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        signInBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        signInBtn.setText("Sign In");
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailIdLabel)
                            .addComponent(passwordLabel)
                            .addComponent(errorLabel))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailIdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(passwordTxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(signInBtn)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(errorLabel)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailIdLabel)
                    .addComponent(emailIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(signInBtn)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        String enteredEmailId = emailIdTxt.getText();
        String enteredPassword = passwordTxt.getText();
        Person authenticatedPerson = null;
        
        for(Person person: Database.personList.values()) {
            if(person.getEmailId().equalsIgnoreCase(enteredEmailId) && person.getPassword().equalsIgnoreCase(enteredPassword)){
                authenticatedPerson = person;
            }
        }
        
        if (authenticatedPerson == null) {
            errorLabel.setText("User not found!!!");
        } else {
            System.out.println("Login successfully");
            ApplicationState.authenticatedPerson = authenticatedPerson;
            new HomeFrame().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_signInBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailIdLabel;
    private javax.swing.JTextField emailIdTxt;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JButton signInBtn;
    // End of variables declaration//GEN-END:variables
}
