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

    private boolean isBalanced = true;
    public boolean isBalanced1(TreeNode root) {
        return height(root) != -1;
    }

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        if (Math.abs(rightMax - leftMax) > 1) isBalanced = false;
        return 1 + Math.max(rightMax, leftMax);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        
        int left = height(root.left);
        if (left == -1) return -1;

        int right = height(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}