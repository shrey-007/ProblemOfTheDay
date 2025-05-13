package ableToSolve.prefix;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    /**
     * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible
     * by k.
     * */
    /*
    * suppose we are at index i ,and index j to i ka sum k se divisible hai
    * means (prefixSum(i)-prefixSum(j)) % k = 0
    * prefixSum(i) % k - prefixSum(j) % k = 0
    * prefixSum(i) % k = prefixSum(j) % k
    * fix i, i se apan iterate karege toh i, nums[i], prefixSum(i) apan ko pata hoga. Means LHS pata hai
    * Since LHS pata hai toh RHS bhi pata hai since LHS = RHS, but RHS kis j ke liye esa hai voh nhi pata toh RHS mai jo
    * term hai voh apan hashmap mai store karege. And LHS mai jo term hai voh apan find karege hashmap mai
    *
    * since apan ko count of subarrays chaiye toh map mai RHS ko uske count se map karege
    *
    *     * */
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int prefix = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            prefix += nums[i];
            int req = prefix % k;
            count += map.getOrDefault(req,0);
            map.put(req,map.getOrDefault(req,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int []arr = {-1,2,9};
        SubarraySumsDivisibleByK subarraySumsDivisibleByK = new SubarraySumsDivisibleByK();
        subarraySumsDivisibleByK.subarraysDivByK(arr,2);
    }
}
