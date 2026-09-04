class Solution {
    public int minPushBox(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] box = null, target = null, player = null;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 'S') player = new int[]{r, c};
                if (grid[r][c] == 'B') box = new int[]{r, c};
                if (grid[r][c] == 'T') target = new int[]{r, c};
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{box[0], box[1], player[0], player[1]});
        visited.add(key(box[0], box[1], player[0], player[1]));

        int pushes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int br = cell[0], bc = cell[1], pr = cell[2], pc = cell[3];

                if (br == target[0] && bc == target[1]) return pushes;
                
                for (int[] dir : directions) {
                    int nbr = dir[0] + br, nbc = dir[1] + bc;
                    int needPr = br - dir[0], needPc = bc - dir[1];

                    if (!inGrid(nbr, nbc, rows, cols) || grid[nbr][nbc] == '#') continue;
                    if (!inGrid(needPr, needPc, rows, cols) || grid[needPr][needPc] == '#') continue;

                    // can the player walk from (pr,pc) to (needPr,needPc) WITHOUT crossing the box?
                    if (!canReach(grid, rows, cols, needPr, needPc, pr, pc, br, bc)) continue;
                    
                    String key = key(nbr, nbc, br, bc);
                    if (!visited.contains(key)) {
                        visited.add(key);
                        queue.offer(new int[]{nbr, nbc, br, bc});
                    }
                }
            }

            pushes++;
        }
        return -1;
    }

    private String key(int br, int bc, int pr, int pc) {
        return br + "," + bc + "," + pr + "," + pc;
    }

    private boolean inGrid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    // can the player walk from (pr,pc) to (needPr,needPc) WITHOUT crossing the box?
    private boolean canReach(
        char[][] grid, int rows, int cols, int npr, int npc, int pr, int pc, int br, int bc) {
        if (npr == pr && npc == pc) return true;
        boolean[][] seen = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{pr, pc});
        seen[pr][pc] = true;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int nr = dir[0] + cell[0], nc = dir[1] + cell[1];
                if (!inGrid(nr, nc, rows, cols)) continue;
                if (grid[nr][nc] == '#' || seen[nr][nc]) continue;
                if (nr == br && nc == bc) continue;
                if (nr == npr && nc == npc) return true;

                seen[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }
}