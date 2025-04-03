package ableToSolve.prefix;

public class MaximumValueOfAnOrderedTripletII {

    /**
     * You are given a 0-indexed integer array nums.
     *
     * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
     *
     * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
     * */

    /*
    * Preprocess the prefix maximum array, prefix_max[i] = max(nums[0], nums[1], …, nums[i]) and the suffix maximum array,
    *  suffix_max[i] = max(nums[i], nums[i + 1], …, nums[i - 1]).
    **/

    /*
    * For index j, the maximum triplet value is (prefix_max[j - 1] - nums[j]) * suffix_max[j + 1].
    */
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int prefixMax[] = new int[n];
        int max = nums[0];
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            prefixMax[i] = max;
        }

        int suffixMax[] = new int[n];
        max = nums[n-1];
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,nums[i]);
            suffixMax[i] = max;
        }

        long ans = 0;
        for(int j=1;j<n-1;j++){
            int i = prefixMax[j-1];
            int k = suffixMax[j+1];
            long value = (i-nums[j])*(long)k;
            ans = Math.max(ans,value);
        }

        return ans;
    }
}
