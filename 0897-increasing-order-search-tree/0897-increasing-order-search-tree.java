class Solution {
    // given a bst, return a sorted "linked list"
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // first, flatten the left and right subtrees
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        root.right = right;
        // if the left subtree is empty, no need to process it
        if (left == null) {
            return root;
        }
        // if the left subtree is not empty, attach the root and
        // right subtree to the end of the left subtree
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = root;

        return left;
    }
}