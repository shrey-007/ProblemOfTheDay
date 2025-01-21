package notAbleToSolve.shortestPath;

public class MinimumCostToMakeAtLeastOneValidPathInGrid {
    /**
     * Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are
     * currently in this cell. The sign of grid[i][j] can be:
     *
     * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
     * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
     * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
     * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
     * Notice that there could be some signs on the cells of the grid that point outside the grid.
     *
     * You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the
     * upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid.
     * The valid path does not have to be the shortest.
     *
     * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
     *
     * Return the minimum cost to make the grid have at least one valid path.
     * */

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        return func(grid, 0, 0, visited);
    }

    public int func(int[][] grid, int r, int c, int[][] visited) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] == 1)
            return (int) 1e9;
        if (r == grid.length - 1 && c == grid[0].length - 1)
            return 0;

        int faith = (int) 1e9;
        visited[r][c] = 1;

        // Loop through four possible directions
        for (int i = 1; i <= 4; i++) {
            if (grid[r][c] == i) {
                // Move in the current direction
                if (i == 1) faith = Math.min(faith, func(grid, r, c + 1, visited)); // right
                else if (i == 2) faith = Math.min(faith, func(grid, r, c - 1, visited)); // left
                else if (i == 3) faith = Math.min(faith, func(grid, r + 1, c, visited)); // down
                else faith = Math.min(faith, func(grid, r - 1, c, visited)); // up
            } else {
                // Change direction and move
                if (i == 1) faith = Math.min(faith, Math.min(func(grid, r, c - 1, visited) + 1,
                        Math.min(func(grid, r + 1, c, visited) + 1,
                                func(grid, r - 1, c, visited) + 1)));
                else if (i == 2) faith = Math.min(faith, Math.min(func(grid, r, c + 1, visited) + 1,
                        Math.min(func(grid, r + 1, c, visited) + 1,
                                func(grid, r - 1, c, visited) + 1)));
                else if (i == 3) faith = Math.min(faith, Math.min(func(grid, r - 1, c, visited) + 1,
                        Math.min(func(grid, r, c + 1, visited) + 1,
                                func(grid, r, c - 1, visited) + 1)));
                else faith = Math.min(faith, Math.min(func(grid, r, c + 1, visited) + 1,
                            Math.min(func(grid, r, c - 1, visited) + 1,
                                    func(grid, r + 1, c, visited) + 1)));
            }
        }

        visited[r][c] = 0;  // Reset the visited state
        return faith;
    }
}
