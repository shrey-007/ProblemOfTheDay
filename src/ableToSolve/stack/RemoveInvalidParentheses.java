package ableToSolve.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        // generate all possible string after removal of characters
        func(s,0,0,"",ans,n);
        // find min removal required to make s valid
        int minRemoval = minRemovalToMakeValid(s);
        // find length string after removing min characters
        int length = n-minRemoval;
        // add only those strings to ans whose length is equal to length
        List<String> ans2 = new ArrayList<>();
        for(String ss: ans){
            if(ss.length()==length) ans2.add(ss);
        }
        return ans2;
    }


    // find min number of removals req to make s valid, it is already done in previous questions
    public int minRemovalToMakeValid(String s) {
        int count=0;
        int n=s.length();
        int ans=0;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){count++;}
            else if(s.charAt(i)==')'){count--;}
            if(count<0){ans++;count=0;}
        }

        if(count>0){ans= ans+count;}

        return ans;
    }

    // generate all possible removals.
    public void func(String s,int index,int count,String currAns,Set<String> ans,int n){
        if(index==n){
            if(count==0) ans.add(currAns);
            return;
        }
        char curr = s.charAt(index);
        // skip current character
        func(s,index+1,count,currAns,ans,n);
        // take current character
        if(curr=='('){
            // we can directly take opening bracket
            func(s,index+1,count+1,currAns+curr,ans,n);
        }
        else if(curr==')' && count!=0){
            // we can only take closing bracket , if after adding this bracket, count does not become negative
            // when we add a closing bracket we decrease the count by 1
            // so it will become negative if current count is 0
            func(s,index+1,count-1,currAns+curr,ans,n);
        }
        else if(curr!='(' && curr!=')') func(s,index+1,count,currAns+curr,ans,n);
    }

}
