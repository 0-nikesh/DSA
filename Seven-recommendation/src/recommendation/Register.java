
package recommendation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {
 private Connection conn;
    private Statement stmt;
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        conn = dbConnection.dbconnect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnsignup = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sportsCheckbox = new javax.swing.JRadioButton();
        flimsCheckbox = new javax.swing.JRadioButton();
        forestCheckbox = new javax.swing.JRadioButton();
        musicCheckbox = new javax.swing.JRadioButton();
        entertainmentCheckbox = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(234, 248, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsignup.setBackground(new java.awt.Color(0, 0, 0));
        btnsignup.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        btnsignup.setForeground(new java.awt.Color(255, 255, 255));
        btnsignup.setText("Sign Up");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, -1, 70));

        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        username.setForeground(new java.awt.Color(0, 0, 0));
        username.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 360, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Register Page");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 300, 70));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Already Registered? Click here!");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 790, -1, -1));

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        password.setForeground(new java.awt.Color(0, 0, 0));
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 360, 60));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 240, 70));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Category");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Candara Light", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        sportsCheckbox.setBackground(new java.awt.Color(234, 248, 249));
        sportsCheckbox.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        sportsCheckbox.setForeground(new java.awt.Color(0, 0, 0));
        sportsCheckbox.setText("Sports");
        sportsCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsCheckboxActionPerformed(evt);
            }
        });
        jPanel1.add(sportsCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 160, 50));

        flimsCheckbox.setBackground(new java.awt.Color(234, 248, 249));
        flimsCheckbox.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        flimsCheckbox.setForeground(new java.awt.Color(0, 0, 0));
        flimsCheckbox.setText("Films");
        jPanel1.add(flimsCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 570, 150, 50));

        forestCheckbox.setBackground(new java.awt.Color(234, 248, 249));
        forestCheckbox.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        forestCheckbox.setForeground(new java.awt.Color(0, 0, 0));
        forestCheckbox.setText("Forest");
        jPanel1.add(forestCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 160, 50));

        musicCheckbox.setBackground(new java.awt.Color(234, 248, 249));
        musicCheckbox.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        musicCheckbox.setForeground(new java.awt.Color(0, 0, 0));
        musicCheckbox.setText("Music");
        jPanel1.add(musicCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 160, 50));

        entertainmentCheckbox.setBackground(new java.awt.Color(234, 248, 249));
        entertainmentCheckbox.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        entertainmentCheckbox.setForeground(new java.awt.Color(0, 0, 0));
        entertainmentCheckbox.setText("Entertainment");
        jPanel1.add(entertainmentCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 190, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 900));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed

        String Username = username.getText().trim();
        String pass = password.getText().trim();
        List<String> selectedCategories = getSelectedCategoriesFromUI();


        registerUser(Username,pass,selectedCategories );

    }//GEN-LAST:event_btnsignupActionPerformed
    private List<String> getSelectedCategoriesFromUI() {
    List<String> selectedCategories = new ArrayList<>();
    
    if (sportsCheckbox.isSelected()) {
        selectedCategories.add("Sports");
    }
    if (entertainmentCheckbox.isSelected()) {
        selectedCategories.add("Entertainment");
    }
    if (musicCheckbox.isSelected()) {
        selectedCategories.add("Music");
    }
    if (forestCheckbox.isSelected()) {
        selectedCategories.add("Forest");
    }
    if (flimsCheckbox.isSelected()) {
        selectedCategories.add("Films");
    }
    
    return selectedCategories;
}
    private void sportsCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sportsCheckboxActionPerformed

    
    private void registerUser(String Username, String Password, List<String> selectedCategories) {
    if (Username.equals("") || Password.equals("")) {
        JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        return;
    }
    
    try {
        Connection conn = dbConnection.dbconnect();
        String query = "SELECT UserName FROM Users WHERE UserName = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, Username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            JOptionPane.showMessageDialog(null, "Username Already Taken. Please choose a different one.");
            return;
        }
        
        // Close the previous statement before creating a new one
        statement.close();

        String insertUserSQL = "INSERT INTO Users (UserName, pass) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, Username);
            pstmt.setString(2, Password);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User inserted successfully");

                // Retrieve the generated UserId
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int userId = generatedKeys.getInt(1);
                    System.out.println("UserId of the inserted user: " + userId);

                    // Store the selected categories for the user
                    String insertCategorySQL = "INSERT INTO UserCategories (UserId, CategoryId) VALUES (?, ?)";
                    try (PreparedStatement pstmtCategories = conn.prepareStatement(insertCategorySQL)) {
                        for (String category : selectedCategories) {
                            // Retrieve the CategoryId for each selected category
                            String categoryIdQuery = "SELECT CategoryId FROM Categories WHERE CategoryName = ?";
                            PreparedStatement pstmtCategoryId = conn.prepareStatement(categoryIdQuery);
                            pstmtCategoryId.setString(1, category);
                            ResultSet rsCategoryId = pstmtCategoryId.executeQuery();
                            if (rsCategoryId.next()) {
                                int categoryId = rsCategoryId.getInt("CategoryId");
                                // Insert the UserId and CategoryId into UserCategories table
                                pstmtCategories.setInt(1, userId);
                                pstmtCategories.setInt(2, categoryId);
                                pstmtCategories.addBatch();
                            }
                        }
                        // Execute batch insert
                        pstmtCategories.executeBatch();
                    }
                }
                
                // Show success message and close the current window
                JOptionPane.showMessageDialog(null, "User successfully registered");
                new Login().setVisible(true);
                dispose();
            } else {
                System.out.println("Data insertion failed");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error connecting to the database or inserting data");
        e.printStackTrace();
    }
}




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsignup;
    private javax.swing.JRadioButton entertainmentCheckbox;
    private javax.swing.JRadioButton flimsCheckbox;
    private javax.swing.JRadioButton forestCheckbox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton musicCheckbox;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton sportsCheckbox;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
