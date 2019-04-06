package graph.clone_graph_133;

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> neighbors = new ArrayList<>();
    Node(int x) {
        val = x;
    }
}
