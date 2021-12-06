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

import java.time.LocalDate;
import javax.swing.SpinnerNumberModel;

/**
 * Form for Librarian Menu
 * As required per final project problem statement (GUI choice)
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro, Giuliana Bouzon
 */
public class LibrarianForm extends javax.swing.JFrame {
    
    //properties
    private DBController controller;

    /**
     * Creates new form LibrarianForm
     */
    public LibrarianForm() {
        initComponents();
        changePanel();
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 300, 1);
        quantitySpinner.setModel(model); //allows for values to go up to 300
         try {
            this.controller = new DBController(new View());
        }
        catch (Exception e) {
            displayTextArea.setText("Error: " + e.getMessage());
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

        LibrarianTasksBG = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        issueReturnBookPanel = new javax.swing.JPanel();
        bookSNTF1 = new javax.swing.JTextField();
        bookSNLabel1 = new javax.swing.JLabel();
        enterButton1 = new javax.swing.JButton();
        studentIDTF = new javax.swing.JTextField();
        studentIDLabel = new javax.swing.JLabel();
        addBookPanel = new javax.swing.JPanel();
        bookSNTF = new javax.swing.JTextField();
        bookSNLabel = new javax.swing.JLabel();
        titleTF = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        priceTF = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        authorTF = new javax.swing.JTextField();
        publisherTF = new javax.swing.JTextField();
        publisherLabel = new javax.swing.JLabel();
        enterButton2 = new javax.swing.JButton();
        librarianTaskPanel = new javax.swing.JPanel();
        addBookRB = new javax.swing.JRadioButton();
        issueBookRB = new javax.swing.JRadioButton();
        viewCatalogRB = new javax.swing.JRadioButton();
        returnBookRB = new javax.swing.JRadioButton();
        viewIssuedBooksRB = new javax.swing.JRadioButton();
        displayScrollPanel = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();
        taskLabel = new javax.swing.JLabel();
        backToMainMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setLayout(new java.awt.CardLayout());

        issueReturnBookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bookSNLabel1.setText("Book SN :");

        enterButton1.setText("ENTER");
        enterButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButton1ActionPerformed(evt);
            }
        });

        studentIDLabel.setText("StudentID:");

        addBookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bookSNLabel.setText("Book SN :");

        priceLabel.setText("Price");

        titleLabel.setText("Title :");

        authorLabel.setText("Author");

        quantityLabel.setText("Quantity");

        publisherLabel.setText("Publisher");

        enterButton2.setText("Add");
        enterButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addBookPanelLayout = new javax.swing.GroupLayout(addBookPanel);
        addBookPanel.setLayout(addBookPanelLayout);
        addBookPanelLayout.setHorizontalGroup(
            addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addBookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addBookPanelLayout.createSequentialGroup()
                        .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorLabel)
                            .addComponent(publisherLabel)
                            .addComponent(quantityLabel))
                        .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addBookPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(publisherTF)
                                    .addGroup(addBookPanelLayout.createSequentialGroup()
                                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(addBookPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(authorTF))))
                    .addGroup(addBookPanelLayout.createSequentialGroup()
                        .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabel)
                            .addComponent(bookSNLabel))
                        .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addBookPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(priceTF))
                            .addGroup(addBookPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bookSNTF))))
                    .addGroup(addBookPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(23, 23, 23)
                        .addComponent(titleTF)))
                .addContainerGap())
            .addGroup(addBookPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(enterButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        addBookPanelLayout.setVerticalGroup(
            addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addBookPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSNLabel)
                    .addComponent(bookSNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel)
                    .addComponent(authorTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publisherTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherLabel))
                .addGap(13, 13, 13)
                .addGroup(addBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLabel)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enterButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout issueReturnBookPanelLayout = new javax.swing.GroupLayout(issueReturnBookPanel);
        issueReturnBookPanel.setLayout(issueReturnBookPanelLayout);
        issueReturnBookPanelLayout.setHorizontalGroup(
            issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                .addGroup(issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                                .addComponent(bookSNLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(bookSNTF1))
                            .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                                .addComponent(studentIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studentIDTF))))
                    .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(enterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(addBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        issueReturnBookPanelLayout.setVerticalGroup(
            issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issueReturnBookPanelLayout.createSequentialGroup()
                .addComponent(addBookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSNLabel1)
                    .addComponent(bookSNTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(issueReturnBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDLabel)
                    .addComponent(studentIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(enterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(issueReturnBookPanel, "card2");

        librarianTaskPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LibrarianTasksBG.add(addBookRB);
        addBookRB.setSelected(true);
        addBookRB.setText("Add Book");
        addBookRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookRBActionPerformed(evt);
            }
        });

        LibrarianTasksBG.add(issueBookRB);
        issueBookRB.setText("Issue Book");
        issueBookRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookRBActionPerformed(evt);
            }
        });

        LibrarianTasksBG.add(viewCatalogRB);
        viewCatalogRB.setText("View Catalog");
        viewCatalogRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCatalogRBActionPerformed(evt);
            }
        });

        LibrarianTasksBG.add(returnBookRB);
        returnBookRB.setText("Return a Book");
        returnBookRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookRBActionPerformed(evt);
            }
        });

        LibrarianTasksBG.add(viewIssuedBooksRB);
        viewIssuedBooksRB.setText("View Issued Books");
        viewIssuedBooksRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIssuedBooksRBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout librarianTaskPanelLayout = new javax.swing.GroupLayout(librarianTaskPanel);
        librarianTaskPanel.setLayout(librarianTaskPanelLayout);
        librarianTaskPanelLayout.setHorizontalGroup(
            librarianTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(librarianTaskPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(librarianTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewIssuedBooksRB)
                    .addComponent(addBookRB)
                    .addComponent(issueBookRB)
                    .addComponent(viewCatalogRB)
                    .addComponent(returnBookRB))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        librarianTaskPanelLayout.setVerticalGroup(
            librarianTaskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(librarianTaskPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addBookRB)
                .addGap(18, 18, 18)
                .addComponent(issueBookRB)
                .addGap(18, 18, 18)
                .addComponent(viewCatalogRB)
                .addGap(18, 18, 18)
                .addComponent(returnBookRB)
                .addGap(12, 12, 12)
                .addComponent(viewIssuedBooksRB)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        displayTextArea.setEditable(false);
        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        displayScrollPanel.setViewportView(displayTextArea);

        taskLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        backToMainMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backToMainMenuButton.setText("Back to Main Menu");
        backToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(backToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(librarianTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taskLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(librarianTaskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void addBookRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookRBActionPerformed
        changePanel();
        taskLabel.setText("Add Book");
    }//GEN-LAST:event_addBookRBActionPerformed

    private void issueBookRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBookRBActionPerformed
        changePanel();
        taskLabel.setText("Issue Book");
    }//GEN-LAST:event_issueBookRBActionPerformed

    private void viewCatalogRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCatalogRBActionPerformed
        changePanel();
        taskLabel.setText("View Catalog");
    }//GEN-LAST:event_viewCatalogRBActionPerformed

    private void returnBookRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookRBActionPerformed
        changePanel();
        taskLabel.setText("Return Book");
    }//GEN-LAST:event_returnBookRBActionPerformed

    private void viewIssuedBooksRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIssuedBooksRBActionPerformed
        changePanel();
        taskLabel.setText("View Issued Books");
    }//GEN-LAST:event_viewIssuedBooksRBActionPerformed

    private void backToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuButtonActionPerformed
        MainMenuForm mainMenuForm = new MainMenuForm();
        mainMenuForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMainMenuButtonActionPerformed

    //enter button for everything else
    private void enterButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButton1ActionPerformed
        if (issueBookRB.isSelected()) {
            String SN = bookSNTF1.getText();
            String studentID = studentIDTF.getText();

            try {
                Book book = new Book(SN, new BookData()); //bookdata can be empty because issuebook method only checks book SN
                Student student = new Student(studentID, new StudentData()); //same with studentData
                this.controller.issueBook(book, student);
                displayTextArea.setText("Book successfully issued!"); 
            }
            catch(Exception e){
                displayTextArea.setText("Error: " + e.getMessage()); 
            }
        }
        else if (returnBookRB.isSelected()) {
            String SN = bookSNTF1.getText();
            String studentID = studentIDTF.getText();
            
            try {
                Book book = new Book(SN, new BookData()); //bookdata can be empty because issuebook method only checks book SN
                Student student = new Student(studentID, new StudentData()); //same with studentData
                this.controller.returnBook(book, student);
                displayTextArea.setText("Book successfully returned!"); 
            }
            catch(Exception e){
                displayTextArea.setText("Error: " + e.getMessage()); 
            }
        }
    }//GEN-LAST:event_enterButton1ActionPerformed

    //button to add book
    private void enterButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButton2ActionPerformed
        //initializing variables
        String SN = bookSNTF.getText();
        String title = titleTF.getText();
        String author = authorTF.getText();
        String publisher = publisherTF.getText();
        int bookQuantity = (int)quantitySpinner.getValue();
        double price = Double.parseDouble(priceTF.getText());
        
        try {
            Book book = new Book(SN, new BookData(title, author, publisher, bookQuantity,
                                price, 0, LocalDate.now()));
            this.controller.addBook(book);
            displayTextArea.setText("Book successfully added!"); 
        }
        catch (Exception e) {
            displayTextArea.setText("Error: " + e.getMessage()); 
        }
    }//GEN-LAST:event_enterButton2ActionPerformed

    private void changePanel() {
        // removing panel
        if (addBookRB.isSelected()) {
            mainPanel.setSize(434, 327);
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            // add panel
            mainPanel.add(addBookPanel);
        }

        // removing panel
        if (issueBookRB.isSelected() || returnBookRB.isSelected()) {
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            // add panel 
            mainPanel.add(issueReturnBookPanel);
        }
        
        if (viewIssuedBooksRB.isSelected()) {
            try {
                displayTextArea.setText(this.controller.updateViewIssuedTable());
            }
            catch(Exception e) {
                displayTextArea.setText("Error: " + e.getMessage()); 
            }
        }
        
        if (viewCatalogRB.isSelected()) {
            try {
                displayTextArea.setText(this.controller.updateViewCatalog());
            }
            catch(Exception e) {
                displayTextArea.setText("Error: " + e.getMessage()); 
            }
        }

        mainPanel.repaint();
        mainPanel.revalidate();
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
            java.util.logging.Logger.getLogger(LibrarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup LibrarianTasksBG;
    private javax.swing.JPanel addBookPanel;
    private javax.swing.JRadioButton addBookRB;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTF;
    private javax.swing.JButton backToMainMenuButton;
    private javax.swing.JLabel bookSNLabel;
    private javax.swing.JLabel bookSNLabel1;
    private javax.swing.JTextField bookSNTF;
    private javax.swing.JTextField bookSNTF1;
    private javax.swing.JScrollPane displayScrollPanel;
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JButton enterButton1;
    private javax.swing.JButton enterButton2;
    private javax.swing.JRadioButton issueBookRB;
    private javax.swing.JPanel issueReturnBookPanel;
    private javax.swing.JPanel librarianTaskPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTF;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JTextField publisherTF;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JRadioButton returnBookRB;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField studentIDTF;
    private javax.swing.JLabel taskLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTF;
    private javax.swing.JRadioButton viewCatalogRB;
    private javax.swing.JRadioButton viewIssuedBooksRB;
    // End of variables declaration//GEN-END:variables
}