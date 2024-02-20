package two;
public class two_a_sewingmachine {

    public static int minMovesToEqualizeDresses(int[] sewingMachines) {
        int totalDresses = 0; //variable to store the total dress
        int numMachines = sewingMachines.length; //get bumber of sewing machine

        // Calculate the total number of dresses
        for (int i : sewingMachines) {
            totalDresses = totalDresses+ i;
        }

        // Check if the total dresses can be evenly distributed among the machines
        if (totalDresses % numMachines != 0) {
            return -1; // Cannot equalize if the total dresses cannot be evenly distributed
        }

        int averageDressesPerMachine = totalDresses / numMachines;
        int moves = 0;
        int cumulativeSum = 0;

        for (int dresses : sewingMachines) {
            cumulativeSum = cumulativeSum + (dresses - averageDressesPerMachine); //
            moves = Math.max(moves, Math.abs(cumulativeSum));//abs does the work of magnitude and make it positive 
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] sewingMachines = { 1,0,5}; //
        System.out.println(minMovesToEqualizeDresses(sewingMachines)); 
    }
}