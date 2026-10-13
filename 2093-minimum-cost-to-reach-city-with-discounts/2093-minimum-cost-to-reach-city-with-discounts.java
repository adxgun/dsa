class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] hw : highways) {
            graph[hw[0]].add(new int[]{hw[1], hw[2]});
            graph[hw[1]].add(new int[]{hw[0], hw[2]});
        }

        int[][] best = new int[n][discounts + 1];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);
        
        // {cost, city, used}
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        best[0][0] = 0;
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int cost = node[0], city = node[1], used = node[2];
            if (cost > best[city][used]) continue;

            if (city == n - 1) return cost;

            for (int[] edge : graph[city]) {
                // option 1: pay full toll, discount unchanged
                int next = edge[0], toll = edge[1];
                int full = cost + toll;
                if (full < best[next][used]) {
                    best[next][used] = full;
                    queue.offer(new int[]{full, next, used});
                }

                if (used < discounts) {
                    int half = cost + toll / 2;
                    if (half < best[next][used + 1]) {
                        best[next][used + 1] = half;
                        queue.offer(new int[]{half, next, used + 1});
                    }
                }
            }
        }

        return -1;
    }
}