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
    private int idx = 0;
    private Map<Integer, Integer> inIndex = new HashMap<>();
    private int[] postorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) inIndex.put(inorder[i], i);

        this.idx = postorder.length - 1;
        this.postorder = postorder;
        return build(0, postorder.length - 1);
    }

    private TreeNode build(int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        
        int val = postorder[idx--];
        TreeNode root = new TreeNode(val);
        int split = inIndex.get(val);

        root.right = build(split + 1, inRight);
        root.left = build(inLeft, split - 1);
        return root;
    }
}