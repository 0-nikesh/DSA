// Import necessary libraries
package five;

import java.util.Arrays;
import java.util.Random;

// Define the AntColony class
class AntColony {
    // Declare variables
    private int[][] distanceMatrix; // 2D array to store distances between cities
    private int numAnts; // Number of ants
    private double[][] pheromoneMatrix; // 2D array to store pheromone levels between cities
    private double[][] probabilities; // 2D array to store probabilities of selecting each city
    private int numCities;  // Number of cities 
    private int[] bestTour; // Array to store best tour
    private int bestTourLength; // Length of best tour
    private double evaporationRate; // Evaporation rate of pheromones 
    private double alpha; // Alpha parameter
    private double beta; // Beta parameter

    // Constructor to initialize AntColony object
    public AntColony(int[][] distanceMatrix, int numAnts, double evaporationRate, double alpha, double beta) {
        this.distanceMatrix = distanceMatrix;
        this.numAnts = numAnts;
        this.evaporationRate = evaporationRate;
        this.alpha = alpha;
        this.beta = beta;
        this.numCities = distanceMatrix.length;
        this.pheromoneMatrix = new double[numCities][numCities];
        this.probabilities = new double[numCities][numCities];
        initializePheromones(); // Call method to initialize pheromones
    }

    // Method to initialize pheromone levels
    private void initializePheromones() {
        double initialPheromone = 1.0 / numCities; // Calculate initial pheromone level
        // Iterate over each city
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (i != j) { // Check if cities are not the same
                    pheromoneMatrix[i][j] = initialPheromone; // Assign initial pheromone level
                }
            }
        }
    }

    // Method to solve TSP using ACO algorithm
    public void solve(int maxIterations) { 
        bestTourLength = Integer.MAX_VALUE; // Initially assign max value to best tour length
        bestTour = new int[numCities]; // Initialize the best tour length
        Random random = new Random(); // Create random generator

        // Iterate over the maximum number of iterations
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            // Loop over each ant
            for (int ant = 0; ant < numAnts; ant++) {
                boolean[] visited = new boolean[numCities]; // Declare visited cities by each ant
                int[] tour = new int[numCities];  // Initialize the tour
                int currentCity = random.nextInt(numCities); // Select a random starting city
                tour[0] = currentCity;
                visited[currentCity] = true;

                // Traverse the remaining cities
                for (int i = 1; i < numCities; i++) {
                    calculateProbabilities(currentCity, visited); // Calculate probabilities
                    int nextCity = selectNextCity(currentCity); // Select next city based on probabilities
                    tour[i] = nextCity;
                    visited[nextCity] = true;
                    currentCity = nextCity;
                }

                int tourLength = calculateTourLength(tour); // Calculate tour length
                // Update best tour if a shorter tour is found
                if (tourLength < bestTourLength) {
                    bestTourLength = tourLength;
                    bestTour = tour;
                }
            }

            updatePheromones(); // Update pheromones
        }
    }

    // Method to calculate probabilities of selecting each city
    private void calculateProbabilities(int city, boolean[] visited) {
        double total = 0.0;
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) {
                // Calculate probability based on pheromone levels and distances
                probabilities[city][i] = Math.pow(pheromoneMatrix[city][i], alpha) *
                        Math.pow(1.0 / distanceMatrix[city][i], beta);
                total += probabilities[city][i];
            } else {
                probabilities[city][i] = 0.0;
            }
        }

        // Normalize probabilities
        for (int i = 0; i < numCities; i++) {
            probabilities[city][i] /= total;
        }
    }

    // Method to select the next city based on probabilities
    private int selectNextCity(int city) {
        double[] probabilities = this.probabilities[city];
        double r = Math.random();
        double cumulativeProbability = 0.0;
        // Select a city based on cumulative probabilities
        for (int i = 0; i < numCities; i++) {
            cumulativeProbability += probabilities[i];
            if (r <= cumulativeProbability) {
                return i;
            }
        }
        return -1;
    }

    // Method to update pheromone levels
    private void updatePheromones() {
        // Evaporation
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                pheromoneMatrix[i][j] *= (1.0 - evaporationRate);
            }
        }
        // Add new pheromones
        for (int ant = 0; ant < numAnts; ant++) {
            for (int i = 0; i < numCities - 1; i++) {
                int city1 = bestTour[i];
                int city2 = bestTour[i + 1];
                pheromoneMatrix[city1][city2] += (1.0 / bestTourLength);
                pheromoneMatrix[city2][city1] += (1.0 / bestTourLength);
            }
        }
    }

    // Method to calculate the length of a tour
    private int calculateTourLength(int[] tour) {
        int length = 0;
        for (int i = 0; i < tour.length - 1; i++) {
            length += distanceMatrix[tour[i]][tour[i + 1]];
        }
        length += distanceMatrix[tour[tour.length - 1]][tour[0]]; // Return to the starting city
        return length;
    }

    // Getter method for the best tour length
    public int getBestTourLength() {
        return bestTourLength;
    }

    // Getter method for the best tour
    public int[] getBestTour() {
        return bestTour;
    }
}

// Main class to test the AntColony class
public class five_a_antcolony {
    public static void main(String[] args) {
        // Define distance matrix, number of ants, evaporation rate, alpha, and beta
        int[][] distanceMatrix = {
                {0, 12, 25, 30},
                {12, 0, 40, 20},
                {25, 40, 0, 35},
                {30, 20, 35, 0}
        };
        int numAnts = 8;
        double evaporationRate = 0.3;
        double alpha = 1.5;
        double beta = 2.5;

        // Create AntColony object and solve TSP
        AntColony colony = new AntColony(distanceMatrix, numAnts, evaporationRate, alpha, beta);
        colony.solve(500); // Solve TSP with 500 iterations

        // Retrieve and print the best tour and its length
        int[] bestTour = colony.getBestTour();
        int bestTourLength = colony.getBestTourLength();

        System.out.println("Best tour: " + Arrays.toString(bestTour));
        System.out.println("Best tour length: " + bestTourLength);
    }
}
