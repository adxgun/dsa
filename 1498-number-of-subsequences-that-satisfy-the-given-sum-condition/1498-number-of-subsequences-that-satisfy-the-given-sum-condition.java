class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;

        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) pow2[i] = pow2[i - 1] * 2 % MOD;

        int lo = 0, hi = n - 1, count = 0;
        while (lo <= hi) {
            if (nums[lo] + nums[hi] <= target) {
                count = (count + pow2[hi - lo]) % MOD;
                lo++;
            } else hi--;
        }
        return count;
    }

    private int lowerBound(int[] nums, int val) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == val) return mid;
            else if (nums[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}