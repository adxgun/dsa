class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size(), cols = grid.get(0).size();
        
        int startHealth = health - grid.get(0).get(0);
        if (startHealth < 1) return false;
        
        int[][] best = new int[rows][cols];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], curHealth = cell[2];
            if (row == rows - 1 && col == cols - 1) return true;
            if (curHealth < best[row][col]) continue;

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int nh = curHealth - grid.get(nr).get(nc);
                if (nh < 1) continue;
                if (nh > best[nr][nc]) {
                    best[nr][nc] = nh;
                    queue.offer(new int[]{nr, nc, nh});
                }
            }
        }
        
        return false;
    }
}