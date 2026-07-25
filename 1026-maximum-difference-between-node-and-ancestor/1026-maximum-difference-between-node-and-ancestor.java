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
 // from this node, collect all the diff from between me & my children, and keep the max.
class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int curMin, int curMax) {
        if (root == null) return curMax - curMin;

        curMin = Math.min(curMin, root.val);
        curMax = Math.max(curMax, root.val);

        int left = dfs(root.left, curMin, curMax);
        int right = dfs(root.right, curMin, curMax);
        return Math.max(left, right);
    }
}