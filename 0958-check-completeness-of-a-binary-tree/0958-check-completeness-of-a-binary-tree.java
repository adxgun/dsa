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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) seenNull = true;
            else {
                if (seenNull) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}