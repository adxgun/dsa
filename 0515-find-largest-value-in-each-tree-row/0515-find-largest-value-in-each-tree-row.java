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
    public List<Integer> largestValues(TreeNode root) {
        // map of row -> max heap
        Map<Integer, PriorityQueue<Integer>> rows = new HashMap<>();
        dfs(root, 0, rows);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : rows.entrySet()) {
            if (!entry.getValue().isEmpty()) res.add(entry.getValue().poll());
        }
        return res;
    }

    private void dfs(TreeNode root, int row, Map<Integer, PriorityQueue<Integer>> rows) {
        if (root == null) return;

        if (rows.get(row) == null) {
            rows.put(row, new PriorityQueue<>(Collections.reverseOrder()));
        }

        rows.get(row).offer(root.val);
        dfs(root.left, row + 1, rows);
        dfs(root.right, row + 1, rows);
    }
}