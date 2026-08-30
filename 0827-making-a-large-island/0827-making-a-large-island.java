class Solution {

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2;
        int rows = grid.length;
        int cols = grid[0].length;
        int best = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int size = labelIsland(grid, r, c, rows, cols, islandId);
                    islandSize.put(islandId, size);
                    best = Math.max(best, size);
                    islandId++;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighbours = new HashSet<>();
                    for (int[] dir : directions) {
                        int nr = dir[0] + r, nc = dir[1] + c;
                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                        if (grid[nr][nc] > 1) {
                            neighbours.add(grid[nr][nc]);
                        }
                    }

                    int total = 1;
                    for (int nextId : neighbours) {
                        total += islandSize.get(nextId);
                    }
                    best = Math.max(best, total);
                }
            }
        }

        return best;
    }

    private int labelIsland(int[][] grid, int row, int col, int rows, int cols, int id) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = id;

        int size = 0;
        while (!queue.isEmpty()) {
            size++;
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int nr = dir[0] + cell[0], nc = dir[1] + cell[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != 1) continue;

                grid[nr][nc] = id;
                queue.offer(new int[]{nr, nc});
            }
        }

        return size;
    }
}