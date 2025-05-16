package ableToSolve.stack;

public class LongestValidParentheses {
    public int func(String s){
        int start = 0;
        int end = 0;

        int n = s.length();
        int count = 0;
        int ans = 0;

        while (end<n){
            char curr = s.charAt(end);
            if(curr=='('){count++;}
            else{count--;}

            if(count==0){
                // equal number of opening and closing brackets, so update ans
                ans = Math.max(ans,end-start+1);
                end++;
            }
            else if(count>0){
                // more number of opening brackets
                end++;
            }
            else{
                // more number of closing bracket, so do start++ until count>=0
                while(count<0){
                    char charAtStart = s.charAt(start);
                    // since ( contributed to count++, but now we are removing this,so so count--
                    if(charAtStart=='('){count--;}
                    // since ) contributed to count-- but now we are removing this, so count++
                    else{count++;}
                    start++;
                }
                if(count==0) ans = Math.max(ans,end-start+1);
                end++;
            }
        }
        return ans;
    }

    // this is not working.
    // You have to do this twice, one from 0 to n-1 and one from n-1 to 0
    // suppose you are given

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int open = 0, close = 0;

        // Left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        // Right to left
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.func(")()())"));
    }
}
