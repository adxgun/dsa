class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : connections) {
            int a = edge[0], b = edge[1];
            graph.get(b).add(new int[]{a, 0});
            graph.get(a).add(new int[]{b, 1});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;
        for (int[] edge : graph.get(node)) {
            int next = edge[0], cost = edge[1];
            if (!visited[next]) {
                changes += cost + dfs(next, graph, visited);
            }
        }
        return changes;
    }
}