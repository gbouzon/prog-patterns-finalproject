/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro, Giuliana Bouzon.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package limitedlibrarymanagementsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Form for Student Login Menu (prompts user to enter student ID) As required
 * per final project problem statement (GUI choice) Final Project for
 * Programming Patterns course - Fall 2021.
 *
 * @author Chilka Castro, Giuliana Bouzon
 */
public class StudentLoginForm extends javax.swing.JFrame {

    private Connection connection;
    private Student student;
    private MainMenuForm mainMenuForm;

    /**
     * Creates new form StudentForm
     *
     * @throws java.lang.Exception
     */
    public StudentLoginForm(MainMenuForm mainMenuForm) throws Exception {
        initComponents();
        this.mainMenuForm = mainMenuForm;
        this.connection = DBConnection.getSingleInstance();
        studentIDTF.setFocusable(true);
      
        if (MainMenuForm.language.equals("English")) {
            changeToEnglish();
        }
        
        if (MainMenuForm.language.equals("French")) {
            changeToFrench();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentIDLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        studentIDTF = new javax.swing.JTextField();
        enterButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        backToMainMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("loginFrame"); // NOI18N

        studentIDLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        studentIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentIDLabel.setText("StudentID :");

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginLabel.setText("Login");

        studentIDTF.setForeground(new java.awt.Color(153, 153, 153));
        studentIDTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        enterButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        enterButton.setText("ENTER");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        messageLabel.setForeground(new java.awt.Color(153, 153, 153));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backToMainMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backToMainMenuButton.setText("Back To Main Menu");
        backToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backToMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)))
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(backToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        try {
            loginStudent();
        } catch (Exception ex) {
            messageLabel.setText("Error!");
        }
    }//GEN-LAST:event_enterButtonActionPerformed

    private void backToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuButtonActionPerformed
        mainMenuForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMainMenuButtonActionPerformed

    private void changeToEnglish() {
        Locale locale = new Locale("en", "CA");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("source/Source", locale);
        loginLabel.setText(resourceBundle.getString("key20"));
        studentIDLabel.setText(resourceBundle.getString("key21"));
        enterButton.setText(resourceBundle.getString("key22"));
        backToMainMenuButton.setText(resourceBundle.getString("key10"));

  
    }

    private void changeToFrench() {
        Locale locale = new Locale("fr", "CA");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("source/Source", locale);
        loginLabel.setText(resourceBundle.getString("key20"));
        studentIDLabel.setText(resourceBundle.getString("key21"));
        enterButton.setText(resourceBundle.getString("key22"));
        backToMainMenuButton.setText(resourceBundle.getString("key10"));
        

    }
    public void checkStudents(String studentIDInput) throws SQLException {
        String query = "SELECT * FROM STUDENT WHERE studentID=" + "'" + studentIDInput + "';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        String studentID = "";
        String studentName = "";
        String contact = "";
        while (rs.next()) {
            studentID = rs.getString("StudentID");
            studentName = rs.getString("Name");
            contact = rs.getString("Contact");
        }
        StudentData data = new StudentData(studentName, contact);
        try {
            this.student = new Student(studentID, data);
        } catch (Exception ex) {
            messageLabel.setText("Error!");
        }

        if (studentID.equalsIgnoreCase(studentIDInput)) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login successful");
            try {
                StudentMenuForm studentMenuForm = new StudentMenuForm(student, mainMenuForm);
                studentMenuForm.setVisible(true);
            } catch (Exception exception) {
                messageLabel.setText("Error!");
            }

        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("StudentID invalid");
            studentIDTF.setText("");
        }
    }

    public void loginStudent() throws SQLException {
        if (!studentIDTF.getText().isEmpty() && !studentIDTF.getText().isBlank()) {
            String studentIDInput = studentIDTF.getText();
            checkStudents(studentIDInput);
        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("StudentID invalid");
        }
    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StudentLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new StudentLoginForm().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(StudentLoginForm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainMenuButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField studentIDTF;
    // End of variables declaration//GEN-END:variables
}
