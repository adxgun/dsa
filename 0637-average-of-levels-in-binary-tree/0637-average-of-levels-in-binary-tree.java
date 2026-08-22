class Solution {
    private List<long[]> rows = new ArrayList<>();  // each entry: {sum, count}

    public List<Double> averageOfLevels1(TreeNode root) {
        dfs(root, 0);
        List<Double> result = new ArrayList<>();
        for (long[] r : rows) {
            result.add((double) r[0] / r[1]);
        }
        return result;
    }

    private void dfs(TreeNode node, int row) {
        if (node == null) return;
        if (row == rows.size()) {
            rows.add(new long[]{0, 0});   // first node seen at this row
        }
        rows.get(row)[0] += node.val;     // sum
        rows.get(row)[1] += 1;            // count
        dfs(node.left,  row + 1);
        dfs(node.right, row + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return Collections.emptyList();
        
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add((sum * 1.0) / size);
        }
        return res;
    }
}