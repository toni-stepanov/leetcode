package graph.walls_gates_286;

import java.util.LinkedList;
import java.util.Queue;

/**
 286. Walls and Gates
 https://leetcode.com/problems/walls-and-gates/#/description

 You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent
 INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible
 to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0   INF
 INF INF INF  -1
 INF  -1 INF  -1
 0    -1 INF  INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
*/

public class Solution {
    //https://discuss.leetcode.com/topic/25265/java-bfs-solution-o-mn-time
    void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        int rows = rooms.length;
        int cols = rooms[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j}); //  add all gates to the queue
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int row = curr[0], col = curr[1];
            int dist = rooms[row][col];
            if (inPlane(row-1, col, rooms) && rooms[row-1][col] == Integer.MAX_VALUE){
                // rooms with Integer.MAX_VALUE are unvisited
                rooms[row-1][col] = dist+1; // mark as visited, set distance
                queue.add(new int[]{row-1,col});
            }
            if (inPlane(row, col-1, rooms) && rooms[row][col-1] == Integer.MAX_VALUE){
                rooms[row][col-1] = dist+1;
                queue.add(new int[]{row,col-1});
            }
            if (inPlane(row+1, col, rooms) && rooms[row+1][col] == Integer.MAX_VALUE){
                rooms[row+1][col] = dist+1;
                queue.add(new int[]{row+1,col});
            }
            if (inPlane(row, col+1, rooms) && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = dist+1;
                queue.add(new int[]{row,col+1});
            }
        }
    }

    private boolean inPlane(int row, int col, int[][] rooms) {
        return row>=0 && row<rooms.length && col>=0 && col<rooms[0].length;
    }
}