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
        dfs(root);
        return maxDepth;
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