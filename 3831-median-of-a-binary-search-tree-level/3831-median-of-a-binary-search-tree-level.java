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
    public int levelMedian(TreeNode root, int level) {
        if (root == null) return 0;
        
        List<Integer> levels = new ArrayList<>();
        dfs(root, levels, level, 0);
        if (levels.size() == 0) return -1;
        int size = levels.size();
        return levels.get(size / 2);
    }

    private void dfs(TreeNode root, List<Integer> levels, int level, int depth) {
        if (root == null) return;
        dfs(root.left, levels, level, depth + 1);
        if (depth == level) {
            levels.add(root.val);
        }
        dfs(root.right, levels, level, depth + 1);
    }
}