class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 1;
        for (int w : weights) {
            lo = Math.max(w, lo);
            hi += w;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numDays(weights, mid) <= days) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    // days needed to ship all weights with the given capacity
    private int numDays(int[] weights, int capacity) {
        int days = 1, load = 0;
        for (int w : weights) {
            if (load + w > capacity) {
                days++;              // start a new day
                load = 0;
            }
            load += w;               // add this package to the current day
        }
        return days;
    }
}