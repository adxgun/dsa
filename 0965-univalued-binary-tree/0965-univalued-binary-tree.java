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
    public boolean isUnivalTree(TreeNode root) {
        return checkVal(root, root.val);
    }

    private boolean checkVal(TreeNode root, int val) {
        if (root == null) return true;
        
        if (root.val != val) return false;
        boolean left = checkVal(root.left, root.val);
        boolean right = checkVal(root.right, root.val);
        return left && right;
    }
}