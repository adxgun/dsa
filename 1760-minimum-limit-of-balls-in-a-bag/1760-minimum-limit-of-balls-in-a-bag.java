class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = 0;
        for (int x : nums) hi = Math.max(hi, x);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feaseable(nums, mid, maxOperations)) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo;
    }

    private boolean feaseable(int[] nums, int t, int maxOps) {
        long splits = 0;
        for (int x : nums) {
            splits += (x - 1) / t;
            if (splits > maxOps) return false;
        }
        return splits <= maxOps;
    }
}