package four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class four_a_game {
    //using static to encapsulate
     class game {
        int x, y;
        String keys;

        game(int x, int y, String keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    public static int shortPath(char[][] matrix) {
        int m = matrix.length; //number of rows in matrix
        int n = matrix[0].length; //number of column in matrix
        Set<Character> keys = new HashSet<>(); //to store key in matrix
        Map<Character, int[]> doors = new HashMap<>(); //to store position of door where key is found
        int startx = -1, starty = -1; //variable to store the starting postion
        
        //iterate through the matrix to find key, door, and starting points
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char box = matrix[i][j]; //getting the character at position 
                if (box == 'S') {
                    startx = i;
                    starty = j;
                } else if ('a' <= box && box <= 'z') {
                    keys.add(box);
                } else if ('A' <= box && box <= 'Z') {
                    doors.put(box, new int[] { i, j });
                }
            }
        }

        List<Character> keysList = new ArrayList<>(keys); //to convert keys set into list 
        int[] minDistance = { Integer.MAX_VALUE }; //array to store the minimum distance
        //calling dfs to find short path
        dfs(matrix, startx, starty, keysList, doors, new boolean[m][n], "", 0, minDistance);
        //return ing the minimum distance from starting point to any other point in the matrix
        if (minDistance[0] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minDistance[0];
        }
        
    }

    private static void dfs(char[][] matrix, int x, int y, List<Character> keys, Map<Character, int[]> doors,
            boolean[][] visited, String collectedKeys, int distance, int[] minDistance) {
        if (distance >= minDistance[0])
            return;

        visited[x][y] = true;

        for (int[] dir : new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }) {
            int nx = x + dir[0]; //new x coordinate
            int ny = y + dir[1]; //new y-coordinate
            //check if the new coordinates are within the matrix and box is visited or not
            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && !visited[nx][ny]) {
                char box = matrix[nx][ny]; // getting the character at new coordinates
                //if the cell contains a passage or the starting point, continuing dfs

                if (box == 'P' || box == 'S') {
                    dfs(matrix, nx, ny, keys, doors, visited, collectedKeys, distance + 1, minDistance);
                    //if the cell contains  a key, continue dfs and collect it 
                } else if ('a' <= box && box <= 'z') {
                    String newCollectedKeys = collectedKeys + box;

                    if (newCollectedKeys.length() == keys.size()) {
                        minDistance[0] = Math.min(minDistance[0], distance + 1);

                    } else {
                        dfs(matrix, nx, ny, keys, doors, visited, newCollectedKeys, distance + 1, minDistance);

                    }
                    //if cell contains a door, check if the corresponding key is collected and continue DFS
                } else if ('A' <= box && box <= 'Z') {
                    char key = Character.toLowerCase(box);

                    if (collectedKeys.indexOf(key) != -1) {
                        dfs(matrix, nx, ny, keys, doors, visited, collectedKeys, distance + 1, minDistance);
                    }
                }
            }
        }

        visited[x][y] = false; //marking the current cell as unvisited after exploring all possible paths
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { 'S', 'P', 'q', 'P', 'P' },
                { 'W', 'W', 'W', 'P', 'W' },
                { 'r', 'P', 'Q', 'P', 'R' }
        };
        System.out.println(shortPath(matrix)); 
    }
}