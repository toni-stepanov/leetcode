package design.connected_components;

/**
 * Connected components implementation
 */
 class ConnectedComponents {
    private boolean[] marked;
    private int[] componentId; // componentId[v] == id of connected component.
    private int count = 0; // count of connected components
    private Graph graph;

    ConnectedComponents(Graph g) {
        int size = g.size();
        graph = g;
        marked = new boolean[size];
        componentId = new int[size];
        for (int i = 0; i< size; i++) {
            componentId[i] = -1;
        }
        for (int i = 0; i< size; i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int curr) {
        marked[curr] = true;
        componentId[curr] = count;
        for (Integer w : graph.adj(curr)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }

     boolean isConnected(int v, int w) {
        return componentId[v] == componentId[w];
    }
}
