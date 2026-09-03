class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int closed = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    if (bfs(grid, r, c, rows, cols)) {
                        closed++;
                    }
                }
            }
        }

        return closed;
    }

    private boolean bfs(int[][] grid, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 1;

        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        boolean isClosed = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                // if this land cell sits on the boundary, the island is not closed;
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    isClosed = false;
                }

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 1) continue;

                    grid[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return isClosed;
    }
}