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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, false, res);
        return res;
    }

    private void dfs(TreeNode root, boolean isLonely, List<Integer> res) {
        if (root == null) return;

        if (isLonely) res.add(root.val);

        dfs(root.left, root.right == null, res);
        dfs(root.right, root.left == null, res);
    }
}