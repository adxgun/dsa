class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int total = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    total += bfs(grid, r, c, rows, cols, k);
                }
            }
        }

        return total;
    }

    private int bfs(int[][] grid, int row, int col, int rows, int cols, int k) {
        long total = (long) grid[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] dir : directions) {
                int nr = node[0] + dir[0], nc = node[1] + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0) continue;
                total += grid[nr][nc];
                grid[nr][nc] = 0;
                queue.offer(new int[]{nr, nc});
            }
        }

        return total % k == 0 ? 1 : 0;
    }
}