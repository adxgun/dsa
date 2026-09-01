class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // effort, row, col
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], effort = cell[2];

            if (dist[row][col] < effort) continue;
            if (row == rows - 1 && col == cols - 1) {
                return dist[row][col];
            }

            // get neighbours
            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[row][col]));
                if (dist[nr][nc] <= newEffort) continue;

                dist[nr][nc] = newEffort;
                queue.offer(new int[]{nr, nc, newEffort});
            }
        }

        return 0;
    }
}