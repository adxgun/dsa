class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] DIR = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] dir : DIR) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                        return step;
                    }

                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}