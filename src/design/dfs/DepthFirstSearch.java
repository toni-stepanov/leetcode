package design.dfs;

import java.util.LinkedList;

/**
 * DFS implementation
 */
class DepthFirstSearch {
    private boolean[] marked; // all items false by default
    private int[] edgeTo; // contains parentId of each the node
    private Graph graph;
    private LinkedList<Integer> items = new LinkedList<>();

    DepthFirstSearch(Graph g, int startVertex, int size) {
        marked = new boolean[size];
        edgeTo = new int[size];
        for (int i=0; i<size; i++) {
            edgeTo[i] = -1;
        }
        this.graph = g;
        // start vertex
        dfs(startVertex, items);
    }

    LinkedList getItems() {
        return this.items;
    }

    Iterable<Integer> getPath(int endVertex) {
        LinkedList<Integer> ls = new LinkedList<>();
        int curr = endVertex;
        while (curr > -1) {
            ls.add(curr);
            curr = edgeTo[curr];
        }
        return ls;
    }

    private void dfs(int current, LinkedList<Integer> result) {
        if (marked[current]) return;
        marked[current] = true;
        result.add(current);
        for (int w : graph.adj(current)) {
            if (!marked[w]) {
                dfs(w, result);
                edgeTo[w] = current;
            }
        }
    }

}
