package ableToSolve;

import java.util.PriorityQueue;

/**
 * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer
 * array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total
 * students, but only passi number of students will pass the exam.
 *
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed
 * to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class
 * in a way that maximizes the average pass ratio across all the classes.
 *
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total
 * number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the
 * number of the classes.
 *
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of
 * the actual answer will be accepted.
 * */
public class MaximumAveragePassRatio {
    /**
     *  Approach is simple-:
     *  1. Agar ek class mai pass ratio 1 hai toh usme ek extra student add krne par jo ki pass hoga usse koi farak nhi
     *     padega ratio mai voh ratio 1 hi rahega
     *  2. Toh ese class mai student add kro jime student ko add krne pe ratio mai bahut bada change aaye, voh class apan
     *     heap se le lenge bas comparator mai logic lagana hai ki classes ko ese sort kro ki 1 student aane par jo change
     *     ho rha hai uske basis pr sorting ho
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int n = classes.length;

        double average = 0.0;

        for (int i = 0; i < n; i++) {
            if(classes[i][0]==classes[i][1]){
                average++;
                continue;
            }
            Pair pair = new Pair(classes[i][0],classes[i][1]);
            priorityQueue.offer(pair);
        }

        if(priorityQueue.size()==0) return average/n;

        while (extraStudents>0){
            Pair pair = priorityQueue.poll();
            pair = new Pair(pair.toppers+1,pair.students+1);
            priorityQueue.offer(pair);
            extraStudents--;
        }

        while (!priorityQueue.isEmpty()){
            Pair pair = priorityQueue.poll();
            average = average + (pair.toppers*1.0)/(pair.students*1.0);
        }

        average = average/n;

        return average;
    }

    public static void main(String[] args) {
        MaximumAveragePassRatio maximumAveragePassRatio = new MaximumAveragePassRatio();
        int arr[][]={{1,2},{3,5},{2,2}};
        int arr2[][]={{2,4},{3,9},{4,5},{2,10}};
        System.out.println(maximumAveragePassRatio.maxAverageRatio(arr,2));
        System.out.println(maximumAveragePassRatio.maxAverageRatio(arr2,4));
    }
    class Pair implements Comparable<Pair>{
        int toppers;
        int students;

        public Pair(int toppers, int students) {
            this.toppers = toppers;
            this.students = students;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.students!=o.students){return o.students-this.students;}
            double currentRatio1 = (this.toppers*1.0)/(this.students*1.0);
            double currentRatio2 = (o.toppers*1.0)/(o.students*1.0);

            double newRatio1 = (this.toppers*1.0+1)/(this.students*1.0+1);
            double newRatio2 = (o.toppers*1.0+1)/(o.students*1.0+1);

            double change1 = newRatio1-currentRatio1;
            double change2 = newRatio2-currentRatio2;

            return Double.compare(change2, change1);
        }
    }
}
