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

    private String startPath, destPath;
    private int startValue, destValue;
    private StringBuilder sb = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        dfs(root);
        int p = 0, m = startPath.length(), n = destPath.length();
        while (p < m && p < n && startPath.charAt(p) == destPath.charAt(p)) p++;

        startPath = startPath.substring(p);
        destPath = destPath.substring(p);
        startPath = "U".repeat(startPath.length());
        return startPath + destPath;    
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.val == startValue) {
            startPath = sb.toString();
        } else if (root.val == destValue) {
            destPath = sb.toString();
        }

        sb.append('L');
        dfs(root.left);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        dfs(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}