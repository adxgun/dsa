class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, len = 0, n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int right = 0; right < n; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            
            while (freq.get(nums[right]) > k) {
                if (freq.merge(nums[left], -1, Integer::sum) == 0) freq.remove(nums[left]);
                left++;
            }

            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}