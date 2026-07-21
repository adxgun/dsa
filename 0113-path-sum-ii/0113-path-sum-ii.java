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

    int target = 0, sum = 0;
    List<Integer> curPath = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {        
        this.target = targetSum;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        sum += root.val;
        curPath.add(root.val);
        if (root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<>(curPath));
        }

        dfs(root.left);
        dfs(root.right);

        curPath.remove(curPath.size() - 1);
        sum -= root.val;
    }
}