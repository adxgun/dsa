class Solution {
    private int[][] memo;
    private int rows, cols;
    private final int[][] DIR = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];

        int best = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                best = Math.max(best, dfs(matrix, r, c));
            }
        }
        return best;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];

        int largest = 1;
        for (int[] dir : DIR) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[row][col]) {
                largest = Math.max(largest, 1 + dfs(matrix, nr, nc));
            }
        }

        memo[row][col] = largest;
        return largest;
    }
}