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

    // each node asks their child node if its a valid BST
    // the dfs function returns {min, max, size} -> min = minimum value, max = maximum value and  size is the size of the valid BST

    int largest = 0; 
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return largest;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // if children reports no BST then this is not a BST as well
        if (left[2] == -1 || right[2] == -1) {
            return new int[]{0, 0, -1};
        }

        // Check the BST ordering condition at this node
        if (root.val > left[1] && root.val < right[0]) {
            int size = left[2] + right[2] + 1;
            largest = Math.max(largest, size);
            
            int min = Math.min(root.val, left[0]);
            int max = Math.max(root.val, right[1]);
            return new int[]{min, max, size};
        }

        return new int[]{0, 0, -1}; // not a valid BST
    }
}