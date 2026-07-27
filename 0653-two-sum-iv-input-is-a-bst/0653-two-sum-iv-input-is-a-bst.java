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
    public boolean findTargetA(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set, k);
        return hasSum;
    }

    private void dfsA(TreeNode root, Set<Integer> set, int target) {
        if (root == null) return;

        if (hasSum) return;

        dfsA(root.left, set, target);
        int compliment = target - root.val;
        if (set.contains(compliment)) hasSum = true;
        set.add(root.val);
        dfsA(root.right, set, target);
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, new HashSet<>(), k);
    }

    private boolean dfs(TreeNode node, Set<Integer> set, int target) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;
        set.add(node.val);
        return dfs(node.left, set, target) || dfs(node.right, set, target);
    }
}