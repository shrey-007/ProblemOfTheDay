package ableToSolve.prefix;

import java.util.HashMap;

public class CountNumberOfBadPairs {
    /**
     * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and
     * j - i != nums[j] - nums[i].
     *
     * Return the total number of bad pairs in nums.
     * */

    // It is same as 2 sum
    // j-i != nums[j]-nums[i]
    // total pairs = n(n-1)/2
    // countPairsWith(j-i != nums[j]-nums[i]) =  total pais -countPairsWith(j-i = nums[j]-nums[i])

    // j-i = nums[j]-nums[i]
    // fix j,
    // j-nums[j] = i-nums[i]
    // Separate out known and unknown terms, we know j(since we will iterate over array using j), so we know j, nums[j]
    // we don't know i-nums[i], so map mai i-nums[i] store karege har element ka, and since count of pairs poocha hai toh
    // i-nums[i] ki frequency store krege

    // j-nums[j] -> frequency of (j-nums[j])
    public long countBadPairs(int[] nums) {
        long count = 0;
        int n = nums.length;

        HashMap<Long,Long> hashMap = new HashMap<>();


        for(int j=0;j<n;j++){
            long target = j-nums[j];
            long temp = hashMap.getOrDefault(target,0L);
            count += temp;
            hashMap.put(target,temp+1);
        }

        return ((long)n*(n-1))/2-count;
    }
}
