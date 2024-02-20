
package recommendation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(234, 248, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 900));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userField.setBackground(new java.awt.Color(255, 255, 255));
        userField.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        userField.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 360, 70));

        passField.setBackground(new java.awt.Color(255, 255, 255));
        passField.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        passField.setForeground(new java.awt.Color(0, 0, 0));
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        jPanel1.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 360, 70));

        jLabel17.setFont(new java.awt.Font("Candara Light", 1, 64)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Login Page");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 320, 90));

        jLabel18.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Password");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 180, -1));

        login.setBackground(new java.awt.Color(0, 0, 0));
        login.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 154, 55));

        jLabel19.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Don't have account? Click here!");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 750, 340, 50));

        jLabel20.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Username");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 190, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String userName = userField.getText().trim();
        String password= passField.getText().trim();
        Login(userName,password);
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    public void Login(String phone, String pass){
    
    if (phone.equals("")) {
        JOptionPane.showMessageDialog(null, "Enter username");
        return;
    }
    
    if (pass.equals("")) {
        JOptionPane.showMessageDialog(null, "Enter password");
        return;
    }
    
    Connection conn = dbConnection.dbconnect();
    try {

        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Users WHERE UserName='" + phone + "' AND pass='" + pass + "'";
        ResultSet resultSet = stmt.executeQuery(query);
        boolean check = resultSet.next();
        if (check) {
            JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
        
            String query2 = "SELECT UserId FROM Users WHERE UserName = ?";
        try (PreparedStatement pstmt2 = conn.prepareStatement(query2)) {
            pstmt2.setString(1, phone);
            ResultSet rs = pstmt2.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("UserId");
                System.out.println("UserId of the inserted user: " + userId);  
                new Dashboard(userId).setVisible(true);
                dispose();
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving UserId: " + e.getMessage());
        }
      
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    

}

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JTextField passField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
