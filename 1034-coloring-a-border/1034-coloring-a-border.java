class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        int originalColor = grid[row][col];
        List<int[]> borderCells = new ArrayList<>();
        
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            boolean borderCell = false;

            for (int[] dir : directions) {
                int nr = cell[0] + dir[0], nc = dir[1] + cell[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    borderCell = true;
                    continue;
                }

                if (grid[nr][nc] == originalColor) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                } else {
                    borderCell = true;
                }
            }

            if (borderCell) borderCells.add(new int[]{cell[0], cell[1]});
        }

        for (int[] cell : borderCells) {
            int r = cell[0], c = cell[1];
            grid[r][c] = color;
        }

        return grid;
    }
}