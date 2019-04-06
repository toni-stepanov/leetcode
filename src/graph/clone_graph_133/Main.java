package graph.clone_graph_133;

public class Main {
    public static void main(String[] args) {
        Node node = new Node(1);
        Solution s = new Solution();
        Node res = s.cloneGraph(node);
        System.out.print(res.val);
    }
}


