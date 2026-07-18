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

    private StringBuilder sb = new StringBuilder();
    private String result = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            sb.append((char) ('a' + root.val));
            sb.reverse();
            String s = sb.toString();

            if (result == null || result.compareTo(s) > 0) {
                result = s;
            }
            
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        // preorder position
        sb.append((char) ('a' + root.val));

        dfs(root.left);
        dfs(root.right);

        sb.deleteCharAt(sb.length() - 1);
    }
}