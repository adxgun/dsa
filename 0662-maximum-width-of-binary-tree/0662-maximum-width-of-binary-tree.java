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
    
    // store the index of the first element at each depth(row)
    private Map<Integer, Integer> firstIndex = new HashMap<>();
    private int maxWidth = 0;
    
    public int widthOfBinaryTree_DFS(TreeNode root) {
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode root, int depth, int index) {
        if (root == null) return;

        firstIndex.putIfAbsent(depth, index);
        int width = index - firstIndex.get(depth) + 1;
        maxWidth = Math.max(width, maxWidth);
        
        dfs(root.left, depth + 1, 2 * index + 1);
        dfs(root.right, depth + 1, 2 * index + 2);
    }

    class Pair {
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while (!q.isEmpty()) {
            int sz = q.size();
            int start = 0, end = 0;
            for (int i = 0; i < sz; i++) {
                Pair cur = q.poll();

                if (i == 0) start = cur.id;
                if (i == sz - 1) end = cur.id;
                
                if (cur.node.left != null) q.offer(new Pair(cur.node.left, cur.id * 2));
                if (cur.node.right != null) q.offer(new Pair(cur.node.right, cur.id * 2 + 1));
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }
}