package design.top_sort_digraph;

import java.util.LinkedList;

/**
 * Topological sort implementation
 */
class DepthFirstOrder {
    private boolean[] marked;
    private LinkedList<Integer> list;

    DepthFirstOrder(Digraph g) {
        list = new LinkedList<>();
        marked = new boolean[g.size()];
        for (int i = 0; i < g.size(); i++) {
            if (!marked[i]) {
                dfs(g, i, list);
            }
        }
    }

    private void dfs(Digraph g, int curr, LinkedList<Integer> list) {
        marked[curr] = true;
        for (Integer i : g.adj(curr)) {
            if (!marked[i]) {
                dfs(g, i, list);
            }
        }
        list.add(0, curr);
    }

    Iterable<Integer> getTopologicalOrder() {
        return list;
    }
}
