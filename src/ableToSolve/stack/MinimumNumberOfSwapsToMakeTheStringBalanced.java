package ableToSolve.stack;

import java.util.Stack;

/**
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and
 * n / 2 closing brackets ']'.
 *
 * A string is called balanced if and only if:
 *
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 *
 * Return the minimum number of swaps to make s balanced.*/
public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    /**
     * It is easy question, find number of closing brackets which are at wrong position, agar closing se pehele openeing
     * nhi aaya toh wrong position pr hai. It is done using balanced paranthesis logic only
     * Fir test cases ko dekh kr pattern dikha mujhe ki if number of closing brackets agar even hai toh divide by
     * 2 krke return kro else divide by 2 plus one krke return krdo
     * */

    public int minSwaps(String s) {
        int numberOfClosingBracketsMisplaced = 0;

        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr==']'){
                if(stack.size()>0 && stack.peek()=='['){
                    stack.pop();
                }
                else{
                    numberOfClosingBracketsMisplaced++;
                }
            }
            else{
                stack.push(curr);
            }
        }

        if(numberOfClosingBracketsMisplaced%2==0){return numberOfClosingBracketsMisplaced/2;}
        else{return numberOfClosingBracketsMisplaced/2+1;}
    }

    // or you can do this in this way
    public int minSwaps2(String s) {
        int numberOfClosingBracketsMisplaced = 0;

        int n = s.length();
        int open = 0;
        int close = 0;

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr==']') close++;
            else open++;
            if(close>open) numberOfClosingBracketsMisplaced++;
        }

        if(numberOfClosingBracketsMisplaced%2==0){return numberOfClosingBracketsMisplaced/2;}
        else{return numberOfClosingBracketsMisplaced/2+1;}
    }

    // or you can do this in this way
    public int minSwaps3(String s) {
        int numberOfClosingBracketsMisplaced = 0;

        int n = s.length();
        int count = 0;

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr==']') count--;
            else count++;
            if(count<0){
                numberOfClosingBracketsMisplaced++;
                count = 0;
            }
        }

        if(numberOfClosingBracketsMisplaced%2==0){return numberOfClosingBracketsMisplaced/2;}
        else{return numberOfClosingBracketsMisplaced/2+1;}
    }

}
