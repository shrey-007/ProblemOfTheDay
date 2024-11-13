package ableToSolve;

import java.util.PriorityQueue;


/**
 * You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.
 *
 * In one operation:
 *
 * choose an index i such that 0 <= i < nums.length,
 * increase your score by nums[i], and
 * replace nums[i] with ceil(nums[i] / 3).
 * Return the maximum possible score you can attain after applying exactly k operations.
 *
 * The ceiling function ceil(val) is the least integer greater than or equal to val.
 * */

/**
 * The concept is simple hume k times operations krne hai
 * Har operation mai hume array ka max element lena hai and uspr operation krna hai, toh har baar max chaiye toh use max heap
 * toh top har operation mai top element ko pop kro, score add kro, us element ka score ko change kro and again add it to max heap
 * */
public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        long score = 0;

        PriorityQueue<IndexScore> priorityQueue = new PriorityQueue<>();

        // put all elements inside priorityQueue
        int n = nums.length;
        for (int i = 0; i <n ; i++) {
            priorityQueue.offer(new IndexScore(i,nums[i]));
        }

        // perform operations k times
        while (k!=0){
            // pop the top element with mx score
            IndexScore indexScore = priorityQueue.poll();
            // add the score
            score = score+indexScore.score;
            // change its score
            indexScore.score=Math.ceilDiv(indexScore.score,3);
            // again add to maxheap
            priorityQueue.offer(indexScore);
            k--;
        }

        return score;
    }

    class IndexScore implements Comparable<IndexScore>{
        int index;
        int score;

        public IndexScore(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(IndexScore o) {
            return o.score-this.score;
        }

        @Override
        public String toString() {
            return "IndexScore{" +
                    "index=" + index +
                    ", score=" + score +
                    '}';
        }
    }
}

