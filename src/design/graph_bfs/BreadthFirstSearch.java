package design.graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth first search implementation.
 */
class BreadthFirstSearch {
    private boolean[] marked; // all items false by default
    private int[] edgeTo; // contains parentId of each the node
    private Graph graph;
    private LinkedList items;

    BreadthFirstSearch(Graph g, int startVertex, int size) {
        marked = new boolean[size];
        edgeTo = new int[size];
        for (int i = 0; i < size; i++) {
            edgeTo[i] = -1;
        }
        this.graph = g;
        // start vertex
        this.items = bfs(startVertex);
    }

    Iterable<Integer> getItems() {
        return this.items;
    }

    Iterable<Integer> getPath(int endVertex) {
        LinkedList path = new LinkedList();
        int curr = endVertex;
        while (curr > -1) {
            path.add(curr);
            curr = edgeTo[curr];
        }
        return path;
    }

    private LinkedList bfs(int start) {
        LinkedList result = new LinkedList();
        Queue<Integer> queue = new LinkedList<>();
        marked[start] = true;
        result.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    result.add(w);
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
        return result;
    }
}
