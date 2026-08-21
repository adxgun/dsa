class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeters = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    perimeters += countExposedSides(grid, r, c, rows, cols);
                }
            }
        }
        return perimeters;
    }

    private int countExposedSides(int[][] grid, int row, int col, int rows, int cols) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int exposed = 0;

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0) {
                exposed++;
            }
        }
        return exposed;
    }
}