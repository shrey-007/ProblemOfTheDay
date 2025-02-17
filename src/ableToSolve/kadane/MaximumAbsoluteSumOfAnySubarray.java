package ableToSolve.kadane;

public class MaximumAbsoluteSumOfAnySubarray {
    /***
     * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr]
     * is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
     *
     * Return the maximum absolute sum of any (possibly empty) subarray of nums.
     *
     * Note that abs(x) is defined as follows:
     *
     * If x is a negative integer, then abs(x) = -x.
     * If x is a non-negative integer, then abs(x) = x.
     * */
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = 0, minEndingHere = 0, maxSum = 0;

        for (int num : nums) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            minEndingHere = Math.min(num, minEndingHere + num);
            maxSum = Math.max(maxSum, Math.max(maxEndingHere, -minEndingHere));
        }

        return maxSum;
    }

}
