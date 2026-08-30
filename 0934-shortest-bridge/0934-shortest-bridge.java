class Solution {
    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean found = false;
        for (int r = 0; r < rows && !found; r++) {
            for (int c = 0; c < cols && !found; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, rows, cols, queue);
                    found = true;
                }
            }
        }

        int steps = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int nr = dir[0] + row, nc = dir[1] + col;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] == 1) return steps;

                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int row, int col, int rows, int cols, Queue<int[]> queue) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) return;

        grid[row][col] = 2;
        queue.offer(new int[]{row, col});
        dfs(grid, row + 1, col, rows, cols, queue);
        dfs(grid, row - 1, col, rows, cols, queue);
        dfs(grid, row, col + 1, rows, cols, queue);
        dfs(grid, row, col - 1, rows, cols, queue);
    }
}