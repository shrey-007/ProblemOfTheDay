package ableToSolve;

import java.util.ArrayDeque;
import java.util.Queue;

public class MapOfHighestPeak {
    /**
     * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
     *
     * If isWater[i][j] == 0, cell (i, j) is a land cell.
     * If isWater[i][j] == 1, cell (i, j) is a water cell.
     * You must assign each cell a height in a way that follows these rules:
     *
     * The height of each cell must be non-negative.
     * If the cell is a water cell, its height must be 0.
     * Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell
     * if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
     * Find an assignment of heights such that the maximum height in the matrix is maximized.
     *
     * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple
     * solutions, return any of them.
     * */
    public int[][] highestPeak(int[][] isWater) {
        Queue<Cell> queue = new ArrayDeque<>();
        int m = isWater.length;
        int n = isWater[0].length;

        int visited[][] = new int[m][n];
        int height[][] = new int[m][n];

        // insert all water cells into the queue with the height of 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j]==1){
                    queue.offer(new Cell(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()){
            Cell cell = queue.poll();
            int currentHeight = cell.height;

            // put all its unvisited neighbour in queue
            int r[] = {-1,0,1,0};
            int c[] = {0,-1,0,1};

            for (int i = 0; i < 4; i++) {
                int X_Cordinate = cell.x+r[i];
                int Y_Cordinate = cell.y+c[i];

                if(X_Cordinate>=0 && Y_Cordinate>=0 && X_Cordinate<m && Y_Cordinate<n && visited[X_Cordinate][Y_Cordinate]==0){
                    queue.offer(new Cell(X_Cordinate,Y_Cordinate,currentHeight+1));
                    visited[X_Cordinate][Y_Cordinate] = 1;
                    height[X_Cordinate][Y_Cordinate] = currentHeight+1;
                }
            }
        }

        return height;
    }


    class Cell{
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", height=" + height +
                    '}';
        }
    }
}
