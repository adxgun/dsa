class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int rows = grid.length, cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{0, 0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0], col = node[1], w = node[2];
                if (row == rows - 1 && col == cols - 1) return w;
                if (w > dist[row][col]) continue;

                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    int nt = w + 1;
                    if (grid[nr][nc] > nt) {
                        int wait = ((grid[nr][nc] - w) % 2 == 0 ? 1 : 0);
                        nt = grid[nr][nc] + wait;
                    }

                    if (nt < dist[nr][nc]) {
                        dist[nr][nc] = nt;
                        queue.offer(new int[]{nr, nc, nt});
                    }
                }
            }
        }

        return -1;
    }
}