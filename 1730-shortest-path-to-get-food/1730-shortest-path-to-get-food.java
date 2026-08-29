class Solution {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '#') {
                    queue.offer(new int[]{r, c, 0});
                    grid[r][c] = 'X';
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], distance = cell[2];
            if (grid[row][col] == '*') return distance;

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] == 'X') continue;

                queue.offer(new int[]{nr, nc, distance + 1});
                if (grid[nr][nc] == 'O') grid[nr][nc] = 'X';
            }
        }

        return -1;
    }
}