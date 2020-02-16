package design.digraph_shortest_path;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find shortest path from source vertex to some other vertex
 */
class ShortestPathInDigraph {
    private Digraph digraph;
    private boolean[] marked;
    private int[] edgeTo;

    ShortestPathInDigraph(Digraph digraph, int startVertex) {
        marked = new boolean[digraph.size()];
        edgeTo = new int[digraph.size()];
        for (int i = 0; i < digraph.size(); i++) {
            edgeTo[i] = -1;
        }
        this.digraph = digraph;
        bfs(this.digraph, startVertex);
    }

    // Multiple-source shortest path.
    ShortestPathInDigraph(Digraph G, List<Integer> startVertices) {
        marked = new boolean[G.size()];
        edgeTo = new int[G.size()];
        for (int i = 0; i < G.size(); i++) {
            edgeTo[i] = -1;
        }
        digraph = G;
        bfs(digraph, startVertices);
    }

    private void bfs(Digraph g, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        marked[start] = true;
        bfsPart(g, q);
    }

    private void bfs(Digraph g, List<Integer> startVertices) {
        Queue<Integer> q = new LinkedList<>();
        for (Integer i : startVertices) {
            q.add(i);
            marked[i] = true;
        }
        bfsPart(g, q);
    }

    private void bfsPart(Digraph g, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (Integer w : g.adj(curr)) {
                if (!marked[w]) {
                    edgeTo[w] = curr;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    Iterable<Integer> getPath(int w) {
        LinkedList<Integer> res = new LinkedList<>();
        int curr = w;
        while (curr != -1) {
            res.add(0, curr);
            curr = edgeTo[curr];
        }
        return res;
    }
}
