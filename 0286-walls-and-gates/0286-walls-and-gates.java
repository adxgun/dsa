class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        final int WALL = -1, GATE = 0, EMPTY = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) queue.offer(new int[]{i, j});
            }
        }

        int[][] DIR = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : DIR) {
                int nr = dir[0] + row;
                int nc = dir[1] + col;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == EMPTY) {
                    rooms[nr][nc] = rooms[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}