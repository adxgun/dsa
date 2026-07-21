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
    int best = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return best;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int len = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            len = Math.max(len, 1 + left);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            len = Math.max(len, 1 + right);
        }

        best = Math.max(len, best);
        return len;
    }
}