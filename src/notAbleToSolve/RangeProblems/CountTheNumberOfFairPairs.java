package notAbleToSolve.RangeProblems;

import java.util.Arrays;

/**
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 *
 * A pair (i, j) is fair if:
 *
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 * */
public class CountTheNumberOfFairPairs {
    // brute force is ki hum har possible pairs ko explore kre in O(n2)
    // here is optimal approach-:

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long count=0;

        // sort the array
        Arrays.sort(nums);

        // for each element i in array, find how many pairs you can found like (i,a),(i,b),(i,c) etc.
        for(int i=0;i<n;i++){
            count = count + func(i,nums,lower,upper);
        }

        return count;
    }

    public long func(int index,int[] nums, int lower, int upper){

        int pairWithMaxVal = upper-nums[index];
        int pairWithMinVal = lower-nums[index];
        // i ke pairs pairs find krne hai, toh unki range hogi pairWithMinVal to pairWithMaxVal

        // ab array mai dhoondo ki esa konsa index hai jo pairWithMaxVal se just equal and chota hai and
        // konsa index pairWithMinVal se just bada hai
        int indexOfLowerBound = lowerBound(index+1,nums.length-1,pairWithMinVal,nums); // index having value just greater or equal to pairWithMinVal
        int indexOfUpperBound = upperBound(index+1,nums.length-1,pairWithMaxVal,nums); // index having value just smaller or equal to pairWithMaxVal

        // let the indexes be x,y
        // toh i ke respect mai tumhe jo pairs mili hai voh x to y index vaali mili hai
        if(indexOfLowerBound<=indexOfUpperBound){return indexOfUpperBound-indexOfLowerBound+1;}
        return 0;
    }

    public int lowerBound(int start,int end,int pairWithMinVal,int nums[]){
        // use BS to find lower bound

        int ans = Integer.MAX_VALUE;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==pairWithMinVal){
                ans = mid;
                end=mid-1;
            }
            else if(nums[mid]>pairWithMinVal){
                ans = mid;
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }


    public int upperBound(int start,int end,int pairWithMaxVal,int nums[]){
        // use BS to find upper bound

        int ans = Integer.MIN_VALUE;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==pairWithMaxVal){
                ans = mid;
                start=mid+1;
            }
            else if(nums[mid]>pairWithMaxVal){
                end=mid-1;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }

        return ans;
    }

}
