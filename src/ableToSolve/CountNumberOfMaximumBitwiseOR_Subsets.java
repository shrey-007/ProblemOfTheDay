package ableToSolve;

import java.util.Arrays;

/**
 * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of
 * different non-empty subsets with the maximum bitwise OR.
 *
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two
 * subsets are considered different if the indices of the elements chosen are different.
 *
 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
 * */
public class CountNumberOfMaximumBitwiseOR_Subsets {

    // Concept is ki jab bhi OR krte hai toh atleast 1 hone chaiye agar dono 0 hai toh 0 aaega result else agar ek 1 hai toh 1 aaega
    // Toh maximum OR tab aaega jab poore array ka OR ek saath loge. It is agar ith index tak OR ki value x hai toh (i+1) th index tak OR ki value ya toh increase hogi ya fir same rahegi
    public int countMaxOrSubsets(int[] nums) {
        // find the maximum OR
        int maxOR = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            maxOR = maxOR | nums[i];
        }

        // Now we have to find how many subsets whose bitwise or is maxOr
        // Since it is count number of subsets , not count number is sub-arrays, so we can't do it either using prefix sum and hashmap or sliding window
        // to generate all possible subsets we have to do recursion
        // Apply memoization
        int dp[][] = new int[n][maxOR+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return func(nums,0,maxOR,0,dp);
    }
    public int func(int nums[],int index,int targetOR,int currentOR,int dp[][]){
        // return 1 in positive base case
        if(index==nums.length && currentOR==targetOR){return 1;}
        // return 0 in negative base case
        if(index==nums.length && currentOR!=targetOR){return 0;}

        if(dp[index][currentOR]!=-1){return dp[index][currentOR];}

        // include this element in OR
        int faith1 = func(nums,index+1,targetOR,currentOR | nums[index],dp);
        // don't include this element in OR
        int faith2 = func(nums,index+1,targetOR,currentOR,dp);

        dp[index][currentOR] = faith1 + faith2;

        return faith1 + faith2;
    }

}
