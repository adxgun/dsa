class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int x : nums) {
            lo = Math.min(x, lo);
            hi += x;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (countSubArraySum(nums, mid) >= k) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo;
    }

    private int countSubArraySum(int[] nums, int val) {
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > val) {
                sum -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }
}