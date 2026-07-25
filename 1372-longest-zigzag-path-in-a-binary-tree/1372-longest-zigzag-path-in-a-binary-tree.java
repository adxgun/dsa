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
    int res = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{-1, -1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rootPathLen1 = left[1] + 1;
        int rootPathLen2 = right[0] + 1;

        res = Math.max(res, Math.max(rootPathLen1, rootPathLen2));
        return new int[]{rootPathLen1, rootPathLen2};
    }
}