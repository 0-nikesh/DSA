package two;

import java.util.ArrayList;
import java.util.List;

public class two_b {
    

    public static List<Integer> peopleKnowingSecret(int n, int[][] intervals, int firstOne) { //method  to find the list of people knowing the secret 
        boolean[] knowingSecret = new boolean[n]; //boolean array "knowingSecret" declare garxa with size n
        knowingSecret[firstOne] = true; // first person lai true banako 

        for (int[] interval : intervals) { // iterates over each array "interval" in the "intervals" array.
            for (int i = interval[0]; i <= interval[1]; i++) { // Iterates over the range specified by the two integers in the current "interval".
                if (knowingSecret[i]) { //index "i" "knowsSecret" ma true xaki nai check garxa
                   
                    for (int j = interval[0]; j <= interval[1]; j++) {
                        knowingSecret[j] = true;
                    }
                    break;
                }
            }
        }

        List<Integer> answer = new ArrayList<>(); //arraylist create garne answer lai store garna (indices of people jaslai secret thaxa)
        for (int i = 0; i < n; i++) { //0 dekhi "n-1" samma iterate garney 
            if (knowingSecret[i]) { //element  at index "i" is true on ""knowing Secret, then print that number
                answer.add(i); //true bhako statement "answer ma add garney "
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] intervals = {{0, 2}, {1, 3}, {2, 4}};//2d array declare gareko with 3 array
        int firstOne = 0; //firstone lai 0 initialize garney

        List<Integer> answer = peopleKnowingSecret(n, intervals, firstOne);//  peopleKnowingSecret method lai call garera answer ma return bhako list assign garney
        System.out.println(answer);
    }

    
}