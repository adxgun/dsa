/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode cur = root;
        while (cur != null) {
            if (p.val < cur.val) {
                successor = cur;
                cur = cur.left;
            } else cur = cur.right;
        }
        return successor;
    }
}