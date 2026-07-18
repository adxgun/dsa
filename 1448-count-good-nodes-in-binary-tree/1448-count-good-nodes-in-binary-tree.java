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
    
    int good = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return good;
    }

    private void dfs(TreeNode root, int pathMax) {
        if (root == null) return;
        if (pathMax <= root.val) good++;

        pathMax = Math.max(pathMax, root.val);

        dfs(root.left, pathMax);
        dfs(root.right, pathMax);
    }
}