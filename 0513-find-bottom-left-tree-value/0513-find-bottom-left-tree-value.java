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
    int maxDepth = 0, value = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        depth++;
        if (root.left == null && depth > maxDepth) {
            value = root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        maxDepth = Math.max(depth, maxDepth);
    }
}