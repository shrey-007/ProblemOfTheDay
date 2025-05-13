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
    /**
     * Means kisi bhi sub-array [i to j] ka ka absolute sum Math.abs(arr[i]+arr[i+1]+....arr[j]) hoga
     * Toh tumhe find karna hai subarray with maximum absolute sum.
     * Agar subarray with maximum sum poocha hota toh kadane lagate
     * Example-: [2,-5,1,-4,3,-2]
     * Isme kadane lagaoge toh subarray [3] ka sum maximum hai toh 3 return karega
     * But absolute sum mai [-5,1,-4] maximum hai with sum = 8
     * Toh ans 8 aaega.
     * Important thing is individual elements mai mod nhi laga rhe, poore subarray ka sum nikaal kr mod nikaal rhe hai
     * Ab dekho mod usi subarray ka bada hoga jiska sum either maximum hai or minimum hai
     * Toh 2 baar kadane lagao, to find the sub-array with maximum sum, and minimum sum
     * Jo bada hua uske mod return krdo
     * */
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = 0;

        // kadane to find maximum sum of an sub-array
        for(int i=0;i<n;i++){
            if(currSum+nums[i]>nums[i]){
                currSum += nums[i];
            }
            else{
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum,currSum);
        }

        currSum = 0;
        int minSum = 0;
        // kadane to find minimum sum of an sub-array(just reverse the conditions)
        for(int i=0;i<n;i++){
            if(currSum+nums[i]>nums[i]){
                currSum = nums[i];
            }
            else{
                currSum += nums[i];
            }
            minSum = Math.min(minSum,currSum);
        }

        return Math.max(maxSum,Math.abs(minSum));
    }

}
