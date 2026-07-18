/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int depthX = 0, depthY = 0;
    TreeNode parentX, parentY;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        dfs(root, 0, null);
        if (depthX == depthY && parentX != parentY) return true;
        return false;
    }

    private void dfs(TreeNode root, int depth, TreeNode parent) {
        if (root == null) return;

        if (root.val == this.x) {
            parentX = parent;
            depthX = depth;
        }

        if (root.val == this.y) {
            parentY = parent;
            depthY = depth;
        }

        dfs(root.left, depth + 1, root);
        dfs(root.right, depth + 1, root);
    }
}