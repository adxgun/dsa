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
    int sum = 0, target = 0;
    boolean hasSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        dfs(root);
        return hasSum;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (hasSum) return;

        sum += root.val;
        if (root.left == null && root.right == null && sum == target) hasSum = true;

        dfs(root.left);
        dfs(root.right);
        sum -= root.val;
    }
}