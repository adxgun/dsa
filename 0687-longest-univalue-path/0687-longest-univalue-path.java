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
    int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        
        traverse(root, root.val);
        return count;
    }

    private int traverse(TreeNode root, int value) {
        if (root == null) return 0;

        int left = traverse(root.left, root.val);
        int right = traverse(root.right, root.val);

        count = Math.max(count, right + left);

        if (root.val != value) return 0;
        return 1 + Math.max(left, right);
    }
}