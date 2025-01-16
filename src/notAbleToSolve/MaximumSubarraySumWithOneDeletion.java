package notAbleToSolve;

public class MaximumSubarraySumWithOneDeletion {
    /**
     * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most
     * one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so
     * that there is still at least one element left and the sum of the remaining elements is maximum possible.
     *
     * Note that the subarray needs to be non-empty after deleting one element.
     * */

    // kadane algorithm with slight modification
    public int maximumSum(int[] arr) {
        int n = arr.length;

        // Forward pass: Maximum subarray sum ending at each index
        int[] forward = new int[n];
        forward[0] = arr[0];
        for (int i = 1; i < n; i++) {
            forward[i] = Math.max(arr[i], forward[i - 1] + arr[i]);
        }

        // Backward pass: Maximum subarray sum starting at each index
        int[] backward = new int[n];
        backward[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = Math.max(arr[i], backward[i + 1] + arr[i]);
        }

        // Maximum sum without any deletion
        int maxSum = forward[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, forward[i]);
        }

        // Check maximum sum with one deletion
        for (int i = 1; i < n - 1; i++) {
            maxSum = Math.max(maxSum, forward[i - 1] + backward[i + 1]);
        }

        return maxSum;
    }
}
