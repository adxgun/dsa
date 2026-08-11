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
    public List<List<Integer>> verticalOrder1(TreeNode root) {
        dfs(root);
        return Arrays.asList(new ArrayList<>());
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
    }

    class State {
        TreeNode node;
        int col;

        State(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Arrays.asList();
        
        Map<Integer, List<Integer>> cols = new HashMap<>();
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, 0));

        int minCol = 0, maxCol = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                State cur = q.poll();
                cols.computeIfAbsent(cur.col, (x) -> new ArrayList<>()).add(cur.node.val);

                minCol = Math.min(minCol, cur.col);
                maxCol = Math.max(maxCol, cur.col);

                if (cur.node.left != null) q.offer(new State(cur.node.left, cur.col - 1));
                if (cur.node.right != null) q.offer(new State(cur.node.right, cur.col + 1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int c = minCol; c <= maxCol; c++) res.add(cols.get(c));
        return res;
    }
}