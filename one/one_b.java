package one;
public class one_b {
    // method to calculate the minimum build time for engines
    public static int minBuildTime(int[] engines, int splitCost) {
        //get the number of engine
        int n = engines.length;
        int[][] dp = new int[n + 1][n + 1];//creating 2d array, dp[i][j] represents the minimum build time for i engines using j engineers

        for (int i = 1; i <= n; i++) { //calculates the base case for 1 engineer
            dp[i][1] = engines[i - 1] + (i - 1) * splitCost;// minimum build time for each engine with 1 engineer is the time to build the engine plus (i-1) * split cost
        }
        //to calculate minimum build time for each number of engineers
        for (int i = 2; i <= n; i++) {
            for (int m = 2; m <= i; m++) {
                // minimum build time without split
                dp[i][m] = Math.max(engines[i - 1], dp[i - 1][m - 1]);
                // minimum build time with split 
                dp[i][m] = Math.min(dp[i][m], (engines[i - 1] + engines[i - 2]) / 2 + splitCost + dp[i - 2][m - 2]);
            }
        }

        return dp[n][n]; // returns minimum build time for all engines using all engineers
    }

    public static void main(String[] args) {
        int[] engines = {3, 4, 5, 2};
        int splitCost = 2;
        int minTime = minBuildTime(engines, splitCost);
        System.out.println("Minimum build time: " + minTime);
    }
}
