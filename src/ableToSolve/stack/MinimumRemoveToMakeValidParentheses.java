package ableToSolve.stack;

public class MinimumRemoveToMakeValidParentheses {
    // It is not like RemoveInvalidParentheses(which is leetcode hard and require BFS solution)
    // It is like MinRemoveToMakeValid
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        int n = s.length();
        String ans = "";

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='('){
                // add the ( in the ans
                ans += curr;
                count++;
            }
            else if(curr==')'){
                count--;
                // if count<0 means ye ) galat jagah hai toh ise remove kro toh ise ans mai add mat kro
                if(count<0) count = 0;
                // agar count>=0 means ye ) sahi hai and ise ans mai add krdo
                else ans += curr;
            }
            else{
                // means ki ye a,b,c,d hai toh ise direct add krdo
                ans += curr;
            }
        }

        // esa krne se saare ) jo galat jagah hai nikal jaaege.
        // ab agar count>0 hai toh means ki ( jyaada hai and unhe remove krna hai hai, toh unhe last se remove kro


        int i = ans.length()-1;
        while(i>=0 && count>0){
            char curr = ans.charAt(i);
            if(curr=='('){
                ans = ans.substring(0,i)+ans.substring(i+1);
                count--;
            }
            i--;
        }


        return ans;
    }
}
