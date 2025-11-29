package notAbleToSolve.goodQuestions;

import java.util.Stack;

public class OneThreeTwoPattern {

    // most brute force approach
    public boolean bruteForce(int nums[]){
        int n = nums.length;
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(nums[i]<nums[k] && nums[k]<nums[j]){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    // Reason to use stack-:
    /**
     * 1. jab bhi multiple dependent for loops ho toh stack use ho skte hai like isme j ki loop i+1 se start this and k
     * ki loop j+1 se toh dependent loops hai toh stack use ho skta hai
     * 2.
     * */

    // i<j<k , nums[i]<nums[k]<nums[j]

    /**
     * largest element is num2(j)
     * numk, numj se chota hona chaiye and numi se bada toh mai keh rha hu ki numk ko numj se just chota element rakhe toh hum esa kare
     * toh hum 2 pointer rakhege largest(j) and secondLargest(k). suppose largest=4, secondLargest=2. now ab agar 3 aaya
     * toh hum secondLargest ko update krege coz hume chaiye ki secondLargest nums[i] se baa ho toh use largest ke bahut paas rakho.
     * largest=4, secondLargest=3. now ab agar 6 aaya toh largest=6 and secondLargest=4 krdo
     * now ab agar 2 aaya means ki hume apne 3 numbers mil gye hai largest, second largest and nums[i]. But point is ki i<j<k ye constraint follow hua ki nhi
     * Ye constraint follow hoga agar right to left iterate kroge.
     * Right to left iterate kro and largest and secondLargest maintained rahega orderwise bhi , and value wise bhi
     * phir agar koi element secondLargest se chota aaya toh since apan r to l traverse kr rhe hai toh current element ka index sabse chota hai toh ordering i<j<k bilkul sahi hai
     * */

    // watch video for good explanation -: https://www.youtube.com/watch?v=RZXxX1EU364
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = n-1; i >=0 ; i--) {
            int curr = nums[i];
            if(curr>largest){
                secondLargest = largest;
                largest = curr;
            }
            else if(curr>secondLargest){
                secondLargest = curr;
            }
            else if(curr<secondLargest){
                return true;
            }
        }

        return false;
    }

    /** This code is totally wrong-: Apan ko ye order chaiye -: nums[i], largest, secondLargest
     * take a test case-: {3,5,0,3,4}
     * index=4 ->  largest=4
     * index=3 ->  largest=4 secondLargest=3 but ye galat order ho gya ye {nums[i],secondLargest,largest} ho gya joki ni chaiye
     * */

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int secondLargest = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();  // holds possible value of nums[k]

        // Traverse from the end of the array to ensure 'i < j < k'.
        for (int i = n - 1; i >= 0; i--) {
            // If we find a number smaller than 'secondLargest',means ki largest and secondLargest already mil gye hai and abhi nums[i] bhi mil gya
            // we found a 132 pattern.
            if (nums[i] < secondLargest) {
                return true;
            }

            // Maintain the stack for the 'largest' value by popping elements smaller than current element.
            // since hum r to l jaa rhe hai toh abhi hum ith index pr hai toh stack mai abhi jo bhi elements hai voh i ke right side vaale elements hai
            // toh agar stack ka peek se current element bada hai means right side mai ek chota element hai current element se toh j<k and nums[j]>nums[k] ye cheej ho gyi
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondLargest = stack.pop();
            }

            // Push the current number into the stack.
            stack.push(nums[i]);
        }

        return false;
    }
    /**
     *  Put all elements in the stack-:
     *  Now there can be two cases current element is greater than stack peek, smaller than stack peek
     *  1. If current element is greater then stack peek-: stack mai right side vale elements hai, means current element is greater than a element to its right so we found a good j<k pair satisfying nums[j]>nums[k]
     *  2. If current element is smaller than stack peek-: toh use store krlo stack mai as it is possible value of nums[k].(suppose nums[k] largest element le liya toh koi element j nhi milega jo usse bada ho isliye koshish kro ki chota element lo)
     * */

}
