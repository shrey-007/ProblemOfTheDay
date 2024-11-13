package notAbleToSolve;

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    // It is ditto same as minimum number of platforms question in striver A2Z sheet-------------------------
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=0;
        int j=0;
        int count = 0;
        int ans = 0;

        while(i<n && j<n){
            if(start[i]<=end[j]){
                i++;
                count++;
                ans = Math.max(ans,count);
            }
            else{
                j++;
                count--;
            }
        }

        return ans;
    }
}
