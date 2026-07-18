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

    private int result;
    private StringBuilder path = new StringBuilder();
    
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(path.toString());
        }

        dfs(root.left);
        dfs(root.right);

        path.deleteCharAt(path.length() - 1);
    }
}