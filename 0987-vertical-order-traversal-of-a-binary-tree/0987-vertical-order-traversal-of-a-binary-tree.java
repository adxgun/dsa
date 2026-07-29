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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>(); // col, row, value
        dfs(root, 0, 0, nodes);

        List<List<Integer>> result = new ArrayList<>();
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int prevCol = Integer.MAX_VALUE;
        for (int[] node : nodes) {
            if (node[0] != prevCol) {
                result.add(new ArrayList<>());
            }

            result.get(result.size() - 1).add(node[2]);
            prevCol = node[0];
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<int[]> nodes) {
        if (root == null) return;
        nodes.add(new int[]{col, row, root.val});
        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}