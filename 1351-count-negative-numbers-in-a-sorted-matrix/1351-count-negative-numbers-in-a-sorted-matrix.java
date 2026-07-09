class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] gd : grid) {
            int start = lowerBound(gd, -1);
            System.out.println(start);
            count += (gd.length - start);
        }
        return count;
    }

    private int lowerBound(int[] grid, int val) {
        int lo = 0, hi = grid.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (grid[mid] <= val) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}