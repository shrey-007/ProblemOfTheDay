package notAbleToSolve.prefixArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 *
 * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task
 * is to check that subarray nums[fromi..toi] is special or not.
 *
 * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 * */
public class SpecialArrayII {

    // Best way is using prefix sum
    // Generally ye queries vale question prefix sum se hi hote hai
    // suppose tumhe array diya hai ,and ab tumhe queries di hai [start,end].
    // tumhe start to end ka sum return krna hai
    // toh ya toh har query mai start to end sum calculate kro, or ek prefix array bana lo and har query ka ans prefix[end]-prefix[start] return krdo
    // Toh query vale questions mai repetitive calculation se bachne ke liye computed result ko store kro kahi like prefix array
    // TC-: O(n)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Create an array to mark special indices
        boolean[] isSpecial = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            isSpecial[i] = sameParity(nums[i], nums[i + 1]);
        }

        // Create a prefix sum to count special indices
        int[] prefixSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isSpecial[i] ? 1 : 0);
        }

        // Answer each query
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // Check if there are any special indices in the range
            int countSpecial = prefixSum[right] - prefixSum[left];
            ans[i] = countSpecial == 0;
        }

        return ans;
    }

    public boolean sameParity(int i, int j) {
        return (i % 2) == (j % 2);
    }

}
