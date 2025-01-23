package notAbleToSolve;

import java.util.ArrayList;
import java.util.HashMap;

public class CountServersThatCommunicate {
    /**
     * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that
     * cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the
     * same row or on the same column.
     *
     * Return the number of servers that communicate with any other server
     * */
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        ArrayList<Row> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i <m ; i++) {
            int countOfServer = 0;
            int col = -1;
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    countOfServer++;
                    col = j;
                    hashMap.put(j,hashMap.getOrDefault(j,0)+1);
                }
            }
            Row row = new Row(0,countOfServer,col);
            if(countOfServer>1) count += countOfServer;
            list.add(row);
        }



        // now iterate over the rows with 1 server
        for (Row row: list){
            if(row.count==1){
                int col = row.col;
                if(hashMap.get(col)>1){
                    count++;
                }
            }
        }

        return count;
    }
    class Row{
        int index;
        int count;

        int col;

        public Row(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public Row(int index, int count, int col) {
            this.index = index;
            this.count = count;
            this.col = col;
        }
    }
}
