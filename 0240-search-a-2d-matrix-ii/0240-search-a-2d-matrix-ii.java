class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            int v = matrix[r][c];
            if (v == target) return true;
            else if (v > target) c--; // go left
            else r++; // go down
        }

        return false;
    }
}