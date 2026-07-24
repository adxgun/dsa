/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int depth = 0, res = 0;
    public int maxDepth(Node root) {
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) return;

        depth++;
        res = Math.max(depth, res);
        for (Node node : root.children) dfs(node);

        // postorder
        depth--;
    }
}