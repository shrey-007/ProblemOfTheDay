package ableToSolve;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI {
    /**
     * You are given a string s that consists of lowercase English letters.
     *
     * A string is called special if it is made up of only a single character. For example, the string "abc" is not
     * special, whereas the strings "ddd", "zz", and "f" are special.
     *
     * Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special
     * substring occurs at least thrice.
     *
     * A substring is a contiguous non-empty sequence of characters within a string.
     * */

    // sometime if u don't understand anything , just apply brute force
    public int maximumLength(String s) {

        int n = s.length();
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i,j+1);
                boolean isSpecial = true;
                for(int k=i;k<j;k++){
                    if(s.charAt(k)!=s.charAt(k+1)){
                        isSpecial = false;
                    }
                }
                if(isSpecial) hashMap.put(substring,hashMap.getOrDefault(substring,0)+1);
            }
        }

        int max = -1;

        for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
            if(entry.getValue()>=3){
                max = Math.max(max,entry.getKey().length());
            }
        }

        return max;
    }
}
