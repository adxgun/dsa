class Solution {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int max = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    max = Math.max(bfs(grid, r, c, rows, cols), max);
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int row, int col, int rows, int cols) {
        int fishes = grid[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0;
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            
            for (int[] dir : directions) {
                int nr = dir[0] + r, nc = dir[1] + c;

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0) continue;
                queue.offer(new int[]{nr, nc});
                fishes += grid[nr][nc];
                grid[nr][nc] = 0;
            }
        }

        return fishes;
    }
}