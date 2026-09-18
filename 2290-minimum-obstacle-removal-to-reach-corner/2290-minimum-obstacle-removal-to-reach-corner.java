class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] costs = new int[rows][cols];
        for (int[] row : costs) Arrays.fill(row, Integer.MAX_VALUE);
        queue.offer(new int[]{0, 0, grid[0][0]}); // row, col, cost
        costs[0][0] = grid[0][0];

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], cost = cell[2];
            if (row == rows - 1 && col == cols - 1) return cost;
            if (cost > costs[row][col]) continue;

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int newCost = cost + grid[nr][nc];
                if (newCost < costs[nr][nc]) {
                    costs[nr][nc] = newCost;
                    queue.offer(new int[]{nr, nc, newCost});
                }
            }
        }

        return costs[rows - 1][cols - 1];
    }
}