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
    int res = 0, low = 0, high = 0;
    public int rangeSumBST1(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (root.val >= low && root.val <= high) res += root.val;
        dfs(root.right);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        if (root.val < low) traverse(root.right);
        else if (root.val > high) traverse(root.left);
        else {
            res += root.val;
            traverse(root.left);
            traverse(root.right);
        }
    }
}