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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, graph);

        System.out.println(graph);

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int val = queue.poll();

                for (int nei : graph.getOrDefault(val, Collections.emptyList())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            minutes++;
        }

        return minutes;
    }

    private void dfs(TreeNode root, Map<Integer, List<Integer>> graph) {
        if (root == null) return;

        graph.computeIfAbsent(root.val, (k) -> new ArrayList<>());
        for (TreeNode child : new TreeNode[]{root.left, root.right}) {
            if (child != null) {
                graph.get(root.val).add(child.val);
                graph.computeIfAbsent(child.val, (j) -> new ArrayList<>()).add(root.val);
            }
        }
        
        dfs(root.left, graph);
        dfs(root.right, graph);
    }
}