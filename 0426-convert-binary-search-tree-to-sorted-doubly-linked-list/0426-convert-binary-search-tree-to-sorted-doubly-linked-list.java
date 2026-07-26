/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    private Node first = null;
    private Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);

        first.left = prev;
        prev.right = first;
        return first;
    }

    private void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);

        if (prev != null) {
            root.left = prev;
            prev.right = root;
        } else first = root;

        prev = root;
        dfs(root.right);
    }

}