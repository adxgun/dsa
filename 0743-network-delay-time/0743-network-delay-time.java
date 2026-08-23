class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], (v) -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.offer(new int[]{k, 0}); // node, time
        dist[k] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int node = current[0], time = current[1];
                if (time > dist[node]) continue;

                for (int[] edge : graph.getOrDefault(node, Collections.emptyList())) {
                    int next = edge[0], weight = edge[1];
                    int newTime = time + weight;
                    if (newTime < dist[next]) {
                        dist[next] = newTime;
                        queue.offer(new int[]{next, newTime});
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(dist[i], max);
        }
        return max;
    }
}