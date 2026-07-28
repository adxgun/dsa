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
    // store the index of the first element at each depth(row)

    private Map<Integer, Integer> firstIndex = new HashMap<>();
    private int maxWidth = 0;
    
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int index) {
        if (root == null) return;

        firstIndex.putIfAbsent(depth, index);
        int width = index - firstIndex.get(depth) + 1;
        maxWidth = Math.max(width, maxWidth);
        
        dfs(root.left, depth + 1, 2 * index + 1);
        dfs(root.right, depth + 1, 2 * index + 2);
    }
}