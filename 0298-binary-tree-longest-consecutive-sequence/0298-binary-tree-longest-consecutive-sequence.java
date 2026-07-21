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
    int best = 0;
    public int longestConsecutiveA(TreeNode root) {
        dfsA(root);
        return best;
    }

    private int dfsA(TreeNode root) {
        if (root == null) return 0;

        int left = dfsA(root.left);
        int right = dfsA(root.right);

        int len = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            len = Math.max(len, 1 + left);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            len = Math.max(len, 1 + right);
        }

        best = Math.max(len, best);
        return len;
    }

    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }

    private void dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        maxLength = Math.max(maxLength, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
}