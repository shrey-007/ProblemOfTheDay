package notAbleToSolve.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    /**
     * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the
     * remaining elements is divisible by p. It is not allowed to remove the whole array.
     *
     * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
     * */
    public int minSubarray(int[] nums, int p) {
        // let total sum of an array is totalSum. If we take mod totalSum%p = T (let)
        // let the sum of smallest subarray who need to be deleted from this array is S1
        //(totalSum-s1)%p = 0
        // totalSum%p = s1%p = T
        // so if you find totalSum, then the question will reduce to finding the smallest subarray whose sum%p is T
        int totalSum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++) totalSum = (totalSum%p + nums[i]%p)%p;
        int T = totalSum%p;
        if(T==0) return 0;

        // now find a smallest sub-array with sum%p = T
        // create a hashmap sum%p -> index
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = n;

        // agar abhi apan currently i index par hai and 0 to i tak ka sum Si hai
        // and there exist a j such that 0<=j<i and 0 to j ka sum Sj hai
        // and j+1 to i ka sum Sz hai

        // 0.....j....i
        // toh Si = Sj + Sz
        // Si%p = Sj%p + Sz%p
        // toh let j+1 to i is the min subarray jiska sum%p = T aaye. toh kese pata kare ki ye vahi hai
        // toh Si%p toh pata pad jaaega coz abhi apan ith index pr hai toh Si pata hai
        // Sz%p = T , bas apan ko Sj%p hi toh nikalna hai
        // Sj%p = Si%p - T
        // toh when you reach to index, i find a subarray whose sum%p is Si%p-T. if you found one then j+1 to i is the
        // subarray with sum%p = T

        int prefixSum = 0;
        for(int i=0;i<n;i++){
            prefixSum = (prefixSum%p + nums[i]%p)%p;
            int currentMod = prefixSum%p;
            int requiredMod = (currentMod - T+p)%p;
            if(map.containsKey(requiredMod)){
                int index = map.get(requiredMod);
                ans = Math.min(ans,i-index);
            }
            map.put(currentMod,i);
        }
        if(ans==n) return -1;
        return ans;
    }
}
