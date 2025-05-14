package notAbleToSolve.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountServersThatCommunicate{
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[m]; // Counts servers in each row
        int[] colCount = new int[n]; // Counts servers in each column

        // First pass: count the number of servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int totalServers = 0;

        // Second pass: count servers that can communicate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // A server can communicate if there are other servers in its row or column
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        totalServers++;
                    }
                }
            }
        }

        return totalServers;
    }

}

/**
 * This question is same as Most Stones Removed With Same Row or Column in A2Z Sheet
 * */
