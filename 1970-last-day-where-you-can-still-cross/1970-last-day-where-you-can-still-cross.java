class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int lo = 0, hi = cells.length, answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canCross(row, col, cells, mid)) {
                answer = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }

        return answer;
    }

    private boolean canCross(int rows, int cols, int[][] cells, int day) {
        boolean[][] blocked = new boolean[rows][cols];
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            blocked[r][c] = true;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int c = 0; c < cols; c++) {
            if (!blocked[0][c]) {
                blocked[0][c] = true;
                queue.offer(new int[]{0, c});
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1];
            if (r == rows - 1) return true;
            
            for (int[] dir : directions) {
                int nr = dir[0] + r, nc = dir[1] + c;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || blocked[nr][nc]) continue;

                blocked[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }
}