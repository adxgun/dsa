class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        int[][] minTime = new int[rows][cols];
        for (int[] t : minTime) Arrays.fill(t, Integer.MAX_VALUE);
        minTime[0][0] = 0;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{0, 0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], t = cell[2];
            if (row == rows - 1 && col == cols - 1) return minTime[row][col];
            if (t > minTime[row][col]) continue;

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                int arrive = Math.max(t, moveTime[nr][nc]) + 1;
                if (arrive < minTime[nr][nc]) {
                    minTime[nr][nc] = arrive;
                    queue.offer(new int[]{nr, nc, arrive});
                }
            }
        }

        return -1;
    }
}

// 0 4
// 4 4

// 0 0 0
// 0 0 0

// 0 1
// 1 2

// 0->1: 1
// 1 -> 2