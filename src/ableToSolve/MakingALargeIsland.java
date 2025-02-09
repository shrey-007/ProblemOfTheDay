package ableToSolve;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int visited[][] = new int[n][n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==0){
                    if(grid[i][j]==1) ans = Math.max(ans,bfs(i,j,visited,grid,n));
                    else{
                        int tempVisited[][] = new int[n][n];
                        ans = Math.max(ans,bfs(i,j,tempVisited,grid,n));
                    }
                }
            }
        }

        return ans;
    }

    public int bfs(int r,int c,int visited[][],int grid[][],int n){
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(r,c));
        visited[r][c] = 1;
        int count = 1;

        while (!queue.isEmpty()){
            Cell cell = queue.poll();
            int row[] = {-1,1,0,0};
            int col[] = {0,0,1,-1};

            for (int i = 0; i < 4; i++) {
                int X_Cordinate = cell.x+row[i];
                int Y_Cordinate = cell.y+col[i];
                if(X_Cordinate>=0 && Y_Cordinate>=0 && X_Cordinate<n && Y_Cordinate<n && visited[X_Cordinate][Y_Cordinate]==0 && grid[X_Cordinate][Y_Cordinate]==1){
                    queue.offer(new Cell(X_Cordinate,Y_Cordinate));
                    visited[X_Cordinate][Y_Cordinate] = 1;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,1},{1,0}};
        MakingALargeIsland makingALargeIsland = new MakingALargeIsland();
        System.out.println(makingALargeIsland.largestIsland(arr));
    }
    class Cell{
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
