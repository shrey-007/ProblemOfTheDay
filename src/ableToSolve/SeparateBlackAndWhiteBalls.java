package ableToSolve;

import java.util.Stack;

/**
 * There are n balls on a table, each ball has a color black or white.
 *
 * You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.
 *
 * In each step, you can choose two adjacent balls and swap them.
 *
 * Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
 * */
public class SeparateBlackAndWhiteBalls {

    /**
     * Just simple observation suppose string 111000 hoti toh pehle 2,3 index vale swap hote.
     * 110100 fir 1,2 index vaale swap hote
     * 101100 fir 0,1 index vale swap hote
     * 011100 toh 3 swaps ke baad ek zero apni sahi place pr aaya abhi 2 zeroes aur hai unme bhi same number of swaps lagege
     * Toh basically ith 0 ko left mai laane mai kitne swaps lagege = number of 1's from 0 to i-1
     * */

    public long minimumSteps(String s) {
        int n=s.length();
        long count = 0;

        Stack<Character> stack  = new Stack<>();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='1'){stack.push(curr);}
            else{
                count = count+stack.size();
            }
        }
        return count;
    }

    // or you can easily do this using
    public long minimumSteps2(String s) {
        int n=s.length();
        long countOfOnes = 0;
        long count = 0;


        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='1'){countOfOnes++;}
            else{
                count = count+countOfOnes;
            }
        }
        return count;
    }

}
