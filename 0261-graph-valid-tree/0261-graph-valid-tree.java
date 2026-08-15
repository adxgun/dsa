class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        // adjacency list
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add(new ArrayList());

        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        int seen = 1;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : nodes.get(node)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    seen++;
                    queue.offer(nei);
                }
            }
        }

        return seen == n;
    }
}