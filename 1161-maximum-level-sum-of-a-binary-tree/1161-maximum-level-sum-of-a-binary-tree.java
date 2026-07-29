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

    private int smallestLevel = 0;
    private Map<Integer, Integer> levelSums = new HashMap<>();
    
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);

        int maxSum = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : levelSums.entrySet()) {
            if (entry.getValue() > maxSum) {
                maxSum = entry.getValue();
                smallestLevel = entry.getKey();
            }
        }
        return smallestLevel;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

        levelSums.merge(depth, root.val, Integer::sum);
    }


}