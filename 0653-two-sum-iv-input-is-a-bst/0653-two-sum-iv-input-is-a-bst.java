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
    private boolean hasSum = false;
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set, k);
        return hasSum;
    }

    private void dfs(TreeNode root, Set<Integer> set, int target) {
        if (root == null) return;

        if (hasSum) return;

        dfs(root.left, set, target);
        int compliment = target - root.val;
        if (set.contains(compliment)) hasSum = true;
        set.add(root.val);
        dfs(root.right, set, target);
    }
}