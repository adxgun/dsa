class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        // Phase 1: multi-source BFS from all thieves
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                if (grid.get(r).get(c) == 1) { dist[r][c] = 0; q.offer(new int[]{r, c}); }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dirs) {
                int nr = cell[0] + d[0], nc = cell[1] + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[cell[0]][cell[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        // Phase 2: max-heap Dijkstra maximizing the minimum dist along the path
        boolean[][] visited = new boolean[n][n];
        // {safeness, row, col}, max-heap by safeness
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{dist[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int safe = cur[0], r = cur[1], c = cur[2];

            if (r == n - 1 && c == n - 1) return safe;   // first pop of target = best answer

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                int newSafe = Math.min(safe, dist[nr][nc]);   // path safeness = running min
                pq.offer(new int[]{newSafe, nr, nc});
            }
        }
        return 0;   // unreachable in practice; corners always connected
    }
}