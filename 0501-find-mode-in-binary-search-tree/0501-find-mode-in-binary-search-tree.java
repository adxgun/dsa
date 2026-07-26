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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq = new HashMap<>();
        dfs(root, freq);

        int max = 0;
        for (int n : freq.values()) max = Math.max(max, n);
        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) res.add(entry.getKey());
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
    
    private void dfs(TreeNode root, Map<Integer, Integer> freq) {
        if (root == null) return;

        freq.merge(root.val, 1, Integer::sum);
        dfs(root.left, freq);
        dfs(root.right, freq);
    }
}