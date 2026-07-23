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
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return best;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(height(root.left), 0);
        int right = Math.max(height(root.right), 0);
        
        best = Math.max(best, left + right);
        return 1 + Math.max(left, right);
    }
}