class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int rows = forest.size();
        int cols = forest.get(0).size();

        List<int[]> trees = new ArrayList<>(); // height, row, col
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int h = forest.get(r).get(c);
                if (h > 1) trees.add(new int[]{h, r, c});
            }
        }

        trees.sort((a, b) -> Integer.compare(a[0], b[0]));
        int total = 0, sr = 0, sc = 0;
        for (int[] tree : trees) {
            int tr = tree[1], tc = tree[2];
            int steps = bfs(forest, rows, cols, sr, sc, tr, tc);
            if (steps == -1) return -1;
            total += steps;

            sr = tr;
            sc = tc;
        }

        return total;
    }

    private int bfs(List<List<Integer>> forest, int rows, int cols, int sr, int sc, int tr, int tc) {
        if (sr == tr && sc == tc) return 0;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                if (cell[0] == tr && cell[1] == tc) return steps;

                for (int[] dir : directions) {
                    int nr = dir[0] + cell[0], nc = dir[1] + cell[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;

                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}