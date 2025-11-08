package ableToSolve.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    /**
     *                                         Leetcode 904. Fruit Into Baskets
     *
     *
     * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     *
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     *
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick
     * */
    public int totalFruit(int[] fruits) {
        // this is longest subarray with atmost 2 distinct integers , so this is sliding window question
        int start = 0;
        int end = 0;
        int n = fruits.length;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        while(end<n){
            hm.put(fruits[end],hm.getOrDefault(fruits[end],0)+1);
            if(hm.size()<=2){
                ans = Math.max(ans,updateAns(hm));
                end++;
            }
            else{
                while(hm.size()>2){
                    int fruitAtStart = fruits[start];
                    hm.put(fruitAtStart,hm.get(fruitAtStart)-1);
                    if(hm.get(fruitAtStart)==0) hm.remove(fruitAtStart);
                    start++;
                }
                end++;
            }
        }

        return ans;
    }

    public int updateAns(HashMap<Integer,Integer> hm){
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            count += entry.getValue();
        }
        return count;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int arr[] = {1,2,3,2,2};
        System.out.println(fruitIntoBaskets.totalFruit(arr));
    }
}
