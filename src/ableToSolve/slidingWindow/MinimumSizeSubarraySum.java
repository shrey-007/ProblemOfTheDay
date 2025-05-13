package ableToSolve.slidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a sub-array.
 * Whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * */
public class MinimumSizeSubarraySum {
    // Since it is a sub-array question, first thing that should click is sliding window
    // It is same as find smallest sub-array with sum target
    // Only change is to update answer even if currentSum>target because it is given in question
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int currentSum = 0;
        int n = nums.length;

        while(end<n){
            // do work on end
            currentSum = currentSum+nums[end];

            if(currentSum<target){
                end++;
            }

            else{
                // means currentsum>target so this is possible ans
                ans = Math.min(ans,end-start+1);
                // now reduce window size by increasing start
                while(currentSum>=target && start<end){
                    if(currentSum>=target){ans = Math.min(ans,end-start+1);}
                    currentSum = currentSum - nums[start];
                    start++;
                }
                if(currentSum==target){ans = Math.min(ans,end-start+1);}
                end++;
            }
        }

        if(ans==Integer.MAX_VALUE){return 0;}

        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(minSubArrayLen(11,arr));
    }
}
