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
    private TreeNode prev;
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        return buildTree(values, 0, values.size() - 1);
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    private TreeNode buildTree(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(values, start, mid - 1);
        TreeNode right = buildTree(values, mid + 1, end);
        
        return new TreeNode(values.get(mid), left, right);
    }
}