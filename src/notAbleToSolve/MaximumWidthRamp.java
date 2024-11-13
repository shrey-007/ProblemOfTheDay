package notAbleToSolve;

import java.util.Stack;

/**
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
 *
 * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.*/
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;

        // stack will store the elements which can be i
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0,nums[0]));

        for(int i=1;i<n;i++){
            if(nums[i]<stack.peek().value){stack.push(new Pair(i,nums[i]));}
        }

        int ans = 0;
        // now for j , we will iterate from last and check whether it can be ans or not
        for(int j=n-1;j>=0;j--){
            while(stack.size()>0 && nums[j]>=stack.peek().value){
                Pair pair = stack.pop();
                ans = Math.max(ans,j-pair.index);
            }
        }

        return ans;

    }

    class Pair{
        int index;
        int value;
        Pair(int i,int v){
            index=i;
            value=v;
        }
    }

}
