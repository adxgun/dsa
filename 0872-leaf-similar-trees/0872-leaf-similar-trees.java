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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        buildLeaf(root1, left);
        buildLeaf(root2, right);
        return left.equals(right);
    }

    private void buildLeaf(TreeNode root, List<Integer> res) {
        if (root == null) return;

        buildLeaf(root.left, res);
        buildLeaf(root.right, res);

        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) res.add(root.val);
    }
}