package five;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class five_b_ISP{
    // method to find nodes that is targetted
    public static List<Integer> Targetednode(int[][] edges, int startNode, int targetNode ) { 
        Map<Integer, List<Integer>> graph = new HashMap<>(); //creating a graph to represent relationships between nodes 
        Map<Integer, Integer> incomingedge = new HashMap<>(); //Map to store the number of incoming edges for each node

        // Build the graph and calculate incoming edge of each node
        for (int[] edge : edges) {
            int from = edge[0]; //source node of the edge
            int to = edge[1]; //destination node of edge 
            graph.putIfAbsent(from, new ArrayList<>()); ///adding new node if sourcce node is not htere
            graph.get(from).add(to); //adding desetination node as a neighbor of source code 
            incomingedge.put(to, incomingedge.getOrDefault(to, 0) + 1); //updating the depth oof destination 
        }

        // Perform Depth-First Search starting from the target node
        List<Integer> result = new ArrayList<>();
        dfs(graph, incomingedge, startNode, targetNode, result);

        return result;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, Map<Integer, Integer> incomingedge, int node, int target,
                            List<Integer> result) {
        //if current node has no incoming edge  , then it means we have reached the target node so adding this node to the reslut list
        if (incomingedge.getOrDefault(node, 0) == 1 && graph.get(target).contains(node)) {
            result.add(node);
            // Adding child nodes recursively
            addChildren(graph, node, result);
        }

        // Recursively explore the children of the current node
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                dfs(graph, incomingedge, child, target, result);
            }
        }
    }
    //mthod to add child node recursively
    private static void addChildren(Map<Integer, List<Integer>> graph, int node, List<Integer> result) {
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                result.add(child);
                addChildren(graph, child, result); // Recursively adding children of children
            }
        }
    }
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 6 }, { 2, 4 }, { 4, 6 }, { 4, 5 }, { 5, 7 } };
        int startNode = 4; // Specify the starting node
        int targetNode = 4; // Specify the target node
    
        List<Integer> targetedNodes = Targetednode(edges, startNode, targetNode);
    
        System.out.println("Nodes targeted by node " + targetNode + ":");
        for (int node : targetedNodes) {
            System.out.println(node);
        }
    }
}