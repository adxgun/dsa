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
class FindElements {

    private Set<Integer> values;
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        dfs(root, 0);
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        values.add(val);
        root.val = val;

        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */