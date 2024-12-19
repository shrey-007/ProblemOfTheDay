package ableToSolve;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 *
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating
 * them, the result should equal the sorted array.
 *
 * Return the largest number of chunks we can make to sort the array.
 * */
public class MaxChunksToMakeSorted {
    // question is saying ki pehele partition kro, fir individual parttion ko sort kro. Fir unhe concatenate kro
    // Agar concatenate krne pr sorted array aaya tan toh theek h else voh parttion invalid hai
    // maximum partition krne hai
    public int maxChunksToSorted(int[] arr) {
        // sabse chota element milne ke liye
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // element-> index mapping ke liye
        HashMap<Integer,Integer> hashMap = new HashMap<>();


        // insert values into hashmap and heap
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(arr[i]);
            hashMap.put(arr[i],i);
        }

        // number of partition
        int partition = 0;
        // number of elements covered by partition
        int elementsCovered = 0;

        while (!priorityQueue.isEmpty()){
            // get the index and value of the smallest element which is not included in any partition
            int element = priorityQueue.poll();
            int index = hashMap.get(element);

            // if partition = 0, this is the first time we are doing partition.
            if(partition==0){
                // increase count
                partition++;
                // since we have included "element" into the partition which is at index "index",
                // means we have included "index+1" elements into the partition, since those elements are already incuded
                // in a partition so we will remove them from heap
                elementsCovered = index+1;
                // remove elements from heap, who are already included in the partition
                for (int i = 0; i < index; i++) {
                    priorityQueue.remove(Integer.valueOf(arr[i]));
                }
            }
            // means we have already made some partition and this current "element" is not included in them
            else{
                // since apan yaha aaye means this element is not covered in any partition, so either we create a new
                // partition or we extend the previous one

                // we can create a new partition only if number of elements covered is == element
                if(elementsCovered==element){
                    // create new partition
                    partition++;
                    // and update elements covered
                    for (int i = elementsCovered; i <index ; i++) {
                        priorityQueue.remove(Integer.valueOf(arr[i]));
                    }
                    elementsCovered = index+1;
                }

                else{
                    // else we have to extend the partition
                    for (int i = elementsCovered; i <index ; i++) {
                        priorityQueue.remove(Integer.valueOf(arr[i]));
                    }
                    elementsCovered = index+1;
                }

            }
        }

        return partition;
    }

}

