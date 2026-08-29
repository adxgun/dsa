class Solution {
    public int trapRainWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < 3 || cols < 3) return 0;

        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    queue.offer(new int[]{grid[r][c], r, c});
                    visited[r][c] = true;
                }
            }
        }

        int water = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int height = cell[0], row = cell[1], col = cell[2];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
                water += Math.max(0, height - grid[nr][nc]);
                queue.offer(new int[]{Math.max(height, grid[nr][nc]), nr, nc});
                visited[nr][nc] = true;
            }
        }
        return water;
    }
}