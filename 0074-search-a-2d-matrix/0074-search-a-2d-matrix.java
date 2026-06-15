class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // map the 2D array to 1D
        int left = 0, right = m * n - 1;
        // the standard binary search framework mentioned earlier
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(matrix, mid) == target)
                return true;
            else if (get(matrix, mid) < target)
                left = mid + 1;
            else if (get(matrix, mid) > target)
                right = mid - 1;
        }
        return false;
    }

    // access elements in the 2D array using 1D coordinates
    int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // calculate the row and column coordinates in the 2D array
        int i = index / n, j = index % n;
        return matrix[i][j];
    }
}