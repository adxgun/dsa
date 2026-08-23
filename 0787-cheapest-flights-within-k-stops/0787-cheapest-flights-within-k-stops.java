class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], (v) -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[src] = 0;
        
        Queue<int[]> queue = new ArrayDeque<>(); // src, cost
        queue.offer(new int[]{src, 0});
        int stops = 0;
        
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0], cost = cur[1];

                for (int[] nei : graph.getOrDefault(node, Collections.emptyList())) {
                    int next = nei[0], price = nei[1];
                    if (price + cost < best[next]) {
                        best[next] = price + cost;
                        queue.offer(new int[]{next, price + cost});
                    }
                }
            }
            stops++;
        }

        return best[dst] == Integer.MAX_VALUE ? -1 : best[dst];
    }
}