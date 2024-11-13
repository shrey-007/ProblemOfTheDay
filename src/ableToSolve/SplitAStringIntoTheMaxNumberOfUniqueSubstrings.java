package ableToSolve;

import java.util.HashSet;

/**
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 *
 * You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the
 * original string. However, you must split the substrings such that all of them are unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 * */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    // The concept is same as palindromic partition in striver A2Z
    public int maxUniqueSplit(String s) {
        // pass the answer array to update answer at base case
        int ans[] = new int[1];
        // empty string bhej kr 0 index se start ni kr skte kiuki, jab f("",0) call hoga toh usme voh case chalega jab
        // vo current character ko nhi lega and purani string ko break krke new string banaega, and purani string empty hai
        // toj isliye 1 se bheja
        func(s,1,ans,""+s.charAt(0),0,new HashSet<>());
        return ans[0];
    }

    public void func(String s, int index, int ans[], String currentString, int count, HashSet<String> hashSet){
        if(index==s.length()){
            // abhi currentString mai koi string hogi jiska count add ni hua hai , now ya toh voh string hashset mai pehle
            // se exist krti hogi ya nhi , if yes then count ko negative infinity krdo else count++ krdo
            if(!hashSet.contains(currentString)){count++;}
            else if(hashSet.contains(currentString)){count=Integer.MIN_VALUE;}
            ans[0]=Math.max(ans[0],count);
            return;
        }
        char curr = s.charAt(index);
        // we have 2 choices either we include current character in the string or we create a new string from this character

        // include curr, since new string form nhi hui toh count is same, but currentString mai curr ko add krege
        func(s,index+1,ans,currentString+curr,count,hashSet);

        // don't include curr, means ki new string form hui hai curr se pehle vaali
        // but ye step apan tabhi perform kr stke hai jab curr se pehle jo new string form hui hai "currentString" voh unique ho
        // now jo next string hogi voh curr se start hogi
        if(!hashSet.contains(currentString)){
            // since hashset does not contain currentString means it is unique so we can add break it
            hashSet.add(currentString);
            func(s,index+1,ans,""+curr,count+1,hashSet);
            // since backtrack kr rhe hai toh hashset se remove kro currentString ko
            hashSet.remove(currentString);
        }

    }


}
