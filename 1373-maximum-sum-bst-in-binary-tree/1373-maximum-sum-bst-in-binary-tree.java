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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // return isBST, sum, min, max
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left[0] == 0 || right[0] == 0) return new int[]{0, 0, 0, 0};

        // validate BST property.
        // if the left max is greater than root value OR if the right min is lesser than the root.
        if (left[3] >= root.val || right[2] <= root.val) return new int[]{0, 0, 0, 0};
        
        int rootSum = root.val + left[1] + right[1];
        int min = Math.min(root.val, left[2]);
        int max = Math.max(root.val, right[3]);
        maxSum = Math.max(rootSum, maxSum);

        return new int[]{1, rootSum, min, max};
    }
}