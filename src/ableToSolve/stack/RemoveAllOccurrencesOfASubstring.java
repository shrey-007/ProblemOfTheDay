package ableToSolve.stack;

import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {
    /**
     * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
     *
     * Find the leftmost occurrence of the substring part and remove it from s.
     * Return s after removing all occurrences of part.
     *
     * A substring is a contiguous sequence of characters in a string.
     * */

    // first is simple brute force, find first occurence of part, remove it and then again do the same from the start of the string
    // Note that a new occurrence of pattern can appear if you remove an old one, For example, s = "ababcc" and pattern = "abc".
    // means ith character ko delete krne se ho skta hai new substring bane jisme i se pehle valo ko delete krna pade, so use stack
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();

        int m = s.length();
        int n = part.length();

        // iterate over s
        for (int i = 0; i < m; i++) {
            char curr = s.charAt(i);
            stack.push(curr);

            if(stack.size()>=n && isSubstring(part,n,stack)){
                for (int j = 0; j < n; j++) stack.pop();
            }
        }

        String ans = "";
        while (!stack.isEmpty()){
            ans = stack.pop() + ans;
        }

        return ans;
    }

    private boolean isSubstring(String part, int n, Stack<Character> stack) {
        // you can use another temporary stack
        for (int i = 0; i < n; i++) {
            if (stack.get(stack.size() - n + i) != part.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
