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
    List<Integer> curPath = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;    
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        curPath.add(root.val);
        if (root.left == null && root.right == null) {
            String path = curPath.
                stream().
                map(String::valueOf).
                collect(Collectors.joining("->"));
            res.add(path);
        }

        dfs(root.left);
        dfs(root.right);

        curPath.remove(curPath.size() - 1);
    }
}