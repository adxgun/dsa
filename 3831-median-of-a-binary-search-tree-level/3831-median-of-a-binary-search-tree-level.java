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
        
        Map<Integer, List<Integer>> levels = new HashMap<>();
        dfs(root, levels, 0);
        List<Integer> values = levels.get(level);
        if (values == null || values.size() == 0) return -1;
        int size = values.size();
        return values.get(size / 2);
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> levels, int depth) {
        if (root == null) return;
        dfs(root.left, levels, depth + 1);
        levels.computeIfAbsent(depth, (k) -> new ArrayList<>()).add(root.val);
        dfs(root.right, levels, depth + 1);
    }
}