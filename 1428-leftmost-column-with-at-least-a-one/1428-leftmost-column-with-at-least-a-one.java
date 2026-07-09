/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOneA(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0), cols = dim.get(1);

        int row = 0, col = cols - 1;   // start at top-right corner
        int result = -1;

        while (row < rows && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                result = col;   // a 1 here means leftmost-so-far is at least this far left
                col--;          // move left to look for an even earlier 1
            } else {
                row++;          // 0 here: no 1 in this row at/before col, go down
            }
        }
        return result;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0), cols = dim.get(1);

        int result = cols;   // "no 1 found yet" sentinel (one past the last column)
        for (int r = 0; r < rows; r++) {
            // binary search for the first column holding a 1 in row r
            int lo = 0, hi = cols - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (binaryMatrix.get(r, mid) == 0) lo = mid + 1;   // 1s are further right
                else hi = mid - 1;                                      // this or earlier
            }
            result = Math.min(result, lo);   // lo = leftmost 1 in this row (or cols if none)
        }
        return result == cols ? -1 : result;
    }
}