package graph.clone_graph_133;


/*
133. Clone Graph
https://leetcode.com/problems/clone-graph/

Clone an undirected graph. Each node in the graph contains a val and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node val and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for undirected graph.
 * class Node {
 *     int val;
 *     List<Node> neighbors;
 *     Node(int x) { val = x; neighbors = new ArrayList<Node>(); }
 * };
 */
public class Solution {
    private Map<Integer, Node> map = new HashMap<>();

    // Time complexity O(n), space complexity O(n + m) - n - number of vertices, m - number of edges.
    Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node res = new Node(node.val);
        res.neighbors = new ArrayList<>();
        map.put(node.val, res);
        for (Node n : node.neighbors) {
            res.neighbors.add(cloneGraph(n));
        }
        return res;
    }
}