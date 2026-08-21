class Solution {
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] totalDist = new int[rows][cols];
        int[][] reachCount = new int[rows][cols];
        int[][] DIR = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int buildingCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    
                    
                    boolean[][] visited = new boolean[rows][cols];
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j, 0}); // row, col, distance
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0], col = cur[1], dist = cur[2];

                        for (int[] dir : DIR) {
                            int nr = row + dir[0];
                            int nc = col + dir[1];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                totalDist[nr][nc] += dist + 1;
                                reachCount[nr][nc]++;
                                queue.offer(new int[]{nr, nc, dist + 1});
                            }
                        }
                    }
                }
            }
        }

        int best = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == buildingCount) {
                    if (best == -1 || totalDist[i][j] < best) {
                        best = totalDist[i][j];
                    }
                }
            }
        }

        return best;
    }
}