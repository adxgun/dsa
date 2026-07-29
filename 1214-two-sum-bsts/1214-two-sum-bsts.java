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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> values = new ArrayList<>();
        collect(root1, values);

        for (int x : values) {
            int complement = target - x;
            TreeNode cnode = findComplementaryNode(root2, complement);
            if (cnode != null) return true;
        }
        return false;
    }

    private void collect(TreeNode root, List<Integer> values) {
        if (root == null) return;

        collect(root.left, values);
        values.add(root.val);
        collect(root.right, values);
    }

    private TreeNode findComplementaryNode(TreeNode root, int target) {
        if (root == null) return null;

        if (root.val > target) return findComplementaryNode(root.left, target);
        else if (root.val < target) return findComplementaryNode(root.right, target);
        else return root;
    }
}