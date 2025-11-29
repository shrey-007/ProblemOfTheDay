package notAbleToSolve.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// This is a very-very good question of intervals pattern, so please, atleast solve this one seriously
// this is the youtube link , if you want don;t understand the below solution-: https://www.youtube.com/watch?v=9rCmrMed8h8
public class CheckIfGridCanBeCutIntoSections {
    /**
     * You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner
     * of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form
     * [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:
     *
     * (startx, starty): The bottom-left corner of the rectangle.
     * (endx, endy): The top-right corner of the rectangle.
     * Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:
     *
     * Each of the three resulting sections formed by the cuts contains at least one rectangle.
     * Every rectangle belongs to exactly one section.
     * Return true if such cuts can be made; otherwise, return false.*/

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<Interval> row = new ArrayList<>();
        List<Interval> col = new ArrayList<>();

        int k = rectangles.length;
        for(int i=0;i<k;i++){
            int startx = rectangles[i][0];
            int starty = rectangles[i][1];
            int endx = rectangles[i][2];
            int endy = rectangles[i][3];

            Interval intervalx = new Interval(startx,endx);
            Interval intervaly = new Interval(starty,endy);

            row.add(intervalx);
            col.add(intervaly);
        }

        // sort the interval on start time.
        Collections.sort(row);
        Collections.sort(col);

        return mergeIntervals(row) || mergeIntervals(col);
    }

    public boolean mergeIntervals(List<Interval> list){
        Stack<Interval> stack = new Stack<>();
        for(Interval interval: list){
            if(!stack.isEmpty() && stack.peek().end>interval.start){
                // merge them
                Interval top = stack.pop();
                stack.push(new Interval(Math.min(interval.start,top.start),Math.max(interval.end,top.end)));
            }
            else{
                stack.push(new Interval(interval.start,interval.end));
            }
        }

        return stack.size()>=3;
    }
}

class Interval implements Comparable<Interval>{
    int start;
    int end;
    public Interval(int s,int e){
        start = s;
        end = e;
    }
    public int compareTo(Interval o){
        return this.start-o.start;
    }
}
