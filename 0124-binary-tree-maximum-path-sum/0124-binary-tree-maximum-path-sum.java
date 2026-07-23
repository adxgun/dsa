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
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;    
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSumMax = Math.max(dfs(root.left), 0);
        int rightSumMax = Math.max(dfs(root.right), 0);

        int pathSum = root.val + leftSumMax + rightSumMax;
        res = Math.max(res, pathSum);
        
        return root.val + Math.max(leftSumMax, rightSumMax);
    }
}