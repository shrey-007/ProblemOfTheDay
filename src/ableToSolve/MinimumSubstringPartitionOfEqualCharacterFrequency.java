package ableToSolve;

public class MinimumSubstringPartitionOfEqualCharacterFrequency {
    /**
     * Given a string s, you need to partition it into one or more balanced substrings
     *
     * For example, if s == "ababcc" then ("abab", "c", "c"), ("ab", "abc", "c"), and ("ababcc") are all valid
     * partitions, but ("a", "bab", "cc"), ("aba", "bc", "c"), and ("ab", "abcc") are not. The unbalanced substrings
     * are bolded.
     *
     * Return the minimum number of substrings that you can partition s into.
     *
     * Note: A balanced string is a string where each character in the string occurs the same number of times.
     * */

    /**
     * we have to partition the string into substring following some constraint, so this is similar to palindrome
     * partitioning. But the constraint here is ki hum tabhi parttion kr skte hai if the substring has equal frequencies
     * of all characters.
     * Toh hum jab run krege toh har substring par check krna padega ki voh possible hai ki nhi toh prefix array bana lo
     * har character ka i.e 26 characters ka
     * */
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;

        // create prefix array of 26 characters
        // col[0] is prefix of a, col[1] is prefix of b and so on...
        int freq[][] = new int[n][26];

        freq[0][s.charAt(0)-'a']++;

        for(int i=1;i<n;i++){
            char curr = s.charAt(i);
            for(char c='a';c<='z';c++){
                if(c==curr) freq[i][c-'a'] = freq[i-1][c-'a']+1;
                else freq[i][c-'a'] = freq[i-1][c-'a'];
            }
        }


        int ans =  func(s,0,n,freq);
        if(ans>=(int)1e9) return 1;
        return ans;
    }

    // palindrome partition code
    public int func(String s,int index,int n,int freq[][]){
        if(index==n) return 0;
        int ans = (int)1e9;
        for(int i=index;i<n;i++){
            // divide from index to i
            if(canDivide(s,index,i,freq)){
                int faith = func(s,i+1,n,freq)+1;
                ans = Math.min(ans,faith);
            }
        }

        return ans;
    }

    public boolean canDivide(String s,int start,int end,int freq[][]){
        // now we have to check ki start to end sab characters ki freq same hai ki nhi, uske liye start to end iterate
        // krne ki need nhi hai. We have prefix array

        // freq[end][0] is the count of 'a' from 0 to end, freq[start][0] is the count of 'a'
        // from 0 to start. So freq[end][0]-freq[start-1][0] is the count of 'a' from start to end

        // similarly freq[end][1]-freq[start-1][1] is the count of 'b' from start to end
        // means freq[end][i]-freq[start-1][i] is the count of 'i'th from start to end

        // a,b,c,d.. in sab ki freq same hone chaiye if they are present i.e if inki freq!=0 hai toh sabki freq same honi chaiye
        // toh bas usi ka check hai
        int requireFreq = -1;

        for(char c='a'; c<='z';c++){
            int currFreq = -1;
            if(start==0) currFreq = freq[end][c-'a'];
            else currFreq = freq[end][c-'a']-freq[start-1][c-'a'];
            if(currFreq==0) continue;
            else{
                if(requireFreq==-1) requireFreq = currFreq;
                else{
                    if(requireFreq!=currFreq) return false;
                }
            }
        }

        return true;
    }
}
