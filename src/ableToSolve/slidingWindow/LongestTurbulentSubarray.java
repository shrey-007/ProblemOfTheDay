package ableToSolve.slidingWindow;

public class LongestTurbulentSubarray {
    /**
     * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
     *
     * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
     *
     * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
     *
     * For i <= k < j:
     * arr[k] > arr[k + 1] when k is odd, and
     * arr[k] < arr[k + 1] when k is even.
     *
     * Or, for i <= k < j:
     * arr[k] > arr[k + 1] when k is even, and
     * arr[k] < arr[k + 1] when k is odd.
     * */

    // This is longest subarray question , not subarray with maximum sum, so it is done using sliding window
    // It will be done using variable size window
    // Bas positive point ye hai ki suppsoe [start...end] is satisfying the condition, ab end++ kra toh
    // [start....,(end+1)] is not satisfying the condition toh start++ kro jab tak condition satisfy na ho, krte the apan normally. Isme condition tab tak satisfy nhi hogi jab tak start = end-1 na ho jaaye. Toh directly start = end-1 krdo
    // aur agar start++ krne se agar koi sub-array consition satisfy kr bhi liya toh voh chota hi hoga, we want the biggest size.
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) return n;

        int start = 0, maxLen = 1;
        int end = 1;
        int prevSign = 0; // 0: none/equal, 1: increasing, 2: decreasing

        while(end<n){
            int currSign = 0;
            if (arr[end - 1] < arr[end]) currSign = 1;
            else if (arr[end - 1] > arr[end]) currSign = 2;

            if (currSign == 0) {
                // equal elements, reset window
                start = end;
                prevSign = 0;
            } else if (prevSign == 0 || Math.abs(currSign - prevSign) == 1) {
                // valid turbulence continues
                maxLen = Math.max(maxLen, end - start + 1);
                prevSign = currSign;
            } else {
                // turbulence breaks, restart from previous
                start = end - 1;
                prevSign = currSign;
            }
            end++;
        }

        return maxLen;
    }


    public static void main(String[] args) {
        int arr[] = {9,4,2,10,7,8,8,1,9};
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(arr));
    }
}
