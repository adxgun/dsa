class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(i, (k) -> new ArrayList<>()).add(i + 1);
        }

        int start = 0, destination = n - 1;
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            graph.computeIfAbsent(query[0], (j) -> new ArrayList<>()).add(query[1]);
            answer[i] = bfs(graph, start, destination);
        }

        return answer;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start, int destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int path = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (node == destination) return path;

                for (int next : graph.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            path++;
        }

        return path;
    }
}