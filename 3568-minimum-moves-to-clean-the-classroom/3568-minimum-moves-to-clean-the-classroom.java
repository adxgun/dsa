class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] litterBit = new int[m][n];
        for (int[] row : litterBit) Arrays.fill(row, -1);
        int total = 0, sr = 0, sc = 0;

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'L') litterBit[r][c] = total++;
                else if (ch == 'S') { sr = r; sc = c; }
            }
        if (total == 0) return 0;
        int fullMask = (1 << total) - 1;

        // best energy with which we've reached (r, c, mask); -1 = never
        int[][][] bestEnergy = new int[m][n][1 << total];
        for (int[][] plane : bestEnergy)
            for (int[] row : plane) Arrays.fill(row, -1);

        // state = {row, col, energy, mask}
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0});
        bestEnergy[sr][sc][0] = energy;

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];

                if (mask == fullMask) return moves;
                if (e <= 0) continue;              // can't move further from here

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char ch = classroom[nr].charAt(nc);
                    if (ch == 'X') continue;

                    int ne = (ch == 'R') ? energy : e - 1;
                    int nmask = mask;
                    if (ch == 'L') nmask |= (1 << litterBit[nr][nc]);

                    // dominance: only proceed if this beats the best energy
                    // previously recorded for (nr, nc, nmask)
                    if (ne <= bestEnergy[nr][nc][nmask]) continue;
                    bestEnergy[nr][nc][nmask] = ne;
                    queue.offer(new int[]{nr, nc, ne, nmask});
                }
            }
            moves++;
        }
        return -1;
    }
}