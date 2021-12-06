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

import java.sql.Connection;

/**
 * Form for Student Menu 
 * As required per final project problem statement (GUI choice)
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro, Giuliana Bouzon
 */
public class StudentMenuForm extends javax.swing.JFrame {
    
    //properties
    private Student student;
    private DBController controller;
    
       /**
     * Creates new form StudentLoginForm
     */
    
    public StudentMenuForm() {
        initComponents();
        searchTitleTF.setEnabled(Boolean.TRUE);
        searchPublisherTF.setEnabled(Boolean.FALSE);
        searchAuthorTF.setEnabled(Boolean.FALSE);
        try {
            this.student = new Student();
            this.controller = new DBController(this.student, new View());
        }
        catch (Exception e) {
            displayTA.setText("Error: " + e.getMessage());
        }
    }
   
    /**
     * Creates new form StudentLoginForm
     */
    
    public StudentMenuForm(Student student) {
        initComponents();
        searchTitleTF.setEnabled(Boolean.TRUE);
        searchPublisherTF.setEnabled(Boolean.FALSE);
        searchAuthorTF.setEnabled(Boolean.FALSE);
        try {
            this.student = new Student(student);
            this.controller = new DBController(this.student, new View());
        }
        catch (Exception e) {
            displayTA.setText("Error: " + e.getMessage());
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

        searchBG = new javax.swing.ButtonGroup();
        displayScrollPanel = new javax.swing.JScrollPane();
        displayTA = new javax.swing.JTextArea();
        borrowReturnPanel = new javax.swing.JPanel();
        bookSNLabel = new javax.swing.JLabel();
        borrowButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        bookSNTF = new javax.swing.JTextField();
        searchPanel = new javax.swing.JPanel();
        titleRB = new javax.swing.JRadioButton();
        authorNameRB = new javax.swing.JRadioButton();
        publisherRB = new javax.swing.JRadioButton();
        searchTitleTF = new javax.swing.JTextField();
        searchPublisherTF = new javax.swing.JTextField();
        searchAuthorTF = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        viewCatalogButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        studentFormLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayTA.setEditable(false);
        displayTA.setColumns(20);
        displayTA.setRows(5);
        displayScrollPanel.setViewportView(displayTA);

        borrowReturnPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bookSNLabel.setText("BookSN  :");

        borrowButton.setText("Borrow");
        borrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout borrowReturnPanelLayout = new javax.swing.GroupLayout(borrowReturnPanel);
        borrowReturnPanel.setLayout(borrowReturnPanelLayout);
        borrowReturnPanelLayout.setHorizontalGroup(
            borrowReturnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowReturnPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(bookSNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookSNTF, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(borrowReturnPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(borrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        borrowReturnPanelLayout.setVerticalGroup(
            borrowReturnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowReturnPanelLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(borrowReturnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSNTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookSNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(borrowReturnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        searchPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchBG.add(titleRB);
        titleRB.setSelected(true);
        titleRB.setText("Title:");
        titleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleRBActionPerformed(evt);
            }
        });

        searchBG.add(authorNameRB);
        authorNameRB.setText("Author");
        authorNameRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorNameRBActionPerformed(evt);
            }
        });

        searchBG.add(publisherRB);
        publisherRB.setText("Publisher");
        publisherRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherRBActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publisherRB)
                    .addComponent(authorNameRB)
                    .addComponent(titleRB))
                .addGap(39, 39, 39)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTitleTF)
                    .addComponent(searchAuthorTF)
                    .addComponent(searchPublisherTF))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleRB)
                    .addComponent(searchTitleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorNameRB)
                    .addComponent(searchAuthorTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publisherRB)
                    .addComponent(searchPublisherTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewCatalogButton.setText("View Catalog");
        viewCatalogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCatalogButtonActionPerformed(evt);
            }
        });

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        studentFormLabel.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        studentFormLabel.setText("STUDENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewCatalogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentFormLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(borrowReturnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(displayScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(studentFormLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrowReturnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(displayScrollPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewCatalogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (titleRB.isSelected()) {
            searchAuthorTF.setText("");
            searchPublisherTF.setText("");
            try {
                if (searchTitleTF.getText() != null && !searchTitleTF.getText().isEmpty())
                    displayTA.setText(this.controller.updateViewBookList(this.controller.searchBookByTitle(searchTitleTF.getText())));
            }
            catch (Exception e) {
                displayTA.setText("Error: " + e.getMessage());
            } 
        }
        
        if (authorNameRB.isSelected()) {
            searchTitleTF.setText("");
            searchPublisherTF.setText("");
            try {
                if (searchAuthorTF.getText() != null && !searchAuthorTF.getText().isEmpty())
                    displayTA.setText(this.controller.updateViewBookList(this.controller.searchBookByAuthorName(searchAuthorTF.getText())));
            }
            catch (Exception e) { 
                displayTA.setText("Error: " + e.getMessage());
            }
        }
        
        if (publisherRB.isSelected()) { 
            searchAuthorTF.setText("");
            searchPublisherTF.setText("");
            try {
                if (searchPublisherTF.getText() != null && !searchPublisherTF.getText().isEmpty())
                    displayTA.setText(this.controller.updateViewBookList(this.controller.searchBookByPublisher(searchPublisherTF.getText())));
            }
            catch (Exception e) {
                displayTA.setText("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void authorNameRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorNameRBActionPerformed
        changeSearch();
    }//GEN-LAST:event_authorNameRBActionPerformed

    private void titleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleRBActionPerformed
        changeSearch();
    }//GEN-LAST:event_titleRBActionPerformed

    private void publisherRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherRBActionPerformed
        changeSearch();
    }//GEN-LAST:event_publisherRBActionPerformed

    private void viewCatalogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCatalogButtonActionPerformed
        try {
            displayTA.setText(this.controller.updateViewCatalog());
        }
        catch(Exception e) {
           displayTA.setText("Error: " + e.getMessage()); 
        }
    }//GEN-LAST:event_viewCatalogButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        MainMenuForm mainMenuForm = new MainMenuForm();
        mainMenuForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void borrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButtonActionPerformed
        String SN = bookSNTF.getText();
        try {
            Book book = new Book(SN, new BookData()); //bookdata can be empty because borrow method only checks book SN
            this.student.borrow(book);
            displayTA.setText("Book successfully borrowed!"); 
        }
        catch(Exception e){
            displayTA.setText("Error: " + e.getMessage()); 
        }
    }//GEN-LAST:event_borrowButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        String SN = bookSNTF.getText();
        try {
            Book book = new Book(SN, new BookData()); //bookdata can be empty because borrow method only checks book SN
            this.student.toReturn(book);
            displayTA.setText("Book successfully returned!"); 
        }
        catch(Exception e){
            displayTA.setText("Error: " + e.getMessage()); 
        }
    }//GEN-LAST:event_returnButtonActionPerformed

    public void changeSearch() {
         if (titleRB.isSelected()) {
           searchAuthorTF.setText("");
           searchPublisherTF.setText("");
           searchTitleTF.setEnabled(Boolean.TRUE);
           searchPublisherTF.setEnabled(Boolean.FALSE);
           searchAuthorTF.setEnabled(Boolean.FALSE);
        }
        
        if (publisherRB.isSelected()) {
           searchAuthorTF.setText("");
           searchTitleTF.setText("");
           searchTitleTF.setEnabled(Boolean.FALSE);
           searchPublisherTF.setEnabled(Boolean.TRUE);
           searchAuthorTF.setEnabled(Boolean.FALSE);
        }
        
        if (authorNameRB.isSelected()) {
           searchPublisherTF.setText("");
           searchTitleTF.setText("");
           searchTitleTF.setEnabled(Boolean.FALSE);
           searchPublisherTF.setEnabled(Boolean.FALSE);
           searchAuthorTF.setEnabled(Boolean.TRUE);   
        }   
    }
    
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
            java.util.logging.Logger.getLogger(StudentMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentMenuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton authorNameRB;
    private javax.swing.JLabel bookSNLabel;
    private javax.swing.JTextField bookSNTF;
    private javax.swing.JButton borrowButton;
    private javax.swing.JPanel borrowReturnPanel;
    private javax.swing.JScrollPane displayScrollPanel;
    private javax.swing.JTextArea displayTA;
    private javax.swing.JButton logOutButton;
    private javax.swing.JRadioButton publisherRB;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField searchAuthorTF;
    private javax.swing.ButtonGroup searchBG;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchPublisherTF;
    private javax.swing.JTextField searchTitleTF;
    private javax.swing.JLabel studentFormLabel;
    private javax.swing.JRadioButton titleRB;
    private javax.swing.JButton viewCatalogButton;
    // End of variables declaration//GEN-END:variables
}
