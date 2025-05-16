package ableToSolve.stack;

import java.util.Stack;

/**
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 * */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int count=0;
        int n=s.length();
        Stack<Character> stack=new Stack<>();


        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){stack.push(s.charAt(i));}
            else{
                if(stack.isEmpty()){count++;}
                else{stack.pop();}
            }
        }

        if(!stack.isEmpty()){count=count+stack.size();}
        return count;
    }

    // we can also solve this question without stack
    // It is a good approach to solve all parenthesis problems
    public int minAddToMakeValid2(String s) {
        int count=0;
        int n=s.length();
        int ans=0;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){count++;}
            else{count--;}
            if(count<0){
                // means ki closing jyaada ho gye opening se, toh ek open bracket add krdo toh ek add kra toh ans++
                ans++;
                // since ek open bracket add krne par ab balance ho gya hai toh count = 0 krdo
                count=0;
            }
        }

        if(count>0){ans= ans+count;}

        return ans;
    }


}
