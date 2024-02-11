package two;
public class two_a_sewingmachine {
    

    public static int minMove(int[] machines) {
        int totLuga = 0;
        int noOfMachine = machines.length; //machine ko length calculate garna

        // luga ko no. calculate garna 
        for (int luga : machines) {
            totLuga += luga;
        }

        // equally distribute hunxa ki nai check garna 
        if (totLuga % noOfMachine != 0) {
            return -1; //hunna bhane -1
        }

        // auta machine ma kati ota luga atxa check garna 
        int lugaPerMachine = totLuga / noOfMachine;

        
        int moves = 0; //inital ma 0 paxi badhxa
        for (int i = 0; i < noOfMachine - 1; i++) {
            int diff = lugaPerMachine - machines[i];
            if (diff > 0) {
                int shift = Math.min(diff, machines[i + 1]);//no. of luga update garne after shift 
                machines[i] += shift;
                machines[i + 1] -= shift;
                //total num of move update garney 
                moves += shift;
            }
        }

        return moves;
    }
    public static void main(String[] args) {
        int[] input = { 1, 0, 5 };
        System.out.println(minMove(input) + " is the kam number of move to shift luga");
    }
}

