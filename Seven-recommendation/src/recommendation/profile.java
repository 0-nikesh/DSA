
package recommendation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saroj
 */
public class profile extends javax.swing.JFrame {
private int userID; 
private Connection conn;
    private Statement stmt;
    DefaultTableModel model;

    /**
     * Creates new form profile
     */
    public profile(int userID) {
        this.userID=userID;
        conn = dbConnection.dbconnect();
        initComponents();
        welcomeUser(userID);
        showFollowingList(followingtable);
        showFollowersList(followerstable);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilepanel = new javax.swing.JPanel();
        profilewelcomePane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        followerstable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        followingtable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        viewProfile2 = new javax.swing.JButton();
        Logoutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilepanel.setBackground(new java.awt.Color(234, 248, 249));
        profilepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilewelcomePane.setBackground(new java.awt.Color(234, 248, 249));
        profilewelcomePane.setForeground(new java.awt.Color(0, 0, 0));
        profilepanel.add(profilewelcomePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 570, 50));

        followerstable.setBackground(new java.awt.Color(234, 248, 249));
        followerstable.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        followerstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Followers"
            }
        ));
        followerstable.setRowHeight(30);
        jScrollPane1.setViewportView(followerstable);

        profilepanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 320, 350));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Followers");
        profilepanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 100, -1));

        followingtable.setBackground(new java.awt.Color(234, 248, 249));
        followingtable.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        followingtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Following"
            }
        ));
        followingtable.setRowHeight(30);
        jScrollPane3.setViewportView(followingtable);

        profilepanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 320, 340));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("People you Follow");
        profilepanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 190, -1));

        viewProfile2.setBackground(new java.awt.Color(0, 0, 0));
        viewProfile2.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        viewProfile2.setForeground(new java.awt.Color(255, 255, 255));
        viewProfile2.setText("Go to Dashboard");
        viewProfile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfile2createBtnActionPerformed(evt);
            }
        });
        profilepanel.add(viewProfile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 220, 40));

        Logoutbtn.setBackground(new java.awt.Color(0, 0, 0));
        Logoutbtn.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        Logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        Logoutbtn.setText("Logout");
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });
        profilepanel.add(Logoutbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 640, -1, -1));

        getContentPane().add(profilepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewProfile2createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfile2createBtnActionPerformed
        // TODO add your handling code here:
        new Dashboard(userID).setVisible(true);
        this.dispose();
        //        profilepanel.show();

    }//GEN-LAST:event_viewProfile2createBtnActionPerformed

    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
        // TODO add your handling code here:
       
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutbtnActionPerformed

  
    
    private void welcomeUser(int userId) {
    Connection conn = dbConnection.dbconnect();
    
    try {
        // Retrieve the username from the database
        PreparedStatement getNameStmt = conn.prepareStatement("SELECT UserName FROM Users WHERE UserId = ?");
        getNameStmt.setInt(1, userId);
        ResultSet userNameResult = getNameStmt.executeQuery();
        String userName = "";
        if (userNameResult.next()) {
            userName = userNameResult.getString("UserName");
        }

        // Create a new JLabel with the username
        JLabel newLabel = new JLabel("Hello " + userName + "!");
        newLabel.setFont(new Font("Candara Light", Font.BOLD, 28));
        newLabel.setForeground(new java.awt.Color(0, 0, 0));
        profilewelcomePane.add(newLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 50));
        profilewelcomePane.revalidate();
        profilewelcomePane.repaint();

        // Close statements
        getNameStmt.close();
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    public String getUsernameByUserId(int userId) {
    String followed_users = null;
    Connection conn = dbConnection.dbconnect();
    
    try {
        // Prepare SQL query
        String query = "SELECT UserName FROM users WHERE UserId = ?";
        
        // Execute query
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userId);
        ResultSet rs = pstmt.executeQuery();
        
        // Process the result set
        if (rs.next()) {
            followed_users = rs.getString("username");
        }
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    
    return followed_users;
}
    
    public void showFollowingList(JTable followingTable) {
    DefaultTableModel model = (DefaultTableModel) followingTable.getModel();
    model.setRowCount(0); // Clear existing table data
    try {
        Connection con = dbConnection.dbconnect();

        // Retrieve the list of users that the current user is following
        PreparedStatement pst = con.prepareStatement("SELECT u.UserName " +
                                                       "FROM Users u " +
                                                       "INNER JOIN Edge e ON u.UserId = e.followee_id " +
                                                       "WHERE e.follower_id = ?");
        pst.setInt(1, userID);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String userName = rs.getString("UserName");

            Object[] obj = {userName};
            model.addRow(obj);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void showFollowersList(JTable followerstable) {
    DefaultTableModel model = (DefaultTableModel) followerstable.getModel();
    model.setRowCount(0); // Clear existing table data
    try {
        Connection con = dbConnection.dbconnect();

        // Retrieve the list of users that follow the current user
        PreparedStatement pst = con.prepareStatement("SELECT u.UserName " +
                                                       "FROM Users u " +
                                                       "INNER JOIN Edge e ON u.UserId = e.follower_id " +
                                                       "WHERE e.followee_id = ?");
        pst.setInt(1, userID);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String userName = rs.getString("UserName");

            Object[] obj = {userName};
            model.addRow(obj);
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
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profile(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JTable followerstable;
    private javax.swing.JTable followingtable;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel profilepanel;
    private javax.swing.JPanel profilewelcomePane;
    private javax.swing.JButton viewProfile2;
    // End of variables declaration//GEN-END:variables
}
