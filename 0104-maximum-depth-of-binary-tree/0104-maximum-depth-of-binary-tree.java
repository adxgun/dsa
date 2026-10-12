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
    int depth = 0, maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) return;
        maxDepth = Math.max(d, maxDepth);
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        depth++;
        maxDepth = Math.max(depth, maxDepth);

        dfs(root.left);
        dfs(root.right);
        depth--;
    }
}