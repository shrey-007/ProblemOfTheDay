package notAbleToSolve;

/**
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 *
 * You can perform the following operation at most maxOperations times:
 *
 * Take any bag of balls and divide it into two new bags with a positive number of balls.
 * For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 *
 * Return the minimum possible penalty after performing the operations.
 * */

// the question is that you have to minimise the maximum number of balls
// so this is a binary search question
// jisme search space maximum number of balls hogi and ans milne par high = mid -1 krege
// ab bas ye check krna hai ki mid(agar max number of balls bana) toh kya nums array ko reduce kr paaege in
// maxOperations(given) such that max ballas in any bag is mid, means ki agar koi bag mai mid se jyaada balls hai toh usse divide kro
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        int n = nums.length;
        for(int i=0;i<n;i++){
            high = Math.max(high,nums[i]);
        }

        int ans = high;

        while(high>=low){
            int mid = (low+high)/2;

            if(predicate(mid,nums,maxOperations)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    public boolean predicate(int maxBalls,int nums[],int maxOps){
        int n = nums.length;

        for(int i=0;i<n;i++){
            maxOps -= (nums[i] - 1) / maxBalls; // Calculate splits required for current num
            if (maxOps < 0) {
                return false; // Exceeded allowed operations
            }
        }

        return true;
    }
}
