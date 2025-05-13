package ableToSolve.kadane;

import java.util.HashMap;
import java.util.Map;

public class FindTheSubstringWithMaximumCost {
    /**
     * You are given a string s, a string chars of distinct characters and an integer array vals of the same length as chars.
     *
     * The cost of the substring is the sum of the values of each character in the substring. The cost of an empty
     * string is considered 0.
     *
     * The value of the character is defined in the following way:
     *
     * If the character is not in the string chars, then its value is its corresponding position (1-indexed) in the alphabet.
     * For example, the value of 'a' is 1, the value of 'b' is 2, and so on. The value of 'z' is 26.
     * Otherwise, assuming i is the index where the character occurs in the string chars, then its value is vals[i].
     * Return the maximum cost among all substrings of the string s.
     * */

    // Simply ye hai ki har character(a to z) ki ek value hai voh either uska index hai ya fir vals[] array se nikalo
    // ek baar value mil gayi toh esi substring nikaalo jiski characters ki value ka sum maximum ho
    // toh subarray/substring with maximum/minimum sum nikalna hai toh use kadane
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = chars.length();

        // first map the values of each character
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(chars.charAt(i),vals[i]);
        }

        n = s.length();
        int currSum = 0;
        int maxSum = 0;

        // now apply kadane, bus is baar value arr[i] nhi hogi voh tumhe nikaalni hogi
        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            // find the value of current character, in normal kadane it is nums[i]
            int currVal = curr-'a'+1;
            if(map.containsKey(curr)) currVal = map.get(curr);

            if(currSum+currVal>currVal){
                currSum += currVal;
            }
            else{
                currSum = currVal;
            }
            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
    }
}
