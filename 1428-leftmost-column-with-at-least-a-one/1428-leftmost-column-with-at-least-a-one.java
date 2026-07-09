/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
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
}