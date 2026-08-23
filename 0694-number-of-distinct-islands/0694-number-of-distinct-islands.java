class Solution {
    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> shapes = new HashSet<>();
        
        int distinct = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    String shape = bfs(grid, visited, r, c, rows, cols);
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    private String bfs(int[][] grid, boolean[][] visited, int startRow, int startCol, int rows, int cols) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        List<String> relativeCoords = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            relativeCoords.add((row - startRow) + "," + (col - startCol));

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        Collections.sort(relativeCoords);
        return String.join("|", relativeCoords);
    }
}