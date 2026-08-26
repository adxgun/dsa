class Solution {
    public int matrixMedian(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = n * m;
        int[] values = new int[len];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int idx = r * m + c;
                values[idx] = grid[r][c];
            }
        }

        Arrays.sort(values);
        return values[len / 2];
    }

    // row * C + col
}