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

    int[] voyage;
    List<Integer> result;
    boolean canFlip = true;
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        this.result = new ArrayList<>();
        dfs(root);

        if (canFlip) return result;
        return Arrays.asList(-1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }

        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            result.add(root.val);
        }

        dfs(root.left);
        dfs(root.right);
    }
}