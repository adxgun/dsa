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
    
    List<Integer> values = new ArrayList<>();
    
    public int getMinimumDifferenceA(TreeNode root) {
        dfs(root);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            min = Math.min(min, values.get(i) - values.get(i - 1));
        }
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        values.add(root.val);
        dfs(root.right);
    }

    TreeNode prev;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }

        prev = root;
        traverse(root.right);
    }
}