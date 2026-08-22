class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0], start[1], 0});
        dist[start[0]][start[1]] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], distance = cell[2];

            if (row == destination[0] && col == destination[1]) return distance;
            
            for (int[] dir : directions) {
                int[] stop = roll(maze, dir, row, col, rows, cols);

                int nr = stop[0], nc = stop[1], steps = stop[2];
                int newDist = distance + steps;
                if (newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;
                    queue.offer(new int[]{nr, nc, newDist});
                }
            }
        }
        return -1;
    }

    private int[] roll(int[][] maze, int[] dir, int row, int col, int rows, int cols) {
        int r = row, c = col, steps = 0;
        while (true) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || maze[nr][nc] == 1) {
                break;
            }
            
            steps++;
            r = nr;
            c = nc;
        }

        return new int[]{r, c, steps};
    }
}