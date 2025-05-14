package notAbleToSolve.slidingWindow;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * */


import java.util.HashMap;

/**
 * My approach-:
 * Method 1-: s1 ke saare possible permutations banao and check kro ki voh s2 ki substring hai ki nhi using KMP
 * Method 2-: Since hume order se lena dena nhi hai ki s1 ke characters kis order mai s2 mai aa rhe toh simply ek hashmap
 *            banao s1 ka and dekho ki vahi characters s2 ki kisi substring mai aa rhe hai kya. Means we have to check ki
 *            s1 , s2 ki substring ki anagram hai ki nhi
 * Method 3-: Since isme repeated calculations hai har substring of s2 ke liye hashmap banana padega, and ye substring ka
 *            question hai toh slinding window aana chaiye dimaag mai. It is a fixed size slinding window problem which we
 *            already solved in Aditya Verma Playlist, bas usme find whether s2 contains anagram of s1 poocha tha, yaha
 *            usi cheej ko ghuma ke pooch liya and ye mujhe click nhi kra pehli baar mai
 *            Then i opened solution, toh mujhe pata pada it is sliding window , toh uske baad poora code khud likha
 *            */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> hashMap = new HashMap<>();

        // create hashmap for s1
        int k = s1.length();   // size of the window
        for(int i = 0; i<k; i++){
            hashMap.put(s1.charAt(i),hashMap.getOrDefault(s1.charAt(i),0)+1);
        }

        int size = hashMap.size();

        // iterate over s2, it is fixed size window
        int start = 0;
        int end = 0;
        int n = s2.length();

        while(end<n){
            // do work on end
            char charAtEnd = s2.charAt(end);
            if(hashMap.containsKey(charAtEnd)){
                hashMap.put(charAtEnd,hashMap.get(charAtEnd)-1);
                if(hashMap.get(charAtEnd)==0){size--;}
            }

            if(end-start+1<k){
                end++;
            }

            else if(end-start+1==k){
                // it can be a answer so check whether this window is permutation of s1 or not
                if(size==0){return true;}

                // maintain window
                // remove calculation of start
                char charAtStart = s2.charAt(start);
                if(hashMap.containsKey(charAtStart)){
                    hashMap.put(charAtStart,hashMap.get(charAtStart)+1);
                    if(hashMap.get(charAtStart)==1){size++;}
                }
                // increase start
                start++;

                // increase end
                end++;
            }
        }

        // if code comes here means there is no permutation
        return false;

    }


}
