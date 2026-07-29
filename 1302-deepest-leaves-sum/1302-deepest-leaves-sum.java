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
    int maxDepth = 0, deepestSum = 0, depth = 0;
    public int deepestLeavesSum(TreeNode root) {
        findMaxDepth(root, 0);
        dfs(root, 0);
        return deepestSum;
    }

    private void findMaxDepth(TreeNode root, int depth) {
        if (root == null) return;

        maxDepth = Math.max(maxDepth, depth);
        findMaxDepth(root.left, depth + 1);
        findMaxDepth(root.right, depth + 1);
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

        if (depth == maxDepth) deepestSum += root.val;
    }
}