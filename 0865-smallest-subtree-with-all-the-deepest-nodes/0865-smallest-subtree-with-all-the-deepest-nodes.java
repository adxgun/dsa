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

    class Result {
        TreeNode node;
        int depth;

        public Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    TreeNode res;
    int minDepth = Integer.MAX_VALUE;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Result res = dfs(root);
        return res.node;    
    }

    private Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        }

        Result res = left.depth > right.depth ? left : right;
        res.depth++;
        return res;
    }
}