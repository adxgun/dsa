class Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        List<int[]> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (land[r][c] == 1) {
                    int startR = r;
                    int startC = c;
                    int[] end = bfs(land, r, c, rows, cols);
                    result.add(new int[]{startR, startC, end[0], end[1]});
                }
            }
        }

        return result.toArray(int[][]::new);
    }

    private int[] bfs(int[][] land, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new ArrayDeque<>();
        int endRow = row, endCol = col;
        queue.offer(new int[]{row, col});
        land[row][col] = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] >= endRow && cell[1] >= endCol) {
                endRow = cell[0];
                endCol = cell[1];
            }

            for (int[] dir : directions) {
                int nr = cell[0] + dir[0], nc = cell[1] + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (land[nr][nc] == 0) continue;

                queue.offer(new int[]{nr, nc});
                land[nr][nc] = 0;
            }
        }

        return new int[]{endRow, endCol};
    }
}