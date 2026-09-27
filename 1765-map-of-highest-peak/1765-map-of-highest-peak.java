class Solution {
    public int[][] highestPeak(int[][] isWater) {
        final int WATER = 1, LAND = 0;
        int rows = isWater.length, cols = isWater[0].length;
        int[][] heights = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isWater[r][c] == WATER) {
                    heights[r][c] = LAND;
                    queue.offer(new int[]{r, c, 0});
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0], col = node[1], h = node[2];

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int nh = h + 1;
                if (heights[nr][nc] == 0 && isWater[nr][nc] == LAND) {
                    heights[nr][nc] = nh;
                    queue.offer(new int[]{nr, nc, nh});
                } 
            }
        }

        return heights;
    }
}