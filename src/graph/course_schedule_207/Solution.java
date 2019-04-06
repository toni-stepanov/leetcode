package graph.course_schedule_207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
207. Course Schedule
https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to
finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists,
 no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic
 concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

// Great solutions
// https://discuss.leetcode.com/topic/15762/java-dfs-and-bfs-solution
// https://discuss.leetcode.com/topic/17273/18-22-lines-c-bfs-dfs-solutions
// Graph additional info
//        https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/describing-graphs
//        http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/ same idea with colors, DFS
//        http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/ - depth first graph traversal.
//        https://www.youtube.com/watch?v=W9cfpsPJwhc - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting/ - topological sort via DFS
//        http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
public class Solution {


    boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = makeGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, visited, recStack, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean hasCycle(int cur, boolean visited[], boolean recStack[], ArrayList<Integer>[] graph) {
        if (recStack[cur]) {
            return true;
        }
        if (visited[cur]) {
            return false;
        }
        visited[cur] = true;
        recStack[cur] = true;
        ArrayList<Integer> adjacentNodes = graph[cur];
        for (int n : adjacentNodes) {
            if (hasCycle(n, visited, recStack, graph)) {
                return true;
            }
        }
        recStack[cur] = false;
        return false;
    }

    ArrayList[] makeGraph(int numCources, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCources];
        for (int i = 0; i < numCources; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int edge[] : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    // BFS solution
    // http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
    // time complexity O(E+V), space complexity O(E+V) - to hold the graph + O(V) - for the queue of vertices =>
    // O(E+2V) => O(E+V).
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = makeGraph(numCourses, prerequisites);
        int[] inDegrees = getInDegrees(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        int count = 0; // counter of visited vertices.
        // push all the vertices with no incoming edges to the q.
        for (int i=0; i<numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
                inDegrees[i] = -1; // mark vertices as visited.
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> adjacentNodes = graph[curr];
            for (int n : adjacentNodes) {
                inDegrees[n]--;
                if (inDegrees[n] == 0) {
                    q.add(n);
                    count++;
                }
            }
        }
        return numCourses == count;
    }

    private int[] getInDegrees(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for(int[] edge : prerequisites) {
            //int from = edge[0];
            int to = edge[1];
            inDegrees[to]++;
        }
        return inDegrees;
    }

}