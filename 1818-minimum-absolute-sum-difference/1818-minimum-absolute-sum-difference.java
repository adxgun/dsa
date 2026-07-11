class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1_000_000_007;
        long baseSum = 0, maxReduction = 0;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            baseSum += diff;

            int closest = findClosest(sorted, nums2[i]);
            int newDiff = Math.abs(closest - nums2[i]);
            
            maxReduction = Math.max(diff - newDiff, maxReduction);
        }

        long result = (baseSum - maxReduction) % MOD;
        return (int) result;
    }

    private int findClosest(int[] nums, int t) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == t) return t;
            else if (nums[mid] < t) lo = mid + 1;
            else hi = mid - 1;
        }

        int best = nums[Math.min(lo, nums.length - 1)];
        if (lo > 0 && Math.abs(nums[lo - 1] - t) < Math.abs(best - t)) {
            best = nums[lo - 1];
        }
        return best;
    }
}