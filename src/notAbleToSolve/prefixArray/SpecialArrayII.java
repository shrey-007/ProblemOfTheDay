package notAbleToSolve.prefixArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 *
 * You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task
 * is to check that subarray nums[fromi..toi] is special or not.
 *
 * Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 * */
public class SpecialArrayII {

    // Method1-:
    // I am going to tell how i solved this question
    // Brute force way is ki tum har query ke liye start to end iterate kro and search kro ki usme special indices hai ki nhi
    // TC-: m*n (m=length of queries, n=length of array)

    // Method2-:
    // Iterate only once and store the special indices in a list(n)
    // suppose ith and (i+1)th index mai same parity hai toh ith index ko store kro list mai
    // now iterate over queries array and check ki ith query mai list ka koi element toh nhi hai
    // suppose list mai 4 hai. Means ki 4th and 5th index ki parity same hai toh agar query is [4,4],[4,7],[3,8] toh in
    // queries mai false jaaega and if query is [2,4] toh usme true hoga. toh iska logic dekh lena
    // In worst case esa ho skta hai ki saare hi list ke elements special ho toh TC-: m*n
    public boolean[] isArraySpecial2(int[] nums, int[][] queries) {

        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(sameParity2(nums[i],nums[i+1])){
                list.add(i);
            }
        }

        int m = queries.length;
        boolean ans[] = new boolean[m];
        for(int i=0;i<m;i++){
            ans[i] = true;
        }
        int k = list.size();
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                int left = queries[i][0];
                int right = queries[i][1];
                int current = list.get(j);

                if(left==current){
                    if(right!=current) ans[i] = false;
                }
                else if(right==current){
                    // true
                }
                else if(current>left && current<right){
                    // false
                    ans[i] = false;
                }
            }
        }

        return ans;
    }


    public boolean sameParity2(int i,int j){
        int ia = i%2;
        int ja = j%2;
        return ia==ja;
    }

    // Method3-:
    // special indices ko list mai store kro as previous
    // sort the queries array on start time
    // ab tumhe har query mia nhi dekhna ki speacial indices aa rhe hai ki nhi, tumhe bas Binary search lagana hai
    // suppose list mai 5 hai, and queries={(3,20),(3,15),(5,11),(9,12),(13,17),(17,20)}
    // toh yaha un queries ko ignore kro jinka start index special index ke baad aata hai like ignore queries-: (9,12),(13,17),(17,20)
    // u can find (9,12) through binary search and loop from 3,20 to 5,11 ye check krne ke liye ki unme kya hoga, 9.12 ke baad se toh true hi aaega

    // time complexity-: n for first loop (list)
    //                   logm for second loop(find the query jiske baad ki queries ko ignore krna hai let x)
    //                   loop from 0 to x
    // in worst case x could be m itself so TC-: m*n
    public boolean[] isArraySpecial3(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        List<Integer> list = new ArrayList();
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(sameParity3(nums[i],nums[i+1])){
                list.add(i);
            }
        }

        int m = queries.length;
        boolean ans[] = new boolean[m];
        for(int i=0;i<m;i++){
            ans[i] = true;
        }
        int k = list.size();

        for(int i=0;i<k;i++){
            int current = list.get(i);
            int high = m-1;
            int low = 0;
            int till = m;
            while(low<=high){
                int mid = (low+high)/2;
                if(queries[mid][0]>current){
                    till = mid;
                    high = mid-1;
                }
                else{
                    low = mid + 1;
                }
            }

            for(int j=0;j<till;j++){
                int left = queries[j][0];
                int right = queries[j][1];

                if(left==current){
                    if(right!=current) ans[i] = false;
                }
                else if(right==current){
                    // true
                }
                else if(current>left && current<right){
                    // false
                    ans[i] = false;
                }
            }
        }

        return ans;
    }

    public boolean sameParity3(int i,int j){
        int ia = i%2;
        int ja = j%2;
        return ia==ja;
    }


    // Best way is using prefix sum
    // TC-: O(n)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Create an array to mark special indices
        boolean[] isSpecial = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            isSpecial[i] = sameParity(nums[i], nums[i + 1]);
        }

        // Create a prefix sum to count special indices
        int[] prefixSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isSpecial[i] ? 1 : 0);
        }

        // Answer each query
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // Check if there are any special indices in the range
            int countSpecial = prefixSum[right] - prefixSum[left];
            ans[i] = countSpecial == 0;
        }

        return ans;
    }

    public boolean sameParity(int i, int j) {
        return (i % 2) == (j % 2);
    }





}
