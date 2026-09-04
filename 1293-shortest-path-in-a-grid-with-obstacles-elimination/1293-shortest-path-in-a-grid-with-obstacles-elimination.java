class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] seen = new boolean[rows][cols][k + 1];
        queue.offer(new int[]{0, 0, k});
        seen[0][0][k] = true;

        int steps = 0;
        int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1], rem = cell[2];

                if (row == rows - 1 && col == cols - 1) return steps;
                for (int[] dir : directions) {
                    int nr = dir[0] + row, nc = dir[1] + col;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    
                    int newRem = rem - grid[nr][nc];
                    if (newRem < 0) continue;

                    if (!seen[nr][nc][newRem]) {
                        queue.offer(new int[]{nr, nc, newRem});
                        seen[nr][nc][newRem] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}