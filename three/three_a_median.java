package three;
import java.util.ArrayList;

public class three_a_median {
    private ArrayList<Double> scores;  //arraylist created to store the scores

    public three_a_median() {
        scores = new ArrayList<>(); //initializing arraylist
    }

    public void addScore(double score) {
        scores.add(score); // arraylist ma score add gareko
    }

    public double getMedianScore() {
        if (scores.isEmpty()) { // empty ho ki nai arraylist check garney 
            throw new IllegalStateException("No scores added yet."); // kunai pani number add xaina bhane error falxa
        }

        int size = scores.size(); //arraylist ko size herney
        // sorting suru
        for (int i = 0; i < size - 1; i++) { //sabai list ko laagi outer loop
            for (int j = 0; j < size - i - 1; j++) { //unsorted portion ko laagi inner loop
                if (scores.get(j) > scores.get(j + 1)) { //if current element thulo xa bhane
                    // swap the  scores
                    double temp = scores.get(j); //temp ma add garney current value
                    scores.set(j, scores.get(j + 1)); //current ma adjacent value halney 
                    scores.set(j + 1, temp); //adjacent ma temp halney 
                }
            }
        }

        if (size % 2 == 0) {
            // if number even ho bhane duita number line 
            int middleIndex1 = (size / 2) - 1;
            int middleIndex2 = size / 2;
            return (scores.get(middleIndex1) + scores.get(middleIndex2)) / 2.0;
        } else {
            // if not middle number is median 
            return scores.get(size / 2);
        }
    }

    public static void main(String[] args) {
        three_a_median tracker = new three_a_median(); //creating object 
        tracker.addScore(85.5);
        tracker.addScore(92.3);
        tracker.addScore(77.8);
        tracker.addScore(90.1);
        System.out.println("Median Score 1: " + tracker.getMedianScore());

        tracker.addScore(81.2);
        tracker.addScore(88.7);

        System.out.println("Median Score 2: " + tracker.getMedianScore());
    }
}
