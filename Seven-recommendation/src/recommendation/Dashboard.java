
package recommendation;

import static java.awt.Color.*;
import static recommendation.UserGraphStructure.*;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Dashboard extends javax.swing.JFrame {
private int userID;
private int categoryID;
private int click;
UserGraphStructure userGraph= new UserGraphStructure();

 private Connection conn;
    private Statement stmt;
    DefaultTableModel model;
    DefaultTableModel model2;
    
    /**
     * Creates new form Dashboard
     */

    public Dashboard(int userID) {
       this.userID=userID;
               conn = dbConnection.dbconnect();

       System.out.println("logged in as "+userID);
        initComponents();
        setRecordsToTable(Tablee);
        welcomeUser(userID);
//        post();
        Tablee.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        Tablee.setGridColor(BLACK);
        Tablee.setForeground(BLACK);
        Tablee.setShowGrid(true);
        Tablee.setGridColor(Color.BLACK);
        Tablee.getTableHeader().setOpaque(false);
        initiateGraph(userGraph);
        setReccomendedFriends(recommendtable);
        
//        profilepanel.hide();

//        hey.hide();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        peoplePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        followUser = new javax.swing.JTextField();
        followButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recommendtable = new javax.swing.JTable();
        welcomePane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        createpist = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tablee = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        likebtn = new javax.swing.JButton();
        viewProfile2 = new javax.swing.JButton();
        Categorycombo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(234, 248, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        peoplePanel.setBackground(new java.awt.Color(234, 248, 249));
        peoplePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("People You may Know");
        peoplePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        followUser.setBackground(new java.awt.Color(234, 248, 249));
        followUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followUserActionPerformed(evt);
            }
        });
        peoplePanel.add(followUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 220, 40));

        followButton.setBackground(new java.awt.Color(0, 0, 0));
        followButton.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        followButton.setForeground(new java.awt.Color(255, 255, 255));
        followButton.setText("Follow");
        followButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followButtonActionPerformed(evt);
            }
        });
        peoplePanel.add(followButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        recommendtable.setBackground(new java.awt.Color(234, 248, 249));
        recommendtable.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        recommendtable.setForeground(new java.awt.Color(0, 0, 0));
        recommendtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reccomended Users"
            }
        ));
        recommendtable.setRowHeight(30);
        jScrollPane1.setViewportView(recommendtable);

        peoplePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 220, 260));

        jPanel1.add(peoplePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 290, 470));

        welcomePane.setBackground(new java.awt.Color(234, 248, 249));
        welcomePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(welcomePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 670, 60));

        createpist.setBackground(new java.awt.Color(255, 255, 255));
        createpist.setColumns(20);
        createpist.setFont(new java.awt.Font("Candara Light", 1, 36)); // NOI18N
        createpist.setRows(5);
        jScrollPane4.setViewportView(createpist);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 820, 140));

        Tablee.setBackground(new java.awt.Color(234, 248, 249));
        Tablee.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        Tablee.setForeground(new java.awt.Color(0, 0, 0));
        Tablee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Post", "Like"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tablee.setRowHeight(40);
        Tablee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tablee);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 700, 370));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2createBtnActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 170, 160, 40));

        likebtn.setBackground(new java.awt.Color(0, 0, 0));
        likebtn.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        likebtn.setForeground(new java.awt.Color(255, 255, 255));
        likebtn.setText("Like");
        likebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likebtncreateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(likebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 630, 160, 40));

        viewProfile2.setBackground(new java.awt.Color(0, 0, 0));
        viewProfile2.setFont(new java.awt.Font("Candara Light", 0, 24)); // NOI18N
        viewProfile2.setForeground(new java.awt.Color(255, 255, 255));
        viewProfile2.setText("View Profile");
        viewProfile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProfile2createBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewProfile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 160, 40));

        Categorycombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sports", "Entertainment", "Music", "Forest", "Films" }));
        jPanel1.add(Categorycombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 160, 50));

        jScrollPane5.setViewportView(jPanel1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 700));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 230, 180));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void followButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followButtonActionPerformed
        // TODO add your handling code here:
        String usernameToFollow = followUser.getText().trim();
    
    // Call the followUser method with the current user's ID and the username to follow
    followUser(userID, usernameToFollow);
    setReccomendedFriends(recommendtable);
    }//GEN-LAST:event_followButtonActionPerformed

    private void jButton2createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2createBtnActionPerformed
        // TODO add your handling code here:
        String content= createpist.getText();
        
        createPost(content, Categorycombo);
        
    }//GEN-LAST:event_jButton2createBtnActionPerformed

    private void TableeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableeMouseClicked
        // TODO add your handling code here:
        int rowNo = Tablee.getSelectedRow();
        TableModel model = Tablee.getModel();
     click = Integer.parseInt(model.getValueAt(rowNo, 0).toString());
    }//GEN-LAST:event_TableeMouseClicked

    private void likebtncreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likebtncreateBtnActionPerformed
        // TODO add your handling code here:
        LikePost(click);
        setRecordsToTable(Tablee);

    }//GEN-LAST:event_likebtncreateBtnActionPerformed

    private void viewProfile2createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProfile2createBtnActionPerformed
        // TODO add your handling code here:
        new profile(userID).setVisible(true);
        this.dispose();
