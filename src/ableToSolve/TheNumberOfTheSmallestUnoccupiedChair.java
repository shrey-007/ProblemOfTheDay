package ableToSolve;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this
 * party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with
 * the smallest number.
 *
 * For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
 * When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at
 * that same moment, they can sit in that chair.
 *
 * You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and
 * leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.
 *
 * Return the chair number that the friend numbered targetFriend will sit on.
 * */
public class TheNumberOfTheSmallestUnoccupiedChair {

    /**
     * 2 heaps are used-:
     * free chairs-: consisting free chairs with chair with min index at top
     * allocated chairs-: consisting allocated chairs with chair with min end time at top
     * */
    public static int smallestChair(int[][] times, int targetFriend) {

        // it is given that arrival time is unique for all, so store the arrival time of target friend
        // else after sorting we will lose the index of target friend
        int targetFriendArrivalTime = times[targetFriend][0];

        // sort the friends on arrival time
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        // free (available) chairs, initially all chairs are empty so put all of them here
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        int n = times.length;
        for (int i = 0; i < n; i++) {
            freeChairs.offer(i);
        }


        PriorityQueue<Pair> allocatedChairs = new PriorityQueue<>();

        // allocate 0th chair to the 0th friend, so 0th chair is allocated so remove it from the free chairs and add it to
        // allocated chairs
        if(targetFriendArrivalTime==times[0][1]){return 0;}
        allocatedChairs.offer(new Pair(0,times[0][0]));
        freeChairs.poll();

        for (int i = 1; i < n; i++) {
            int currStartTime = times[i][0];

            // if some chairs can be freed till this time then free them
            while (allocatedChairs.size()>0 && allocatedChairs.peek().endTime<=currStartTime){
                // remove it from allocated
                int freedChair = allocatedChairs.poll().index;
                // add it to free
                freeChairs.offer(freedChair);
            }

            // now allocate smallest numbered chair to current person
            // remove the least chair from the free chairs
            int allocateChair = freeChairs.poll();
            // add it to allocated chairs
            if(targetFriendArrivalTime==times[i][0]){return allocateChair;}
            allocatedChairs.offer(new Pair(allocateChair,times[i][1]));
        }


        return -1;
    }

    public static void main(String[] args) {
        int arr[][]={{4,5},{12,13},{5,6},{1,2},{8,9},{9,10},{6,7},{3,4},{7,8},{13,14},{15,16},{14,15},{10,11},{11,12},{2,3},{16,17}};
        smallestChair(arr,15);
    }


}
class Pair implements Comparable<Pair>{
    int index;
    int endTime;
    Pair(int i,int e){
        index=i;
        endTime=e;
    }

    @Override
    public int compareTo(Pair o) {
        return this.endTime-o.endTime;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "index=" + index +
                ", endTime=" + endTime +
                '}';
    }
}
