class Solution {
    private final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int maximumMinutes(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] fireTime = new int[rows][cols];
        for (int[] t : fireTime) Arrays.fill(t, Integer.MAX_VALUE);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fireTime[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (fireTime[nr][nc] != Integer.MAX_VALUE) continue;
                if (grid[nr][nc] == 2) continue;

                fireTime[nr][nc] = fireTime[row][col] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        if (canEscape(grid, fireTime, rows * cols)) return 1_000_000_000;
        if (!canEscape(grid, fireTime, 0)) return -1;

        int lo = 0, hi = rows * cols, answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canEscape(grid, fireTime, mid)) {
                answer = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }

        return answer;
    }

    private boolean canEscape(int[][] grid, int[][] fireTime, int wait) {
        if (fireTime[0][0] <= wait) return false;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, wait});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], t = cell[2];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] != 0 || visited[nr][nc]) continue;

                int arrive = t + 1;
                if (nr == rows - 1 && nc == cols - 1) {
                    if (arrive <= fireTime[nr][nc]) return true;
                }

                if (arrive < fireTime[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, arrive});
                }
            }
        }

        return false;
    }
}