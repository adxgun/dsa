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
    public List<Integer> largestValuesA(TreeNode root) {
        // map of row -> max heap
        Map<Integer, PriorityQueue<Integer>> rows = new HashMap<>();
        dfsA(root, 0, rows);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : rows.entrySet()) {
            if (!entry.getValue().isEmpty()) res.add(entry.getValue().poll());
        }
        return res;
    }

    private void dfsA(TreeNode root, int row, Map<Integer, PriorityQueue<Integer>> rows) {
        if (root == null) return;

        if (rows.get(row) == null) {
            rows.put(row, new PriorityQueue<>(Collections.reverseOrder()));
        }

        rows.get(row).offer(root.val);
        dfsA(root.left, row + 1, rows);
        dfsA(root.right, row + 1, rows);
    }

    public List<Integer> largestValues1(TreeNode root) {
        Map<Integer, Integer> rowMax = new HashMap<>();  // row -> max value so far
        dfs(root, 0, rowMax);

        List<Integer> res = new ArrayList<>();
        for (int r = 0; r < rowMax.size(); r++) {
            res.add(rowMax.get(r));
        }
        return res;
    }

    private void dfs(TreeNode node, int row, Map<Integer, Integer> rowMax) {
        if (node == null) return;

        // Update this row's max
        rowMax.merge(row, node.val, Math::max);   // put node.val, or max with existing

        dfs(node.left,  row + 1, rowMax);
        dfs(node.right, row + 1, rowMax);
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Arrays.asList();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int currentMax = Integer.MIN_VALUE, sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                currentMax = Math.max(currentMax, cur.val);

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(currentMax);
        }
        return res;
    }
}