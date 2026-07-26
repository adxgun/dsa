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

    private Node first = null; // first element aka smallest value
    private Node prev = null; // last element via in-order traversal of BST - a.k.a largest value

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);

        first.left = prev; // link first element to the last element
        prev.right = first; // link last element to the first;
        return first;
    }

    private void dfs(Node root) {
        if (root == null) return;

        dfs(root.left);

        if (prev != null) { // not the first element or the first leave node
            root.left = prev; // make it the previous value
            prev.right = root; // set current value as next
        } else first = root;

        prev = root;
        dfs(root.right);
    }

}