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
