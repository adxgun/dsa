class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int cols = grid2[0].length;

        int count = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid2[r][c] == 1) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c});
                    grid2[r][c] = 0;
                    boolean isSub = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int row = cell[0], col = cell[1];
                        if (grid1[row][col] == 0) isSub = false;

                        for (int[] dir : directions) {
                            int nr = dir[0] + row, nc = dir[1] + col;
                            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                            if (grid2[nr][nc] == 1) {
                                grid2[nr][nc] = 0;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }

                    if (isSub) count += 1;
                }
            }
        }

        return count;
    }
}