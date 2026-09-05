class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = nums.length;
        int[] minValues = new int[n];
        minValues[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minValues[i] = Math.min(nums[i], minValues[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max - minValues[i] <= k) return i;
        }

        return -1;
    }
}