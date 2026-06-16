class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}