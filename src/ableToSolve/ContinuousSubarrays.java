package ableToSolve;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
 *
 * Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j,
 * 0 <= |nums[i1] - nums[i2]| <= 2.
 * Return the total number of continuous subarrays.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * */
public class ContinuousSubarrays {

    // since it is a subarray question, first thing that clicks is sliding window
    public long continuousSubarrays2(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int start = 0;
        int end = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (end<n){
            // update min and max
            max = Math.max(max,nums[end]);
            min = Math.min(min,nums[end]);

            if(max-min<=2){
                // means this is possible ans
                ans = ans + end-start+1;
                end++;
            }

            else{
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

                for (int i = start; i <=end ; i++) {
                    minHeap.offer(nums[i]);
                    maxHeap.offer(nums[i]);
                }

                while (max-min>2){
                    minHeap.remove(Integer.valueOf(nums[start]));
                    maxHeap.remove(Integer.valueOf(nums[start]));
                    min = minHeap.peek();
                    max = maxHeap.peek();
                    start++;
                }
                // important thing is ki ab jaise hi loop khatam hui toh max-min<=2 ho jaaege toh start to end is now
                // an valid ans, but tumne is answer ko include nhi kra abhi tak toh isliye end++ mat kro
                // next iteration mai end ki calculations apne aap add ho jaaegi\

                // or if u want toh yahi add krdo end ki calculations and end++ krdo
            }
        }

        return ans;
    }

    // har baar min, max element ke liye heap use kr rhe the jo ki inefficient hai
    // toh aditya verma ne sliding mai ek concept bataya tha maxElementInEachWindow mai voh concept lagaya
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int start = 0;
        int end = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        List<Integer> minheap = new ArrayList<>();  // 0th element gives min
        List<Integer> maxheap = new ArrayList<>();  // 0th element gives max

        while (end<n){
            // update min and max
            max = Math.max(max,nums[end]);
            min = Math.min(min,nums[end]);
            // do work
            while(!minheap.isEmpty() && minheap.get(minheap.size()-1)>nums[end]){
                minheap.remove(minheap.size()-1);
            }
            minheap.add(nums[end]);

            // do work
            while(!maxheap.isEmpty() && maxheap.get(maxheap.size()-1)<nums[end]){
                maxheap.remove(maxheap.size()-1);
            }
            maxheap.add(nums[end]);

            if(max-min<=2){
                // means this is possible ans
                ans = ans + end-start+1;
                end++;
            }

            else{
                while (max-min>2){
                    if(maxheap.get(0)==nums[start]){maxheap.remove(0);}
                    if(minheap.get(0)==nums[start]){minheap.remove(0);}
                    min = minheap.get(0);
                    max = maxheap.get(0);
                    start++;
                }
                // important thing is ki ab jaise hi loop khatam hui toh max-min<=2 ho jaaege toh start to end is now
                // an valid ans, but tumne is answer ko include nhi kra abhi tak toh isliye end++ mat kro
                // next iteration mai end ki calculations apne aap add ho jaaegi

                // or if u want toh yahi add krdo end ki calculations and end++ krdo
                ans = ans + end-start+1;
                end++;
            }
        }

        return ans;
    }

}
