/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    private TreeNode res, target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        dfs(original, cloned);
        return res;
    }

    private void dfs(TreeNode original, TreeNode cloned) {
        if (original == null || res != null) return;

        if (original == target) {
            res = cloned;
            return;
        }

        dfs(original.left, cloned.left);
        dfs(original.right, cloned.right);
    }

    private void dfs2(TreeNode cloned) {
        if (cloned == null) return;

        if (cloned == target) res = cloned;

        dfs2(cloned.left);
        dfs2(cloned.right);
    }
}