class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // starts[i] = {start value, original index}
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        java.util.Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = search(starts, intervals[i][1]);
        }
        return res;
    }

    // Binary search: smallest start >= target, return its original index
    private int search(int[][] starts, int target) {
        int lo = 0, hi = starts.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (starts[mid][0] >= target) {
                ans = starts[mid][1];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
