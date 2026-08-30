class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean boundary = r == 0 || r == rows - 1 || c == 0 || c == cols - 1;
                if (boundary && grid[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                    grid[r][c] = 0;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != 1) continue;

                grid[nr][nc] = 0;
                queue.offer(new int[]{nr, nc});
            }
        }

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) count++;
            }
        }

        return count;
    }
}