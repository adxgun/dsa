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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (level % 2 == 0) {
                    if (cur.val % 2 == 0) return false;
                    if (prev != Integer.MAX_VALUE && prev >= cur.val) return false;
                } else {
                    if (cur.val % 2 != 0) return false;
                    if (prev != Integer.MAX_VALUE && prev <= cur.val) return false;
                }

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                prev = cur.val;
            }
            level++;
        }
        return true;
    }
}