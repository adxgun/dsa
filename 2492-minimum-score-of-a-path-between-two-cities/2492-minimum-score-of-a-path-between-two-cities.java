class Solution {

    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int from = road[0], to = road[1], distance = road[2];
            graph.get(from).add(new int[]{to, distance});
            graph.get(to).add(new int[]{from, distance});
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        visited[1] = true;

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] edge : graph.get(city)) {
                int next = edge[0], dist = edge[1];
                min = Math.min(dist, min);
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        return min;
    }
}

// 9,5
// 4,7 or 1,2,1,3,4 -> 2,2,3,7