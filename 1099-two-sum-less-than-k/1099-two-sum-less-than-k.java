class Solution {
    public int twoSumLessThanK_A(int[] nums, int k) {
        int i = 0, j = nums.length - 1, max = -1;
        Arrays.sort(nums);
        
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                max = Math.max(max, nums[i] + nums[j]);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, max = -1;
        for (int i = 0; i < n - 1; i++) {
            int target = k - nums[i];
            int idx = lowerBound(nums, i + 1, n - 1, target) - 1;
            if (idx > i) {
                max = Math.max(max, nums[i] + nums[idx]);
            }
        }
        return max;
    }

    private int lowerBound(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}