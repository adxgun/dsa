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
    private int index = 0;
    private boolean isValid = false;
    private List<Integer> path = new ArrayList<>();
    
    public boolean isValidSequence(TreeNode root, int[] arr) {
        List<Integer> comp = new ArrayList<>();
        for (int x : arr) comp.add(x);
        dfs(root, comp);
        return isValid;
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (path.equals(arr)) isValid = true;
        }

        dfs(root.left, arr);
        dfs(root.right, arr);
        path.remove(path.size() - 1);
    }
}