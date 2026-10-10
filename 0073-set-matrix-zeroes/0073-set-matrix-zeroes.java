class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rows[r] || cols[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}