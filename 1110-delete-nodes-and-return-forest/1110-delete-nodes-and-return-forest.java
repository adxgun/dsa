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
    
    private Set<Integer> deleteSet = new HashSet<>();
    private List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return res;

        for (int x : to_delete) deleteSet.add(x);
        delete(root, false);
        return res;
    }

    private TreeNode delete(TreeNode root, boolean hasParent) {
        if (root == null) return null;

        boolean deleted = deleteSet.contains(root.val);
        if (!deleted && !hasParent) res.add(root);

        root.left = delete(root.left, !deleted);
        root.right = delete(root.right, !deleted);
        return deleted ? null : root;
    }
}