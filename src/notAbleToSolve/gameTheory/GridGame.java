package notAbleToSolve.gameTheory;

public class GridGame {
    /**
     * You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at
     * position (r, c) on the matrix. Two robots are playing a game on this matrix.
     *
     * Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c)
     * to (r, c + 1)) or down ((r, c) to (r + 1, c)).
     *
     * At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells
     * on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves
     * from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.
     *
     * The first robot wants to minimize the number of points collected by the second robot. In contrast, the second
     * robot wants to maximize the number of points it collects. If both robots play optimally, return the number of
     * points collected by the second robot.
     * */
    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        long[] pref1 = new long[m];
        long[] pref2 = new long[m];

        pref1[0] = grid[0][0];
        pref2[0] = grid[1][0];

        for (int i = 1; i < m; i++) {
            pref1[i] = pref1[i - 1] + grid[0][i];
            pref2[i] = pref2[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long top = (i == m - 1) ? 0 : pref1[m - 1] - pref1[i];
            long bottom = (i == 0) ? 0 : pref2[i - 1];
            result = Math.min(result, Math.max(top, bottom));
        }

        return result;
    }
}
