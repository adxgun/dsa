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
        
        // add the current node
        path.append(root.val);

        // at the leaf node, the whole subtree would be in 'path'
        // so we add it add to result.
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(path.toString());
        }

        // traverse left subtree
        dfs(root.left);

        // traverse right subtree
        dfs(root.right);

        // remove everything.
        path.deleteCharAt(path.length() - 1);
    }
}