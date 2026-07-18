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
    int targetVal = 0;
    int targetDepth = 0;
    int curDepth = 0;
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        targetVal = val;
        targetDepth = depth;

        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        curDepth++;
        if (curDepth == targetDepth - 1) {
            TreeNode newLeft = new TreeNode(targetVal);
            TreeNode newRight = new TreeNode(targetVal);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }

        dfs(root.left);
        dfs(root.right);

        curDepth--;
    }
}