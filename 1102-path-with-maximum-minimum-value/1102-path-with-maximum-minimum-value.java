class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int score = grid[0][0];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[rows][cols];
        heap.offer(new int[]{score, 0, 0});
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!heap.isEmpty()) {
            int[] cell = heap.poll();
            int val = cell[0], row = cell[1], col = cell[2];

            score = Math.min(val, score);
            if (row == rows - 1 && col == cols - 1) return score;

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                heap.offer(new int[]{grid[nr][nc], nr, nc});
            }
        }

        return score;
    }
}