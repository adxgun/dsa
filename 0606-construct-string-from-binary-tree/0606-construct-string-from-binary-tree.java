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

    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (root.left != null && root.right == null) {
            return root.val + "(" + left + ")";
        }

        if (root.left == null && root.right != null) {
            return root.val + "()" + "(" + right + ")";
        }

        return root.val + "(" + left + ")" + "(" + right + ")";
    }
}

// 1(2()4(