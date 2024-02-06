package three;
import java.util.ArrayList;
import java.util.List;

//representing edge in graph 
class Edge {
    int source;
    int destination;
    int weight;
    
    //contructor with source destionation and weight
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
//class representing graph and Krushkal algorithm
class Graph {
    int vertices; //number of vertices in the graph 
    List<Edge> edges; // list to store the edges of graph 

    //constructor to initialize the graph with given number vertices
    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    //method to add edge to graph
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight); // create new edge
        edges.add(edge); //add the edge to the list of edge
    }

    //method to find the minimum spanning tree using krushkal algorithm
    public void kruskalMST() {
        mergeSort(edges, 0, edges.size() - 1); // Sort edges based on their weights manually

        int[] parent = new int[vertices]; // array to stroe parent of each vertices
        for (int i = 0; i < vertices; i++) {
            parent[i] = i; // Initialize each vertex as its own parent
        }

        List<Edge> result = new ArrayList<>(); // list to store the edges of the minimum spanning tree
        int totalWeight = 0; // Variable to store the total weight of the minimum spanning tree
        for (Edge edge : edges) { //iterate through each edge in sorted order
            int sourceParent = find(parent, edge.source); //find the parent of source vertex
            int destinationParent = find(parent, edge.destination);  //find the parent of destination vertex
            if (sourceParent != destinationParent) { // Check if including this edge forms a cycle
                result.add(edge); //add edge to minimum spanning tree
                totalWeight += edge.weight; // Add the weight of the current edge to the total weight
                union(parent, sourceParent, destinationParent); //union the two set
            }
        }

        // Print the minimum spanning tree
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
        // Print the total weight of the minimum spanning tree
        System.out.println("Total Weight of Minimum Spanning Tree: " + totalWeight);
    }
    //method to perform merge sort on  a list of edges based on their weight
    private void mergeSort(List<Edge> edges, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(edges, left, mid); //recursively sorts the left half
            mergeSort(edges, mid + 1, right); // recursively sorts the right half 
            merge(edges, left, mid, right); // merge the two sorted half
        }
    }

    //method to merge two sorted subarrays of edges
    private void merge(List<Edge> edges, int left, int mid, int right) {
        //calculate the sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //creating temporary  array to store the left and right subarrays
        Edge[] leftArray = new Edge[n1];
        Edge[] rightArray = new Edge[n2];

        //copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = edges.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = edges.get(mid + 1 + j);
        }

        //merge the temporary arrays back into the orignal array 
        int i = 0, j = 0; //initial indices of left and right subarrays
        int k = left; //initial index of merged subarray
        while (i < n1 && j < n2) {
            if (leftArray[i].weight <= rightArray[j].weight) {
                edges.set(k, leftArray[i]); // copy elemnet from leftsubarray 
                i++; // increment index of left subarray 
            } else {
                edges.set(k, rightArray[j]); // copy element form right subarray to merged subarray 
                j++; // increment index of right subarray 
            }
            k++; //increment index of merged subarray 
        }

        // copy remaining elements of left array[]
        while (i < n1) {
            edges.set(k, leftArray[i]);
            i++;
            k++;
        }

        //copy remainng element of right array[]
        while (j < n2) {
            edges.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    //method to find the parent of a vertex in the union find data structure 
    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    // method to perform unioon operation in the union -find data structure
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
}

public class b {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices); // creating graph with 6 vertices 
        graph.addEdge(0, 1, 4); 
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 0, 4);
        graph.addEdge(2, 0, 4);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 2, 4);
        graph.addEdge(4, 3, 3);
        graph.addEdge(5, 2, 2);
        graph.addEdge(5, 4, 3);

        graph.kruskalMST();
    }
}
