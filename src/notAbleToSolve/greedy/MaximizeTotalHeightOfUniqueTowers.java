package notAbleToSolve.greedy;

import java.util.Arrays;

public class MaximizeTotalHeightOfUniqueTowers {
    /**
     * You are given an array maximumHeight, where maximumHeight[i] denotes the maximum height the ith tower can be assigned.
     *
     * Your task is to assign a height to each tower so that:
     *
     * The height of the ith tower is a positive integer and does not exceed maximumHeight[i].
     * No two towers have the same height.
     * Return the maximum possible total sum of the tower heights. If it's not possible to assign heights, return -1.
     *
     *----------------------------------------------------------------------------------------------------------------
     * You need to assign heights to buildings so that:
     *
     * 1. Each building’s height ≤ its given `maximumHeight[i]`.
     * 2. All assigned heights are **unique positive integers**.
     * 3. The **total sum** of assigned heights is **maximum possible**.
     *
     *
     * ----------------------------------------------------------------------------------------------------------------
     * If you think about it —
     *
     * * To maximize the sum, you want to give taller buildings larger numbers.
     * * But they must be strictly decreasing (unique) — no two can have the same height.
     *
     * So when sorted in ascending order, if we assign greedily from right to left (largest → smallest):
     *
     * * The tallest building gets the maximum possible allowed height.
     * * The next one must be less than that, otherwise it would clash or exceed.
     *
     * --------------------------------------------------------------------------------------------------------------
     *
     * 🔍 Why `Math.min(prev - 1, maximumHeight[i])`
     *
     * Let’s break that down:
     *
     * * `maximumHeight[i]` → upper bound for this building (can’t exceed it).
     * * `prev - 1` → must be strictly smaller than the previous building’s assigned height to keep all heights unique
     *    and decreasing.
     * */
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long sum = 0;
        long prev = Long.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            long height = Math.min(prev - 1, maximumHeight[i]);
            if (height <= 0) return -1;
            sum += height;
            prev = height;
        }

        return sum;
    }
}
