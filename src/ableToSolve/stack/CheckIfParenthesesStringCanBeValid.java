package ableToSolve.stack;

import java.util.Arrays;
import java.util.Stack;

public class CheckIfParenthesesStringCanBeValid {
    /**
     * A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following
     * conditions is true:
     *
     * 1. It is ().
     * 2. It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
     * 3. It can be written as (A), where A is a valid parentheses string.
     *
     * You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,
     *
     * 1. If locked[i] is '1', you cannot change s[i].
     * 2. But if locked[i] is '0', you can change s[i] to either '(' or ')'.
     *
     * Return true if you can make s a valid parentheses string. Otherwise, return false.
     * */

    // First i tried solving it using DP, har unlocked index par 2 choices thi, but usse TLE aaya
    // Even after applying memoization, it is showing TLE stuff and memory limit exceeded means it is not a dp question,
    // it greedy
    // It has constraints of n<=10^5 means ki it can only be solved by O(N) algorithm, which is greedy obviously

    public boolean canBeValid(String s, String locked) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        int n = s.length();
        if(n%2==1) return false;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if(locked.charAt(i)=='0'){
                // means is index par open, close koi bhi bracket laga do, toh ise main stack mai nhi open close stack
                // mai daal rha hu
                openClose.push(i);
            }
            else{
                // means ki ye character change nhi ho skta
                // apply same logic of valid parenthesis checker
                if(curr=='('){
                    // since open bracket hai toh stack mai push krdo
                    stack.push(i);
                }
                else{
                    // agar close bracket hai toh ya toh isse pehle koi open bracket aaya ho ya fir koi unlocked character
                    if(!stack.isEmpty()){
                        // if stack is not empty means isse pehle koi open bracket aaya hai jo ise balance kr dega
                        // since usne balance kr diya toh use pop krdo
                        stack.pop();
                    }
                    else{
                        // is stack is empty means ki koi open bracket nhi aaya check kro ki koi esa character aaya hai jo
                        // change kr skte ho jiska locked[i]=0 ho
                        if(!openClose.isEmpty()){
                            // means ki pehle koi unlocked character aaya tha jise apan open bracket bana dege jo ise
                            // balance kr dega
                            // since usne balance kr diya toh use pop krdo
                            openClose.pop();
                        }
                        else{
                            // means koi bhi closing bracket ko balance krne vaala nhi hai
                            return false;
                        }
                    }
                }
            }
        }



        // This above loop made sure ki agar koi closing bracket hai jo ki balance ni ho rha hai toh return false
        // agar yaha tak aaye means closing brackets are balanced
        // But opening brackets may not be balanced , opening brackets are in stack
        while (!stack.isEmpty()){
            int index = stack.pop();
            if(openClose.isEmpty()) return false;
            int indexOfLastUnlocked = openClose.pop();
            if(indexOfLastUnlocked>=index){
                // means ki this open bracket can be balanced with a unlocked character which is located right of it
                // means open vala pehle hai since uska index chota hai
            }
            else{
                // means ki humare paas esa character toh hai jo change ho skta hai but voh pehle hi aagya , open bracket
                // ko balance krne ke liye close vaala uske baad aana chaiye
                return false;
            }
        }

        return true;
    }


    // It has one more very small code, but not much intuitive like the above one

}
