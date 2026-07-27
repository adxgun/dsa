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

    private List<Integer> nodes;
    private int[] preSum;
    private int inOrderIdx = 0, n = 0;

    public TreeNode convertBSTA(TreeNode root) {
        nodes = new ArrayList<>();
        collectNodes(root);
        preSum = new int[nodes.size() + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nodes.get(i - 1);
        }

        n = preSum.length - 1;
        dfs(root);
        return root;
    }

    private void collectNodes(TreeNode root) {
        if (root == null) return;

        collectNodes(root.left);
        nodes.add(root.val);
        collectNodes(root.right);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        inOrderIdx++;
        root.val = root.val + (preSum[n] - preSum[inOrderIdx]);
        dfs(root.right);
    }

    private int runningSum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) return;

        convert(root.right);
        runningSum += root.val;
        root.val = runningSum;
        convert(root.left);
    }
}