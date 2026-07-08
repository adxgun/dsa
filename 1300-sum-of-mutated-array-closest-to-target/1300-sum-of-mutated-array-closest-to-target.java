class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0, hi = 0;
        for (int x : arr) hi = Math.max(hi, x);

        int best = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sum(arr, mid) <= target) {
                best = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }

        int sumLow = sum(arr, best);
        int sumHigh = sum(arr, best + 1);
        // distances to target
        if (Math.abs(sumHigh - target) < Math.abs(sumLow - target)) {
            return best + 1;   // overshoot is strictly closer
        }
        return best;
    }

    private int sum(int[] arr, int val) {
        int sum = 0;
        for (int x : arr) {
            if (x > val) {
                x = val;
            }
            sum += x;
        }
        return sum;
    }
}