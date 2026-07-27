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
    
    private Map<Integer, List<Integer>> rows = new HashMap<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);

        List<Double> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : rows.entrySet()) {
            result.add(average(entry.getValue()));
        }
        return result;
    }

    private void dfs(TreeNode root, int row) {
        if (root == null) return;
        
        rows.computeIfAbsent(row, (a) -> new ArrayList<>()).add(root.val);
        dfs(root.left, row + 1);
        dfs(root.right, row + 1);
    }

    private double average(List<Integer> ls) {
        long sum = 0;
        for (int x : ls) {
            sum += x;
        }

        return (double) sum / ls.size();
    }
}