class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            // if (row == destination[0] && col == destination[1]) return true;
            if (Arrays.equals(cell, destination)) return true;

            for (int[] dir : directions) {
                int[] stop = roll(maze, row, col, dir, rows, cols);
                int nr = stop[0], nc = stop[1];
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    private int[] roll(int[][] maze, int row, int col, int[] dir, int rows, int cols) {
        int r = row, c = col;
        
        while (true) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || maze[nr][nc] == 1) {
                break;
            }

            r = nr;
            c = nc;
        }

        return new int[]{r, c};
    }
}