class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new ArrayDeque<>();
        Queue<int[]> atlanticQueue = new ArrayDeque<>();

        // start bfs from pacific side
        for (int c = 0; c < cols; c++) {
            pacificReachable[0][c] = true;
            pacificQueue.offer(new int[]{0, c});
        }

        for (int r = 0; r < rows; r++) {
            pacificReachable[r][0] = true;
            pacificQueue.offer(new int[]{r, 0});
        }

        for (int c = 0; c < cols; c++) {
            atlanticReachable[rows - 1][c] = true;
            atlanticQueue.offer(new int[]{rows - 1, c});
        }

        for (int r = 0; r < rows; r++) {
            atlanticReachable[r][cols - 1] = true;
            atlanticQueue.offer(new int[]{r, cols - 1});
        }

        bfs(atlanticQueue, atlanticReachable, heights, rows, cols);
        bfs(pacificQueue, pacificReachable, heights, rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (atlanticReachable[r][c] && pacificReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] reachable, int[][] heights, int rows, int cols) {
        int[][] DIR = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0], col = node[1];

            for (int[] dir : DIR) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (reachable[nr][nc]) continue;
                if (heights[row][col] > heights[nr][nc]) continue;

                reachable[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}