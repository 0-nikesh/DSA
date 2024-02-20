package three;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight; // source, destination, weight of the edge

    public Edge(int src, int dest, int weight) { //constructor
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) { //comparing edge on basis of weigth
        return Integer.compare(this.weight, other.weight);
    }
}

// Class for disjoint-set data structure
class DisjointSet {
    private int[] parent, depth; //array to track parent node annd depth of the set

    public DisjointSet(int size) {
        parent = new int[size];
        depth = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; //each node is innitially its own parent 
            depth[i] = 0;  //initially depth to 0
        }
    }

    //to determine set of vertex
    public int find(int x) {
        if (parent[x] != x) //checking if it not its own parent 
            parent[x] = find(parent[x]); //compressing to find the root
        return parent[x];
    }


    //to merge to set
    public void union(int x, int y) {
        int rootX = find(x); //finding root of 1st set
        int rootY = find(y); //root of 2nd set
        if (rootX != rootY) {  //if they are in different sets
            if (depth[rootX] < depth[rootY]) {
                parent[rootX] = rootY; //making rootY parent since its grater
            } else if (depth[rootX] > depth[rootY]) {
                parent[rootY] = rootX; //making rootx parent
            } else {
                parent[rootY] = rootX; //making rootX the parent of rootY
                depth[rootX]++; //increasing depth of rootx
            }
        }
    }
}

// Class for Kruskal's algorithm
public class three_b_krushkal {
    //to find MST using  Kruskal's Algorithm
    public List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        // Initialize disjoint-set
        DisjointSet ds = new DisjointSet(vertices);

        // Sort edges based on weight using priority queue (min heap)
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);

        // Initialize result
        List<Edge> result = new ArrayList<>();
        
        // iterate thorugh the edges until the MST is formed
        while (!pq.isEmpty() && result.size() < vertices - 1) {
            Edge edge = pq.poll(); //getting the edge with the minimum weight 
            int srcParent = ds.find(edge.src); //finding the set of the source 
            int destParent = ds.find(edge.dest); // finding the set of destination 

            // Add edge to result if including it doesn't form a cycle
            if (srcParent != destParent) {
                result.add(edge);
                ds.union(srcParent, destParent); //merging the set of source and destination
            }
        }

        return result; //returning MST
    }

    // Example usage
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        three_b_krushkal kruskalMST = new three_b_krushkal();
        List<Edge> mst = kruskalMST.kruskalMST(edges, 4);

        
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}