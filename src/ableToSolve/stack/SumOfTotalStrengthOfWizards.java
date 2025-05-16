package ableToSolve.stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfTotalStrengthOfWizards {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int nse[] = nse(strength,n);
        int pse[] = pse(strength,n);
        int prefix[] = prefixSum(strength,n);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int numberOfSubarrayInWhichCurrIsSmalllest = (nse[i]-i)*(i-pse[i]);
            int val2 = 0;
            int sumOfRightSubarray = prefix[nse[i]-1]-prefix[i];;

            int sumOfLeftSubarray = 0;
            if(pse[i]!=-1) sumOfLeftSubarray = prefix[i]-prefix[pse[i]]-strength[i];
            else sumOfLeftSubarray = prefix[i]-strength[i];

            val2 += sumOfLeftSubarray*(nse[i]-i)+sumOfRightSubarray*(i-pse[i]);
            val2 += strength[i]*numberOfSubarrayInWhichCurrIsSmalllest;

            ans += strength[i]*val2;
        }

        return ans;
    }

    public int[] prefixSum(int arr[],int n){
        int sum = 0;
        int prefix[] = new int[n];

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefix[i] = sum;
        }

        return prefix;
    }
    public int[] nse(int arr[],int n){
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            int curr = arr[i];
            // first find ki ye kisika nse ha kya
            while(!stack.isEmpty() && arr[stack.peek()]>curr){
                nse[stack.pop()] = i;
            }
            // now put this to get the nse of this element
            stack.push(i);
        }

        // the elements jinke nse nhi mile, unhe n set krdo
        while(!stack.isEmpty()){
            nse[stack.pop()] = n;
        }
        return nse;
    }

    public int[] pse(int arr[],int n){
        int pse[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int curr = arr[i];
            // first find ki ye kisika pse ha kya
            while(!stack.isEmpty() && arr[stack.peek()]>curr){
                pse[stack.pop()] = i;
            }
            // now put this to get the pse of this element
            stack.push(i);
        }

        // the elements jinke pse nhi mile, unhe -1 set krdo
        while(!stack.isEmpty()){
            pse[stack.pop()] = -1;
        }
        return pse;
    }



    public static void main(String[] args) {
//        int arr[] = {3,1,2,4};
        SumOfTotalStrengthOfWizards sumOfTotalStrengthOfWizards = new SumOfTotalStrengthOfWizards();
//        int nse[] = sumOfTotalStrengthOfWizards.nse(arr,arr.length);
//        int pse[] = sumOfTotalStrengthOfWizards.pse(arr, arr.length);
//        int prefix[] = sumOfTotalStrengthOfWizards.prefixSum(arr, arr.length);
//        Arrays.stream(nse).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(pse).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(prefix).forEach(System.out::print);
        int arr2[] = {5,4,6};
        int arr3[] = {1,3,7,2};
        System.out.println(sumOfTotalStrengthOfWizards.totalStrength(arr3));
    }
}
