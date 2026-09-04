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
    int maxDepth = 0, deepestSum = 0, depth = 0;
    public int deepestLeavesSum1(TreeNode root) {
        // findMaxDepth(root, 0);
        dfs1(root, 0);
        return deepestSum;
    }

    private void dfs1(TreeNode root, int depth) {
        if (root == null) return;

        if (depth > maxDepth) {
            maxDepth = depth;
            deepestSum = root.val;
        } else if (depth == maxDepth) {
            deepestSum += root.val;
        }

        dfs1(root.left, depth + 1);
        dfs1(root.right, depth + 1);
    }

    private void findMaxDepth(TreeNode root, int depth) {
        if (root == null) return;

        maxDepth = Math.max(maxDepth, depth);
        findMaxDepth(root.left, depth + 1);
        findMaxDepth(root.right, depth + 1);
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

        if (depth == maxDepth) deepestSum += root.val;
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int s = 0; s < size; s++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return sum;
    }
}