//        profilepanel.show();
        
    }//GEN-LAST:event_viewProfile2createBtnActionPerformed

    private void followUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_followUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_followUserActionPerformed

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
        welcomePane.add(newLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 50));
        welcomePane.revalidate();
        welcomePane.repaint();

        // Close statements
        getNameStmt.close();
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    
    
    private void LikePost(int postId){
    Connection conn = dbConnection.dbconnect();

    try{
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Likes (userID, postID) VALUES (?, ?)");
        pstmt.setInt(1, userID); 
        pstmt.setInt(2, postId);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "You have liked "+postId);
        PreparedStatement pstmt2 = conn.prepareStatement("UPDATE Posts SET like_count = like_count + 1 WHERE post_id = ?");
    pstmt2.setInt(1, postId);
    pstmt2.executeUpdate();
        conn.close();

        setRecordsToTable(Tablee);
        setReccomendedFriends(recommendtable);
    }catch (Exception ex){
        ex.printStackTrace();
    }
}

private void followUser(int followerId, String followeeUsername) {
    Connection conn = dbConnection.dbconnect();
    
    try {
        PreparedStatement getFollowerStmt = conn.prepareStatement("SELECT UserName FROM Users WHERE UserId = ?");
        getFollowerStmt.setInt(1, followerId);
        ResultSet followerResult = getFollowerStmt.executeQuery();
        String followerName = "";
        if (followerResult.next()) {
            followerName = followerResult.getString("UserName");
        }
        getFollowerStmt.close();
        // Retrieve the ID of the followee based on the username
        PreparedStatement getIdStmt = conn.prepareStatement("SELECT UserId FROM Users WHERE UserName = ?");
        getIdStmt.setString(1, followeeUsername);
        ResultSet followeeIdResult = getIdStmt.executeQuery();
        int followeeId = -1; // Initialize to an invalid value
        if (followeeIdResult.next()) {
            followeeId = followeeIdResult.getInt("UserId");
        } else {
            JOptionPane.showMessageDialog(null, "User with username " + followeeUsername + " does not exist.");
            return; // Exit the method if the user does not exist
        }

        // Insert follow relationship into the Edge table
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Edge (follower_id, followee_id) VALUES (?, ?)");
        pstmt.setInt(1, followerId);
        pstmt.setInt(2, followeeId);
        pstmt.executeUpdate();

        // Close statements
        pstmt.close();
        getIdStmt.close();
        conn.close();
        setRecordsToTable(Tablee);
        setReccomendedFriends(recommendtable);

        
        // Show message dialog indicating successful follow
        JOptionPane.showMessageDialog(null, followerName + " now follows " + followeeUsername);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

private void createPost(String content, JComboBox<String> Categorycombo) {
    Connection conn = dbConnection.dbconnect();
    
    try {
        // Get the selected category name from the JComboBox
        String categoryName = (String) Categorycombo.getSelectedItem();
        
        // Query the database to get the category ID based on the selected category name
        int categoryID = -1; // Initialize to an invalid value
        String query = "SELECT CategoryId FROM Categories WHERE CategoryName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, categoryName);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                categoryID = resultSet.getInt("CategoryId");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // Insert the post into the database with the retrieved category ID
        String insertQuery = "INSERT INTO Posts (content, userID, category_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, content); 
            pstmt.setInt(2, userID);
            pstmt.setInt(3, categoryID); // Set the category ID
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Posted Successfully");
//            model.setRowCount(0);
            setRecordsToTable(Tablee);
            setReccomendedFriends(recommendtable);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
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
public void setReccomendedFriends(JTable recommendtable){
    DefaultTableModel tableModel = (DefaultTableModel) recommendtable.getModel();
    tableModel.setRowCount(0);
    List<Integer> reccomendedUsers=userGraph.suggestUsersToFollow(userID);

    for (Integer user : reccomendedUsers) {
        String username = getUsernameByUserId(user);
        System.out.println(username);
        Object[] row = {username};
        model2 = (DefaultTableModel)recommendtable.getModel();

        model2.addRow(row);
    }


    }


public void setRecordsToTable(JTable Tablee) {
    DefaultTableModel model = (DefaultTableModel) Tablee.getModel();
    model.setRowCount(0); // Clear existing table data
    try {
        Connection con = dbConnection.dbconnect();


        PreparedStatement pst = con.prepareStatement("SELECT DISTINCT p.post_id, p.userID, p.content, p.like_count " +
                                                       "FROM Posts p " +
                                                       "INNER JOIN UserCategories uc ON p.category_id = uc.CategoryId " +
                                                       "LEFT JOIN Edge e ON p.userID = e.followee_id " +
                                                       "WHERE uc.UserId = ? OR e.follower_id = ?");
        pst.setInt(1, userID);
        pst.setInt(2, userID);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int postId = rs.getInt("post_id");
            int userId = rs.getInt("userID");
            String content = rs.getString("content");
            int likes = rs.getInt("like_count");

            Object[] obj = {postId, getUsernameByUserId(userId), content, likes};
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Categorycombo;
    private javax.swing.JTable Tablee;
    private javax.swing.JTextArea createpist;
    private javax.swing.JButton followButton;
    private javax.swing.JTextField followUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton likebtn;
    private javax.swing.JPanel peoplePanel;
    private javax.swing.JTable recommendtable;
    private javax.swing.JButton viewProfile2;
    private javax.swing.JPanel welcomePane;
    // End of variables declaration//GEN-END:variables
}
