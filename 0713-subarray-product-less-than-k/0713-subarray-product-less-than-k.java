class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, product = 1, total = 0;
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            total += right - left + 1;
        }

        // total += nums.length;
        return total;
    }
}