package ableToSolve.stack;

public class MinRemoveToMakeValid {
    // This question is not on leetcode, this is made by me
    // Given a string s, find min number of removals of brackets, to make the parethesis valid

    // No need to do this, it will work with the same code min add to make s valid
    public int minRemoveToMakeValid(String s) {
        int open = 0, remove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--; // matched with an earlier '('
                } else {
                    remove++; // unmatched ')'
                }
            }
        }

        return remove + open; // unmatched ')' + unmatched '('
    }

}
