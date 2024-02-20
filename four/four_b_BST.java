pacxage four; 

import java.util.ArrayList;
import java.util.List;

//  representing a node in a binary search tree
class Node {
    int val; // Value of the node
    Node left, right; // Left and right child nodes

    public Node(int val) {
        this.val = val;
        this.left = this.right = null; 
    }
}

//class to find the x closest values to a target in a binary search tree
public class four_b_BST {
    //  to find the x closest values to the target in the binary search tree
    public static List<Integer> closestxValues(Node root, double target, int x) {
        List<Integer> result = new ArrayList<>(); // Create a list to store the x closest values
        inorderTraversal(root, target, x, result); // Perform inorder traversal to find the closest values
        return result; // Return the list of closest values
    }

    // Recursive method to perform inorder traversal and find the closest values to the target
    private static void inorderTraversal(Node root, double target, int x, List<Integer> result) {
        if (root == null) { 
            return;
        }
        
        inorderTraversal(root.left, target, x, result); // Recursively traverse the left subtree

        if (result.size() < x) { // If the result list has fewer than x elements, add the current node's value
            result.add(root.val);
        } else { // If the result list has x elements, compare the current node's value with the first element
            if (Math.abs(target - root.val) < Math.abs(target - result.get(0))) { // If the current node is closer to the target
                result.remove(0); // Remove the first element (farthest from the target)
                result.add(root.val); // Add the current node's value
            } else { // If the current node is farther from the target
                return; // No need to traverse further right
            }
        }

        inorderTraversal(root.right, target, x, result); // Recursively traverse the right subtree
    }

    // Main method to test the closestxValues method
    public static void main(String[] args) {
        // Create a binary search tree
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        double target = 3.8; // Define the target value
        int x = 2; // Define the number of closest values to find

        // Find the x closest values to the target in the binary search tree
        List<Integer> closestValues = closestxValues(root, target, x);

        // Print the x closest values
        System.out.println(closestValues); 
    }
}
