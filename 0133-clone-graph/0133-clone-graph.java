/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private Map<Node, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes.containsKey(node)) return nodes.get(node);

        Node copy = new Node(node.val);
        nodes.put(node, copy);
        for (Node nb : node.neighbors) {
            copy.neighbors.add(cloneGraph(nb));
        }
        return copy;
    }
}