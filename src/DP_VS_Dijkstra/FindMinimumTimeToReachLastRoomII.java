package DP_VS_Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII {
    /**
     * There is a dungeon with n x m rooms arranged as a grid.
     *
     * You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when
     * you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room.
     * Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between
     * the two.
     *
     * Return the minimum time to reach the room (n - 1, m - 1).
     *
     * Two rooms are adjacent if they share a common wall, either horizontally or vertically
     * */
    public int minTimeToReach(int[][] moveTime) {
        // agar current move krne mai 1 sec ka time laga toh next move krne mai 2 sec ka time lagega
        // agar current move krne mai 2 sec ka time laga toh next move krne mai 1 sec ka time lagega
        // so we have alter the cost, toh uske liye flag variable le liya
        // flag-true-1 sec move time
        // flag-false-2 sec move time
        // intial-true
        int n = moveTime.length;
        int m = moveTime[0].length;
        return func(moveTime,0,0,new int[n][m],true,0,n,m);
    }
    public int func(int[][] moveTime,int row,int col,int visited[][],boolean flag,int timePassed,int n,int m){
        if(row==n-1 && col==m-1) return timePassed;
        if(row>=n || col>=m) return Integer.MAX_VALUE;

        // we have 4 options
        int r[] = {-1,1,0,0};
        int c[] = {0,0,-1,1};

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<4;i++){
            int newX = row+r[i];
            int newY = col+c[i];
            // if the neighbour cell is unvisited so visit it
            if(newX>=0 && newX<n && newY>=0 && newY<m && visited[newX][newY]==0){
                int move = 0;
                if(flag) move = 1;
                else move = 2;
                visited[newX][newY] = 1;
                // suppose abhi time 6 hai and and neighbour cell ki value 2 hai means ki neighbour cell mai jaa
                // sakte hai bas jaane ka time lagega 1 or 2
                if(timePassed>=moveTime[newX][newY]){
                    ans = Math.min(ans,func(moveTime,newX,newY,visited,!flag,timePassed+move,n,m));
                }
                // suppose abhi time 0 hai and neighbour cell ki value 4 hai toh t=4 par jaaege and fir jaane mai bhi
                // time lagega
                else{
                    ans = Math.min(ans,func(moveTime,newX,newY,visited,!flag,moveTime[newX][newY]+move,n,m));
                }
                visited[newX][newY] = 0;
            }
        }

        return ans;
    }

    // This solution is working completely fine. Everything is correct
    // The problem is it checks every possibility.
    // (0,0) to (n-1,m-1) jaane ki saari possibilities mai se min nikaalega, hence time complexity is high
    // also DP is complicated kiuki parameter are not only (row,col), instead parameters are (row,col,timePassed,flag) 4d array banana padega memoization ke liye

    // You better use Dijkstra here
    // Dijkstra's algorithm ensures we explore paths in order of increasing time, so the first time we reach (n-1, m-1), it's the minimum possible time.

    // Ypu should read this -: https://grok.com/chat/e762d622-c945-4a3d-bce1-3ad74b56effe


    class Solution {
        public int minTimeToReach(int[][] moveTime) {
            int n = moveTime.length, m = moveTime[0].length;
            int INF = Integer.MAX_VALUE;
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], INF);
            }

            PriorityQueue<int[]> minh = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            minh.add(new int[]{0, 0, 0});
            moveTime[0][0] = 0;

            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            while (!minh.isEmpty()) {
                int[] current = minh.poll();
                int currTime = current[0];
                int currRow  = current[1];
                int currCol  = current[2];
                if (currTime >= dp[currRow][currCol]) continue;
                if (currRow == n - 1 && currCol == m - 1) return currTime;
                dp[currRow][currCol] = currTime;

                for (int[] dir : directions) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];
                    if (nextRow >= 0 && nextRow < n &&
                            nextCol >= 0 && nextCol < m &&
                            dp[nextRow][nextCol] == INF) {
                        int cost  = (currRow + currCol) % 2 + 1;
                        int start = Math.max(moveTime[nextRow][nextCol], currTime);
                        int nextTime = start + cost;
                        minh.add(new int[]{nextTime, nextRow, nextCol});
                    }
                }
            }
            return -1;
        }
    }
}
