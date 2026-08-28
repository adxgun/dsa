class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>(); // row, col, dist
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[]{r, c, 0});
                    visited[r][c] = true;
                }
            }
        }

        // all lands or all water
        if (queue.isEmpty() || queue.size() == rows * cols) return -1;

        int distance = -1;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            distance = Math.max(distance, cell[2]);

            int row = cell[0], col = cell[1];
            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;

                queue.offer(new int[]{nr, nc, distance + 1});
                visited[nr][nc] = true;
            }
        }

        return distance;
    }
}