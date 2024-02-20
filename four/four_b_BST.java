package four;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class node { //representing binary tree node
    int val;
    node left, right; //child nodes

    public node(int val) { 
        this.val = val;
        this.left = this.right = null; 
    }
}

public class four_b_BST {
    //finding closest value to  target in BInary search tree
    public static List<Integer> closestKValues(node root, double target, int x) { //
        List<Integer> result = new ArrayList<>(); //creating a arrayist to store closest values
        Stack<Integer> front = new Stack<>(); //stacks to store elements during in-order traversal 
        Stack<Integer> back = new Stack<>();  //to store elements during reverse in-order traveersal 

        // initializing both stacks during inorder traversal 
        inorderTraversal(root, target, false, front); // traversing binary tree in in order manner
        inorderTraversal(root, target, true, back); //transvering binary tree in a reverse inorder manner

        // Merging the stacks to find the x closest values
        while (x-- > 0) {
            if (front.isEmpty()) { //checking empty or not
                result.add(back.pop()); //adding the top element of back  stack into result list
            } else if (back.isEmpty()) {
                result.add(front.pop());//adding tope element of front
            } else if (Math.abs(front.peek() - target) < Math.abs(back.peek() - target)) { //comparing difference bwtween the top and back with target
                result.add(front.pop()); //adding top of element of front if difference is smaller 
            } else {
                result.add(back.pop()); //adding top of element of back if  difference is smaller or equal
            }
        }

        return result;
    }

    //method for inordertraversal 
    private static void inorderTraversal(node root, double target, boolean reverse, Stack<Integer> stack) { //
        if (root == null) {
            return; //
        }

        Stack<node> nodeStack = new Stack<>(); //to store during traversal 
        node current = root; //initializing current with the root node

        while (current != null || !nodeStack.isEmpty()) {
            //Traversing left subtree and pushing nodes into the stack
            while (current != null) {
                nodeStack.push(current);//pushing current node into the node 
                current = (reverse) ? current.right : current.left; //updating the current node to its right or left child based on the traversal direction
            }
            //deleting the node from the stack
            current = nodeStack.pop(); 

            if (!reverse && current.val > target) { //checking if the traversal direction is forward and current node value is greater than the target value
                break;
            }
            if (reverse && current.val <= target) { //checking if the traversal direction is reverse and the current node's value is less than or equal to the target value
                break;
            }

            stack.push(current.val);

            current = (reverse) ? current.left : current.right; //updating the current node to its left or right child based on the traversal direction
        }
    }

    public static void main(String[] args) {
        // Example usage
        node root = new node(4);
        root.left = new node(2);
        root.right = new node(5);
        root.left.left = new node(1);
        root.left.right = new node(3);

        double target = 3.8;
        int x = 2;
        
        List<Integer> closestValues = closestKValues(root, target, x); //calls the closest value method to find the x closest values to the target in the binary search tree 
        System.out.println(closestValues); 
    }
}