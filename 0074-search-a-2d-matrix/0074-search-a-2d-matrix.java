class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = get(matrix, mid, m);
            if (val == target) return true;
            else if (val > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    private int get(int[][] matrix, int index, int m) {
        return matrix[index / m][index % m];
    }
}