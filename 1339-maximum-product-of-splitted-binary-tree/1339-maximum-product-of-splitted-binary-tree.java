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

    int treeSum = 0;
    long res;
    private static final int MOD = 1_000_000_007;
    
    public int maxProduct(TreeNode root) {
        treeSum = sum(root);
        sum(root);
        return (int) (res % MOD);
    }

    int sum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int rootSum = leftSum + rightSum + root.val;

        res = Math.max(res, (long) rootSum * (treeSum - rootSum));
        return rootSum;
    }
}