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

    record Result(TreeNode node, int height) {}
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.height == right.height) {
            return new Result(root, left.height + 1);
        } else if (left.height > right.height) {
            return new Result(left.node, left.height + 1);
        } else return new Result(right.node, right.height + 1);


    }
}