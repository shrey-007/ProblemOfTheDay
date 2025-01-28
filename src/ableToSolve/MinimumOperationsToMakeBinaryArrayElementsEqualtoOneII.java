package ableToSolve;

public class MinimumOperationsToMakeBinaryArrayElementsEqualtoOneII {
    /**
     * You are given a binary array nums.
     *
     * You can do the following operation on the array any number of times (possibly zero):
     *
     * Choose any index i from the array and flip all the elements from index i to the end of the array.
     * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
     *
     * Return the minimum number of operations required to make all elements in nums equal to 1.
     * */
    public int minOperations(int[] nums) {
        // concept is very simple if current element is 0, toh use 1 banane ke liye flip kro
        // ab ya toh seriously i to n-1 loop laga kr flip krdo, ya fir bas flip ka count badao
        // and agar even number of flips hai toh element is same, else element is opposite

        int n = nums.length;
        int flips = 0;

        for (int i = 0; i < n; i++) {
            int currElement = -1;
            // first find the current element,initially arr[i] jo bhi tha, voh jaruri nhi hai ki abhi bhi vahi ho
            // coz flips hui hai toh agar even flips hui hai toh same arr[i] vahi rahega else opposite.

            if(flips%2==1){
                // means ki agar arr[index] pr 0 hai toh 1.
                if(nums[i]==0) currElement = 1;
                else currElement=0;
            }
            else{
                currElement = nums[i];
            }
            // toh abhi current element real mai kya hai voh pata pad gaya
            // ab agar current element 0 hai toh use flip krna padega toh increase count
            if(currElement==0) flips++;
        }

        return flips;
    }
}
