package notAbleToSolve.RangeProblems;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    /**
     * You are given a 0-indexed array nums and a non-negative integer k.
     *
     * In one operation, you can do the following:
     *
     * Choose an index i that hasn't been chosen before from the range [0, nums.length - 1].
     * Replace nums[i] with any integer from the range [nums[i] - k, nums[i] + k].
     * The beauty of the array is the length of the longest subsequence consisting of equal elements.
     *
     * Return the maximum possible beauty of the array nums after applying the operation any number of times.
     *
     * Note that you can apply the operation to each index only once.
     *
     * A subsequence of an array is a new array generated from the original array by deleting some elements
     * (possibly none) without changing the order of the remaining elements.
     * */

    // Method 1-:
    /** suppose nums[]={4,6,1,2}, and k=2
     * toh sabse pehle range nikaal lo ki har element kis se kis tak convert ho skta hai
     * nums[]={4,6,1,2}
     * min[]={2,4,-1,0}
     * max[]={6,8,3,4}
     *
     * since lowest value in min is -1 and highest value in max is 8 toh ans [-1,8] ke beech mai hi hoga
     * kiuki is range se bahar kisi mai bhi convert nhi hoga koi bhi element
     *
     * toh we have to check ki inme se kon ans hai-: {-1,0,1,2,3,4,5,6,7,8}
     * toh check kro ki kitne elements -1 mai convert ho jaaege, uske liye func() hai.
     * fir check kro ki kitne elements 0 mai convert hoge and so on
     * jiska sabse jyaada count aaya vahi count ans hoga
     * */
    public int maximumBeauty2(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min[i] = nums[i]-k;
            max[i] = nums[i]+k;
            low = Math.min(low,min[i]);
            high = Math.max(high,max[i]);
        }

        int ans = 0;

        for(int i=low;i<=high;i++){
            ans = Math.max(ans,func2(i,min,max,n));
        }

        return ans;
    }

    int func2(int num,int min[],int max[],int n){
        int count = 0;

        for(int i=0;i<n;i++){
            if(min[i]<=num && num<=max[i]){
                count++;
            }
        }
        return count;
    }

    // Method2-:
    /** First step is same ki har element ki range nikaalo ki voh kisme convert ho skta hai
     * nums[]={4,6,1,2} , k=2
     * range = {(2,6),(4,8),(-1,3),(2,4)}
     * Ab in ranges ko intervals maano and and apan ko voh time chaiye jaha maximum number of intervals overlap kr rhe hai
     * We have already sloved this quesiton in Minimum Number of Platforms required at station in Strinver A2Z, greedy playlist
     */
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==0){return 0;}
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];

        for(int i=0;i<n;i++){
            min[i] = nums[i]-k;
            max[i] = nums[i]+k;
        }

        // min[i] is start o ith interval, max[i] is end of ith interval
        // Apply Minimum Number of Platforms required at station algorithm
        Arrays.sort(max);
        Arrays.sort(min);


        int i=1;
        int j=0;

        int count = 1;
        int ans = 1 ;

        while (i<n && j<n){
            if(min[i]<=max[j]){
                count++;
                ans = Math.max(ans,count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }

        return ans;
    }

    // Method3-:
    // Sort the array.
    // The problem becomes the following: find maximum subarray A[i … j] such that A[j] - A[i] ≤ 2 * k.
    // You can solve this using sliding window since it is converted to sub-array problem


}
