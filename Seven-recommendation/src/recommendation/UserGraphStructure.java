/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recommendation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserGraphStructure {
    private Map<Integer, List<Integer>> adjacencyList; // Maping user ID to their connections

    public UserGraphStructure() {
        adjacencyList = new HashMap<>(); 
    }

    public void addUser(int userId) {
        // Add a new user to the graph
        adjacencyList.put(userId, new ArrayList<>());
        System.out.println("User Added Successfully. Id: "+userId );
    }

    public void addConnection(int user1, int user2) {
        // Add an edge (connection) between user1 and user2
        adjacencyList.get(user1).add(user2);
        System.out.println(user1+"Follows"+user2);
//        adjacencyList.get(user2).add(user1); // For an undirected graph
    }
    
    public boolean isConnected(int user1, int user2) {
    List<Integer> connectionsOfUser1 = adjacencyList.get(user1);
    if (connectionsOfUser1 != null) {
        return connectionsOfUser1.contains(user2);
    } else {
        return false; // user1 doesn't exist in the graph
    }
}

    public List<Integer> getConnections(int userId) {
        return adjacencyList.getOrDefault(userId, new ArrayList<>());
    }
    public List<Integer> followingListOf(int userId) {
        return adjacencyList.getOrDefault(userId, new ArrayList<>());
    }
    // Get connections for a given user (users who follow the specified user)
    public List<Integer> getFollowers(int userId) {
        List<Integer> followers = new ArrayList<>();
        for (List<Integer> connections : adjacencyList.values()){
            if (connections.contains(userId)) {
                for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
                    if (entry.getValue().equals(connections)) {
                        followers.add(entry.getKey());
                        break;
                    }
                }
            }
        }
        return followers;
    }

    public List<Integer> suggestUsersToFollow(int userId) {
        List<Integer> mutualFollowers = new ArrayList<>();

        // Get the users followed by the given user
        List<Integer> following = followingListOf(userId);
        System.out.println(following);

        // Iterate through the users followed by the given user
        for (int followedUser : following) {
            // Get the followers of the followed user
            List<Integer> followersOfFollowedUser = getFollowers(followedUser);
            System.out.println("followers of the follwed user , i.e 1 are:"+followersOfFollowedUser);

            // Check if the followers of the followed user also follow the original user (userId)
            for (int follower : followersOfFollowedUser) {
                if (follower != userId && !following.contains(follower) && !mutualFollowers.contains(follower)) {
                    mutualFollowers.add(follower);
                }
            }
        }
        return mutualFollowers;
    }
    
    public static void initiateGraph( UserGraphStructure socialGraph){
//            UserGraphStructure socialGraph = new UserGraphStructure();
        // Add users
       // Fetching users from the Databas
        Connection conn = dbConnection.dbconnect();


        try {
            // Prepare SQL query
            String query = "SELECT UserID FROM Users";

            // Execute query
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                socialGraph.addUser(rs.getInt("UserID"));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Retrieving the Connection from Database and 
        Connection conn2= dbConnection.dbconnect();
        try {
            // Prepare SQL query
            String query = "SELECT follower_id, followee_id FROM Edge";

            // Execute query
            PreparedStatement pstmt = conn2.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                int followerId = rs.getInt("follower_id");
                int followeeId = rs.getInt("followee_id");
                socialGraph.addConnection(followerId, followeeId);

            }
            conn2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
} }
 
    public static void main(String[] args) {
        
    }
}