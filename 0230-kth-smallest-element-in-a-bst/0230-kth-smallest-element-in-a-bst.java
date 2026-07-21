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
    
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return q.poll();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        dfs(root.right);
        q.offer(root.val);
        if (q.size() > k) q.poll();
    }
}