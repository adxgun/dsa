class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // build adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long radius = bombs[i][2];

                if (dx * dx + dy * dy <= radius * radius) {
                    graph.get(i).add(j);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, bfs(graph, i));
        }
        return max;
    }

    private int bfs(List<List<Integer>> graph, int start) {
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
        return count;
    }
}