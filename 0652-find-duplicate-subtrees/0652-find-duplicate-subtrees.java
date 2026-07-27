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

    private Map<String, Integer> count = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();
    private static String NULL = "#";
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;    
    }

    private String dfs(TreeNode root) {
        if (root == null) return NULL;

        String left = dfs(root.left);
        String right = dfs(root.right);

        String triple = root.val + "," + left + "," + right;
        int c = count.merge(triple, 1, Integer::sum);

        if (c == 2) result.add(root);
        return triple;
    }
}