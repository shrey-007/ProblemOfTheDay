package ableToSolve.stack;

import java.util.Stack;

public class ClearDigits {
    /**
     * You are given a string s.
     *
     * Your task is to remove all digits by doing this operation repeatedly:
     *
     * Delete the first digit and the closest non-digit character to its left.
     * Return the resulting string after removing all digits.
     *
     * ex-: cb34
     * output-: ""
     * explain-: 3 ko delete kro toh b ko delete krna pada, toh c4 bacha fir 4 ko delete kro toh c ko delete krna pada
     * */

    // ith index par agar digit hai toh i ke peeche vaale indexes ko delete krna hai
    // so it is stack question
    public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr>='0' && curr<='9'){
                stack.pop();
            }
            else stack.push(curr);
        }

        String ans = new String("");
        while(!stack.isEmpty()){
            ans = stack.pop() + ans;
        }

        return ans;
    }
}
