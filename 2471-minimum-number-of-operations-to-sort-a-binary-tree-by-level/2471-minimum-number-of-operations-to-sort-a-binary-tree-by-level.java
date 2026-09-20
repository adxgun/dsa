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
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int ops = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level[i] = cur.val;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ops += minSwaps(level);
        }

        return ops;
    }

    private int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || pairs[i][1] == i) continue;

            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}