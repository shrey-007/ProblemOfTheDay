package ableToSolve;

public class MaximumNumberOfFishInGrid {
    /**
     * You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
     *
     * A land cell if grid[r][c] = 0, or
     * A water cell containing grid[r][c] fish, if grid[r][c] > 0.
     * A fisher can start at any water cell (r, c) and can do the following operations any number of times:
     *
     * Catch all the fish at cell (r, c), or
     * Move to any adjacent water cell.
     * Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no
     * water cell exists.
     *
     * An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.
     * */

    // simply grid mai multiple components hoge s, so you have to return the maximum sum of elements a component has
    // same code as , find number of components
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];

        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && visited[i][j]==0){
                    ans = Math.max(ans,func(i,j,visited,grid,m,n));
                }
            }
        }

        return ans;
    }

    public int func(int row,int col,int visited[][],int grid[][],int m,int n){
        int ans = grid[row][col];
        visited[row][col] = 1;

        // visit all unvisited neighbours if land cell is available
        int r[] = {1,0,-1,0};
        int c[] = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int newRow = row+r[i];
            int newCol = col+c[i];
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && visited[newRow][newCol]==0 && grid[newRow][newCol]>0){
                ans = ans + func(newRow,newCol,visited,grid,m,n);
            }
        }

        return ans;
    }
}
